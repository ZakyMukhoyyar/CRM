/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;


public class RiwayatApplyMahasiswaDTOBuilder {

    private String idRiwayatApplyMahasiswa;
    private LowonganState lowonganState;
    private String namaLowonganApply;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyMahasiswaDTOBuilder() {
    }

    public RiwayatApplyMahasiswaDTOBuilder setIdRiwayatApplyMahasiswa(String idRiwayatApplyMahasiswa) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
        return this;
    }

    public RiwayatApplyMahasiswaDTOBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public RiwayatApplyMahasiswaDTOBuilder setNamaLowonganApply(String namaLowonganApply) {
        this.namaLowonganApply = namaLowonganApply;
        return this;
    }

    public RiwayatApplyMahasiswaDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public RiwayatApplyMahasiswaDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public RiwayatApplyMahasiswaDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public RiwayatApplyMahasiswaDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public RiwayatApplyMahasiswaDTO createRiwayatApplyMahasiswaDTO() {
        return new RiwayatApplyMahasiswaDTO(idRiwayatApplyMahasiswa, lowonganState, namaLowonganApply, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
