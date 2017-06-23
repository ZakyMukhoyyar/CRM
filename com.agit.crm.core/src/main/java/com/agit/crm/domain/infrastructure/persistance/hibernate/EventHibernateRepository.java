package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.EventRepository;
import com.agit.crm.domain.crm.Event;
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
public class EventHibernateRepository extends HibernateRepository implements EventRepository {

    @Override
    public void saveOrUpdate(Event event) {
        getSession().saveOrUpdate(event);
    }

    @Override
    public void deleteData(Event event) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Event where idEvent = :tid");
        query.setParameter("tid", event.getIdEvent());
        query.executeUpdate();
    }

    @Override
    public Event findByID(String idEvent) {
        return (Event) getSession()
                .createQuery("from com.agit.crm.domain.crm.Event where idEvent = :tid")
                .setParameter("tid", idEvent)
                .uniqueResult();
    }

    @Override
    public List<Event> findAll() {
        return (List<Event>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Event ")
                .list();
    }

    @Override
    public List<Event> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Event.class);
        if (StringUtil.hasValue(map.get("idEvent"))) {
            criteria.add(Restrictions.eq("idEvent", map.get("idEvent")));
        }
        if (StringUtil.hasValue(map.get("namaEvent"))) {
            criteria.add(Restrictions.like("namaEvent", "%" + map.get("namaEvent") + "%").ignoreCase());
        }

        return criteria.list();
    }
    
}
