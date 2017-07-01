/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import java.util.Date;

public class KetrampilanBuilder {

    private String idKetrampilan;
    private String namaKetrampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public KetrampilanBuilder() {
    }

    public KetrampilanBuilder setIdKetrampilan(String idKetrampilan) {
        this.idKetrampilan = idKetrampilan;
        return this;
    }

    public KetrampilanBuilder setNamaKetrampilan(String namaKetrampilan) {
        this.namaKetrampilan = namaKetrampilan;
        return this;
    }

    public KetrampilanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KetrampilanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KetrampilanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KetrampilanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KetrampilanBuilder setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public Ketrampilan createKetrampilan() {
        return new Ketrampilan(idKetrampilan, namaKetrampilan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
