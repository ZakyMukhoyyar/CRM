package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganRepository;
import com.agit.crm.shared.id.IdLowongan;
import com.agit.crm.util.StringUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class LowonganHibernateRepository extends HibernateRepository implements LowonganRepository {

    @Override
    public void saveOrUpdate(Lowongan lowongan) {
        getSession().saveOrUpdate(lowongan);
    }

    @Override
    public Lowongan findByID(String idLowongan) {
        return (Lowongan) getSession()
                .createQuery("from com.agit.crm.domain.crm.Lowongan where idLowongan = :tid")
                .setParameter("tid", idLowongan)
                .uniqueResult();
    }

    @Override
    public List<Lowongan> findAll() {
        return (List<Lowongan>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Lowongan ")
                .list();
    }

    @Override
    public List<Lowongan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Lowongan.class);
        if (StringUtil.hasValue(map.get("idLowongan"))) {
            criteria.add(Restrictions.like("idLowongan", "%" + map.get("idLowongan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("namaLowongan"))) {
            criteria.add(Restrictions.like("namaLowongan", "%" + map.get("namaLowongan") + "%").ignoreCase());
        }

        return criteria.list();
    }

    @Override
    public void deleteData(Lowongan lowongan) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Lowongan where idLowongan = :tid");
        query.setParameter("tid", lowongan.getIdLowongan());
        query.executeUpdate();
    }

}
