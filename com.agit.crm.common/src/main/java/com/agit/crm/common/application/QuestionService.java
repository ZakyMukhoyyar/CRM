package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface QuestionService {

    void SaveOrUpdate(QuestionDTO question);

    void deleteData(QuestionDTO question);

    QuestionDTO getDummyData();

    QuestionDTO findByID(String questionID);

    List<QuestionDTO> findAll();

    List<QuestionDTO> findByParams(Map map);

    List<QuestionDTO> findAllByTypeTouchpoints(TypeTouchpoints touchpoints);
}
