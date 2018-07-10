/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Date;


public class QuestionBuilder {

    private long id;
    private String questionID;
    private TypeTouchpoints touchpoints;
    private Status status;
    private String question;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public QuestionBuilder() {
    }

    public QuestionBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public QuestionBuilder setQuestionID(String questionID) {
        this.questionID = questionID;
        return this;
    }

    public QuestionBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public QuestionBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public QuestionBuilder setQuestion(String question) {
        this.question = question;
        return this;
    }

    public QuestionBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public QuestionBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public QuestionBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public QuestionBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Question createQuestion() {
        return new Question(id, questionID, touchpoints, status, question, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
