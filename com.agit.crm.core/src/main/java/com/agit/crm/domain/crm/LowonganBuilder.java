package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class LowonganBuilder {
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;
    private String idLowongan;
    private Long userID;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private Boolean freelance;

    public LowonganBuilder() {
    }

    public LowonganBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LowonganBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LowonganBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public LowonganBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public LowonganBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public LowonganBuilder setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
        return this;
    }

    public LowonganBuilder setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public LowonganBuilder setNamaLowongan(String namaLowongan) {
        this.namaLowongan = namaLowongan;
        return this;
    }

    public LowonganBuilder setDeskripsiLowongan(String deskripsiLowongan) {
        this.deskripsiLowongan = deskripsiLowongan;
        return this;
    }

    public LowonganBuilder setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
        return this;
    }

    public LowonganBuilder setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
        return this;
    }

    public LowonganBuilder setMinatPekerjaan(String minatPekerjaan) {
        this.minatPekerjaan = minatPekerjaan;
        return this;
    }

    public LowonganBuilder setPersyaratan(String persyaratan) {
        this.persyaratan = persyaratan;
        return this;
    }

    public LowonganBuilder setLokasiKerja(String lokasiKerja) {
        this.lokasiKerja = lokasiKerja;
        return this;
    }

    public LowonganBuilder setGaji(String gaji) {
        this.gaji = gaji;
        return this;
    }

    public LowonganBuilder setFreelance(Boolean freelance) {
        this.freelance = freelance;
        return this;
    }

    public Lowongan createLowongan() {
        return new Lowongan(createdBy, createdDate, modifiedBy, modifiedDate, status, idLowongan, userID, namaLowongan, deskripsiLowongan, tanggalMulai, tanggalBerakhir, minatPekerjaan, persyaratan, lokasiKerja, gaji, freelance);
    }
    
}
