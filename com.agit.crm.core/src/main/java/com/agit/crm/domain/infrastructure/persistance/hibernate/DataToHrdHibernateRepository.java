package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.DataToHrd;
import com.agit.crm.domain.crm.DataToHrdRepository;
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
public class DataToHrdHibernateRepository extends HibernateRepository implements DataToHrdRepository{

    @Override
    public void saveOrUpdate(DataToHrd dataToHrd) {
        getSession().saveOrUpdate(dataToHrd);
    }

    @Override
    public void deleteData(DataToHrd dataToHrd) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.DataToHrd where idLowonganHrd = :cid");
        query.setParameter("cid", dataToHrd.getIdLowonganHrd());
        query.executeUpdate();
    }

    @Override
    public DataToHrd findByID(String idLowonganHrd) {
        return (DataToHrd) getSession()
                .createQuery("from com.agit.crm.domain.crm.DataToHrd where idLowonganHrd = :cid")
                .setParameter("cid", idLowonganHrd)
                .uniqueResult();
    }

    @Override
    public List<DataToHrd> findAll() {
        return (List<DataToHrd>) getSession()
                .createQuery("from com.agit.crm.domain.crm.DataToHrd")
                .list();
    }

    @Override
    public List<DataToHrd> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(DataToHrd.class);
        if (StringUtil.hasValue(map.get("idLowonganHrd"))) {
            criteria.add(Restrictions.eq("idLowonganHrd", map.get("idLowonganHrd")));
        }
        if (StringUtil.hasValue(map.get("namaLowonganHrd"))) {
            criteria.add(Restrictions.like("namaLowonganHrd", "%" + map.get("namaLowonganHrd") + "%").ignoreCase());
        }
        return criteria.list();
    }
    
}
