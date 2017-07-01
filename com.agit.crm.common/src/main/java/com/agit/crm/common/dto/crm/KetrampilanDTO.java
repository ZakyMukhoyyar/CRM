package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class KetrampilanDTO implements Serializable{
    
    private String idKetrampilan;
    private String namaKetrampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public KetrampilanDTO() {
    }

    public KetrampilanDTO(String idKetrampilan, String namaKetrampilan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean status) {
        this.idKetrampilan = idKetrampilan;
        this.namaKetrampilan = namaKetrampilan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdKetrampilan() {
        return idKetrampilan;
    }

    public void setIdKetrampilan(String idKetrampilan) {
        this.idKetrampilan = idKetrampilan;
    }

    public String getNamaKetrampilan() {
        return namaKetrampilan;
    }

    public void setNamaKetrampilan(String namaKetrampilan) {
        this.namaKetrampilan = namaKetrampilan;
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
        return "KetrampilanDTO{" + "idKetrampilan=" + idKetrampilan + ", namaKetrampilan=" + namaKetrampilan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", status=" + status + '}';
    }
       
}
