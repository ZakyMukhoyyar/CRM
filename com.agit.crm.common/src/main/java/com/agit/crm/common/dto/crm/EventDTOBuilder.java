package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class EventDTOBuilder {
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

    public EventDTOBuilder() {
    }

    public EventDTOBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public EventDTOBuilder setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
        return this;
    }

    public EventDTOBuilder setDeskripsiEvent(String deskripsiEvent) {
        this.deskripsiEvent = deskripsiEvent;
        return this;
    }

    public EventDTOBuilder setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventDTOBuilder setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventDTOBuilder setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public EventDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public EventDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EventDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public EventDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public EventDTO createEventDTO() {
        return new EventDTO(idEvent, namaEvent, deskripsiEvent, startDate, endDate, attachment, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
