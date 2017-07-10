/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;

public class CivitasDTOBuilder {

    private String civitasID;
    private String uploadCivitas;
    private String namaCivitas;
    private Status status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public CivitasDTOBuilder() {
    }

    public CivitasDTOBuilder setCivitasID(String civitasID) {
        this.civitasID = civitasID;
        return this;
    }

    public CivitasDTOBuilder setUploadCivitas(String uploadCivitas) {
        this.uploadCivitas = uploadCivitas;
        return this;
    }

    public CivitasDTOBuilder setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
        return this;
    }

    public CivitasDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public CivitasDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CivitasDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CivitasDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public CivitasDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public CivitasDTO createCivitasDTO() {
        return new CivitasDTO(civitasID, uploadCivitas, namaCivitas, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
