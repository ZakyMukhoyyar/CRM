/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.type.PendidikanType;
import java.util.Date;
import java.util.List;


public class MahasiswaBuilder {

    private String idMahasiswa;
    private String username;
    private String password;
    private String retypedPassword;
    private String namaLengkap;
    private String email;
    private Date tanggalLahir;
    private String domisili;
    private String noHP;
    private PendidikanType pendidikanType;
    private String namaCivitas;
    private String minat;
    private String ketrampilan1;
    private String ketrampilan2;
    private String ketrampilan3;
    private String ketrampilan4;
    private String ketrampilan5;
    private String tingkat1;
    private String tingkat2;
    private String tingkat3;
    private String tingkat4;
    private String tingkat5;
    private String uploadCV;
    private List<Lowongan> lowongans;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public MahasiswaBuilder() {
    }

    public MahasiswaBuilder setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
        return this;
    }

    public MahasiswaBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public MahasiswaBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public MahasiswaBuilder setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
        return this;
    }

    public MahasiswaBuilder setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
        return this;
    }

    public MahasiswaBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public MahasiswaBuilder setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
        return this;
    }

    public MahasiswaBuilder setDomisili(String domisili) {
        this.domisili = domisili;
        return this;
    }

    public MahasiswaBuilder setNoHP(String noHP) {
        this.noHP = noHP;
        return this;
    }

    public MahasiswaBuilder setPendidikanType(PendidikanType pendidikanType) {
        this.pendidikanType = pendidikanType;
        return this;
    }

    public MahasiswaBuilder setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
        return this;
    }

    public MahasiswaBuilder setMinat(String minat) {
        this.minat = minat;
        return this;
    }

    public MahasiswaBuilder setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
        return this;
    }

    public MahasiswaBuilder setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
        return this;
    }

    public MahasiswaBuilder setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
        return this;
    }

    public MahasiswaBuilder setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
        return this;
    }

    public MahasiswaBuilder setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
        return this;
    }

    public MahasiswaBuilder setTingkat1(String tingkat1) {
        this.tingkat1 = tingkat1;
        return this;
    }

    public MahasiswaBuilder setTingkat2(String tingkat2) {
        this.tingkat2 = tingkat2;
        return this;
    }

    public MahasiswaBuilder setTingkat3(String tingkat3) {
        this.tingkat3 = tingkat3;
        return this;
    }

    public MahasiswaBuilder setTingkat4(String tingkat4) {
        this.tingkat4 = tingkat4;
        return this;
    }

    public MahasiswaBuilder setTingkat5(String tingkat5) {
        this.tingkat5 = tingkat5;
        return this;
    }

    public MahasiswaBuilder setUploadCV(String uploadCV) {
        this.uploadCV = uploadCV;
        return this;
    }

    public MahasiswaBuilder setLowongans(List<Lowongan> lowongans) {
        this.lowongans = lowongans;
        return this;
    }

    public MahasiswaBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public MahasiswaBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public MahasiswaBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public MahasiswaBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Mahasiswa createMahasiswa() {
        return new Mahasiswa(idMahasiswa, username, password, retypedPassword, namaLengkap, email, tanggalLahir, domisili, noHP, pendidikanType, namaCivitas, minat, ketrampilan1, ketrampilan2, ketrampilan3, ketrampilan4, ketrampilan5, tingkat1, tingkat2, tingkat3, tingkat4, tingkat5, uploadCV, lowongans, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
