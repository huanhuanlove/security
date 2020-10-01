package com.kang.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kang.security.dao.RbacPermissionDao;
import com.kang.security.entity.RbacPermission;
import com.kang.security.service.RbacPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacPermission)表服务实现类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Service
public class RbacPermissionServiceImpl extends ServiceImpl<RbacPermissionDao, RbacPermission> implements RbacPermissionService {

    private static final Logger logger = LoggerFactory.getLogger(RbacPermissionServiceImpl.class);
    
    @Autowired private RbacPermissionDao rbacPermissionDao;
}