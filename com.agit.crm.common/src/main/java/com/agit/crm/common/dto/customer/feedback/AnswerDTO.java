/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;
import java.io.Serializable;

/**
 *
 * @author BayuHS
 */
public class AnswerDTO implements Serializable {

    private String answerID;
    private String chooseQuestion;
    private String chooseAnswer;
    private TypeTouchpoints touchpoints;

    public AnswerDTO() {
    }

    public AnswerDTO(String answerID, String chooseQuestion, String chooseAnswer, TypeTouchpoints touchpoints) {
        this.answerID = answerID;
        this.chooseQuestion = chooseQuestion;
        this.chooseAnswer = chooseAnswer;
        this.touchpoints = touchpoints;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getChooseQuestion() {
        return chooseQuestion;
    }

    public void setChooseQuestion(String chooseQuestion) {
        this.chooseQuestion = chooseQuestion;
    }

    public String getChooseAnswer() {
        return chooseAnswer;
    }

    public void setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
    }

    public TypeTouchpoints getTouchpoints() {
        return touchpoints;
    }

    public void setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" + "answerID=" + answerID + ", chooseQuestion=" + chooseQuestion + ", chooseAnswer=" + chooseAnswer + ", touchpoints=" + touchpoints + '}';
    }

}
