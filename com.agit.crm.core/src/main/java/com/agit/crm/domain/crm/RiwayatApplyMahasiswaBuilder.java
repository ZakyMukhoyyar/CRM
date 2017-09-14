/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;

public class RiwayatApplyMahasiswaBuilder {

    private String idRiwayatApplyMahasiswa;
    private String idRiwayatLowongan;
    private String idUserRiwayat;
    private String namaLowonganApply;
    private String namaApplyLowongan;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private String statusApprove;
    private String jurusan;
    private String minat;
    private String ketrampilan1;
    private String ketrampilan2;
    private String ketrampilan3;
    private String ketrampilan4;
    private String ketrampilan5;
    private String email;

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

    public RiwayatApplyMahasiswaBuilder setIdUserRiwayat(String idUserRiwayat) {
        this.idUserRiwayat = idUserRiwayat;
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

    public RiwayatApplyMahasiswaBuilder setStatusApprove(String statusApprove) {
        this.statusApprove = statusApprove;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setJurusan(String jurusan) {
        this.jurusan = jurusan;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setMinat(String minat) {
        this.minat = minat;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
        return this;
    }

    public RiwayatApplyMahasiswaBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public RiwayatApplyMahasiswa createRiwayatApplyMahasiswa() {
        return new RiwayatApplyMahasiswa(idRiwayatApplyMahasiswa, idRiwayatLowongan, idUserRiwayat, namaLowonganApply, namaApplyLowongan, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate, statusApprove, jurusan, minat, ketrampilan1, ketrampilan2, ketrampilan3, ketrampilan4, ketrampilan5, email);
    }

}
