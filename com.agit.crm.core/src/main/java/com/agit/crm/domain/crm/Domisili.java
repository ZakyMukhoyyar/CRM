package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class Domisili implements EntityObject<Domisili> {

    long id;
    private String idDomisili;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKota;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;
    

    public Domisili() {
    }

    public Domisili(String idDomisili, String namaProvinsi, String namaKabupaten, String namaKota, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status) {
        this.idDomisili = idDomisili;
        this.namaProvinsi = namaProvinsi;
        this.namaKabupaten = namaKabupaten;
        this.namaKota = namaKota;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdDomisili() {
        return idDomisili;
    }

    public void setIdDomisili(String idDomisili) {
        this.idDomisili = idDomisili;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
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
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idDomisili);
        hash = 17 * hash + Objects.hashCode(this.namaProvinsi);
        hash = 17 * hash + Objects.hashCode(this.namaKabupaten);
        hash = 17 * hash + Objects.hashCode(this.namaKota);
        hash = 17 * hash + Objects.hashCode(this.createdBy);
        hash = 17 * hash + Objects.hashCode(this.createdDate);
        hash = 17 * hash + Objects.hashCode(this.modifiedBy);
        hash = 17 * hash + Objects.hashCode(this.modifiedDate);
        hash = 17 * hash + Objects.hashCode(this.status);
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
        final Domisili other = (Domisili) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDomisili(Domisili domisili) {
        this.namaProvinsi = domisili.namaProvinsi;
        this.namaKabupaten = domisili.namaKabupaten;
        this.namaKota = domisili.namaKota;
        this.modifiedBy = domisili.modifiedBy;
        this.modifiedDate = domisili.modifiedDate;
        this.status = domisili.status;
    }

    @Override
    public boolean sameIdentityAs(Domisili other) {
        return this.equals(other);
    }

}
