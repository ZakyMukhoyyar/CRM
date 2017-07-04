/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;

public class EventAgitDTOBuilder {

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

    public EventAgitDTOBuilder() {
    }

    public EventAgitDTOBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public EventAgitDTOBuilder setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
        return this;
    }

    public EventAgitDTOBuilder setDeskripsiEvent(String deskripsiEvent) {
        this.deskripsiEvent = deskripsiEvent;
        return this;
    }

    public EventAgitDTOBuilder setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventAgitDTOBuilder setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventAgitDTOBuilder setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public EventAgitDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public EventAgitDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventAgitDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EventAgitDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public EventAgitDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public EventAgitDTO createEventAgitDTO() {
        return new EventAgitDTO(idEvent, namaEvent, deskripsiEvent, startDate, endDate, attachment, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
