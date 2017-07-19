package com.agit.crm.domain.crm;

import java.util.Date;


public class DataToHrdBuilder {
    private String idLowonganHrd;
    private String namaLowonganHrd;
    private String hasilSeleksi;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DataToHrdBuilder() {
    }

    public DataToHrdBuilder setIdLowonganHrd(String idLowonganHrd) {
        this.idLowonganHrd = idLowonganHrd;
        return this;
    }

    public DataToHrdBuilder setNamaLowonganHrd(String namaLowonganHrd) {
        this.namaLowonganHrd = namaLowonganHrd;
        return this;
    }

    public DataToHrdBuilder setHasilSeleksi(String hasilSeleksi) {
        this.hasilSeleksi = hasilSeleksi;
        return this;
    }

    public DataToHrdBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public DataToHrdBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public DataToHrdBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public DataToHrdBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public DataToHrd createDataToHrd() {
        return new DataToHrd(idLowonganHrd, namaLowonganHrd, hasilSeleksi, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
