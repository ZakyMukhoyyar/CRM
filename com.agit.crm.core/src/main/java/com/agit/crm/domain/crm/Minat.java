package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class Minat implements EntityObject<Minat> {

    long id;
    private String idMinat;
    private String namaMinat;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public Minat() {
    }

    public Minat(String idMinat, String namaMinat, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean status) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idMinat);
        hash = 19 * hash + Objects.hashCode(this.namaMinat);
        hash = 19 * hash + Objects.hashCode(this.createdBy);
        hash = 19 * hash + Objects.hashCode(this.createdDate);
        hash = 19 * hash + Objects.hashCode(this.modifiedBy);
        hash = 19 * hash + Objects.hashCode(this.modifiedDate);
        hash = 19 * hash + Objects.hashCode(this.status);
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
        final Minat other = (Minat) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewMinat(Minat minat){
        this.idMinat = minat.idMinat;
        this.namaMinat = minat.namaMinat;
        this.createdBy = minat.createdBy;
        this.createdDate = minat.createdDate;
        this.modifiedBy = minat.modifiedBy;
        this.modifiedDate = minat.modifiedDate;
        this.status = minat.status;
    }
    
    @Override
    public boolean sameIdentityAs(Minat other) {
        return this.equals(other);
    }

}
