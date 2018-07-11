package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface AnswerRepository {

    void saveOrUpdate(Answer answer);

    void deleteData(Answer answer);

    Answer findByID(String answerID);

    List<Answer> findAll();

    List<Answer> findByParams(Map map);

    List<Answer> findAllByTypeTouchpoints(TypeTouchpoints touchpoints);

}
