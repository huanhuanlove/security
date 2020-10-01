package com.kang.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.kang.security.dao.*;
import com.kang.security.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-10-01-9:27
 * @Description: 查询用户以及设置角色
 */
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    //@Autowired CustomUserDetails customUserDetails;

    @Autowired RbacUserDao userDao;

    @Autowired RbacUserRoleDao userRoleDao;

    @Autowired RbacRoleDao roleDao;

    @Autowired RbacRolePermissionDao rolePermissionDao;

    @Autowired RbacPermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 1. 查询用户
        RbacUser user = userDao.selectOne(new LambdaQueryWrapper<RbacUser>()
                .eq(RbacUser::getAccount, username));
        Optional.ofNullable(user).<UsernameNotFoundException>orElseThrow(() -> {
            throw new UsernameNotFoundException("未找到此用户！！！");
        });
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        List<RbacUserRole> userRoles = userRoleDao.selectList(
                new LambdaQueryWrapper<RbacUserRole>().eq(RbacUserRole::getUserId, user.getId()));
        userRoles.stream().forEach(ur -> {
            List<RbacRole> role = roleDao.selectList(new LambdaQueryWrapper<RbacRole>()
                    .eq(RbacRole::getId, ur.getRoleId()));
            role.stream().forEach(r -> {
                //设置权限
                List<RbacRolePermission> rolePermissionList = rolePermissionDao.selectList(new LambdaQueryWrapper<RbacRolePermission>()
                        .eq(RbacRolePermission::getRoleId, r.getId()));
                rolePermissionList.stream().forEach(rp -> {
                    List<RbacPermission> permissions = permissionDao.selectList(new LambdaQueryWrapper<RbacPermission>()
                            .eq(RbacPermission::getId, rp.getPermissionId()));
                    permissions.stream().forEach(p -> {
                        //将权限设置给用户
                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p.getPermissionKey());
                        grantedAuthorities.add(grantedAuthority);
                    });
                });
            });
    });
        return new User(username,
                user.getPassword(), grantedAuthorities);
    }
}
