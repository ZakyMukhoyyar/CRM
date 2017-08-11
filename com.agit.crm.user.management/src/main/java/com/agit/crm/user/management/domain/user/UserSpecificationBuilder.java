/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import java.util.Date;

public class UserSpecificationBuilder {

    private String fullName;
    private String email;
    private String mobilePhone;
    private String immediateSupervisorUserName;
    private String primaryBranchID;
    private String ktp;
    private Date tanggalLahir;
    private String domisili;
    private String noHP;
    private String noKTP;
    private String ipk;
    private JenisKelaminType jenisKelaminType;
    private PendidikanType pendidikanType;
    private String namaCivitas;
    private String minat;
    private String ketrampilan1;
    private String ketrampilan2;
    private String ketrampilan3;
    private String ketrampilan4;
    private String ketrampilan5;
    private TingkatanType tingkatanType1;
    private TingkatanType tingkatanType2;
    private TingkatanType tingkatanType3;
    private TingkatanType tingkatanType4;
    private TingkatanType tingkatanType5;
    private String uploadCV;
    private Boolean statusApprove;
    private String jurusan;
    private String escute;
    private JobDivision jobDivision;
    private JobLocation jobLocation;
    private AccessTime accessTime;
    private UserLoginInfo userLoginInfo;
    private Boolean disableButton;

    public UserSpecificationBuilder() {
    }

    public UserSpecificationBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserSpecificationBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserSpecificationBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UserSpecificationBuilder setImmediateSupervisorUserName(String immediateSupervisorUserName) {
        this.immediateSupervisorUserName = immediateSupervisorUserName;
        return this;
    }

    public UserSpecificationBuilder setPrimaryBranchID(String primaryBranchID) {
        this.primaryBranchID = primaryBranchID;
        return this;
    }

    public UserSpecificationBuilder setKtp(String ktp) {
        this.ktp = ktp;
        return this;
    }

    public UserSpecificationBuilder setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
        return this;
    }

    public UserSpecificationBuilder setDomisili(String domisili) {
        this.domisili = domisili;
        return this;
    }

    public UserSpecificationBuilder setNoHP(String noHP) {
        this.noHP = noHP;
        return this;
    }

    public UserSpecificationBuilder setNoKTP(String noKTP) {
        this.noKTP = noKTP;
        return this;
    }

    public UserSpecificationBuilder setIpk(String ipk) {
        this.ipk = ipk;
        return this;
    }

    public UserSpecificationBuilder setJenisKelaminType(JenisKelaminType jenisKelaminType) {
        this.jenisKelaminType = jenisKelaminType;
        return this;
    }

    public UserSpecificationBuilder setPendidikanType(PendidikanType pendidikanType) {
        this.pendidikanType = pendidikanType;
        return this;
    }

    public UserSpecificationBuilder setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
        return this;
    }

    public UserSpecificationBuilder setMinat(String minat) {
        this.minat = minat;
        return this;
    }

    public UserSpecificationBuilder setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
        return this;
    }

    public UserSpecificationBuilder setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
        return this;
    }

    public UserSpecificationBuilder setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
        return this;
    }

    public UserSpecificationBuilder setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
        return this;
    }

    public UserSpecificationBuilder setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
        return this;
    }

    public UserSpecificationBuilder setTingkatanType1(TingkatanType tingkatanType1) {
        this.tingkatanType1 = tingkatanType1;
        return this;
    }

    public UserSpecificationBuilder setTingkatanType2(TingkatanType tingkatanType2) {
        this.tingkatanType2 = tingkatanType2;
        return this;
    }

    public UserSpecificationBuilder setTingkatanType3(TingkatanType tingkatanType3) {
        this.tingkatanType3 = tingkatanType3;
        return this;
    }

    public UserSpecificationBuilder setTingkatanType4(TingkatanType tingkatanType4) {
        this.tingkatanType4 = tingkatanType4;
        return this;
    }

    public UserSpecificationBuilder setTingkatanType5(TingkatanType tingkatanType5) {
        this.tingkatanType5 = tingkatanType5;
        return this;
    }

    public UserSpecificationBuilder setUploadCV(String uploadCV) {
        this.uploadCV = uploadCV;
        return this;
    }

    public UserSpecificationBuilder setStatusApprove(Boolean statusApprove) {
        this.statusApprove = statusApprove;
        return this;
    }

    public UserSpecificationBuilder setJurusan(String jurusan) {
        this.jurusan = jurusan;
        return this;
    }

    public UserSpecificationBuilder setEscute(String escute) {
        this.escute = escute;
        return this;
    }

    public UserSpecificationBuilder setJobDivision(JobDivision jobDivision) {
        this.jobDivision = jobDivision;
        return this;
    }

    public UserSpecificationBuilder setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    public UserSpecificationBuilder setAccessTime(AccessTime accessTime) {
        this.accessTime = accessTime;
        return this;
    }

    public UserSpecificationBuilder setUserLoginInfo(UserLoginInfo userLoginInfo) {
        this.userLoginInfo = userLoginInfo;
        return this;
    }

    public UserSpecificationBuilder setDisableButton(Boolean disableButton) {
        this.disableButton = disableButton;
        return this;
    }
    

    public UserSpecification createUserSpecification() {
        return new UserSpecification(fullName, email, mobilePhone, immediateSupervisorUserName, primaryBranchID, ktp, tanggalLahir, domisili, noHP, noKTP, ipk, jenisKelaminType, pendidikanType, namaCivitas, minat, ketrampilan1, ketrampilan2, ketrampilan3, ketrampilan4, ketrampilan5, tingkatanType1, tingkatanType2, tingkatanType3, tingkatanType4, tingkatanType5, uploadCV, statusApprove, jurusan, escute, jobDivision, jobLocation, accessTime, userLoginInfo, disableButton);
    }

}
