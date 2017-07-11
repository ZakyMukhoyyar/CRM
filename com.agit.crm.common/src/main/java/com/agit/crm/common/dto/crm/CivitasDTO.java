package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 3AD
 */
public class CivitasDTO implements Serializable {

    private String civitasID;
    private String namaCivitas;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public CivitasDTO() {
    }

    public CivitasDTO(String civitasID, String namaCivitas, String status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.civitasID = civitasID;
        this.namaCivitas = namaCivitas;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
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
    public String toString() {
        return "CivitasDTO{" + "civitasID=" + civitasID + ", namaCivitas=" + namaCivitas + ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
