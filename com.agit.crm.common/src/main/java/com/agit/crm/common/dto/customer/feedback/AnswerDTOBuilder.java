/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;


public class AnswerDTOBuilder {

    private String answerID;
    private String userID;
    private String answer;
    private Long questionID;

    public AnswerDTOBuilder() {
    }

    public AnswerDTOBuilder setAnswerID(String answerID) {
        this.answerID = answerID;
        return this;
    }

    public AnswerDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public AnswerDTOBuilder setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public AnswerDTOBuilder setQuestionID(Long questionID) {
        this.questionID = questionID;
        return this;
    }

    public AnswerDTO createAnswerDTO() {
        return new AnswerDTO(answerID, userID, answer, questionID);
    }
    
}
