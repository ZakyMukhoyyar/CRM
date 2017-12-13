/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.masterdata.domain;

import java.util.Date;

public class SetupEmailBuilder {

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

    public SetupEmailBuilder() {
    }

    public SetupEmailBuilder setIdEmail(String idEmail) {
        this.idEmail = idEmail;
        return this;
    }

    public SetupEmailBuilder setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
        return this;
    }

    public SetupEmailBuilder setParameter(String parameter) {
        this.parameter = parameter;
        return this;
    }

    public SetupEmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public SetupEmailBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public SetupEmailBuilder setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public SetupEmailBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public SetupEmailBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public SetupEmailBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public SetupEmailBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public SetupEmail createSetupEmail() {
        return new SetupEmail(idEmail, templateTitle, parameter, subject, content, createBy, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
