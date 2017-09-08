package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class EventStatusDTO implements Serializable {

    private String idEventStatus;
    private String idUser;
    private String idEvent;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public EventStatusDTO() {
    }

    public EventStatusDTO(String idEventStatus, String idUser, String idEvent, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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
    public String toString() {
        return "EventStatusDTO{" + "idEventStatus=" + idEventStatus + ", idUser=" + idUser + ", idEvent=" + idEvent + ", lowonganState=" + lowonganState + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }
        
}
