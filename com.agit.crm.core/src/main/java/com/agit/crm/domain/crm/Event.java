package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class Event implements EntityObject<Event> {

    long id;
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
    private Boolean status;

    public Event() {
    }

    public Event(String idEvent, String namaEvent, String deskripsiEvent, Date startDate, Date endDate, String attachment, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean status) {
        this.idEvent = idEvent;
        this.namaEvent = namaEvent;
        this.deskripsiEvent = deskripsiEvent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attachment = attachment;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getDeskripsiEvent() {
        return deskripsiEvent;
    }

    public void setDeskripsiEvent(String deskripsiEvent) {
        this.deskripsiEvent = deskripsiEvent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idEvent);
        hash = 97 * hash + Objects.hashCode(this.namaEvent);
        hash = 97 * hash + Objects.hashCode(this.deskripsiEvent);
        hash = 97 * hash + Objects.hashCode(this.startDate);
        hash = 97 * hash + Objects.hashCode(this.endDate);
        hash = 97 * hash + Objects.hashCode(this.attachment);
        hash = 97 * hash + Objects.hashCode(this.createdBy);
        hash = 97 * hash + Objects.hashCode(this.createdDate);
        hash = 97 * hash + Objects.hashCode(this.modifiedBy);
        hash = 97 * hash + Objects.hashCode(this.modifiedDate);
        hash = 97 * hash + Objects.hashCode(this.status);
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
        final Event other = (Event) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewEvent(Event event){
        this.idEvent = event.idEvent;
        this.namaEvent = event.namaEvent;
        this.deskripsiEvent = event.deskripsiEvent;
        this.startDate = event.startDate;
        this.endDate = event.endDate;
        this.attachment = event.attachment;
        this.createdBy = event.createdBy;
        this.createdDate = event.createdDate;
        this.modifiedBy = event.modifiedBy;
        this.modifiedDate = event.modifiedDate;
        this.status = event.status;
    }

    @Override
    public boolean sameIdentityAs(Event other) {
        return this.equals(other);
    }

}
