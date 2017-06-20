package com.agit.crm.user.management.application.impl;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import com.agit.crm.user.management.application.PrivilegeService;
import com.agit.crm.user.management.domain.privilege.Privilege;
import com.agit.crm.user.management.domain.privilege.PrivilegeRepository;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.privilege.PrivilegeDTOAssembler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author bayutridewanto
 */
public class PrivilegeServiceImpl implements PrivilegeService {

    private PrivilegeRepository privilegeRepository;
    private PrivilegeDTOAssembler privilegeDTOAssembler;

    @Override
    public void saveOrUpdate(PrivilegeDTO privilegeDTO) {
        Privilege privilege = privilegeRepository.findByID(privilegeDTO.getPrivilegeID(), null);

        if (privilege == null) {
            privilege = privilegeDTOAssembler.toDomain(privilegeDTO);
        } else {
            /* update specification */
            privilege.assignNewSpecification(
                    privilegeDTO.getPrivilegeName(),
                    privilegeDTO.getPrivilegeStatus(),
                    privilegeDTO.getParentID(),
                    privilegeDTO.isMenu(),
                    privilegeDTO.getMenuName(),
                    privilegeDTO.getTabName(),
                    privilegeDTO.getUrl(),
                    privilegeDTO.getIcon());
        }

        privilegeRepository.saveOrUpdate(privilege);
    }

    @Override
    public PrivilegeDTO findByID(String privilegeID) {
        Validate.notNull(privilegeRepository);
        Privilege privilege = (Privilege) privilegeRepository.findByID(privilegeID, null);
        if (privilege != null) {
            return privilegeDTOAssembler.toDTO(privilege, true);
        }

        return null;
    }

    @Override
    public List<PrivilegeDTO> findByListID(List<String> privilegeID) {
        Validate.notNull(privilegeRepository);
        List<PrivilegeDTO> l = new ArrayList();
        List<Privilege> privilege = (List<Privilege>) privilegeRepository.findByListID(privilegeID, null);
        for (Privilege p : privilege) {
            if (p != null) {
                l.add(privilegeDTOAssembler.toDTO(p, true));
            }
        }

        return l;
    }

    @Override
    public List<PrivilegeDTO> findAll() {
        Validate.notNull(privilegeRepository);
        List<Privilege> privileges = (List<Privilege>) privilegeRepository.findAll();
        return privilegeDTOAssembler.toDTOs(privileges, true);
    }

    @Override
    public List<PrivilegeDTO> findByParameter(String privilegeID) {
        Validate.notNull(privilegeRepository);
        List<Privilege> privileges = (List<Privilege>) privilegeRepository.findByParameter(privilegeID);
        if (privileges != null) {
            return privilegeDTOAssembler.toDTOs(privileges, true);
        }

        return new ArrayList<>();
    }

    @Override
    public List<PrivilegeDTO> findByParentId(String parentId, boolean isMenu) {
        Validate.notNull(privilegeRepository);
        List<Privilege> privileges = (List<Privilege>) privilegeRepository.findByParentId(parentId, true);
        if (privileges != null) {
            return privilegeDTOAssembler.toDTOs(privileges, true);
        }

        return new ArrayList<>();
    }

    @Override
    public List<PrivilegeDTO> findMenu() {
        return findMenu("ROOT");
    }

    @Override
    public List<PrivilegeDTO> findMenu(String privilegeID) {
        Validate.notNull(privilegeRepository);
        List<Privilege> privileges = new ArrayList<>();
        Privilege root = privilegeRepository.findByID(privilegeID, null);
        if (root != null) {
            privileges.add(root);
        }

        return privilegeDTOAssembler.toDTOs(privileges, true);
    }

    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    public void setPrivilegeDTOAssembler(PrivilegeDTOAssembler privilegeDTOAssembler) {
        this.privilegeDTOAssembler = privilegeDTOAssembler;
    }

    @Override
    public List<PrivilegeDTO> findByParam(Map map) {
        Validate.notNull(privilegeRepository);
        List<Privilege> listPrivilege = privilegeRepository.findByParams(map);
        if (listPrivilege != null) {
            return (List<PrivilegeDTO>) privilegeDTOAssembler.toDTOs(listPrivilege, true);
        }
        return null;
    }

}
