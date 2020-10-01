package com.kang.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kang.security.dao.RbacUserDao;
import com.kang.security.entity.RbacUser;
import com.kang.security.service.RbacUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (RbacUser)表服务实现类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Service
public class RbacUserServiceImpl extends ServiceImpl<RbacUserDao, RbacUser> implements RbacUserService {

    private static final Logger logger = LoggerFactory.getLogger(RbacUserServiceImpl.class);

    @Autowired private RbacUserDao userDao;

}