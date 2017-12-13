/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.masterdata;

import java.util.Date;

public class SetupEmailDTOBuilder {

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

    public SetupEmailDTOBuilder() {
    }

    public SetupEmailDTOBuilder setIdEmail(String idEmail) {
        this.idEmail = idEmail;
        return this;
    }

    public SetupEmailDTOBuilder setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
        return this;
    }

    public SetupEmailDTOBuilder setParameter(String parameter) {
        this.parameter = parameter;
        return this;
    }

    public SetupEmailDTOBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public SetupEmailDTOBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public SetupEmailDTOBuilder setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public SetupEmailDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public SetupEmailDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public SetupEmailDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public SetupEmailDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public SetupEmailDTO createSetupEmailDTO() {
        return new SetupEmailDTO(idEmail, templateTitle, parameter, subject, content, createBy, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
