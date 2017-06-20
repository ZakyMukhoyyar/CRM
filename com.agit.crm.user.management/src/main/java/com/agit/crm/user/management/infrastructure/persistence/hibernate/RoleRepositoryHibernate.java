package com.agit.crm.user.management.infrastructure.persistence.hibernate;

import com.agit.crm.shared.type.StatusData;
import com.agit.crm.user.management.domain.role.Role;
import com.agit.crm.user.management.domain.role.RoleRepository;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bayutridewanto
 */
@Repository
@Transactional
public class RoleRepositoryHibernate extends HibernateRepository implements RoleRepository {

    @Override
    public void saveOrUpdate(Role role) {
        getSession().saveOrUpdate(role);
    }

    @Override
    public Role findByID(String roleID) {
        return (Role) getSession().createCriteria(Role.class).add(Restrictions.eq("roleID", roleID)).uniqueResult();
    }

    @Override
    public List<Role> findAll() {
        Criteria criteria = getSession().createCriteria(Role.class);
        return (List<Role>) criteria.list();
    }

    @Override
    public List<Role> findByParameter(String roleName) {
        Criteria criteria = getSession().createCriteria(Role.class)
                .add(Restrictions.like("roleName", roleName).ignoreCase())
                .add(Restrictions.or(Restrictions.eq("roleStatus", StatusData.ACTIVE), Restrictions.eq("roleStatus", StatusData.INACTIVE)));
        return (List<Role>) criteria.list();
    }

    @Override
    public List<Role> findAllByStatus(StatusData statusData) {
        Criteria criteria = getSession().createCriteria(Role.class)
                .add(Restrictions.eq("roleStatus", statusData));
        return (List<Role>) criteria.list();
    }

}
