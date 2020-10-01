package com.kang.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (RbacPermission)表实体类
 *
 * @author kang
 * @since 2020-09-29 20:40:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RbacPermission extends Model<RbacPermission> {
    
    private Long id;
    
    private String description;
    
    private Boolean enable;
    
    private String name;
    
    private String path;
    
    private String permissionKey;
    
    private String resource;
    
    private String type;
    
    private int weight;
    
    private Long parentId;
}