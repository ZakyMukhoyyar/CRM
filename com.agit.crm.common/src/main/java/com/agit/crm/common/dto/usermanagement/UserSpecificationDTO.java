package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bayutridewanto
 */
public class UserSpecificationDTO implements Serializable {

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

    public UserSpecificationDTO() {
    }

    public UserSpecificationDTO(String fullName, String email, String mobilePhone, String immediateSupervisorUserName, String primaryBranchID, String ktp, String escute, JobDivision jobDivision, JobLocation jobLocation, AccessTimeDTO accessTimeDTO, UserLoginInfoDTO userLoginInfoDTO, Date tanggalLahir, String domisili, String noHP, String noKTP, String ipk, JenisKelaminType jenisKelaminType, PendidikanType pendidikanType, String namaCivitas, String minat, String ketrampilan1, String ketrampilan2, String ketrampilan3, String ketrampilan4, String ketrampilan5, TingkatanType tingkatanType1, TingkatanType tingkatanType2, TingkatanType tingkatanType3, TingkatanType tingkatanType4, TingkatanType tingkatanType5, String uploadCV, Boolean statusApprove, String jurusan, String pengalaman, Boolean freelance) {
        this.fullName = fullName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.immediateSupervisorUserName = immediateSupervisorUserName;
        this.primaryBranchID = primaryBranchID;
        this.ktp = ktp;
        this.escute = escute;
        this.jobDivision = jobDivision;
        this.jobLocation = jobLocation;
        this.accessTimeDTO = accessTimeDTO;
        this.userLoginInfoDTO = userLoginInfoDTO;
        this.tanggalLahir = tanggalLahir;
        this.domisili = domisili;
        this.noHP = noHP;
        this.noKTP = noKTP;
        this.ipk = ipk;
        this.jenisKelaminType = jenisKelaminType;
        this.pendidikanType = pendidikanType;
        this.namaCivitas = namaCivitas;
        this.minat = minat;
        this.ketrampilan1 = ketrampilan1;
        this.ketrampilan2 = ketrampilan2;
        this.ketrampilan3 = ketrampilan3;
        this.ketrampilan4 = ketrampilan4;
        this.ketrampilan5 = ketrampilan5;
        this.tingkatanType1 = tingkatanType1;
        this.tingkatanType2 = tingkatanType2;
        this.tingkatanType3 = tingkatanType3;
        this.tingkatanType4 = tingkatanType4;
        this.tingkatanType5 = tingkatanType5;
        this.uploadCV = uploadCV;
        this.statusApprove = statusApprove;
        this.jurusan = jurusan;
        this.pengalaman = pengalaman;
        this.freelance = freelance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getImmediateSupervisorUserName() {
        return immediateSupervisorUserName;
    }

    public void setImmediateSupervisorUserName(String immediateSupervisorUserName) {
        this.immediateSupervisorUserName = immediateSupervisorUserName;
    }

    public String getPrimaryBranchID() {
        return primaryBranchID;
    }

    public void setPrimaryBranchID(String primaryBranchID) {
        this.primaryBranchID = primaryBranchID;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getEscute() {
        return escute;
    }

    public void setEscute(String escute) {
        this.escute = escute;
    }

    public JobDivision getJobDivision() {
        return jobDivision;
    }

    public void setJobDivision(JobDivision jobDivision) {
        this.jobDivision = jobDivision;
    }

    public JobLocation getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public AccessTimeDTO getAccessTimeDTO() {
        return accessTimeDTO;
    }

    public void setAccessTimeDTO(AccessTimeDTO accessTimeDTO) {
        this.accessTimeDTO = accessTimeDTO;
    }

    public UserLoginInfoDTO getUserLoginInfoDTO() {
        return userLoginInfoDTO;
    }

    public void setUserLoginInfoDTO(UserLoginInfoDTO userLoginInfoDTO) {
        this.userLoginInfoDTO = userLoginInfoDTO;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }

    public JenisKelaminType getJenisKelaminType() {
        return jenisKelaminType;
    }

    public void setJenisKelaminType(JenisKelaminType jenisKelaminType) {
        this.jenisKelaminType = jenisKelaminType;
    }

    public PendidikanType getPendidikanType() {
        return pendidikanType;
    }

    public void setPendidikanType(PendidikanType pendidikanType) {
        this.pendidikanType = pendidikanType;
    }

    public String getNamaCivitas() {
        return namaCivitas;
    }

    public void setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
    }

    public String getKetrampilan1() {
        return ketrampilan1;
    }

    public void setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
    }

