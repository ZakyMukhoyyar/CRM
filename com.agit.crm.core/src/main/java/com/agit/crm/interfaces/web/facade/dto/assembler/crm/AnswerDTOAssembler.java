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
                .setIdChooseAnswer1(domainObject.getIdChooseAnswer1())
                .setIdChooseAnswer2(domainObject.getIdChooseAnswer2())
                .setIdChooseAnswer3(domainObject.getIdChooseAnswer3())
                .setIdChooseAnswer4(domainObject.getIdChooseAnswer4())
                .setIdChooseAnswer5(domainObject.getIdChooseAnswer5())
                .setChooseAnswer1(domainObject.getChooseAnswer1())
                .setChooseAnswer2(domainObject.getChooseAnswer2())
                .setChooseAnswer3(domainObject.getChooseAnswer3())
                .setChooseAnswer4(domainObject.getChooseAnswer4())
                .setChooseAnswer5(domainObject.getChooseAnswer5())
                .setChooseQuestion(domainObject.getChooseQuestion())
                .setTouchpoints(domainObject.getTouchpoints())
                .createAnswerDTO();
    }

    @Override
    public Answer toDomain(AnswerDTO dtoObject) {
        return new AnswerBuilder()
                .setAnswerID(dtoObject.getAnswerID())
                .setIdChooseAnswer1(dtoObject.getIdChooseAnswer1())
                .setIdChooseAnswer2(dtoObject.getIdChooseAnswer2())
                .setIdChooseAnswer3(dtoObject.getIdChooseAnswer3())
                .setIdChooseAnswer4(dtoObject.getIdChooseAnswer4())
                .setIdChooseAnswer5(dtoObject.getIdChooseAnswer5())
                .setChooseAnswer1(dtoObject.getChooseAnswer1())
                .setChooseAnswer2(dtoObject.getChooseAnswer2())
                .setChooseAnswer3(dtoObject.getChooseAnswer3())
                .setChooseAnswer4(dtoObject.getChooseAnswer4())
                .setChooseAnswer5(dtoObject.getChooseAnswer5())
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
