package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class Ketrampilan implements EntityObject<Ketrampilan> {

    long id;
    private String idKetrampilan;
    private String namaKetrampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public Ketrampilan() {
    }

    public Ketrampilan(String idKetrampilan, String namaKetrampilan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idKetrampilan);
        hash = 17 * hash + Objects.hashCode(this.namaKetrampilan);
        hash = 17 * hash + Objects.hashCode(this.createdBy);
        hash = 17 * hash + Objects.hashCode(this.createdDate);
        hash = 17 * hash + Objects.hashCode(this.modifiedBy);
        hash = 17 * hash + Objects.hashCode(this.modifiedDate);
        hash = 17 * hash + Objects.hashCode(this.status);
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
        final Ketrampilan other = (Ketrampilan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewKetrampilan (Ketrampilan Ketrampilan){
        this.idKetrampilan = Ketrampilan.idKetrampilan;
        this.namaKetrampilan = Ketrampilan.namaKetrampilan;
        this.createdBy = Ketrampilan.createdBy;
        this.createdDate = Ketrampilan.createdDate;
        this.modifiedBy = Ketrampilan.modifiedBy;
        this.modifiedDate = Ketrampilan.modifiedDate;
        this.status = Ketrampilan.status;
    }

    @Override
    public boolean sameIdentityAs(Ketrampilan other) {
        return this.equals(other);
    }

}
