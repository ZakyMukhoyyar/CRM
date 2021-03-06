package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class Jurusan implements EntityObject<Jurusan>{
    
    long id;
    private String idJurusan;
    private String namaJurusan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public Jurusan() {
    }

    public Jurusan(String idJurusan, String namaJurusan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status ) {
        this.idJurusan = idJurusan;
        this.namaJurusan = namaJurusan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
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
        hash = 79 * hash + Objects.hashCode(this.idJurusan);
        hash = 79 * hash + Objects.hashCode(this.namaJurusan);
        hash = 79 * hash + Objects.hashCode(this.createdBy);
        hash = 79 * hash + Objects.hashCode(this.createdDate);
        hash = 79 * hash + Objects.hashCode(this.modifiedBy);
        hash = 79 * hash + Objects.hashCode(this.modifiedDate);
        hash = 79 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jurusan other = (Jurusan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    public void assignNewJurusan(Jurusan jurusan){
        this.idJurusan = jurusan.idJurusan;
        this.namaJurusan = jurusan.namaJurusan;
        this.createdBy = jurusan.createdBy;
        this.createdDate = jurusan.createdDate;
        this.modifiedBy = jurusan.modifiedBy;
        this.modifiedDate = jurusan.modifiedDate;
        this.status = jurusan.status;
    }
    

    @Override
    public boolean sameIdentityAs(Jurusan other) {
        return this.equals(other);
    }
    
}
