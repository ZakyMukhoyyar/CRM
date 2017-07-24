/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import java.util.Date;

public class LowonganDTOBuilder {

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
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganDTOBuilder() {
    }

    public LowonganDTOBuilder setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
        return this;
    }

    public LowonganDTOBuilder setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public LowonganDTOBuilder setNamaLowongan(String namaLowongan) {
        this.namaLowongan = namaLowongan;
        return this;
    }

    public LowonganDTOBuilder setDeskripsiLowongan(String deskripsiLowongan) {
        this.deskripsiLowongan = deskripsiLowongan;
        return this;
    }

    public LowonganDTOBuilder setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
        return this;
    }

    public LowonganDTOBuilder setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
        return this;
    }

    public LowonganDTOBuilder setMinatPekerjaan(String minatPekerjaan) {
        this.minatPekerjaan = minatPekerjaan;
        return this;
    }

    public LowonganDTOBuilder setPersyaratan(String persyaratan) {
        this.persyaratan = persyaratan;
        return this;
    }

    public LowonganDTOBuilder setLokasiKerja(String lokasiKerja) {
        this.lokasiKerja = lokasiKerja;
        return this;
    }

    public LowonganDTOBuilder setGaji(String gaji) {
        this.gaji = gaji;
        return this;
    }

    public LowonganDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LowonganDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LowonganDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public LowonganDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public LowonganDTO createLowonganDTO() {
        return new LowonganDTO(idLowongan, userID, namaLowongan, deskripsiLowongan, tanggalMulai, tanggalBerakhir, minatPekerjaan, persyaratan, lokasiKerja, gaji, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
