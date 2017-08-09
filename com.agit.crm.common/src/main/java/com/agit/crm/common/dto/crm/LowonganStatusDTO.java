package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class LowonganStatusDTO implements Serializable{
    private String idUser;
    private String idLowongan;
    private String idLowonganStatus;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganStatusDTO() {
    }

    public LowonganStatusDTO(String idUser, String idLowongan, String idLowonganStatus, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idUser = idUser;
        this.idLowongan = idLowongan;
        this.idLowonganStatus = idLowonganStatus;
        this.lowonganState = lowonganState;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
    }

    public String getIdLowonganStatus() {
        return idLowonganStatus;
    }

    public void setIdLowonganStatus(String idLowonganStatus) {
        this.idLowonganStatus = idLowonganStatus;
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
        return "LowonganStatusDTO{" + "idUser=" + idUser + ", idLowongan=" + idLowongan + ", idLowonganStatus=" + idLowonganStatus + ", lowonganState=" + lowonganState + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }
    
}
