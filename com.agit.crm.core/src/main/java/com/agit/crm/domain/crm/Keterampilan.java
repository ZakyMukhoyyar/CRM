package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class Keterampilan implements EntityObject<Keterampilan> {

    long id;
    private String idKeterampilan;
    private String namaKeterampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public Keterampilan() {
    }

    public Keterampilan(String idKeterampilan, String namaKeterampilan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean status) {
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
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idKeterampilan);
        hash = 17 * hash + Objects.hashCode(this.namaKeterampilan);
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
        final Keterampilan other = (Keterampilan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewKeterampilan (Keterampilan keterampilan){
        this.idKeterampilan = keterampilan.idKeterampilan;
        this.namaKeterampilan = keterampilan.namaKeterampilan;
        this.createdBy = keterampilan.createdBy;
        this.createdDate = keterampilan.createdDate;
        this.modifiedBy = keterampilan.modifiedBy;
        this.modifiedDate = keterampilan.modifiedDate;
        this.status = keterampilan.status;
    }

    @Override
    public boolean sameIdentityAs(Keterampilan other) {
        return this.equals(other);
    }

}
