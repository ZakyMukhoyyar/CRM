package com.agit.crm.user.management.domain.privilege;

import com.agit.crm.shared.type.StatusData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public interface PrivilegeRepository {

    void saveOrUpdate(Privilege privilege);

    Privilege findByID(String privilegeID, StatusData status);
    
    List<Privilege> findByListID(List<String> privilegeID, StatusData status);

    List<Privilege> findAll();
    
    List<Privilege> findByParams(Map map);

    List<Privilege> findByParameter(String privilegeId);

    List<Privilege> findByParentId(String parentId, boolean isMenu);

    List<String> getAllAuthorities();

}
