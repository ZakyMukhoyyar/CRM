/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface QuestionService {

    void SaveOrUpdate(QuestionDTO question);

    void deleteData(QuestionDTO question);

    CivitasDTO getDummyData();

    QuestionDTO findByID(String questionID);

    List<QuestionDTO> findAll();

    List<QuestionDTO> findByParams(Map map);

    List<QuestionDTO> findAllByStatus(Status status);
}
