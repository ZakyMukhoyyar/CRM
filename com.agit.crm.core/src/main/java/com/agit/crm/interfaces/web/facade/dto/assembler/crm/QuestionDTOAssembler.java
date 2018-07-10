/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTOBuilder;
import com.agit.crm.domain.customer.feedback.Question;
import com.agit.crm.domain.customer.feedback.QuestionBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class QuestionDTOAssembler implements IObjectAssembler<Question, QuestionDTO> {

    @Override
    public QuestionDTO toDTO(Question domainObject) {
        return new QuestionDTOBuilder()
                .setQuestionID(domainObject.getQuestionID())
                .setTouchpoints(domainObject.getTouchpoints())
                .setStatus(domainObject.getStatus())
                .setQuestion(domainObject.getQuestion())
                .setChoiceAnswer(domainObject.getChoiceAnswer())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createQuestionDTO();
    }

    @Override
    public Question toDomain(QuestionDTO dtoObject) {
        return new QuestionBuilder()
                .setQuestionID(dtoObject.getQuestionID())
                .setTouchpoints(dtoObject.getTouchpoints())
                .setStatus(dtoObject.getStatus())
                .setQuestion(dtoObject.getQuestion())
                .setChoiceAnswer(dtoObject.getChoiceAnswer())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createQuestion();
    }

    public List<Question> toDomains(List<QuestionDTO> arg0) {
        List<Question> res = new ArrayList<>();
        for (QuestionDTO t : arg0) {
            res.add(new QuestionDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<QuestionDTO> toDTOs(List<Question> arg0) {
        List<QuestionDTO> res = new ArrayList<>();
        for (Question t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
