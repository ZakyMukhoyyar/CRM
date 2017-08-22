package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Domisili;
import com.agit.crm.domain.crm.DomisiliRepository;
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
 * @author Bayu Hendra Setiawan
 */
@Repository
@Transactional
public class DomisiliHibernateRepository extends HibernateRepository implements DomisiliRepository {

    @Override
    public void saveOrUpdate(Domisili domisili) {
        getSession().saveOrUpdate(domisili);
    }

    @Override
    public void deleteData(Domisili domisili) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Domisili where idDomisili = :tid");
        query.setParameter("tid", domisili.getIdDomisili());
        query.executeUpdate();
    }

    @Override
    public Domisili findByID(String idDomisili) {
        return (Domisili) getSession()
                .createQuery("from com.agit.crm.domain.crm.Domisili where idDomisili = :tid")
                .setParameter("tid", idDomisili)
                .uniqueResult();
    }

    @Override
    public List<Domisili> findAll() {
        return (List<Domisili>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Domisili ")
                .list();
    }

    @Override
    public List<Domisili> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Domisili.class);
        if (StringUtil.hasValue(map.get("idDomisili"))) {
            criteria.add(Restrictions.eq("idDomisili", map.get("idDomisili")));
        }
        if (StringUtil.hasValue(map.get("namaProvinsi"))) {
            criteria.add(Restrictions.like("namaProvinsi", "%" + map.get("namaProvinsi") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("namaKabupaten"))) {
            criteria.add(Restrictions.like("namaKabupaten", "%" + map.get("namaKabupaten") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("namaKota"))) {
            criteria.add(Restrictions.like("namaKota", "%" + map.get("namaKota") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }
        return criteria.list();
    }

}
