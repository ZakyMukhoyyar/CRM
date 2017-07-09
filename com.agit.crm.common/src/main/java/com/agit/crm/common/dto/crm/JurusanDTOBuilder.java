package com.agit.crm.common.dto.crm;

import java.util.Date;


public class JurusanDTOBuilder {
    private String idJurusan;
    private String namaJurusan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

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

    public JurusanDTO createJurusanDTO() {
        return new JurusanDTO(idJurusan, namaJurusan, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
