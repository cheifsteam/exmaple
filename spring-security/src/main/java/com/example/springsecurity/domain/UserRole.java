package com.example.springsecurity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */

@TableName("t_user_role")
public class UserRole {

    @TableField("USER_ID")
    private Long userId;
    @TableField("ROle_ID")
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
