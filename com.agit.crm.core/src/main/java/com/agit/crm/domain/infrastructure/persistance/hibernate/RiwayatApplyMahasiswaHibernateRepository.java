package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaRepository;
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
public class RiwayatApplyMahasiswaHibernateRepository extends HibernateRepository implements RiwayatApplyMahasiswaRepository {

    @Override
    public void saveOrUpdate(RiwayatApplyMahasiswa riwayatApplyMahasiswa) {
        getSession().saveOrUpdate(riwayatApplyMahasiswa);
    }

    @Override
    public void deleteData(RiwayatApplyMahasiswa riwayatApplyMahasiswa) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.RiwayatApplyMahasiswa where idRiwayatApplyMahasiswa = :tid");
        query.setParameter("tid", riwayatApplyMahasiswa.getIdRiwayatApplyMahasiswa());
        query.executeUpdate();
    }

    @Override
    public RiwayatApplyMahasiswa findByID(String idRiwayatApplyMahasiswa) {
        return (RiwayatApplyMahasiswa) getSession()
                .createQuery("from com.agit.crm.domain.crm.RiwayatApplyMahasiswa where idRiwayatApplyMahasiswa = :tid")
                .setParameter("tid", idRiwayatApplyMahasiswa)
                .uniqueResult();
    }

    @Override
    public List<RiwayatApplyMahasiswa> findAll() {
        return (List<RiwayatApplyMahasiswa>) getSession()
                .createQuery("from com.agit.crm.domain.crm.RiwayatApplyMahasiswa")
                .list();
    }

    @Override
    public List<RiwayatApplyMahasiswa> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(RiwayatApplyMahasiswa.class);
        if (StringUtil.hasValue(map.get("idRiwayatApplyMahasiswa"))) {
            criteria.add(Restrictions.eq("idRiwayatApplyMahasiswa", map.get("idRiwayatApplyMahasiswa")));
        }
        if (StringUtil.hasValue(map.get("idRiwayatLowongan"))) {
            criteria.add(Restrictions.eq("idRiwayatLowongan", map.get("idRiwayatLowongan")));
        }
        if (StringUtil.hasValue(map.get("lowonganState"))) {
            criteria.add(Restrictions.eq("lowonganState", map.get("lowonganState")));
        }
        if (StringUtil.hasValue(map.get("namaApplyLowongan"))) {
            criteria.add(Restrictions.like("namaApplyLowongan", "%" + map.get("namaApplyLowongan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("namaLowonganApply"))) {
            criteria.add(Restrictions.like("namaLowonganApply", "%" + map.get("namaLowonganApply") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("idUserRiwayat"))) {
            criteria.add(Restrictions.like("idUserRiwayat", "%" + map.get("idUserRiwayat") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("jurusan"))) {
            criteria.add(Restrictions.like("jurusan", "%" + map.get("jurusan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("minat"))) {
            criteria.add(Restrictions.like("minat", "%" + map.get("minat") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("ketrampilan"))) {
            criteria.add(Restrictions.like("ketrampilan1", "%" + map.get("ketrampilan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("ketrampilan"))) {
            criteria.add(Restrictions.like("ketrampilan2", "%" + map.get("ketrampilan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("ketrampilan"))) {
            criteria.add(Restrictions.like("ketrampilan3", "%" + map.get("ketrampilan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("ketrampilan"))) {
            criteria.add(Restrictions.like("ketrampilan4", "%" + map.get("ketrampilan") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("ketrampilan"))) {
            criteria.add(Restrictions.like("ketrampilan5", "%" + map.get("ketrampilan") + "%").ignoreCase());
        }
        return criteria.list();
    }

    @Override
    public List<RiwayatApplyMahasiswa> findAllRiwayataLowongan(String idRiwayatLowongan) {
        return (List<RiwayatApplyMahasiswa>) getSession()
                .createQuery("from com.agit.crm.domain.crm.RiwayatApplyMahasiswa where idRiwayatLowongan = :lid")
                .setParameter("lid", idRiwayatLowongan)
                .list();
    }

    @Override
    public RiwayatApplyMahasiswa findByIDUser(String idUserRiwayat) {
        return (RiwayatApplyMahasiswa) getSession()
                .createQuery("from com.agit.crm.domain.crm.RiwayatApplyMahasiswa where idUserRiwayat = :tid")
                .setParameter("tid", idUserRiwayat)
                .uniqueResult();
    }

}
