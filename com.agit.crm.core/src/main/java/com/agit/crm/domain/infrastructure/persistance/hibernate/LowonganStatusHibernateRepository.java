package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.LowonganStatus;
import com.agit.crm.domain.crm.LowonganStatusRepository;
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
@Transactional
@Repository
public class LowonganStatusHibernateRepository extends HibernateRepository implements LowonganStatusRepository{

    @Override
    public void saveOrUpdate(LowonganStatus lowonganStatus) {
        getSession().saveOrUpdate(lowonganStatus);
    }

    @Override
    public void deleteData(LowonganStatus lowonganStatus) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.LowonganStatus where idLowonganStatus = :cid");
        query.setParameter("cid", lowonganStatus.getIdLowonganStatus());
        query.executeUpdate();
    }

    @Override
    public LowonganStatus findByID(String idLowonganStatus) {
        return (LowonganStatus) getSession()
                .createQuery("from com.agit.crm.domain.crm.LowonganStatus where idLowonganStatus = :cid")
                .setParameter("cid", idLowonganStatus)
                .uniqueResult();
    }

    @Override
    public List<LowonganStatus> findAll() {
        return (List<LowonganStatus>) getSession()
                .createQuery("from com.agit.crm.domain.crm.LowonganStatus")
                .list();
    }

    @Override
    public List<LowonganStatus> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(LowonganStatus.class);
        if(StringUtil.hasValue(map.get("idLowonganStatus"))){
            criteria.add(Restrictions.eq("idLowonganStatus", map.get("idLowonganStatus")));
        }
        if(StringUtil.hasValue(map.get("lowonganState"))){
            criteria.add(Restrictions.eq("lowonganState", map.get("lowonganState")));
        }
        return criteria.list();
    }
    
}
