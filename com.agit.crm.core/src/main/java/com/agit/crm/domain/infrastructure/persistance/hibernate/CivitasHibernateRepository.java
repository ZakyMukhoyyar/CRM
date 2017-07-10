package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Civitas;
import com.agit.crm.domain.crm.CivitasRepository;
import com.agit.crm.util.StringUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 3AD
 */
@Repository
@Transactional
public class CivitasHibernateRepository extends HibernateRepository implements CivitasRepository {

    @Override
    public void saveOrUpdate(Civitas civitas) {
        getSession().saveOrUpdate(civitas);
    }

    @Override
    public void deleteData(Civitas civitas) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Civitas where civitasID = :cid");
        query.setParameter("cid", civitas.getCivitasID());
        query.executeUpdate();
    }

    @Override
    public Civitas findByID(String civitasID) {
        return (Civitas) getSession()
                .createQuery("from com.agit.crm.domain.crm.Civitas where civitasID = :cid")
                .setParameter("cid", civitasID)
                .uniqueResult();
    }

    @Override
    public List<Civitas> findAll() {
        return (List<Civitas>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Civitas ")
                .list();
    }

    @Override
    public List<Civitas> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Civitas.class);
        if (StringUtil.hasValue(map.get("civitasID"))) {
            criteria.add(Restrictions.eq("civitasID", map.get("civitasID")));
        }
        if (StringUtil.hasValue(map.get("namaCivitas"))) {
            criteria.add(Restrictions.like("namaCivitas", "%" + map.get("namaCivitas") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }

        return criteria.list();
    }

}
