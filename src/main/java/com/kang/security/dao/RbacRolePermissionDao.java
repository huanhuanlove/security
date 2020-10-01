package com.kang.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.kang.security.entity.RbacRolePermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RbacRolePermission)表服务接口
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Mapper
public interface RbacRolePermissionDao extends BaseMapper<RbacRolePermission> {
    
}