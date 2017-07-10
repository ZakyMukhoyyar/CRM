/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;


public class LowonganBuilder {

    private String idLowongan;
    private String idUser;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private LowonganState lowonganState;
    private List<RiwayatApplyMahasiswa> listRiwayatApplyMahasiswa;
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

    public LowonganBuilder setIdUser(String idUser) {
        this.idUser = idUser;
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

    public LowonganBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public LowonganBuilder setListRiwayatApplyMahasiswa(List<RiwayatApplyMahasiswa> listRiwayatApplyMahasiswa) {
        this.listRiwayatApplyMahasiswa = listRiwayatApplyMahasiswa;
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
        return new Lowongan(idLowongan, idUser, namaLowongan, deskripsiLowongan, tanggalMulai, tanggalBerakhir, minatPekerjaan, persyaratan, lokasiKerja, gaji, lowonganState, listRiwayatApplyMahasiswa, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
