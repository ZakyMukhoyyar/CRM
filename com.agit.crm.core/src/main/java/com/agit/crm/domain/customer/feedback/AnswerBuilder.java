/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;


public class AnswerBuilder {

    private long id;
    private String answerID;
    private String userID;
    private String answer;
    private String questionID;

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

    public AnswerBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public AnswerBuilder setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public AnswerBuilder setQuestionID(String questionID) {
        this.questionID = questionID;
        return this;
    }

    public Answer createAnswer() {
        return new Answer(id, answerID, userID, answer, questionID);
    }
    
}
