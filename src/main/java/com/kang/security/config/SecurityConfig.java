package com.kang.security.config;

import com.kang.security.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-09-29-8:45
 * @Description: 用户认证与授权
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private CustomUserDetailsServiceImpl userDetailsService;

    /**
     * 认证与授权
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 配置需要拦截的资源
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //防止跨域请求
        http.cors().and().csrf().disable()
                .authorizeRequests()
                //所有人可访问的路径
                .antMatchers("/page/toLogin","/logout","/page/toWelcome").permitAll()
                //根据自己的url地址做出相应的控制，当控制权限的时候要加前缀 ROLE_
                .antMatchers("/fun1").hasRole("admin")
                .antMatchers("/fun2").hasAnyRole("admin", "normal")
                .antMatchers("/fun3").hasAuthority("ROLE_user:create")
                //通过非记住我方式登录的允许访问
                .antMatchers("/fun4").fullyAuthenticated()

                //其他的url都需要被认证才可以访问
                .anyRequest().authenticated()
                .and()
                //允许自定义表单登录
                .formLogin()
                //这是action地址，自己不需要写login方法  登录是由security提供
                .loginPage("/page/toLogin")
                //这是html中form中action的值 必须要对应
                .loginProcessingUrl("/user/login")
                //默认登录成功会跳转的controller
                .defaultSuccessUrl("/page/toMain")
                //关于登录失败的提示信息，自行解决
                .failureForwardUrl("/page/toError")
                .failureUrl("/page/toError")
                .and()
                .rememberMe()
                .and()
                //不需要自己写，由security提供
                .logout()
                .logoutUrl("/logout");
    }


    /**
     * 解除对静态资源的保护  -- 可以删除，上边已经配置过相同功能
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/static/**","/templates/**");
    }

    /**
     * 密码加密
     * @return
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        //PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }
}
