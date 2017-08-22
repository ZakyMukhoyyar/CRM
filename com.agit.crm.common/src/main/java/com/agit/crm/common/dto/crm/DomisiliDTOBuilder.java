/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
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
    private Status status;

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

    public DomisiliDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public DomisiliDTO createDomisiliDTO() {
        return new DomisiliDTO(idDomisili, namaProvinsi, namaKabupaten, namaKota, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
