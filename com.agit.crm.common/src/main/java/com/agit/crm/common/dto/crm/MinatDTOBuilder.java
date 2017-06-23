package com.agit.crm.common.dto.crm;

import java.util.Date;


public class MinatDTOBuilder {
    private String idMinat;
    private String namaMinat;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public MinatDTOBuilder() {
    }

    public MinatDTOBuilder setIdMinat(String idMinat) {
        this.idMinat = idMinat;
        return this;
    }

    public MinatDTOBuilder setNamaMinat(String namaMinat) {
        this.namaMinat = namaMinat;
        return this;
    }

    public MinatDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public MinatDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public MinatDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public MinatDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public MinatDTOBuilder setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public MinatDTO createMinatDTO() {
        return new MinatDTO(idMinat, namaMinat, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
