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
    private String chooseAnswer;
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

    public AnswerBuilder setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
        return this;
    }

    public AnswerBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public Answer createAnswer() {
        return new Answer(id, answerID, chooseQuestion, chooseAnswer, touchpoints);
    }
    
}
