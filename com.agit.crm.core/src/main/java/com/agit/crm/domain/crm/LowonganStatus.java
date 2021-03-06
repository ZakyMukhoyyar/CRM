package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class LowonganStatus implements EntityObject<LowonganStatus>{
    
    long id;
    private String idUser;
    private String idLowongan;
    private String idLowonganStatus;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganStatus() {
    }

    public LowonganStatus(String idUser, String idLowongan, String idLowonganStatus, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.idUser);
        hash = 47 * hash + Objects.hashCode(this.idLowongan);
        hash = 47 * hash + Objects.hashCode(this.idLowonganStatus);
        hash = 47 * hash + Objects.hashCode(this.lowonganState);
        hash = 47 * hash + Objects.hashCode(this.createdBy);
        hash = 47 * hash + Objects.hashCode(this.createdDate);
        hash = 47 * hash + Objects.hashCode(this.modifiedBy);
        hash = 47 * hash + Objects.hashCode(this.modifiedDate);
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
        final LowonganStatus other = (LowonganStatus) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewLowonganStatus (LowonganStatus lowonganStatus){
        this.idLowonganStatus = lowonganStatus.idLowonganStatus;
        this.idUser = lowonganStatus.idUser;
        this.idLowongan = lowonganStatus.idLowongan;
        this.lowonganState = lowonganStatus.lowonganState;
        this.createdBy = lowonganStatus.createdBy;
        this.createdDate = lowonganStatus.createdDate;
        this.modifiedBy = lowonganStatus.modifiedBy;
        this.modifiedDate = lowonganStatus.modifiedDate;
    }
    
    @Override
    public boolean sameIdentityAs(LowonganStatus other) {
        return this.equals(other);
    }
    
    
    
}
