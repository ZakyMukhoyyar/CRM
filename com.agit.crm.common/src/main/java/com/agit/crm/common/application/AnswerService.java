/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.application;

import com.agit.crm.common.dto.customer.feedback.AnswerDTO;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface AnswerService {

    void SaveOrUpdate(AnswerDTO answer);

    void deleteData(AnswerDTO answer);

    AnswerDTO getDummyData();

    AnswerDTO findByID(String answerID);

    List<AnswerDTO> findAll();

    List<AnswerDTO> findByParams(Map map);
    
    List<AnswerDTO> findAnswerByTouchPoints(TypeTouchpoints typeTouchpoints);

}
