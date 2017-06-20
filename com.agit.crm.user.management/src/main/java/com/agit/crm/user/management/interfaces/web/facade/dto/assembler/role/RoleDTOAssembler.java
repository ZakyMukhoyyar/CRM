package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.role;

import com.agit.crm.common.dto.usermanagement.RoleDTO;
import com.agit.crm.common.dto.usermanagement.RoleDTOBuilder;
import com.agit.crm.user.management.domain.role.Role;
import com.agit.crm.user.management.domain.role.RoleBuilder;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class RoleDTOAssembler implements IObjectAssembler<Role, RoleDTO> {

    private RolePrivilegeDTOAssembler rolePrivilegeDTOAssembler;

    @Override
    public RoleDTO toDTO(Role domainObject) {
        return new RoleDTOBuilder()
                .setCreationalDate(domainObject.getCreationalDate())
                .setRoleStatus(domainObject.getRoleStatus())
                .setRolePrivilegeDTOs(domainObject.getRolePrivileges() == null ? null : rolePrivilegeDTOAssembler.toDTOs(domainObject.getRolePrivileges()))
                .setRoleID(domainObject.getRoleID())
                .setRoleName(domainObject.getRoleName())
                .setCreationalBy(domainObject.getCreationalBy())
                .setRoleDescription(domainObject.getRoleDescription())
                .createRoleDTO();
    }

    public RoleDTO noPrivilegeToDTO(Role domainObject) {
        return new RoleDTOBuilder()
                .setCreationalDate(domainObject.getCreationalDate())
                .setRoleStatus(domainObject.getRoleStatus())
                .setRoleID(domainObject.getRoleID())
                .setRoleName(domainObject.getRoleName())
                .setCreationalBy(domainObject.getCreationalBy())
                .setRoleDescription(domainObject.getRoleDescription())
                .createRoleDTO();
    }

    @Override
    public Role toDomain(RoleDTO dtoObject) {
        return new RoleBuilder()
                .setCreationalDate(dtoObject.getCreationalDate())
                .setRoleStatus(dtoObject.getRoleStatus())
                .setRolePrivileges(rolePrivilegeDTOAssembler.toDomains(dtoObject.getRolePrivilegeDTOs()))
                .setRoleID(dtoObject.getRoleID())
                .setRoleName(dtoObject.getRoleName())
                .setCreationalBy(dtoObject.getCreationalBy())
                .setRoleDescription(dtoObject.getRoleDescription())
                .createRole();
    }

    public List<RoleDTO> toDTOs(List<Role> arg0) {
        List<RoleDTO> res = new ArrayList<>();
        for (Role o : arg0) {
            res.add(toDTO(o));
        }
        return res;
    }

    public List<RoleDTO> noPrivilegeToDTOs(List<Role> arg0) {
        List<RoleDTO> res = new ArrayList<>();
        for (Role o : arg0) {
            res.add(noPrivilegeToDTO(o));
        }
        return res;
    }

    public List<Role> toDomains(List<RoleDTO> arg0) {
        List<Role> res = new ArrayList<>();
        for (RoleDTO o : arg0) {
            res.add(toDomain(o));
        }
        return res;
    }

    public void setRolePrivilegeDTOAssembler(RolePrivilegeDTOAssembler rolePrivilegeDTOAssembler) {
        this.rolePrivilegeDTOAssembler = rolePrivilegeDTOAssembler;
    }

}
