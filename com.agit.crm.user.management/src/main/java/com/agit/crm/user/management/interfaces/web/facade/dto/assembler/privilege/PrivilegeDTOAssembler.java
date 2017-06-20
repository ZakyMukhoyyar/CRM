package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.privilege;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import com.agit.crm.common.dto.usermanagement.PrivilegeDTOBuilder;
import com.agit.crm.user.management.domain.privilege.Privilege;
import com.agit.crm.user.management.domain.privilege.PrivilegeBuilder;
import com.agit.crm.user.management.domain.privilege.PrivilegeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class PrivilegeDTOAssembler {

    private PrivilegeRepository privilegeRepository;

    public PrivilegeDTO toDTO(Privilege domainObject, boolean isFindMenu) {
        PrivilegeDTO privilegeDTO = toDTOSimpleForm(domainObject);
        //childreen
        privilegeDTO.setChildren(children(privilegeDTO.getPrivilegeID(), isFindMenu));
        return privilegeDTO;
    }

    public Privilege toDomain(PrivilegeDTO dtoObject) {
        return new PrivilegeBuilder()
                .setPrivilegeID(dtoObject.getPrivilegeID())
                .setPrivilegeName(dtoObject.getPrivilegeName())
                .setPrivilegeStatus(dtoObject.getPrivilegeStatus())
                .setParentID(dtoObject.getParentID() == null ? null : dtoObject.getParentID())
                .setCreationalDate(dtoObject.getCreationalDate())
                .setCreationalBy(dtoObject.getCreationalBy())
                .setMenu(dtoObject.isMenu())
                .setMenuName(dtoObject.getMenuName())
                .setTabName(dtoObject.getTabName())
                .setIcon(dtoObject.getIcon())
                .setUrl(dtoObject.getUrl())
                .createPrivilege();
    }

    public List<PrivilegeDTO> children(String privilegeID, boolean isFindMenu) {
        List<Privilege> subPrivileges = privilegeRepository.findByParentId(privilegeID, isFindMenu);
        List<PrivilegeDTO> subPrivilegeDTOs = new ArrayList<>();
        for (Privilege o : subPrivileges) {
            PrivilegeDTO subPrivilegeDTO = new PrivilegeDTOAssembler().toDTOSimpleForm(o);
            subPrivilegeDTO.setChildren(children(subPrivilegeDTO.getPrivilegeID(), isFindMenu));
            subPrivilegeDTOs.add(subPrivilegeDTO);
        }
        return subPrivilegeDTOs;
    }

    public PrivilegeDTO toDTOSimpleForm(Privilege domainObject) {
        return new PrivilegeDTOBuilder()
                .setPrivilegeID(domainObject.getPrivilegeID())
                .setPrivilegeName(domainObject.getPrivilegeName())
                .setPrivilegeStatus(domainObject.getPrivilegeStatus())
                .setCreationalDate(domainObject.getCreationalDate())
                .setCreationalBy(domainObject.getCreationalBy())
                .setMenu(domainObject.isMenu())
                .setMenuName(domainObject.getMenuName())
                .setTabName(domainObject.getTabName())
                .setUrl(domainObject.getUrl())
                .setIcon(domainObject.getIcon())
                .setParentID(domainObject.getParentID() == null ? null : domainObject.getParentID())
                .createPrivilegeDTO();
    }

    public List<PrivilegeDTO> toDTOs(List<Privilege> arg0, boolean isFindByMenu) {
        List<PrivilegeDTO> res = new ArrayList<>();
        for (Privilege o : arg0) {
            res.add(toDTO(o, isFindByMenu));

        }
        return res;
    }

    public List<Privilege> toDomains(List<PrivilegeDTO> arg0) {
        List<Privilege> res = new ArrayList<>();
        for (PrivilegeDTO o : arg0) {
            res.add(toDomain(o));
        }
        return res;
    }

    public List<PrivilegeDTO> toDTOSimpleForms(List<Privilege> arg0) {
        List<PrivilegeDTO> res = new ArrayList<>();
        for (Privilege o : arg0) {
            res.add(toDTOSimpleForm(o));

        }
        return res;
    }

    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

}
