package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class DomisiliDTO implements Serializable {

    private String idDomisili;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKota;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DomisiliDTO() {
    }

    public DomisiliDTO(String idDomisili, String namaProvinsi, String namaKabupaten, String namaKota, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idDomisili = idDomisili;
        this.namaProvinsi = namaProvinsi;
        this.namaKabupaten = namaKabupaten;
        this.namaKota = namaKota;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
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

    @Override
    public String toString() {
        return "DomisiliDTO{" + "idDomisili=" + idDomisili + ", namaProvinsi=" + namaProvinsi + ", namaKabupaten=" + namaKabupaten + ", namaKota=" + namaKota + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
