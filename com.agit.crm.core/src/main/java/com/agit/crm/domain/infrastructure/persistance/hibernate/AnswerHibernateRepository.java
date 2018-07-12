package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.customer.feedback.Answer;
import com.agit.crm.domain.customer.feedback.AnswerRepository;
import com.agit.crm.shared.type.TypeTouchpoints;
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
public class AnswerHibernateRepository extends HibernateRepository implements AnswerRepository {

    @Override
    public void saveOrUpdate(Answer answer) {
        getSession().saveOrUpdate(answer);
    }

    @Override
    public void deleteData(Answer answer) {
        Query query = getSession().createQuery("delete from com.agit.crm.domain.customer.feedback.Answer where questionID = :cid");
        query.setParameter("cid", null);
        query.executeUpdate();
    }

    @Override
    public Answer findByID(String answerID) {
        return (Answer) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.Answer where answerID = :cid")
                .setParameter("cid", answerID)
                .uniqueResult();
    }

    @Override
    public List<Answer> findAll() {
        return (List<Answer>) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.Answer ")
                .list();
    }

    @Override
    public List<Answer> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Answer> findAnswerByTouchPoints(TypeTouchpoints touchpoints) {
        Criteria criteria = getSession().createCriteria(Answer.class);
        criteria.add(Restrictions.eq("touchpoints", touchpoints));
        return (List<Answer>) criteria.list();
    }

}
