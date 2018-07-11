/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.application.impl;

import com.agit.crm.common.application.AnswerService;
import com.agit.crm.common.dto.customer.feedback.AnswerDTO;
import com.agit.crm.domain.customer.feedback.Answer;
import com.agit.crm.domain.customer.feedback.AnswerRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.AnswerDTOAssembler;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author BayuHS
 */
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;
    private AnswerDTOAssembler answerDTOAssembler;

    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void setAnswerDTOAssembler(AnswerDTOAssembler answerDTOAssembler) {
        this.answerDTOAssembler = answerDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(AnswerDTO answer) {
        Answer t = answerRepository.findByID(answer.getAnswerID());

        if (t == null) {
            t = answerDTOAssembler.toDomain(answer);
        } else {
            Answer newAnswer = answerDTOAssembler.toDomain(answer);
            t.assignNewAnswer(newAnswer);

        }
        answerRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(AnswerDTO answer) {
        Answer p = answerDTOAssembler.toDomain(answer);
        answerRepository.deleteData(p);
    }

    @Override
    public AnswerDTO getDummyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnswerDTO findByID(String answerID) {
        Validate.notNull(answerRepository);
        Answer b = (Answer) answerRepository.findByID(answerID);
        if (b != null) {
            return answerDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<AnswerDTO> findAll() {
        Validate.notNull(answerRepository);
        return answerDTOAssembler.toDTOs(answerRepository.findAll());
    }

    @Override
    public List<AnswerDTO> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
