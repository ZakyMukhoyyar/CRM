package com.agit.crm.domain.crm;

import java.util.Date;


public class KeterampilanBuilder {
    private String idKeterampilan;
    private String namaKeterampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public KeterampilanBuilder() {
    }

    public KeterampilanBuilder setIdKeterampilan(String idKeterampilan) {
        this.idKeterampilan = idKeterampilan;
        return this;
    }

    public KeterampilanBuilder setNamaKeterampilan(String namaKeterampilan) {
        this.namaKeterampilan = namaKeterampilan;
        return this;
    }

    public KeterampilanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KeterampilanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KeterampilanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KeterampilanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KeterampilanBuilder setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public Keterampilan createKeterampilan() {
        return new Keterampilan(idKeterampilan, namaKeterampilan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
