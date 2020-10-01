package com.kang.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kang.security.dao.RbacRolePermissionDao;
import com.kang.security.entity.RbacRolePermission;
import com.kang.security.service.RbacRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacRolePermission)表服务实现类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Service
public class RbacRolePermissionServiceImpl extends ServiceImpl<RbacRolePermissionDao, RbacRolePermission> implements RbacRolePermissionService {

    private static final Logger logger = LoggerFactory.getLogger(RbacRolePermissionServiceImpl.class);
    
    @Autowired private RbacRolePermissionDao rbacRolePermissionDao;
}