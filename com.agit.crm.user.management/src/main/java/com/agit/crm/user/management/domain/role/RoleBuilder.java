package com.agit.crm.user.management.domain.role;

import com.agit.crm.shared.type.StatusData;
import java.util.Date;
import java.util.List;


public class RoleBuilder {
    private String roleID;
    private String roleName;
    private String roleDescription;
    private StatusData roleStatus;
    private List<RolePrivilege> rolePrivileges;
    private Date creationalDate;
    private String creationalBy;

    public RoleBuilder() {
    }

    public RoleBuilder setRoleID(String roleID) {
        this.roleID = roleID;
        return this;
    }

    public RoleBuilder setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public RoleBuilder setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
        return this;
    }

    public RoleBuilder setRoleStatus(StatusData roleStatus) {
        this.roleStatus = roleStatus;
        return this;
    }

    public RoleBuilder setRolePrivileges(List<RolePrivilege> rolePrivileges) {
        this.rolePrivileges = rolePrivileges;
        return this;
    }

    public RoleBuilder setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
        return this;
    }

    public RoleBuilder setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
        return this;
    }

    public Role createRole() {
        return new Role(roleID, roleName, roleDescription, roleStatus, rolePrivileges, creationalDate, creationalBy);
    }

}
