package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Keterampilan;
import com.agit.crm.domain.crm.KeterampilanRepository;
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
public class KeterampilanHibernateRepository extends HibernateRepository implements KeterampilanRepository {

    @Override
    public void saveOrUpdate(Keterampilan keterampilan) {
        getSession().saveOrUpdate(keterampilan);
    }

    @Override
    public void deleteData(Keterampilan keterampilan) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Keterampilan where idKeterampilan = :tid");
        query.setParameter("tid", keterampilan.getIdKeterampilan());
        query.executeUpdate();
    }

    @Override
    public Keterampilan findByID(String idKeterampilan) {
        return (Keterampilan) getSession()
                .createQuery("from com.agit.crm.domain.crm.Keterampilan where idKeterampilan = :tid")
                .setParameter("tid", idKeterampilan)
                .uniqueResult();
    }

    @Override
    public List<Keterampilan> findAll() {
        return (List<Keterampilan>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Keterampilan ")
                .list();
    }

    @Override
    public List<Keterampilan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Keterampilan.class);
        if (StringUtil.hasValue(map.get("idKeterampilan"))) {
            criteria.add(Restrictions.eq("idKeterampilan", map.get("idKeterampilan")));
        }
        if (StringUtil.hasValue(map.get("namaKeterampilan"))) {
            criteria.add(Restrictions.like("namaKeterampilan", "%" + map.get("namaKeterampilan") + "%").ignoreCase());
        }

        return criteria.list();
    }

}
