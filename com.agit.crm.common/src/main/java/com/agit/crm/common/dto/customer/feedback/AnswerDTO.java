/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import java.io.Serializable;

/**
 *
 * @author BayuHS
 */
public class AnswerDTO implements Serializable {

    private String answerID;
    private String userID;
    private String answer;
    private String questionID;

    public AnswerDTO() {
    }

    public AnswerDTO(String answerID, String userID, String answer, String questionID) {
        this.answerID = answerID;
        this.userID = userID;
        this.answer = answer;
        this.questionID = questionID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" + "answerID=" + answerID + ", userID=" + userID + ", answer=" + answer + ", questionID=" + questionID + '}';
    }

}
