package com.kang.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (RbacRole)表实体类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RbacRole extends Model<RbacRole> {
    
    private Long id;
    
    private String description;
    
    private Boolean enable;
    
    private String roleKey;
    
    private String roleName;
}