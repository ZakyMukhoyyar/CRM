/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.storing.fi.card.StoringFICard;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOC;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOCRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BayuHS
 */
@Repository
@Transactional
public class StoringFICardPOCHibernateRepository extends HibernateRepository implements StoringFICardPOCRepository {

    @Override
    public void saveOrUpdate(StoringFICardPOC storingFICardPOC) {
        getSession().saveOrUpdate(storingFICardPOC);
    }

    @Override
    public void deleteData(StoringFICardPOC storingFICardPOC) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOC where storingFICardPocID = :cid");
        query.setParameter("cid", storingFICardPOC.getFrameNumber());
        query.executeUpdate();
    }

    @Override
    public StoringFICardPOC findByID(String storingFICardPocID) {
        Criteria criteria = getSession().createCriteria(StoringFICardPOC.class)
                .add(Restrictions.eq("storingFICardPocID", storingFICardPocID));
        return (StoringFICardPOC) criteria.uniqueResult();
    }

    @Override
    public List<StoringFICardPOC> findAll() {
        return (List<StoringFICardPOC>) getSession()
                .createQuery("from com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOC")
                .list();
    }

    @Override
    public List<StoringFICardPOC> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
