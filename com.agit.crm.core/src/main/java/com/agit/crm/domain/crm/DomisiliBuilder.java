/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import java.util.Date;


public class DomisiliBuilder {

    private String idDomisili;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKota;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DomisiliBuilder() {
    }

    public DomisiliBuilder setIdDomisili(String idDomisili) {
        this.idDomisili = idDomisili;
        return this;
    }

    public DomisiliBuilder setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
        return this;
    }

    public DomisiliBuilder setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
        return this;
    }

    public DomisiliBuilder setNamaKota(String namaKota) {
        this.namaKota = namaKota;
        return this;
    }

    public DomisiliBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public DomisiliBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public DomisiliBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public DomisiliBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Domisili createDomisili() {
        return new Domisili(idDomisili, namaProvinsi, namaKabupaten, namaKota, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
