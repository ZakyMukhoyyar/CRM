/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;

public class EventAgitBuilder {

    private String idEvent;
    private String namaEvent;
    private String deskripsiEvent;
    private Date startDate;
    private Date endDate;
    private String attachment;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public EventAgitBuilder() {
    }

    public EventAgitBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public EventAgitBuilder setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
        return this;
    }

    public EventAgitBuilder setDeskripsiEvent(String deskripsiEvent) {
        this.deskripsiEvent = deskripsiEvent;
        return this;
    }

    public EventAgitBuilder setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventAgitBuilder setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventAgitBuilder setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public EventAgitBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public EventAgitBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventAgitBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EventAgitBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public EventAgitBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public EventAgit createEventAgit() {
        return new EventAgit(idEvent, namaEvent, deskripsiEvent, startDate, endDate, attachment, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
