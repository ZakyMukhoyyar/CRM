/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;

public class CivitasBuilder {

    private String civitasID;
    private String namaCivitas;
    private Status status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public CivitasBuilder() {
    }

    public CivitasBuilder setCivitasID(String civitasID) {
        this.civitasID = civitasID;
        return this;
    }

    public CivitasBuilder setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
        return this;
    }

    public CivitasBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public CivitasBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CivitasBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CivitasBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public CivitasBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Civitas createCivitas() {
        return new Civitas(civitasID, namaCivitas, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
