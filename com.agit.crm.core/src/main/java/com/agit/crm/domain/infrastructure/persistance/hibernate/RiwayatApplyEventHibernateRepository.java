package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.domain.crm.RiwayatApplyEvent;
import com.agit.crm.domain.crm.RiwayatApplyEventRepository;
import com.agit.crm.shared.state.LowonganState;
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
 * @author 3AD
 */
@Repository
@Transactional
public class RiwayatApplyEventHibernateRepository extends HibernateRepository implements RiwayatApplyEventRepository {

    @Override
    public void saveOrUpdate(RiwayatApplyEvent riwayatApplyEvent) {
        getSession().saveOrUpdate(riwayatApplyEvent);
    }

    @Override
    public void delete(RiwayatApplyEvent riwayatApplyEvent) {
        Query query = getSession().createQuery("DELETE FROM com.agit.crm.domain.crm.RiwayatApplyEvent WHERE idRiwayatApplyEvent = :ied");
        query.setParameter("ied", riwayatApplyEvent.getIdRiwayatApplyEvent());
        query.executeUpdate();
    }

    @Override
    public RiwayatApplyEvent findByID(String idRiwayatApplyEvent) {
        Query query = getSession().createQuery("FROM com.agit.crm.domain.crm.RiwayatApplyEvent WHERE idRiwayatApplyEvent = :ied");
        query.setParameter("ied", idRiwayatApplyEvent);
        return (RiwayatApplyEvent) query.uniqueResult();
    }

    @Override
    public List<RiwayatApplyEvent> findAll() {
        Criteria criteria = getSession().createCriteria(RiwayatApplyEvent.class);
        return criteria.list();
    }

    @Override
    public List<RiwayatApplyEvent> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(RiwayatApplyEvent.class);
        if (JDCStringUtil.hasValue(map.get("idRiwayatApplyEvent"))) {
            criteria.add(Restrictions.eq("idRiwayatApplyEvent", map.get("idRiwayatApplyEvent")));
        }
        if (JDCStringUtil.hasValue(map.get("idRiwayatEvent"))) {
            criteria.add(Restrictions.eq("idRiwayatEvent", map.get("idRiwayatEvent")));
        }
        if (JDCStringUtil.hasValue(map.get("namaEvent"))) {
            criteria.add(Restrictions.like("namaEvent", map.get("namaEvent")));
        }
        if (JDCStringUtil.hasValue(map.get("lowonganState"))){
            criteria.add(Restrictions.eq("lowonganState", map.get("lowonganState")));
        }
        return criteria.list();
    }

    @Override
    public List<RiwayatApplyEvent> findAllByStatus(LowonganState lowonganState) {
        Criteria criteria = getSession().createCriteria(RiwayatApplyEvent.class);
        criteria.add(Restrictions.eq("lowonganState", lowonganState));
        return (List<RiwayatApplyEvent>) criteria.list();
    }

    @Override
    public List<RiwayatApplyEvent> findIdEvent(String idRiwayatEvent) {
        Criteria criteria = getSession().createCriteria(RiwayatApplyEvent.class);
        criteria.add(Restrictions.eq("idRiwayatEvent", idRiwayatEvent));
        return (List<RiwayatApplyEvent>) criteria.list();
    }

}
