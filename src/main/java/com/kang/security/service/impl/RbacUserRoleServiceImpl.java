package com.kang.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kang.security.dao.RbacUserRoleDao;
import com.kang.security.entity.RbacUserRole;
import com.kang.security.service.RbacUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacUserRole)表服务实现类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Service
public class RbacUserRoleServiceImpl extends ServiceImpl<RbacUserRoleDao, RbacUserRole> implements RbacUserRoleService {

    private static final Logger logger = LoggerFactory.getLogger(RbacUserRoleServiceImpl.class);
    
    @Autowired private RbacUserRoleDao rbacUserRoleDao;
}