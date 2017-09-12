package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Forum;
import com.agit.crm.domain.crm.ForumRepository;
import com.agit.crm.shared.status.Status;
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
public class ForumHibernateRepository extends HibernateRepository implements ForumRepository {

    @Override
    public void saveOrUpdate(Forum forum) {
        getSession().saveOrUpdate(forum);
    }

    @Override
    public void deleteData(Forum forum) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.crm.Forum where idForum = :tid");
        query.setParameter("tid", forum.getIdForum());
        query.executeUpdate();
    }

    @Override
    public Forum findByID(String idForum) {
        return (Forum) getSession()
                .createQuery("from com.agit.crm.domain.crm.Forum where idForum = :tid")
                .setParameter("tid", idForum)
                .uniqueResult();
    }

    @Override
    public List<Forum> findAll() {
        return (List<Forum>) getSession()
                .createQuery("from com.agit.crm.domain.crm.Forum ")
                .list();
    }

    @Override
    public List<Forum> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Forum.class);
        if (StringUtil.hasValue(map.get("idForum"))) {
            criteria.add(Restrictions.eq("idForum", map.get("idForum")));
        }
        if (StringUtil.hasValue(map.get("namaForum"))) {
            criteria.add(Restrictions.like("namaForum", "%" + map.get("namaForum") + "%").ignoreCase());
        }
        if (StringUtil.hasValue(map.get("status"))) {
            criteria.add(Restrictions.eq("status", map.get("status")));
        }

        return criteria.list();
    }

    @Override
    public List<Forum> findAllByStatus(Status status) {
        Criteria criteria = getSession().createCriteria(Forum.class);
        criteria.add(Restrictions.eq("status", status));
        return (List<Forum>) criteria.list();
    }

}
