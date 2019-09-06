package com.rootbant.entity;

/**
 * @Program: mybatis
 * @Description
 * @Author: Stephen
 * @Create: 2019-07-22 17:33
 **/
public class SysRolePrivilege {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long privilegeId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
