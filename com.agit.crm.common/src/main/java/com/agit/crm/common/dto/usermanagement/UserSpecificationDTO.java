package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import java.io.Serializable;

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

    public UserSpecificationDTO() {
    }

    public UserSpecificationDTO(String fullName, String email, String mobilePhone, String immediateSupervisorUserName, String primaryBranchID, String ktp, String escute, JobDivision jobDivision, JobLocation jobLocation, AccessTimeDTO accessTimeDTO, UserLoginInfoDTO userLoginInfoDTO) {
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

    @Override
    public String toString() {
        return "UserSpecificationDTO{" + "fullName=" + fullName + ", email=" + email + ", mobilePhone=" + mobilePhone + ", immediateSupervisorUserName=" + immediateSupervisorUserName + ", primaryBranchID=" + primaryBranchID + ", ktp=" + ktp + ", escute=" + escute + ", jobDivision=" + jobDivision + ", jobLocation=" + jobLocation + ", accessTimeDTO=" + accessTimeDTO + ", userLoginInfoDTO=" + userLoginInfoDTO + '}';
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
