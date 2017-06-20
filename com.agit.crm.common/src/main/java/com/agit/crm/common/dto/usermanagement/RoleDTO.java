package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.StatusData;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class RoleDTO implements Serializable {

    private String roleID;
    private String roleName;
    private String roleDescription;
    private StatusData roleStatus;
    private List<RolePrivilegeDTO> rolePrivilegeDTOs;
    private Date creationalDate;
    private String creationalBy;

    public RoleDTO() {
    }

    public RoleDTO(String roleID, String roleName, String roleDescription, StatusData roleStatus, List<RolePrivilegeDTO> rolePrivilegeDTOs, Date creationalDate, String creationalBy) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.roleStatus = roleStatus;
        this.rolePrivilegeDTOs = rolePrivilegeDTOs;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RolePrivilegeDTO> getRolePrivilegeDTOs() {
        return rolePrivilegeDTOs;
    }

    public void setRolePrivilegeDTOs(List<RolePrivilegeDTO> rolePrivilegeDTOs) {
        this.rolePrivilegeDTOs = rolePrivilegeDTOs;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public StatusData getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(StatusData roleStatus) {
        this.roleStatus = roleStatus;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT+7")
    public Date getCreationalDate() {
        return creationalDate;
    }

    public void setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    public void setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
    }

    @Override
    public String toString() {
        return "RoleDTO{" + "roleID=" + roleID + ", roleName=" + roleName + ", roleDescription=" + roleDescription + ", roleStatus=" + roleStatus + ", rolePrivilegeDTOs=" + rolePrivilegeDTOs + ", creationalDate=" + creationalDate + ", creationalBy=" + creationalBy + '}';
    }

    public static RoleDTO getInstance() {

        RoleDTO role = new RoleDTOBuilder()
                .setRoleID("roleID")
                .setRoleName("roleName")
                .setRoleStatus(StatusData.DELETED)
                .setCreationalBy("creationalBy")
                .setCreationalDate(new Date())
                .setRoleDescription("roleDescription")
                .createRoleDTO();
        return role;
    }
}
