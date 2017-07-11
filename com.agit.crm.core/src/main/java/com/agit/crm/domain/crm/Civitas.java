package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 3AD
 */
public class Civitas implements EntityObject<Civitas> {

    long id;
    private String civitasID;
    private String namaCivitas;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Civitas() {
    }

    public Civitas(String civitasID, String namaCivitas, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.civitasID = civitasID;
        this.namaCivitas = namaCivitas;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCivitasID() {
        return civitasID;
    }

    public void setCivitasID(String civitasID) {
        this.civitasID = civitasID;
    }

    public String getNamaCivitas() {
        return namaCivitas;
    }

    public void setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.civitasID);
        hash = 11 * hash + Objects.hashCode(this.namaCivitas);
        hash = 11 * hash + Objects.hashCode(this.status);
        hash = 11 * hash + Objects.hashCode(this.createdBy);
        hash = 11 * hash + Objects.hashCode(this.createdDate);
        hash = 11 * hash + Objects.hashCode(this.modifiedBy);
        hash = 11 * hash + Objects.hashCode(this.modifiedDate);
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
        final Civitas other = (Civitas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewCivitas(Civitas civitas) {
        this.civitasID = civitas.civitasID;
        this.namaCivitas = civitas.namaCivitas;
        this.status = civitas.status;
        this.createdBy = civitas.createdBy;
        this.createdDate = civitas.createdDate;
        this.modifiedBy = civitas.modifiedBy;
        this.modifiedDate = civitas.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(Civitas other) {
        return this.equals(other);
    }

}
