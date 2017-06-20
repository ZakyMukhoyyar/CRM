package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.role;

import com.agit.crm.common.dto.usermanagement.RolePrivilegeDTO;
import com.agit.crm.common.dto.usermanagement.RolePrivilegeDTOBuilder;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.user.management.domain.privilege.PrivilegeRepository;
import com.agit.crm.user.management.domain.role.RolePrivilege;
import com.agit.crm.user.management.domain.role.RolePrivilegeBuilder;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.IObjectAssembler;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.privilege.PrivilegeDTOAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class RolePrivilegeDTOAssembler implements IObjectAssembler<RolePrivilege, RolePrivilegeDTO> {

    private PrivilegeRepository privilegeRepository;    
    private PrivilegeDTOAssembler privilegeDTOAssembler;

    @Override
    public RolePrivilegeDTO toDTO(RolePrivilege domainObject) {
        return new RolePrivilegeDTOBuilder()
                .setPrivilegeDTO(privilegeDTOAssembler.toDTO(domainObject.getPrivilege(), false))
                .setAccessType(domainObject.getAccessType())
                .createRolePrivilegeDTO();
    }

    @Override
    public RolePrivilege toDomain(RolePrivilegeDTO dtoObject) {
        return new RolePrivilegeBuilder()
                .setPrivilege(privilegeRepository.findByID(dtoObject.getPrivilegeDTO().getPrivilegeID(), StatusData.ACTIVE))
                .setAccessType(dtoObject.getAccessType())
                .createRolePrivilege();
    }

    public List<RolePrivilegeDTO> toDTOs(List<RolePrivilege> arg0) {
        List<RolePrivilegeDTO> res = new ArrayList<>();
        for (RolePrivilege o : arg0) {
            res.add(toDTO(o));
        }
        return res;
    }

    public List<RolePrivilege> toDomains(List<RolePrivilegeDTO> arg0) {
        List<RolePrivilege> res = new ArrayList<>();
        for (RolePrivilegeDTO o : arg0) {
            res.add(toDomain(o));
        }
        return res;
    }

    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    public void setPrivilegeDTOAssembler(PrivilegeDTOAssembler privilegeDTOAssembler) {
        this.privilegeDTOAssembler = privilegeDTOAssembler;
    }

}
