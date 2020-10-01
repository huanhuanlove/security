package com.kang.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (RbacRolePermission)表实体类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RbacRolePermission extends Model<RbacRolePermission> {
    
    private Long roleId;
    
    private Long permissionId;
}