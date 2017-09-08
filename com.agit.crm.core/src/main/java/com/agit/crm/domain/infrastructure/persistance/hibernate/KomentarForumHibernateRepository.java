package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.KomentarForum;
import com.agit.crm.domain.crm.KomentarForumRepository;
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
public class KomentarForumHibernateRepository extends HibernateRepository implements KomentarForumRepository {

    @Override
    public void saveOrUpdate(KomentarForum komentarForum) {
        getSession().saveOrUpdate(komentarForum);
    }

    @Override
    public void delete(KomentarForum komentarForum) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.KomentarForum where komentarID = :kid");
        query.setParameter("kid", komentarForum.getKomentarID());
        query.executeUpdate();
    }

    @Override
    public KomentarForum findByID(String komentarID) {
        Query query = getSession().createQuery("from com.agit.crm.domain.crm.KomentarForum where komentarID = :kid");
        query.setParameter("kid", komentarID);
        return (KomentarForum) query.uniqueResult();
    }

    @Override
    public List<KomentarForum> findAll() {
        Criteria criteria = getSession().createCriteria(KomentarForum.class);
        return (List<KomentarForum>) criteria.list();
    }

    @Override
    public List<KomentarForum> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(KomentarForum.class);            
        if (JDCStringUtil.hasValue(map.get("komentarID"))) {
            criteria.add(Restrictions.eq("komentarID", map.get("komentarID")));
        }
        if (JDCStringUtil.hasValue(map.get("komentar"))) {
            criteria.add(Restrictions.eq("komentar", map.get("komentar")));
        }
        return (List<KomentarForum>) criteria.list();
    }

    @Override
    public List<KomentarForum> findAllByID(String idForum) {
        Criteria criteria = getSession().createCriteria(KomentarForum.class);
        criteria.add(Restrictions.eq("idForum", idForum));
        return (List<KomentarForum>) criteria.list();
    }

}
