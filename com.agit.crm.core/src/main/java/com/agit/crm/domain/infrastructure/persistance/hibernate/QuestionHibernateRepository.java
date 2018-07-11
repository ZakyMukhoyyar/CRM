package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.feedback.Question;
import com.agit.crm.domain.customer.feedback.QuestionRepository;
import com.agit.crm.shared.type.TypeTouchpoints;
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
 * @author 3AD
 */
@Repository
@Transactional
public class QuestionHibernateRepository extends HibernateRepository implements QuestionRepository {

    @Override
    public void saveOrUpdate(Question question) {
        getSession().saveOrUpdate(question);
    }

    @Override
    public void deleteData(Question question) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.feedback.Question where questionID = :cid");
        query.setParameter("cid", question.getQuestionID());
        query.executeUpdate();
    }

    @Override
    public Question findByID(String questionID) {
        return (Question) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.Question where questionID = :cid")
                .setParameter("cid", questionID)
                .uniqueResult();
    }

    @Override
    public List<Question> findAll() {
        return (List<Question>) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.Question ")
                .list();
    }

    @Override
    public List<Question> findByParams(Map map) {
        Criteria criteria = getSession().createCriteria(Question.class);

        if (StringUtil.hasValue(map.get("id"))) {
            criteria.add(Restrictions.eq("id", map.get("id")));
        }
        return criteria.list();
    }

    @Override
    public List<Question> findAllByTypeTouchpoints(TypeTouchpoints touchpoints) {
        Criteria criteria = getSession().createCriteria(Question.class);
        criteria.add(Restrictions.eq("touchpoints", touchpoints));
        return (List<Question>) criteria.list();
    }

}
