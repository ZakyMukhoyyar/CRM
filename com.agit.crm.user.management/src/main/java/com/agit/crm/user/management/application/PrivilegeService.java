package com.agit.crm.user.management.application;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public interface PrivilegeService {


    void saveOrUpdate(PrivilegeDTO privilege);

    PrivilegeDTO findByID(String privilegeID);
    
    List<PrivilegeDTO> findByListID(List<String> privilegeID);

    List<PrivilegeDTO> findAll();
    
    List<PrivilegeDTO> findByParam(Map map);

    List<PrivilegeDTO> findByParameter(String privilegeId);

    List<PrivilegeDTO> findByParentId(String parentId, boolean isMenu);

    List<PrivilegeDTO> findMenu();
    
    List<PrivilegeDTO> findMenu(String privilegeID);
}
