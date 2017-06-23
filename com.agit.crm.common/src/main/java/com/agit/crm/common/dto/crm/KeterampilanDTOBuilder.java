package com.agit.crm.common.dto.crm;

import java.util.Date;


public class KeterampilanDTOBuilder {
    private String idKeterampilan;
    private String namaKeterampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public KeterampilanDTOBuilder() {
    }

    public KeterampilanDTOBuilder setIdKeterampilan(String idKeterampilan) {
        this.idKeterampilan = idKeterampilan;
        return this;
    }

    public KeterampilanDTOBuilder setNamaKeterampilan(String namaKeterampilan) {
        this.namaKeterampilan = namaKeterampilan;
        return this;
    }

    public KeterampilanDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KeterampilanDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KeterampilanDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KeterampilanDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KeterampilanDTOBuilder setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public KeterampilanDTO createKeterampilanDTO() {
        return new KeterampilanDTO(idKeterampilan, namaKeterampilan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
