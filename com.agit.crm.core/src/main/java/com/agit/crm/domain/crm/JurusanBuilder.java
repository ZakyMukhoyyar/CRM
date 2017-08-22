/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class JurusanBuilder {

    private String idJurusan;
    private String namaJurusan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public JurusanBuilder() {
    }

    public JurusanBuilder setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
        return this;
    }

    public JurusanBuilder setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
        return this;
    }

    public JurusanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public JurusanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public JurusanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public JurusanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public JurusanBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Jurusan createJurusan() {
        return new Jurusan(idJurusan, namaJurusan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
