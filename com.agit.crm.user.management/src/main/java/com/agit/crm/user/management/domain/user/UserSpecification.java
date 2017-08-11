package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.object.ValueObject;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class UserSpecification implements ValueObject<UserSpecification> {

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
//    private List<Lowongan> lowongans;
    private Boolean statusApprove;
    private String jurusan;

    private String escute;
    private JobDivision jobDivision;
    private JobLocation jobLocation;

    private AccessTime accessTime;
    private UserLoginInfo userLoginInfo;
    
    private Boolean disableButton;

    public UserSpecification() {
    }

    public UserSpecification(String fullName, String email, String mobilePhone, String immediateSupervisorUserName, String primaryBranchID, String ktp, Date tanggalLahir, String domisili, String noHP, String noKTP, String ipk, JenisKelaminType jenisKelaminType, PendidikanType pendidikanType, String namaCivitas, String minat, String ketrampilan1, String ketrampilan2, String ketrampilan3, String ketrampilan4, String ketrampilan5, TingkatanType tingkatanType1, TingkatanType tingkatanType2, TingkatanType tingkatanType3, TingkatanType tingkatanType4, TingkatanType tingkatanType5, String uploadCV, Boolean statusApprove, String jurusan, String escute, JobDivision jobDivision, JobLocation jobLocation, AccessTime accessTime, UserLoginInfo userLoginInfo, Boolean disableButton) {
        this.fullName = fullName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.immediateSupervisorUserName = immediateSupervisorUserName;
        this.primaryBranchID = primaryBranchID;
        this.ktp = ktp;
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
        this.escute = escute;
        this.jobDivision = jobDivision;
        this.jobLocation = jobLocation;
        this.accessTime = accessTime;
        this.userLoginInfo = userLoginInfo;
        this.userLoginInfo = userLoginInfo;
        this.disableButton = disableButton;
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

    public AccessTime getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(AccessTime accessTime) {
        this.accessTime = accessTime;
    }

    public UserLoginInfo getUserLoginInfo() {
        return userLoginInfo;
    }

    public void setUserLoginInfo(UserLoginInfo userLoginInfo) {
        this.userLoginInfo = userLoginInfo;
    }

    public Boolean getDisableButton() {
        return disableButton;
    }

    public void setDisableButton(Boolean disableButton) {
        this.disableButton = disableButton;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.fullName);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.mobilePhone);
        hash = 83 * hash + Objects.hashCode(this.immediateSupervisorUserName);
        hash = 83 * hash + Objects.hashCode(this.primaryBranchID);
        hash = 83 * hash + Objects.hashCode(this.ktp);
        hash = 83 * hash + Objects.hashCode(this.tanggalLahir);
        hash = 83 * hash + Objects.hashCode(this.domisili);
        hash = 83 * hash + Objects.hashCode(this.noHP);
        hash = 83 * hash + Objects.hashCode(this.noKTP);
        hash = 83 * hash + Objects.hashCode(this.ipk);
        hash = 83 * hash + Objects.hashCode(this.jenisKelaminType);
        hash = 83 * hash + Objects.hashCode(this.pendidikanType);
        hash = 83 * hash + Objects.hashCode(this.namaCivitas);
        hash = 83 * hash + Objects.hashCode(this.minat);
        hash = 83 * hash + Objects.hashCode(this.ketrampilan1);
        hash = 83 * hash + Objects.hashCode(this.ketrampilan2);
        hash = 83 * hash + Objects.hashCode(this.ketrampilan3);
        hash = 83 * hash + Objects.hashCode(this.ketrampilan4);
        hash = 83 * hash + Objects.hashCode(this.ketrampilan5);
        hash = 83 * hash + Objects.hashCode(this.tingkatanType1);
        hash = 83 * hash + Objects.hashCode(this.tingkatanType2);
        hash = 83 * hash + Objects.hashCode(this.tingkatanType3);
        hash = 83 * hash + Objects.hashCode(this.tingkatanType4);
        hash = 83 * hash + Objects.hashCode(this.tingkatanType5);
        hash = 83 * hash + Objects.hashCode(this.uploadCV);
        hash = 83 * hash + Objects.hashCode(this.statusApprove);
        hash = 83 * hash + Objects.hashCode(this.jurusan);
        hash = 83 * hash + Objects.hashCode(this.escute);
        hash = 83 * hash + Objects.hashCode(this.jobDivision);
        hash = 83 * hash + Objects.hashCode(this.jobLocation);
        hash = 83 * hash + Objects.hashCode(this.accessTime);
        hash = 83 * hash + Objects.hashCode(this.userLoginInfo);
        hash = 83 * hash + Objects.hashCode(this.disableButton);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserSpecification other = (UserSpecification) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.mobilePhone, other.mobilePhone)) {
            return false;
        }
        if (!Objects.equals(this.immediateSupervisorUserName, other.immediateSupervisorUserName)) {
            return false;
        }
        if (!Objects.equals(this.primaryBranchID, other.primaryBranchID)) {
            return false;
        }
        if (!Objects.equals(this.ktp, other.ktp)) {
            return false;
        }
        if (!Objects.equals(this.tanggalLahir, other.tanggalLahir)) {
            return false;
        }
        if (!Objects.equals(this.domisili, other.domisili)) {
            return false;
        }
        if (!Objects.equals(this.noHP, other.noHP)) {
            return false;
        }
        if (!Objects.equals(this.noKTP, other.noKTP)) {
            return false;
        }
        if (!Objects.equals(this.ipk, other.ipk)) {
            return false;
        }
        if (this.jenisKelaminType != other.jenisKelaminType) {
            return false;
        }
        if (this.pendidikanType != other.pendidikanType) {
            return false;
        }
        if (!Objects.equals(this.namaCivitas, other.namaCivitas)) {
            return false;
        }
        if (!Objects.equals(this.minat, other.minat)) {
            return false;
        }
        if (!Objects.equals(this.ketrampilan1, other.ketrampilan1)) {
            return false;
        }
        if (!Objects.equals(this.ketrampilan2, other.ketrampilan2)) {
            return false;
        }
        if (!Objects.equals(this.ketrampilan3, other.ketrampilan3)) {
            return false;
        }
        if (!Objects.equals(this.ketrampilan4, other.ketrampilan4)) {
            return false;
        }
        if (!Objects.equals(this.ketrampilan5, other.ketrampilan5)) {
            return false;
        }
        if (this.tingkatanType1 != other.tingkatanType1) {
            return false;
        }
        if (this.tingkatanType2 != other.tingkatanType2) {
            return false;
        }
        if (this.tingkatanType3 != other.tingkatanType3) {
            return false;
        }
        if (this.tingkatanType4 != other.tingkatanType4) {
            return false;
        }
        if (this.tingkatanType5 != other.tingkatanType5) {
            return false;
        }
        if (!Objects.equals(this.uploadCV, other.uploadCV)) {
            return false;
        }
        if (!Objects.equals(this.statusApprove, other.statusApprove)) {
            return false;
        }
        if (!Objects.equals(this.jurusan, other.jurusan)) {
            return false;
        }
        if (!Objects.equals(this.escute, other.escute)) {
            return false;
        }
        if (this.jobDivision != other.jobDivision) {
            return false;
        }
        if (this.jobLocation != other.jobLocation) {
            return false;
        }
        if (!Objects.equals(this.accessTime, other.accessTime)) {
            return false;
        }
        if (!Objects.equals(this.userLoginInfo, other.userLoginInfo)) {
            return false;
        }
        if (!Objects.equals(this.disableButton, other.disableButton)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(UserSpecification other) {
        return this.equals(other);
    }

    public void assignNewLoginInfo(UserLoginInfo loginInfo) {
        this.userLoginInfo = loginInfo;
    }

}
