package com.agit.crm.user.management.domain.role;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.StatusData;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class Role implements EntityObject<Role> {

    /* id for attribute */
    long id;

    private String roleID;
    private String roleName;
    private String roleDescription;
    private StatusData roleStatus;
    private List<RolePrivilege> rolePrivileges;

    /* Cretional */
    private Date creationalDate;
    private String creationalBy;

    public Role() {
    }

    public Role(String roleID, String roleName, String roleDescription, StatusData roleStatus, List<RolePrivilege> rolePrivileges, Date creationalDate, String creationalBy) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.roleStatus = roleStatus;
        this.rolePrivileges = rolePrivileges;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
    }

    public void assignNewStatus(StatusData status) {
        this.roleStatus = status;
    }

    public void assignNewRoleData(String roleName, String roleDescription, List<RolePrivilege> rolePrivileges) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.rolePrivileges = rolePrivileges;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public StatusData getRoleStatus() {
        return roleStatus;
    }

    public List<RolePrivilege> getRolePrivileges() {
        return rolePrivileges;
    }

    public Date getCreationalDate() {
        return creationalDate;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.roleID);
        hash = 31 * hash + Objects.hashCode(this.roleName);
        hash = 31 * hash + Objects.hashCode(this.roleDescription);
        hash = 31 * hash + Objects.hashCode(this.roleStatus);
        hash = 31 * hash + Objects.hashCode(this.rolePrivileges);
        hash = 31 * hash + Objects.hashCode(this.creationalDate);
        hash = 31 * hash + Objects.hashCode(this.creationalBy);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(Role other) {
        return this.equals(other);
    }

    public void assignNewSpecification(String roleName, String roleDescription, StatusData roleStatus, List<RolePrivilege> rolePrivileges) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.roleStatus = roleStatus;
        this.rolePrivileges = rolePrivileges;
    }
}
