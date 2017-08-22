/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class JurusanDTOBuilder {

    private String idJurusan;
    private String namaJurusan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public JurusanDTOBuilder() {
    }

    public JurusanDTOBuilder setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
        return this;
    }

    public JurusanDTOBuilder setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
        return this;
    }

    public JurusanDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public JurusanDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public JurusanDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public JurusanDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public JurusanDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public JurusanDTO createJurusanDTO() {
        return new JurusanDTO(idJurusan, namaJurusan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
