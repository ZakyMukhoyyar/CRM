package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class EventBuilder {
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

    public EventBuilder() {
    }

    public EventBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public EventBuilder setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
        return this;
    }

    public EventBuilder setDeskripsiEvent(String deskripsiEvent) {
        this.deskripsiEvent = deskripsiEvent;
        return this;
    }

    public EventBuilder setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventBuilder setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventBuilder setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public EventBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public EventBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EventBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public EventBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Event createEvent() {
        return new Event(idEvent, namaEvent, deskripsiEvent, startDate, endDate, attachment, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
