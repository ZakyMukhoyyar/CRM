/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.application.impl;

import com.agit.crm.common.application.QuestionService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.domain.customer.feedback.Question;
import com.agit.crm.domain.customer.feedback.QuestionRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.QuestionDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private QuestionDTOAssembler questionDTOAssembler;

    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void setQuestionDTOAssembler(QuestionDTOAssembler questionDTOAssembler) {
        this.questionDTOAssembler = questionDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(QuestionDTO question) {
        Question t = questionRepository.findByID(question.getQuestionID());

        if (t == null) {
            t = questionDTOAssembler.toDomain(question);
        } else {
            Question newQuestion = questionDTOAssembler.toDomain(question);
            t.assignNewQuestion(newQuestion);

        }
        questionRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(QuestionDTO question) {
        Question p = questionDTOAssembler.toDomain(question);
        questionRepository.deleteData(p);
    }

    @Override
    public CivitasDTO getDummyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuestionDTO findByID(String questionID) {
        Validate.notNull(questionRepository);
        Question b = (Question) questionRepository.findByID(questionID);
        if (b != null) {
            return questionDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<QuestionDTO> findAll() {
        Validate.notNull(questionRepository);
        return questionDTOAssembler.toDTOs(questionRepository.findAll());
    }

    @Override
    public List<QuestionDTO> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuestionDTO> findAllByStatus(Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
