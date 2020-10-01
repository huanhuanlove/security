package com.kang.security.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.kang.security.service.RbacPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacPermission)表控制层
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@RestController
@RequestMapping("rbacPermission")
public class RbacPermissionController extends ApiController {
   
    private static final Logger logger = LoggerFactory.getLogger(RbacPermissionController.class);

    @Autowired private RbacPermissionService rbacPermissionService;

    
}