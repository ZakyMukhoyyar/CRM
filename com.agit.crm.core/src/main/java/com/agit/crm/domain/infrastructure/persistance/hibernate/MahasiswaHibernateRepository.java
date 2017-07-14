package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Mahasiswa;
import com.agit.crm.domain.crm.MahasiswaRepository;
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
public class MahasiswaHibernateRepository extends HibernateRepository implements MahasiswaRepository {

    @Override
    public void saveOrUpdate(Mahasiswa lowongan) {
        getSession().saveOrUpdate(lowongan);
    }

    @Override
    public Mahasiswa findByID(String idMahasiswa) {
        return (Mahasiswa) getSession()
                .createQuery("from com.agit.crm.domain.crm.Mahasiswa where idMahasiswa = :tid")
                .setParameter("tid", idMahasiswa)
                .uniqueResult();
    }

    @Override
    public List<Mahasiswa> findAll() {
        return (List<Mahasiswa>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Mahasiswa ")
                .list();
    }

    @Override
    public List<Mahasiswa> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Mahasiswa.class);
        if (StringUtil.hasValue(map.get("idMahasiswa"))) {
            criteria.add(Restrictions.eq("idMahasiswa", map.get("idMahasiswa")));
        }
        if (StringUtil.hasValue(map.get("namaLengkap"))) {
            criteria.add(Restrictions.like("namaLengkap", "%" + map.get("namaLengkap") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("noKTP"))) {
            criteria.add(Restrictions.like("noKTP", "%" + map.get("noKTP") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("domisili"))) {
            criteria.add(Restrictions.like("domisili", "%" + map.get("domisili") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("minatSelect"))) {
            criteria.add(Restrictions.eq("minat", map.get("minatSelect")));
        }

        return criteria.list();
    }

    @Override
    public void deleteData(Mahasiswa mahasiswa) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Mahasiswa where idMahasiswa = :tid");
        query.setParameter("tid", mahasiswa.getIdMahasiswa());
        query.executeUpdate();
    }

    @Override
    public Mahasiswa findByNamaLengkap(String namaApplyLowongan) {
        return (Mahasiswa) getSession()
                .createQuery("from com.agit.crm.domain.crm.Mahasiswa where namaLengkap = :nl")
                .setParameter("nl", namaApplyLowongan)
                .uniqueResult();
    }

}
