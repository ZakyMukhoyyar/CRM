package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class EventStatus implements EntityObject<EventStatus>{
    long id;
    private String idEventStatus;
    private String idUser;
    private String idEvent;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public EventStatus() {
    }

    public EventStatus(String idEventStatus, String idUser, String idEvent, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idEventStatus = idEventStatus;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.lowonganState = lowonganState;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdEventStatus() {
        return idEventStatus;
    }

    public void setIdEventStatus(String idEventStatus) {
        this.idEventStatus = idEventStatus;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
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
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idEventStatus);
        hash = 67 * hash + Objects.hashCode(this.idUser);
        hash = 67 * hash + Objects.hashCode(this.idEvent);
        hash = 67 * hash + Objects.hashCode(this.lowonganState);
        hash = 67 * hash + Objects.hashCode(this.createdBy);
        hash = 67 * hash + Objects.hashCode(this.createdDate);
        hash = 67 * hash + Objects.hashCode(this.modifiedBy);
        hash = 67 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EventStatus other = (EventStatus) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    public void assignNewEventStatus (EventStatus eventStatus){
        this.idEventStatus = eventStatus.idEventStatus;
        this.idUser = eventStatus.idUser;
        this.idEvent = eventStatus.idEvent;
        this.lowonganState = eventStatus.lowonganState;
        this.createdBy = eventStatus.createdBy;
        this.createdDate = eventStatus.createdDate;
        this.modifiedBy = eventStatus.modifiedBy;
        this.modifiedDate = eventStatus.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(EventStatus other) {
        return this.equals(other);
    }
    
}
