package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class MinatDTO {
    
    private String idMinat;
    private String namaMinat;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public MinatDTO() {
    }

    public MinatDTO(String idMinat, String namaMinat, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status) {
        this.idMinat = idMinat;
        this.namaMinat = namaMinat;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdMinat() {
        return idMinat;
    }

    public void setIdMinat(String idMinat) {
        this.idMinat = idMinat;
    }

    public String getNamaMinat() {
        return namaMinat;
    }

    public void setNamaMinat(String namaMinat) {
        this.namaMinat = namaMinat;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MinatDTO{" + "idMinat=" + idMinat + ", namaMinat=" + namaMinat + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", status=" + status + '}';
    }
    
    
    
}
