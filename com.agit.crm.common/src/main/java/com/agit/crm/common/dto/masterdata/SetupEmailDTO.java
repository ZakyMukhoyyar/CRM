package com.agit.crm.common.dto.masterdata;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author TriAA
 */
public class SetupEmailDTO implements Serializable {

    private String idEmail;
    private String templateTitle;
    private String parameter;
    private String subject;
    private String content;
    private String createBy;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public SetupEmailDTO() {
    }

    public SetupEmailDTO(String idEmail, String templateTitle, String parameter, String subject, String content, String createBy, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idEmail = idEmail;
        this.templateTitle = templateTitle;
        this.parameter = parameter;
        this.subject = subject;
        this.content = content;
        this.createBy = createBy;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
        return "SetupEmailDTO{" + "idEmail=" + idEmail + ", templateTitle=" + templateTitle + ", parameter=" + parameter + ", subject=" + subject + ", content=" + content + ", createBy=" + createBy + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
