package com.kang.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.kang.security.entity.RbacRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RbacRole)表服务接口
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Mapper
public interface RbacRoleDao extends BaseMapper<RbacRole> {
    
}