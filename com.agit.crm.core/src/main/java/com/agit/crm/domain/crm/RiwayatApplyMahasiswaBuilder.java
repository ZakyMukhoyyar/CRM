package com.agit.crm.domain.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;


public class RiwayatApplyMahasiswaBuilder {

    private String idRiwayatApplyMahasiswa;
    private String idRiwayatLowongan;
    private String namaLowonganApply;
    private String namaApplyLowongan;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyMahasiswaBuilder() {
    }

    public RiwayatApplyMahasiswaBuilder setIdRiwayatApplyMahasiswa(String idRiwayatApplyMahasiswa) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setIdRiwayatLowongan(String idRiwayatLowongan) {
        this.idRiwayatLowongan = idRiwayatLowongan;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setNamaLowonganApply(String namaLowonganApply) {
        this.namaLowonganApply = namaLowonganApply;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setNamaApplyLowongan(String namaApplyLowongan) {
        this.namaApplyLowongan = namaApplyLowongan;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public RiwayatApplyMahasiswa createRiwayatApplyMahasiswa() {
        return new RiwayatApplyMahasiswa(idRiwayatApplyMahasiswa, idRiwayatLowongan, namaLowonganApply, namaApplyLowongan, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
