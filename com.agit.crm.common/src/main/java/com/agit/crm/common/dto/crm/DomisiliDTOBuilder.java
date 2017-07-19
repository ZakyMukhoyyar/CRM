package com.agit.crm.common.dto.crm;

import java.util.Date;


public class DomisiliDTOBuilder {

    private String idDomisili;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKota;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DomisiliDTOBuilder() {
    }

    public DomisiliDTOBuilder setIdDomisili(String idDomisili) {
        this.idDomisili = idDomisili;
        return this;
    }

    public DomisiliDTOBuilder setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
        return this;
    }

    public DomisiliDTOBuilder setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
        return this;
    }

    public DomisiliDTOBuilder setNamaKota(String namaKota) {
        this.namaKota = namaKota;
        return this;
    }

    public DomisiliDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public DomisiliDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public DomisiliDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public DomisiliDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public DomisiliDTO createDomisiliDTO() {
        return new DomisiliDTO(idDomisili, namaProvinsi, namaKabupaten, namaKota, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
