package com.kang.security.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.kang.security.service.RbacUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacUserRole)表控制层
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@RestController
@RequestMapping("rbacUserRole")
public class RbacUserRoleController extends ApiController {
   
    private static final Logger logger = LoggerFactory.getLogger(RbacUserRoleController.class);

    @Autowired private RbacUserRoleService rbacUserRoleService;

    
}