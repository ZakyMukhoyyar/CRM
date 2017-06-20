package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.StatusData;
import java.util.Date;
import java.util.List;

public class RoleDTOBuilder {
    private String roleID;
    private String roleName;
    private String roleDescription;
    private StatusData roleStatus;
    private List<RolePrivilegeDTO> rolePrivilegeDTOs;
    private Date creationalDate;
    private String creationalBy;

    public RoleDTOBuilder() {
    }

    public RoleDTOBuilder setRoleID(String roleID) {
        this.roleID = roleID;
        return this;
    }

    public RoleDTOBuilder setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public RoleDTOBuilder setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
        return this;
    }

    public RoleDTOBuilder setRoleStatus(StatusData roleStatus) {
        this.roleStatus = roleStatus;
        return this;
    }

    public RoleDTOBuilder setRolePrivilegeDTOs(List<RolePrivilegeDTO> rolePrivilegeDTOs) {
        this.rolePrivilegeDTOs = rolePrivilegeDTOs;
        return this;
    }

    public RoleDTOBuilder setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
        return this;
    }

    public RoleDTOBuilder setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
        return this;
    }

    public RoleDTO createRoleDTO() {
        return new RoleDTO(roleID, roleName, roleDescription, roleStatus, rolePrivilegeDTOs, creationalDate, creationalBy);
    }

}
