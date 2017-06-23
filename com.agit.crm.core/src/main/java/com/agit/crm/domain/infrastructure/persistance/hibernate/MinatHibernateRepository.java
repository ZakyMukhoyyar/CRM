package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Minat;
import com.agit.crm.domain.crm.MinatRepository;
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
 * @author Zaky
 */
@Repository
@Transactional
public class MinatHibernateRepository extends HibernateRepository implements MinatRepository{

    @Override
    public void saveOrUpdate(Minat minat) {
        getSession().saveOrUpdate(minat);
    }

    @Override
    public void deleteData(Minat minat) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Minat where idMinat = :tid");
        query.setParameter("tid", minat.getIdMinat());
        query.executeUpdate();
    }

    @Override
    public Minat findByID(String idMinat) {
        return (Minat) getSession()
                .createQuery("from com.agit.crm.domain.crm.Minat where idMinat = :tid")
                .setParameter("tid", idMinat)
                .uniqueResult();
    }

    @Override
    public List<Minat> findAll() {
        return (List<Minat>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Minat")
                .list();
    }

    @Override
    public List<Minat> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Minat.class);
        if(StringUtil.hasValue(map.get("idMinat"))){
            criteria.add(Restrictions.eq("idMinat", map.get("idMinat")));
        }
        if(StringUtil.hasValue(map.get("idMinat"))){
            criteria.add(Restrictions.like("namaMinat", "%" +map.get("namaMinat")+ "%" ).ignoreCase());
        }
        return criteria.list();
    }
    
}
