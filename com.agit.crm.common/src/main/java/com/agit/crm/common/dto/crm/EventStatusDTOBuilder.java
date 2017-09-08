package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;


public class EventStatusDTOBuilder {
    private String idEventStatus;
    private String idUser;
    private String idEvent;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public EventStatusDTOBuilder() {
    }

    public EventStatusDTOBuilder setIdEventStatus(String idEventStatus) {
        this.idEventStatus = idEventStatus;
        return this;
    }

    public EventStatusDTOBuilder setIdUser(String idUser) {
        this.idUser = idUser;
        return this;
    }

    public EventStatusDTOBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public EventStatusDTOBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public EventStatusDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public EventStatusDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventStatusDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EventStatusDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public EventStatusDTO createEventStatusDTO() {
        return new EventStatusDTO(idEventStatus, idUser, idEvent, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
