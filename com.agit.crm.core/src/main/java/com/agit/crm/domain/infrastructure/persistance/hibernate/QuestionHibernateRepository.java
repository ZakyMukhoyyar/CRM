package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Civitas;
import com.agit.crm.domain.customer.feedback.Question;
import com.agit.crm.domain.customer.feedback.QuestionRepository;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> findAll() {
        return (List<Question>) getSession()
                .createQuery("from com.agit.crm.domain.customer.feedback.Question ")
                .list();
    }

    @Override
    public List<Question> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> findAllByStatus(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