    public String getKetrampilan2() {
        return ketrampilan2;
    }

    public void setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
    }

    public String getKetrampilan3() {
        return ketrampilan3;
    }

    public void setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
    }

    public String getKetrampilan4() {
        return ketrampilan4;
    }

    public void setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
    }

    public String getKetrampilan5() {
        return ketrampilan5;
    }

    public void setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
    }

    public TingkatanType getTingkatanType1() {
        return tingkatanType1;
    }

    public void setTingkatanType1(TingkatanType tingkatanType1) {
        this.tingkatanType1 = tingkatanType1;
    }

    public TingkatanType getTingkatanType2() {
        return tingkatanType2;
    }

    public void setTingkatanType2(TingkatanType tingkatanType2) {
        this.tingkatanType2 = tingkatanType2;
    }

    public TingkatanType getTingkatanType3() {
        return tingkatanType3;
    }

    public void setTingkatanType3(TingkatanType tingkatanType3) {
        this.tingkatanType3 = tingkatanType3;
    }

    public TingkatanType getTingkatanType4() {
        return tingkatanType4;
    }

    public void setTingkatanType4(TingkatanType tingkatanType4) {
        this.tingkatanType4 = tingkatanType4;
    }

    public TingkatanType getTingkatanType5() {
        return tingkatanType5;
    }

    public void setTingkatanType5(TingkatanType tingkatanType5) {
        this.tingkatanType5 = tingkatanType5;
    }

    public String getUploadCV() {
        return uploadCV;
    }

    public void setUploadCV(String uploadCV) {
        this.uploadCV = uploadCV;
    }

    public Boolean getStatusApprove() {
        return statusApprove;
    }

    public void setStatusApprove(Boolean statusApprove) {
        this.statusApprove = statusApprove;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public Boolean getFreelance() {
        return freelance;
    }

    public void setFreelance(Boolean freelance) {
        this.freelance = freelance;
    }

    @Override
    public String toString() {
        return "UserSpecificationDTO{" + "fullName=" + fullName + ", email=" + email + ", mobilePhone=" + mobilePhone + ", immediateSupervisorUserName=" + immediateSupervisorUserName + ", primaryBranchID=" + primaryBranchID + ", ktp=" + ktp + ", escute=" + escute + ", jobDivision=" + jobDivision + ", jobLocation=" + jobLocation + ", accessTimeDTO=" + accessTimeDTO + ", userLoginInfoDTO=" + userLoginInfoDTO + ", tanggalLahir=" + tanggalLahir + ", domisili=" + domisili + ", noHP=" + noHP + ", noKTP=" + noKTP + ", ipk=" + ipk + ", jenisKelaminType=" + jenisKelaminType + ", pendidikanType=" + pendidikanType + ", namaCivitas=" + namaCivitas + ", minat=" + minat + ", ketrampilan1=" + ketrampilan1 + ", ketrampilan2=" + ketrampilan2 + ", ketrampilan3=" + ketrampilan3 + ", ketrampilan4=" + ketrampilan4 + ", ketrampilan5=" + ketrampilan5 + ", tingkatanType1=" + tingkatanType1 + ", tingkatanType2=" + tingkatanType2 + ", tingkatanType3=" + tingkatanType3 + ", tingkatanType4=" + tingkatanType4 + ", tingkatanType5=" + tingkatanType5 + ", uploadCV=" + uploadCV + ", statusApprove=" + statusApprove + ", jurusan=" + jurusan + ", pengalaman=" + pengalaman + ", freelance=" + freelance + '}';
    }

    public static UserSpecificationDTO getInstance() {
        UserSpecificationDTO userSpecification = new UserSpecificationDTOBuilder()
                .setAccessTimeDTO(AccessTimeDTO.getInstance())
                .setEmail("email")
                .setEscute("escute")
                .setFullName("fullName")
                .setImmediateSupervisorUserName("immediateSupervisorUserName")
                .setJobDivision(JobDivision.TI)
                .setJobLocation(JobLocation.JAKARTA)
                .setMobilePhone("mobilePhone")
                .setPrimaryBranchID("primaryBranchID")
                .setUserLoginInfoDTO(UserLoginInfoDTO.getInstance())
                .createUserSpecificationDTO();
        return userSpecification;

    }
}
