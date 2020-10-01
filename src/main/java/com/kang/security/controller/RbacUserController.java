package com.kang.security.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.kang.security.service.RbacUserService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.Collection;

/**
 * (RbacUser)表控制层
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@RestController
@RequestMapping("user")
public class RbacUserController extends ApiController {
   
    private static final Logger logger = LoggerFactory.getLogger(RbacUserController.class);

    @Autowired private RbacUserService rbacUserService;

    /**
     * 获取当前登录用户信息
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public String productInfo(){
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }
        System.out.println("用户名： " + ((UserDetails)principl).getUsername());
        System.out.println("密码： " + ((UserDetails)principl).getPassword());
        Collection<? extends GrantedAuthority> collection = ((UserDetails) principl).getAuthorities();
        collection.stream().forEach(r -> {
            System.out.println("角色： " + ((GrantedAuthority) r).getAuthority());
        });
        return "当前用户是： " + currentUser;
    }


    @PreAuthorize("hasAuthority('system:user:create')")
    @RequestMapping("test1")
    public String test1() {
        System.out.println("test1");
        return "test1";
    }

    @PreAuthorize("hasAuthority('system:user:delete')")
    @RequestMapping("test2")
    public String test2() {
        System.out.println("test2");
        return "test2";
    }

    /**
     * 登录表单提交请求路径
     * @return
     */
    @RequestMapping("login")
    public String login() {
        System.out.println("user login");
        return "main";
    }

    /*@DenyAll   //拒绝所有
    @PermitAll //允许所有
    @RolesAllowed({"NORMAL", "ADMIN"})  //只要具有NORMAL, ADMIN任意一种权限就可以访问
    @PreAuthorize("")  //进入方法之前验证授权
    @RequestMapping("fun1")
    public String fun1() {
        return "测试所有注解";
    }*/
}