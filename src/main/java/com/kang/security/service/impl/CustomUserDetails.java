package com.kang.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kang.security.dao.*;
import com.kang.security.entity.RbacPermission;
import com.kang.security.entity.RbacRolePermission;
import com.kang.security.entity.RbacUser;
import com.kang.security.entity.RbacUserRole;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-09-30-9:23
 * @Description: 用户登录权限分配
 */
@Data
public class CustomUserDetails implements UserDetails {

    private Long id;

    private String account;

    private Boolean enable;

    private String tel;

    private String password;

    private String userName;

    /**
     * 得到用户的权限，如果权限表和用户表是分开的，我们需要在重新定义一个实体类实现UserDetails 并且继承于User类
     * 交给security的权限，放在UserDetailService进行处理
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "system"));
        //角色必须以ROLE_开头，如果数据库没有，则需要加上
        //根据用户名查询所有角色
        /*RbacUser rbacUser = userDao.selectOne(
                new LambdaQueryWrapper<RbacUser>().eq(RbacUser::getUserName, userName));
        List<RbacUserRole> rbacUserRoles = userRoleDao.selectList(
                new LambdaQueryWrapper<RbacUserRole>().eq(RbacUserRole::getUserId, rbacUser.getId()));
        //根据角色查询所有权限
        rbacUserRoles.stream().forEach(role -> {
            List<RbacRolePermission> rbacRolePermissions = rbacRolePermissionDao.selectList(
                    new LambdaQueryWrapper<RbacRolePermission>().eq(RbacRolePermission::getRoleId, role.getRoleId()));
            rbacRolePermissions.stream().forEach(perm -> {
                List<RbacPermission> rbacPermissions = permissionDao.selectList(
                        new LambdaQueryWrapper<RbacPermission>().eq(RbacPermission::getId, perm.getPermissionId()));
                rbacPermissions.stream().forEach(p -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + p.getPermissionKey()));
                });
            });

        });*/
        return authorities;
    }

    /**
     * 获取用户名
     * @return
     */
    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 指示用户的账户是否已过期。无法验证过期的账户。
     * 如果用户的账户有效（即未过期），则返回true，如果不在有效就返回false
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是锁定还是解锁。无法对锁定的用户进行身份验证。
     * 如果用户未被锁定，则返回true，否则返回false
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示用户的凭证（密码）是否已过期。过期的凭证阻止身份验证
     * 如果用户的凭证有效（即未过期），则返回true
     * 如果不在有效（即过期），则返回false
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /**
     * 指示用户是启用还是禁用。无法对禁用的用户进行身份验证
     * 如果启用了用户，则返回true，否则返回false
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
