package com.agit.crm.user.management.application;

import com.agit.crm.common.dto.usermanagement.RoleDTO;
import com.agit.crm.shared.type.StatusData;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public interface RoleService {


    void saveOrUpdate(RoleDTO role);

    RoleDTO findByID(String roleID);

    List<RoleDTO> findAll();

    List<RoleDTO> findAllByStatus(StatusData statusData);

    List<RoleDTO> findByParameter(String roleName);

    List<String> grantedAuthoritys(String roleID);
}
