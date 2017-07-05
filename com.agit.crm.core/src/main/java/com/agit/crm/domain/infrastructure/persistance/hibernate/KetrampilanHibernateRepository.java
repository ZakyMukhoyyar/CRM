package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Ketrampilan;
import com.agit.crm.domain.crm.KetrampilanRepository;
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
public class KetrampilanHibernateRepository extends HibernateRepository implements KetrampilanRepository {

    @Override
    public void saveOrUpdate(Ketrampilan ketrampilan) {
        getSession().saveOrUpdate(ketrampilan);
    }

    @Override
    public void deleteData(Ketrampilan ketrampilan) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Ketrampilan where idKetrampilan = :tid");
        query.setParameter("tid", ketrampilan.getIdKetrampilan());
        query.executeUpdate();
    }

    @Override
    public Ketrampilan findByID(String idKetrampilan) {
        return (Ketrampilan) getSession()
                .createQuery("from com.agit.crm.domain.crm.Ketrampilan where idKetrampilan = :tid")
                .setParameter("tid", idKetrampilan)
                .uniqueResult();
    }

    @Override
    public List<Ketrampilan> findAll() {
        return (List<Ketrampilan>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Ketrampilan ")
                .list();
    }

    @Override
    public List<Ketrampilan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Ketrampilan.class);
        if (StringUtil.hasValue(map.get("idKetrampilan"))) {
            criteria.add(Restrictions.eq("idKetrampilan", map.get("idKetrampilan")));
        }
        if (StringUtil.hasValue(map.get("namaKetrampilan"))) {
            criteria.add(Restrictions.like("namaKetrampilan", "%" + map.get("namaKetrampilan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }

        return criteria.list();
    }

}
