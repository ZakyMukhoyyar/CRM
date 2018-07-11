/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Answer implements EntityObject<Answer> {

    private long id;
    private String answerID;
    private String chooseQuestion;
    private String chooseAnswer;
    private TypeTouchpoints touchpoints;

    public Answer() {
    }

    public Answer(long id, String answerID, String chooseQuestion, String chooseAnswer, TypeTouchpoints touchpoints) {
        this.id = id;
        this.answerID = answerID;
        this.chooseQuestion = chooseQuestion;
        this.chooseAnswer = chooseAnswer;
        this.touchpoints = touchpoints;
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

    public void assignNewAnswer(Answer Answer) {
        this.id = Answer.id;
        this.answerID = Answer.answerID;
        this.chooseQuestion = Answer.chooseQuestion;
        this.chooseAnswer = Answer.chooseAnswer;
        this.touchpoints = Answer.touchpoints;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.answerID);
        hash = 83 * hash + Objects.hashCode(this.chooseQuestion);
        hash = 83 * hash + Objects.hashCode(this.chooseAnswer);
        hash = 83 * hash + Objects.hashCode(this.touchpoints);
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

    @Override
    public boolean sameIdentityAs(Answer other) {
        return this.equals(other);
    }

}
