package com.kang.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * (RbacUser)表实体类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RbacUser extends Model<RbacUser> implements UserDetails {
    
    private Long id;
    
    private String account;
    
    private Boolean enable;
    
    private String password;
    
    private String tel;
    
    private String userName;

    /**
     * 得到用户的权限，如果权限表和用户表是分开的，我们需要在重新定义一个实体类实现UserDetails 并且继承User类
     * 在这里拿到用户的所有权限返回，或者返回空在CustomUserDetailsServiceImpl类中获取权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList();
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