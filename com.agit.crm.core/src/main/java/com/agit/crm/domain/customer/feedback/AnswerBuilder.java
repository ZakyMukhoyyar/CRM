/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.type.TypeTouchpoints;


public class AnswerBuilder {

    private long id;
    private String answerID;
    private String chooseQuestion;
    private String idChooseAnswer1;
    private String idChooseAnswer2;
    private String idChooseAnswer3;
    private String idChooseAnswer4;
    private String idChooseAnswer5;
    private String chooseAnswer1;
    private String chooseAnswer2;
    private String chooseAnswer3;
    private String chooseAnswer4;
    private String chooseAnswer5;
    private TypeTouchpoints touchpoints;

    public AnswerBuilder() {
    }

    public AnswerBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public AnswerBuilder setAnswerID(String answerID) {
        this.answerID = answerID;
        return this;
    }

    public AnswerBuilder setChooseQuestion(String chooseQuestion) {
        this.chooseQuestion = chooseQuestion;
        return this;
    }

    public AnswerBuilder setIdChooseAnswer1(String idChooseAnswer1) {
        this.idChooseAnswer1 = idChooseAnswer1;
        return this;
    }

    public AnswerBuilder setIdChooseAnswer2(String idChooseAnswer2) {
        this.idChooseAnswer2 = idChooseAnswer2;
        return this;
    }

    public AnswerBuilder setIdChooseAnswer3(String idChooseAnswer3) {
        this.idChooseAnswer3 = idChooseAnswer3;
        return this;
    }

    public AnswerBuilder setIdChooseAnswer4(String idChooseAnswer4) {
        this.idChooseAnswer4 = idChooseAnswer4;
        return this;
    }

    public AnswerBuilder setIdChooseAnswer5(String idChooseAnswer5) {
        this.idChooseAnswer5 = idChooseAnswer5;
        return this;
    }

    public AnswerBuilder setChooseAnswer1(String chooseAnswer1) {
        this.chooseAnswer1 = chooseAnswer1;
        return this;
    }

    public AnswerBuilder setChooseAnswer2(String chooseAnswer2) {
        this.chooseAnswer2 = chooseAnswer2;
        return this;
    }

    public AnswerBuilder setChooseAnswer3(String chooseAnswer3) {
        this.chooseAnswer3 = chooseAnswer3;
        return this;
    }

    public AnswerBuilder setChooseAnswer4(String chooseAnswer4) {
        this.chooseAnswer4 = chooseAnswer4;
        return this;
    }

    public AnswerBuilder setChooseAnswer5(String chooseAnswer5) {
        this.chooseAnswer5 = chooseAnswer5;
        return this;
    }

    public AnswerBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public Answer createAnswer() {
        return new Answer(id, answerID, chooseQuestion, idChooseAnswer1, idChooseAnswer2, idChooseAnswer3, idChooseAnswer4, idChooseAnswer5, chooseAnswer1, chooseAnswer2, chooseAnswer3, chooseAnswer4, chooseAnswer5, touchpoints);
    }
    
}
