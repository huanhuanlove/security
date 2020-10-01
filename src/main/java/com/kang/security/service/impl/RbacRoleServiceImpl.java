package com.kang.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kang.security.dao.RbacRoleDao;
import com.kang.security.entity.RbacRole;
import com.kang.security.service.RbacRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacRole)表服务实现类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Service
public class RbacRoleServiceImpl extends ServiceImpl<RbacRoleDao, RbacRole> implements RbacRoleService {

    private static final Logger logger = LoggerFactory.getLogger(RbacRoleServiceImpl.class);
    
    @Autowired private RbacRoleDao rbacRoleDao;
}