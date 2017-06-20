package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.AccessType;
import java.io.Serializable;

/**
 *
 * @author bayutridewanto
 */
public class RolePrivilegeDTO implements Serializable{
    private PrivilegeDTO privilegeDTO;
    private AccessType accessType;

    public RolePrivilegeDTO() {
    }

    public RolePrivilegeDTO(PrivilegeDTO privilegeDTO, AccessType accessType) {
        this.privilegeDTO = privilegeDTO;
        this.accessType = accessType;
    }

    public PrivilegeDTO getPrivilegeDTO() {
        return privilegeDTO;
    }

    public void setPrivilegeDTO(PrivilegeDTO privilegeDTO) {
        this.privilegeDTO = privilegeDTO;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    @Override
    public String toString() {
        return "RolePrivilegeDTO{" + "privilegeDTO=" + privilegeDTO + ", accessType=" + accessType + '}';
    }
    public static RolePrivilegeDTO getInstance() {
        
        RolePrivilegeDTO rolePrivilege = new RolePrivilegeDTOBuilder()
                .setAccessType(AccessType.DENY)
                .setPrivilegeDTO(PrivilegeDTO.getInstance())
                .createRolePrivilegeDTO();
        return rolePrivilege;
    }
}
