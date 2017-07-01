/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import java.util.Date;

public class KetrampilanDTOBuilder {

    private String idKetrampilan;
    private String namaKetrampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public KetrampilanDTOBuilder() {
    }

    public KetrampilanDTOBuilder setIdKetrampilan(String idKetrampilan) {
        this.idKetrampilan = idKetrampilan;
        return this;
    }

    public KetrampilanDTOBuilder setNamaKetrampilan(String namaKetrampilan) {
        this.namaKetrampilan = namaKetrampilan;
        return this;
    }

    public KetrampilanDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KetrampilanDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KetrampilanDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KetrampilanDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KetrampilanDTOBuilder setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public KetrampilanDTO createKetrampilanDTO() {
        return new KetrampilanDTO(idKetrampilan, namaKetrampilan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
