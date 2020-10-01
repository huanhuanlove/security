package com.kang.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.kang.security.entity.RbacPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RbacPermission)表服务接口
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Mapper
public interface RbacPermissionDao extends BaseMapper<RbacPermission> {
    
}