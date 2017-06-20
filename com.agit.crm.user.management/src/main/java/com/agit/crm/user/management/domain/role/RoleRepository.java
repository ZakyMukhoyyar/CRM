package com.agit.crm.user.management.domain.role;

import com.agit.crm.shared.type.StatusData;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public interface RoleRepository {
    void saveOrUpdate(Role role);
    Role findByID(String roleID);
    List<Role> findAll();
    List<Role> findAllByStatus(StatusData statusData);
    List<Role> findByParameter(String roleName);
}
