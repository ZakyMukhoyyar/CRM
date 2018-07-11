/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Date;
import java.util.List;


public class QuestionDTOBuilder {

    private long id;
    private String questionID;
    private TypeTouchpoints touchpoints;
    private Status status;
    private String question;
    private String choiceAnswer;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private List<AnswerDTO> answerDTOs;

    public QuestionDTOBuilder() {
    }

    public QuestionDTOBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public QuestionDTOBuilder setQuestionID(String questionID) {
        this.questionID = questionID;
        return this;
    }

    public QuestionDTOBuilder setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
        return this;
    }

    public QuestionDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public QuestionDTOBuilder setQuestion(String question) {
        this.question = question;
        return this;
    }

    public QuestionDTOBuilder setChoiceAnswer(String choiceAnswer) {
        this.choiceAnswer = choiceAnswer;
        return this;
    }

    public QuestionDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public QuestionDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public QuestionDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public QuestionDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public QuestionDTOBuilder setAnswerDTOs(List<AnswerDTO> answerDTOs) {
        this.answerDTOs = answerDTOs;
        return this;
    }

    public QuestionDTO createQuestionDTO() {
        return new QuestionDTO(id, questionID, touchpoints, status, question, choiceAnswer, createdBy, createdDate, modifiedBy, modifiedDate, answerDTOs);
    }
    
}
