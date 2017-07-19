package com.agit.crm.common.dto.crm;

import java.util.Date;


public class DataToHrdDTOBuilder {
    private String idLowonganHrd;
    private String namaLowonganHrd;
    private String hasilSeleksi;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DataToHrdDTOBuilder() {
    }

    public DataToHrdDTOBuilder setIdLowonganHrd(String idLowonganHrd) {
        this.idLowonganHrd = idLowonganHrd;
        return this;
    }

    public DataToHrdDTOBuilder setNamaLowonganHrd(String namaLowonganHrd) {
        this.namaLowonganHrd = namaLowonganHrd;
        return this;
    }

    public DataToHrdDTOBuilder setHasilSeleksi(String hasilSeleksi) {
        this.hasilSeleksi = hasilSeleksi;
        return this;
    }

    public DataToHrdDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public DataToHrdDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public DataToHrdDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public DataToHrdDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public DataToHrdDTO createDataToHrdDTO() {
        return new DataToHrdDTO(idLowonganHrd, namaLowonganHrd, hasilSeleksi, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
