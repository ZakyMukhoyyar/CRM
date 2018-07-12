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

    public Answer() {
    }

    public Answer(long id, String answerID, String chooseQuestion, String idChooseAnswer1, String idChooseAnswer2, String idChooseAnswer3, String idChooseAnswer4, String idChooseAnswer5, String chooseAnswer1, String chooseAnswer2, String chooseAnswer3, String chooseAnswer4, String chooseAnswer5, TypeTouchpoints touchpoints) {
        this.id = id;
        this.answerID = answerID;
        this.chooseQuestion = chooseQuestion;
        this.idChooseAnswer1 = idChooseAnswer1;
        this.idChooseAnswer2 = idChooseAnswer2;
        this.idChooseAnswer3 = idChooseAnswer3;
        this.idChooseAnswer4 = idChooseAnswer4;
        this.idChooseAnswer5 = idChooseAnswer5;
        this.chooseAnswer1 = chooseAnswer1;
        this.chooseAnswer2 = chooseAnswer2;
        this.chooseAnswer3 = chooseAnswer3;
        this.chooseAnswer4 = chooseAnswer4;
        this.chooseAnswer5 = chooseAnswer5;
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

    public String getIdChooseAnswer1() {
        return idChooseAnswer1;
    }

    public void setIdChooseAnswer1(String idChooseAnswer1) {
        this.idChooseAnswer1 = idChooseAnswer1;
    }

    public String getIdChooseAnswer2() {
        return idChooseAnswer2;
    }

    public void setIdChooseAnswer2(String idChooseAnswer2) {
        this.idChooseAnswer2 = idChooseAnswer2;
    }

    public String getIdChooseAnswer3() {
        return idChooseAnswer3;
    }

    public void setIdChooseAnswer3(String idChooseAnswer3) {
        this.idChooseAnswer3 = idChooseAnswer3;
    }

    public String getIdChooseAnswer4() {
        return idChooseAnswer4;
    }

    public void setIdChooseAnswer4(String idChooseAnswer4) {
        this.idChooseAnswer4 = idChooseAnswer4;
    }

    public String getIdChooseAnswer5() {
        return idChooseAnswer5;
    }

    public void setIdChooseAnswer5(String idChooseAnswer5) {
        this.idChooseAnswer5 = idChooseAnswer5;
    }
    
    public String getChooseAnswer1() {
        return chooseAnswer1;
    }

    public void setChooseAnswer1(String chooseAnswer1) {
        this.chooseAnswer1 = chooseAnswer1;
    }

    public String getChooseAnswer2() {
        return chooseAnswer2;
    }

    public void setChooseAnswer2(String chooseAnswer2) {
        this.chooseAnswer2 = chooseAnswer2;
    }

    public String getChooseAnswer3() {
        return chooseAnswer3;
    }

    public void setChooseAnswer3(String chooseAnswer3) {
        this.chooseAnswer3 = chooseAnswer3;
    }

    public String getChooseAnswer4() {
        return chooseAnswer4;
    }

    public void setChooseAnswer4(String chooseAnswer4) {
        this.chooseAnswer4 = chooseAnswer4;
    }

    public String getChooseAnswer5() {
        return chooseAnswer5;
    }

    public void setChooseAnswer5(String chooseAnswer5) {
        this.chooseAnswer5 = chooseAnswer5;
    }

    public TypeTouchpoints getTouchpoints() {
        return touchpoints;
    }

    public void setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
    }

    public void assignNewAnswer(Answer answer) {
        this.id = answer.id;
        this.answerID = answer.answerID;
        this.chooseQuestion = answer.chooseQuestion;
        this.idChooseAnswer1 = answer.idChooseAnswer1;
        this.idChooseAnswer2 = answer.idChooseAnswer2;
        this.idChooseAnswer3 = answer.idChooseAnswer3;
        this.idChooseAnswer4 = answer.idChooseAnswer4;
        this.idChooseAnswer5 = answer.idChooseAnswer5;
        this.chooseAnswer1 = answer.chooseAnswer1;
        this.chooseAnswer2 = answer.chooseAnswer2;
        this.chooseAnswer3 = answer.chooseAnswer3;
        this.chooseAnswer4 = answer.chooseAnswer4;
        this.chooseAnswer5 = answer.chooseAnswer5;
        this.touchpoints = answer.touchpoints;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.answerID);
        hash = 23 * hash + Objects.hashCode(this.chooseQuestion);
        hash = 23 * hash + Objects.hashCode(this.idChooseAnswer1);
        hash = 23 * hash + Objects.hashCode(this.idChooseAnswer2);
        hash = 23 * hash + Objects.hashCode(this.idChooseAnswer3);
        hash = 23 * hash + Objects.hashCode(this.idChooseAnswer4);
        hash = 23 * hash + Objects.hashCode(this.idChooseAnswer5);
        hash = 23 * hash + Objects.hashCode(this.chooseAnswer1);
        hash = 23 * hash + Objects.hashCode(this.chooseAnswer2);
        hash = 23 * hash + Objects.hashCode(this.chooseAnswer3);
        hash = 23 * hash + Objects.hashCode(this.chooseAnswer4);
        hash = 23 * hash + Objects.hashCode(this.chooseAnswer5);
        hash = 23 * hash + Objects.hashCode(this.touchpoints);
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
