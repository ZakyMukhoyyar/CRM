package com.agit.crm.domain.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;


public class EventStatusBuilder {
    private String idEventStatus;
    private String idUser;
    private String idEvent;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public EventStatusBuilder() {
    }

    public EventStatusBuilder setIdEventStatus(String idEventStatus) {
        this.idEventStatus = idEventStatus;
        return this;
    }

    public EventStatusBuilder setIdUser(String idUser) {
        this.idUser = idUser;
        return this;
    }

    public EventStatusBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public EventStatusBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public EventStatusBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public EventStatusBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventStatusBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EventStatusBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public EventStatus createEventStatus() {
        return new EventStatus(idEventStatus, idUser, idEvent, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
