/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class QuestionDTO implements Serializable {

    private String questionID;
    private TypeTouchpoints touchpoints;
    private Status status;
    private String question;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public QuestionDTO() {
    }

    public QuestionDTO(String questionID, TypeTouchpoints touchpoints, Status status, String question, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.questionID = questionID;
        this.touchpoints = touchpoints;
        this.status = status;
        this.question = question;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public TypeTouchpoints getTouchpoints() {
        return touchpoints;
    }

    public void setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" + "questionID=" + questionID + ", touchpoints=" + touchpoints + ", status=" + status + ", question=" + question + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
