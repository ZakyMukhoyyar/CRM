package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.EventAgitRepository;
import com.agit.crm.domain.crm.EventAgit;
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
public class EventAgitHibernateRepository extends HibernateRepository implements EventAgitRepository {

    @Override
    public void saveOrUpdate(EventAgit eventAgit) {
        getSession().saveOrUpdate(eventAgit);
    }

    @Override
    public void deleteData(EventAgit eventAgit) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.EventAgit where idEvent = :tid");
        query.setParameter("tid", eventAgit.getIdEvent());
        query.executeUpdate();
    }

    @Override
    public EventAgit findByID(String idEvent) {
        return (EventAgit) getSession()
                .createQuery("from com.agit.crm.domain.crm.EventAgit where idEvent = :tid")
                .setParameter("tid", idEvent)
                .uniqueResult();
    }

    @Override
    public List<EventAgit> findAll() {
        return (List<EventAgit>) getSession()
                .createQuery("from com.agit.crm.domain.crm.EventAgit ")
                .list();
    }

    @Override
    public List<EventAgit> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(EventAgit.class);
        if (StringUtil.hasValue(map.get("idEvent"))) {
            criteria.add(Restrictions.eq("idEvent", map.get("idEvent")));
        }
        if (StringUtil.hasValue(map.get("namaEvent"))) {
            criteria.add(Restrictions.like("namaEvent", "%" + map.get("namaEvent") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("endDate"))) {
            criteria.add(Restrictions.eq("endDate", map.get("endDate")));
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }
        return criteria.list();
    }

}
