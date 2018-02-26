/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.storing.fi.card.StoringFICard;
import com.agit.crm.domain.storing.fi.card.StoringFICardRepository;
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
public class StoringFICardHibernateRepository extends HibernateRepository implements StoringFICardRepository {

    @Override
    public void saveOrUpdate(StoringFICard storingFICard) {
        getSession().saveOrUpdate(storingFICard);
    }

    @Override
    public void deleteData(StoringFICard storingFICard) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.storing.fi.card.StoringFICard where storingFICardID = :cid");
        query.setParameter("cid", storingFICard.getStoringFICardID());
        query.executeUpdate();
    }

    @Override
    public StoringFICard findByID(String storingFICardID) {
        Criteria criteria = getSession().createCriteria(StoringFICard.class)
                .add(Restrictions.eq("storingFICardID", storingFICardID));
        return (StoringFICard) criteria.uniqueResult();
    }

    @Override
    public List<StoringFICard> findAll() {
        return (List<StoringFICard>) getSession()
                .createQuery("from com.agit.crm.domain.storing.fi.card.StoringFICard")
                .list();
    }

    @Override
    public List<StoringFICard> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
