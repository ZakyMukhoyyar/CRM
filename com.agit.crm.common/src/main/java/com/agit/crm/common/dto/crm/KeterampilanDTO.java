package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class KeterampilanDTO implements Serializable{
    
    private String idKeterampilan;
    private String namaKeterampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public KeterampilanDTO() {
    }

    public KeterampilanDTO(String idKeterampilan, String namaKeterampilan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean status) {
        this.idKeterampilan = idKeterampilan;
        this.namaKeterampilan = namaKeterampilan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdKeterampilan() {
        return idKeterampilan;
    }

    public void setIdKeterampilan(String idKeterampilan) {
        this.idKeterampilan = idKeterampilan;
    }

    public String getNamaKeterampilan() {
        return namaKeterampilan;
    }

    public void setNamaKeterampilan(String namaKeterampilan) {
        this.namaKeterampilan = namaKeterampilan;
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
    public String toString() {
        return "KeterampilanDTO{" + "idKeterampilan=" + idKeterampilan + ", namaKeterampilan=" + namaKeterampilan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", status=" + status + '}';
    }
       
}
