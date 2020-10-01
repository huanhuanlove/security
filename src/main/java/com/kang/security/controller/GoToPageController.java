package com.kang.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-09-29-21:30
 * @Description: 配置所有跳转页面的请求
 */
@Controller
@RequestMapping("page")
public class GoToPageController {

    /**
     * 登录页
     * @return
     */
    @RequestMapping("toLogin")
    public String login() {
        System.out.println("toLogin");
        return "login";
    }

    /**
     * 登录失败跳转
     * @return
     */
    @RequestMapping("toError")
    public String toError() {
        System.out.println("toError");
        return "error";
    }

    /**
     * 欢迎页
     * @return
     */
    @RequestMapping("toWelcome")
    public String toWelcome() {
        System.out.println("toWelcome");
        return "welcome";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("toMain")
    public String toMain() {
        System.out.println("toMain");
        return "main";
    }
}
