/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.KomentarEvent;
import com.agit.crm.domain.crm.KomentarEventRepository;
import com.agit.crm.util.JDCStringUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class KomentarEventHibernateRepository extends HibernateRepository implements KomentarEventRepository{

    @Override
    public void saveOrUpdate(KomentarEvent komentarEvent) {
        getSession().saveOrUpdate(komentarEvent);
    }

    @Override
    public void delete(KomentarEvent komentarEvent) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.KomentarEvent where komentarID = :kid");
        query.setParameter("kid", komentarEvent.getKomentarID());
        query.executeUpdate();
    }

    @Override
    public KomentarEvent findByID(String komentarID) {
        Query query = getSession().createQuery("from com.agit.crm.domain.crm.KomentarEvent where komentarID = :kid");
        query.setParameter("kid", komentarID);
        return (KomentarEvent) query.uniqueResult();    
    }

    @Override
    public List<KomentarEvent> findAll() {
        Criteria criteria = getSession().createCriteria(KomentarEvent.class);
        return (List<KomentarEvent>) criteria.list();
    }

    @Override
    public List<KomentarEvent> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(KomentarEvent.class);            
        if (JDCStringUtil.hasValue(map.get("komentarID"))) {
            criteria.add(Restrictions.eq("komentarID", map.get("komentarID")));
        }
        if (JDCStringUtil.hasValue(map.get("komentar"))) {
            criteria.add(Restrictions.eq("komentar", map.get("komentar")));
        }
        return (List<KomentarEvent>) criteria.list();
    }

    @Override
    public List<KomentarEvent> findAllByID(String idEvent) {
        Criteria criteria = getSession().createCriteria(KomentarEvent.class);
        criteria.add(Restrictions.eq("idEvent", idEvent));
        return (List<KomentarEvent>) criteria.list();
    }
    
}
