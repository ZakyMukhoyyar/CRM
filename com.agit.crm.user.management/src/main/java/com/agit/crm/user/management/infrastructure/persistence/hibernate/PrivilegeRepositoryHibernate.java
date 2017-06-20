package com.agit.crm.user.management.infrastructure.persistence.hibernate;

import com.agit.crm.shared.type.StatusData;
import com.agit.crm.user.management.domain.privilege.Privilege;
import com.agit.crm.user.management.domain.privilege.PrivilegeRepository;
import com.agit.crm.util.StringUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bayutridewanto
 */
@Repository
@Transactional
public class PrivilegeRepositoryHibernate extends HibernateRepository implements PrivilegeRepository {

    @Override
    public void saveOrUpdate(Privilege privilege) {
        getSession().saveOrUpdate(privilege);
    }

    @Override
    public Privilege findByID(String privilegeID, StatusData status) {
        Criteria criteria = getSession().createCriteria(Privilege.class).add(Restrictions.eq("privilegeID", privilegeID));
        if (status != null) {
            criteria.add(Restrictions.eq("privilegeStatus", status));
        }
        return (Privilege) criteria.uniqueResult();
    }

    @Override
    public List<Privilege> findByListID(List<String> privilegeID, StatusData status) {
        Criteria criteria = getSession().createCriteria(Privilege.class).add(Restrictions.in("privilegeID", privilegeID));
        if (status != null) {
            criteria.add(Restrictions.eq("privilegeStatus", status));
        }
        return (List<Privilege>) criteria.list();
    }

    @Override
    public List<Privilege> findAll() {
        Criteria criteria = getSession().createCriteria(Privilege.class).setCacheable(true);
        return (List<Privilege>) criteria.list();
    }

    @Override
    public List<Privilege> findByParameter(String privilegeId) {
        Criteria criteria = getSession().createCriteria(Privilege.class)
                .add(Restrictions.like("privilegeID", privilegeId).ignoreCase())
                .add(Restrictions.or(Restrictions.eq("privilegeStatus", StatusData.ACTIVE), Restrictions.eq("privilegeStatus", StatusData.INACTIVE)))
                .setCacheable(true)
                .addOrder(Order.asc("privilegeID"));
        return (List<Privilege>) criteria.list();
    }

    @Override
    public List<Privilege> findByParentId(String parentId, boolean isMenu) {
        Criteria criteria = getSession().createCriteria(Privilege.class);
        criteria.add(Restrictions.eq("parentID", parentId))
                .add(Restrictions.ne("privilegeStatus", StatusData.DELETED))
                .setCacheable(true);
        if (isMenu) {
            criteria.add(Restrictions.eq("menu", true));
        }
        return (List<Privilege>) criteria.list();
    }

    @Override
    public List<String> getAllAuthorities() {
        Criteria criteria = getSession().createCriteria(Privilege.class)
                .add(Restrictions.eq("privilegeStatus", StatusData.ACTIVE));
        criteria.setProjection(Projections.property("privilegeID"));
        return (List<String>) criteria.list();
    }

    @Override
    public List<Privilege> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Privilege.class);

        if (StringUtil.hasValue(map.get("privilegeID"))) {
            criteria.add(Restrictions.like("privilegeID", "%" + map.get("privilegeID") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("privilegeName"))) {
            criteria.add(Restrictions.like("privilegeName", "%" + map.get("privilegeName") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("privilegeStatus"))) {
            criteria.add(Restrictions.eq("privilegeStatus", map.get("privilegeStatus")));
        }
        return criteria.list();
    }

}
