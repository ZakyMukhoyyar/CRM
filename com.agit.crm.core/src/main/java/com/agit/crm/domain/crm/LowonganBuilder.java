package com.agit.crm.domain.crm;

import java.util.Date;


public class LowonganBuilder {

    private String idLowongan;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganBuilder() {
    }

    public LowonganBuilder setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
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

    public Lowongan createLowongan() {
        return new Lowongan(idLowongan, namaLowongan, deskripsiLowongan, tanggalMulai, tanggalBerakhir, minatPekerjaan, persyaratan, lokasiKerja, gaji, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
