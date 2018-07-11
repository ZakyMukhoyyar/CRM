/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;


public class AnswerDTOBuilder {

    private String answerID;
    private String chooseQuestion;
    private String chooseAnswer;
    private TypeTouchpoints touchpoints;

    public AnswerDTOBuilder() {
    }

    public AnswerDTOBuilder setAnswerID(String answerID) {
        this.answerID = answerID;
        return this;
    }

    public AnswerDTOBuilder setChooseQuestion(String chooseQuestion) {
        this.chooseQuestion = chooseQuestion;
        return this;
    }

    public AnswerDTOBuilder setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
        return this;
    }

    public AnswerDTOBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public AnswerDTO createAnswerDTO() {
        return new AnswerDTO(answerID, chooseQuestion, chooseAnswer, touchpoints);
    }
    
}
