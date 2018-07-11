package com.agit.crm.domain.customer.feedback;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class Question implements EntityObject<Question> {

    long id;
    private String questionID;
    private TypeTouchpoints touchpoints;
    private Status status;
    private String question;
    private String choiceAnswer;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Question() {
    }

    public Question(long id, String questionID, TypeTouchpoints touchpoints, Status status, String question, String choiceAnswer, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.id = id;
        this.questionID = questionID;
        this.touchpoints = touchpoints;
        this.status = status;
        this.question = question;
        this.choiceAnswer = choiceAnswer;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewQuestion(Question question) {
        this.questionID = question.questionID;
        this.touchpoints = question.touchpoints;
        this.status = question.status;
        this.choiceAnswer = question.choiceAnswer;
        this.question = question.question;
        this.createdBy = question.createdBy;
        this.createdDate = question.createdDate;
        this.modifiedBy = question.modifiedBy;
        this.modifiedDate = question.modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getChoiceAnswer() {
        return choiceAnswer;
    }

    public void setChoiceAnswer(String choiceAnswer) {
        this.choiceAnswer = choiceAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.questionID);
        hash = 59 * hash + Objects.hashCode(this.touchpoints);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.question);
        hash = 59 * hash + Objects.hashCode(this.choiceAnswer);
        hash = 59 * hash + Objects.hashCode(this.createdBy);
        hash = 59 * hash + Objects.hashCode(this.createdDate);
        hash = 59 * hash + Objects.hashCode(this.modifiedBy);
        hash = 59 * hash + Objects.hashCode(this.modifiedDate);
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
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(Question other) {
        return this.equals(other);
    }

}
