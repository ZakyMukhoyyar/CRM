package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import java.util.Date;


public class UserSpecificationDTOBuilder {
    private String fullName;
    private String email;
    private String mobilePhone;
    private String immediateSupervisorUserName;
    private String primaryBranchID;
    private String ktp;
    private String escute;
    private JobDivision jobDivision;
    private JobLocation jobLocation;
    private AccessTimeDTO accessTimeDTO;
    private UserLoginInfoDTO userLoginInfoDTO;
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
    private String pengalaman;
    private Boolean freelance;

    public UserSpecificationDTOBuilder() {
    }

    public UserSpecificationDTOBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserSpecificationDTOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserSpecificationDTOBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UserSpecificationDTOBuilder setImmediateSupervisorUserName(String immediateSupervisorUserName) {
        this.immediateSupervisorUserName = immediateSupervisorUserName;
        return this;
    }

    public UserSpecificationDTOBuilder setPrimaryBranchID(String primaryBranchID) {
        this.primaryBranchID = primaryBranchID;
        return this;
    }

    public UserSpecificationDTOBuilder setKtp(String ktp) {
        this.ktp = ktp;
        return this;
    }

    public UserSpecificationDTOBuilder setEscute(String escute) {
        this.escute = escute;
        return this;
    }

    public UserSpecificationDTOBuilder setJobDivision(JobDivision jobDivision) {
        this.jobDivision = jobDivision;
        return this;
    }

    public UserSpecificationDTOBuilder setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    public UserSpecificationDTOBuilder setAccessTimeDTO(AccessTimeDTO accessTimeDTO) {
        this.accessTimeDTO = accessTimeDTO;
        return this;
    }

    public UserSpecificationDTOBuilder setUserLoginInfoDTO(UserLoginInfoDTO userLoginInfoDTO) {
        this.userLoginInfoDTO = userLoginInfoDTO;
        return this;
    }

    public UserSpecificationDTOBuilder setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
        return this;
    }

    public UserSpecificationDTOBuilder setDomisili(String domisili) {
        this.domisili = domisili;
        return this;
    }

    public UserSpecificationDTOBuilder setNoHP(String noHP) {
        this.noHP = noHP;
        return this;
    }

    public UserSpecificationDTOBuilder setNoKTP(String noKTP) {
        this.noKTP = noKTP;
        return this;
    }

    public UserSpecificationDTOBuilder setIpk(String ipk) {
        this.ipk = ipk;
        return this;
    }

    public UserSpecificationDTOBuilder setJenisKelaminType(JenisKelaminType jenisKelaminType) {
        this.jenisKelaminType = jenisKelaminType;
        return this;
    }

    public UserSpecificationDTOBuilder setPendidikanType(PendidikanType pendidikanType) {
        this.pendidikanType = pendidikanType;
        return this;
    }

    public UserSpecificationDTOBuilder setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
        return this;
    }

    public UserSpecificationDTOBuilder setMinat(String minat) {
        this.minat = minat;
        return this;
    }

    public UserSpecificationDTOBuilder setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
        return this;
    }

    public UserSpecificationDTOBuilder setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
        return this;
    }

    public UserSpecificationDTOBuilder setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
        return this;
    }

    public UserSpecificationDTOBuilder setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
        return this;
    }

    public UserSpecificationDTOBuilder setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
        return this;
    }

    public UserSpecificationDTOBuilder setTingkatanType1(TingkatanType tingkatanType1) {
        this.tingkatanType1 = tingkatanType1;
        return this;
    }

    public UserSpecificationDTOBuilder setTingkatanType2(TingkatanType tingkatanType2) {
        this.tingkatanType2 = tingkatanType2;
        return this;
    }

    public UserSpecificationDTOBuilder setTingkatanType3(TingkatanType tingkatanType3) {
        this.tingkatanType3 = tingkatanType3;
        return this;
    }

    public UserSpecificationDTOBuilder setTingkatanType4(TingkatanType tingkatanType4) {
        this.tingkatanType4 = tingkatanType4;
        return this;
    }

    public UserSpecificationDTOBuilder setTingkatanType5(TingkatanType tingkatanType5) {
        this.tingkatanType5 = tingkatanType5;
        return this;
    }

    public UserSpecificationDTOBuilder setUploadCV(String uploadCV) {
        this.uploadCV = uploadCV;
        return this;
    }

    public UserSpecificationDTOBuilder setStatusApprove(Boolean statusApprove) {
        this.statusApprove = statusApprove;
        return this;
    }

    public UserSpecificationDTOBuilder setJurusan(String jurusan) {
        this.jurusan = jurusan;
        return this;
    }

    public UserSpecificationDTOBuilder setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
        return this;
    }

    public UserSpecificationDTOBuilder setFreelance(Boolean freelance) {
        this.freelance = freelance;
        return this;
    }

    public UserSpecificationDTO createUserSpecificationDTO() {
        return new UserSpecificationDTO(fullName, email, mobilePhone, immediateSupervisorUserName, primaryBranchID, ktp, escute, jobDivision, jobLocation, accessTimeDTO, userLoginInfoDTO, tanggalLahir, domisili, noHP, noKTP, ipk, jenisKelaminType, pendidikanType, namaCivitas, minat, ketrampilan1, ketrampilan2, ketrampilan3, ketrampilan4, ketrampilan5, tingkatanType1, tingkatanType2, tingkatanType3, tingkatanType4, tingkatanType5, uploadCV, statusApprove, jurusan, pengalaman, freelance);
    }
    
}
