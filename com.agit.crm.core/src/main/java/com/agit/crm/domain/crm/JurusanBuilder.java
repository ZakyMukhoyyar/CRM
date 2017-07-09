package com.agit.crm.domain.crm;

import java.util.Date;


public class JurusanBuilder {
    private String idJurusan;
    private String namaJurusan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

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

    public Jurusan createJurusan() {
        return new Jurusan(idJurusan, namaJurusan, createdBy, createdDate, modifiedBy, modifiedDate);
    }

    public Object setDeskripsiJurusan(String deskripsiJurusan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
