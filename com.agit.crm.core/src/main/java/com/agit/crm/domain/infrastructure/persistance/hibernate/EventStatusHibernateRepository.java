package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.EventStatus;
import com.agit.crm.domain.crm.EventStatusRepository;
import com.agit.crm.domain.crm.EventStatus;
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
public class EventStatusHibernateRepository extends HibernateRepository implements EventStatusRepository {

    @Override
    public void saveOrUpdate(EventStatus eventStatus) {
        getSession().saveOrUpdate(eventStatus);
    }

    @Override
    public void deleteData(EventStatus eventStatus) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.EventStatus where idEventStatus = :cid");
        query.setParameter("cid", eventStatus.getIdEventStatus());
        query.executeUpdate();
    }

    @Override
    public EventStatus findByID(String idEventStatus) {
        return (EventStatus) getSession()
                .createQuery("from com.agit.crm.domain.crm.EventStatus where idEventStatus = :cid")
                .setParameter("cid", idEventStatus)
                .uniqueResult();
    }

    @Override
    public List<EventStatus> findAll() {
        return (List<EventStatus>) getSession()
                .createQuery("from com.agit.crm.domain.crm.EventStatus")
                .list();
    }

    @Override
    public List<EventStatus> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(EventStatus.class);
        if (StringUtil.hasValue(map.get("idEventStatus"))) {
            criteria.add(Restrictions.eq("idEventStatus", map.get("idEventStatus")));
        }
        if (StringUtil.hasValue(map.get("idUser"))) {
            criteria.add(Restrictions.eq("idUser", map.get("idUser")));
        }
        if (StringUtil.hasValue(map.get("idEvent"))) {
            criteria.add(Restrictions.eq("idEvent", map.get("idEvent")));
        }
        if (StringUtil.hasValue(map.get("lowonganState"))) {
            criteria.add(Restrictions.eq("lowonganState", map.get("lowonganState")));
        }
        return criteria.list();
    }

    @Override
    public List<EventStatus> findByParams2(Map map2) {
        Criteria criteria = getSession().createCriteria(EventStatus.class);
        criteria.add(Restrictions.eq("idUser", map2.get("idUser")));
        criteria.add(Restrictions.eq("idEvent", map2.get("idEvent")));
        return (List<EventStatus>) criteria.list();
    }
    
}
