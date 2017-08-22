package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Jurusan;
import com.agit.crm.domain.crm.JurusanRepository;
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
public class JurusanHibernateRepository extends HibernateRepository implements JurusanRepository {

    @Override
    public void saveOrUpdate(Jurusan jurusan) {
        getSession().saveOrUpdate(jurusan);
    }

    @Override
    public void deleteData(Jurusan jurusan) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Jurusan where idJurusan = :tid");
        query.setParameter("tid", jurusan.getIdJurusan());
        query.executeUpdate();
    }

    @Override
    public Jurusan findByID(String idJurusan) {
        return (Jurusan) getSession()
                .createQuery("from com.agit.crm.domain.crm.Jurusan where idJurusan = :tid")
                .setParameter("tid", idJurusan)
                .uniqueResult();
    }

    @Override
    public List<Jurusan> findAll() {
        return (List<Jurusan>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Jurusan")
                .list();
    }

    @Override
    public List<Jurusan> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Jurusan.class);
        if (StringUtil.hasValue(map.get("idJurusan"))) {
            criteria.add(Restrictions.eq("idJurusan", map.get("idJurusan")));
        }
        if (StringUtil.hasValue(map.get("namaJurusan"))) {
            criteria.add(Restrictions.like("namaJurusan", "%" + map.get("namaJurusan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }
        return criteria.list();
    }

}
