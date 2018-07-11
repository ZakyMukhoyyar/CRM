/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.customer.feedback.AnswerDTO;
import com.agit.crm.common.dto.customer.feedback.AnswerDTOBuilder;
import com.agit.crm.domain.customer.feedback.Answer;
import com.agit.crm.domain.customer.feedback.AnswerBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class AnswerDTOAssembler implements IObjectAssembler<Answer, AnswerDTO> {

    @Override
    public AnswerDTO toDTO(Answer domainObject) {
        return new AnswerDTOBuilder()
                .setAnswerID(domainObject.getAnswerID())
                .setChooseAnswer(domainObject.getChooseAnswer())
                .setChooseQuestion(domainObject.getChooseQuestion())
                .setTouchpoints(domainObject.getTouchpoints())
                .createAnswerDTO();
    }

    @Override
    public Answer toDomain(AnswerDTO dtoObject) {
        return new AnswerBuilder()
                .setAnswerID(dtoObject.getAnswerID())
                .setChooseAnswer(dtoObject.getChooseAnswer())
                .setChooseQuestion(dtoObject.getChooseQuestion())
                .setTouchpoints(dtoObject.getTouchpoints())
                .createAnswer();
    }

    public List<Answer> toDomains(List<AnswerDTO> arg0) {
        List<Answer> res = new ArrayList<>();
        for (AnswerDTO t : arg0) {
            res.add(new AnswerDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<AnswerDTO> toDTOs(List<Answer> arg0) {
        List<AnswerDTO> res = new ArrayList<>();
        for (Answer t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
