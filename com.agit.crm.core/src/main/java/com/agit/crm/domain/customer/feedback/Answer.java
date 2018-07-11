/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.object.EntityObject;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Answer implements EntityObject<Answer> {

    private long id;
    private String answerID;
    private String userID;
    private String answer;
    private Long questionID;

    public Answer() {
    }

    public Answer(long id, String answerID, String userID, String answer, Long questionID) {
        this.id = id;
        this.answerID = answerID;
        this.userID = userID;
        this.answer = answer;
        this.questionID = questionID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.answerID);
        hash = 79 * hash + Objects.hashCode(this.userID);
        hash = 79 * hash + Objects.hashCode(this.answer);
        hash = 79 * hash + Objects.hashCode(this.questionID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewAnswer(Answer Answer) {
        this.answerID = Answer.answerID;
        this.userID = Answer.userID;
        this.answer = Answer.answer;
        this.questionID = Answer.questionID;
    }

    @Override
    public boolean sameIdentityAs(Answer other) {
        return this.equals(other);
    }

}
