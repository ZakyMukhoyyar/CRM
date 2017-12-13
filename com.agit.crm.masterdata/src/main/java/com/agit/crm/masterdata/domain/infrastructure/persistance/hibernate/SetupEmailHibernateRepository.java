package com.agit.crm.masterdata.domain.infrastructure.persistance.hibernate;

import com.agit.crm.common.infrastructure.persistence.hibernate.HibernateRepository;
import com.agit.crm.masterdata.domain.SetupEmail;
import com.agit.crm.masterdata.domain.SetupEmailRepository;
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
 * @author TriAA
 */
@Repository
@Transactional
public class SetupEmailHibernateRepository extends HibernateRepository implements SetupEmailRepository {

    @Override
    public void saveOrUpdate(SetupEmail setupEmail) {
        getSession().saveOrUpdate(setupEmail);
    }

    @Override
    public void delete(SetupEmail setupEmail) {
        Query query = getSession().createQuery("delete from com.agit.crm.masterdata.domain.SetupEmail where idEmail =:iem");
        query.setParameter("iem", setupEmail.getIdEmail());
        query.executeUpdate();
    }

    @Override
    public SetupEmail findByID(String idEmail) {
        Query query = getSession().createQuery("from com.agit.crm.masterdata.domain.SetupEmail where idEmail =:iem");
        query.setParameter("iem", idEmail);
        return (SetupEmail) query.uniqueResult();
    }

    @Override
    public List<SetupEmail> findAll() {
        Criteria criteria = getSession().createCriteria(SetupEmail.class);
        return criteria.list();
    }

    @Override
    public List<SetupEmail> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(SetupEmail.class);
        if (StringUtil.hasValue(map.get("idEmail"))) {
            criteria.add(Restrictions.like("idEmail", "%" + map.get("idEmail") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("templateTitle"))) {
            criteria.add(Restrictions.like("templateTitle", "%" + map.get("templateTitle") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("subject"))) {
            criteria.add(Restrictions.like("subject", "%" + map.get("subject") + "%").ignoreCase());
        }
        return criteria.list();
    }

}
