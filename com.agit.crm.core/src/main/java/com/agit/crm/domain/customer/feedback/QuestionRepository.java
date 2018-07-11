package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface QuestionRepository {

    void saveOrUpdate(Question question);

    void deleteData(Question question);

    Question findByID(String questionID);

    List<Question> findAll();

    List<Question> findByParams(Map map);

    List<Question> findAllByTypeTouchpoints(TypeTouchpoints touchpoints);
}
