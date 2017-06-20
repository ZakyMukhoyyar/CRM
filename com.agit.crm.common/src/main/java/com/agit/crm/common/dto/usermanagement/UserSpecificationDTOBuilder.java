package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;

public class UserSpecificationDTOBuilder {

    private String fullName;
    private String email;
    private String mobilePhone;
    private String immediateSupervisorUserName;
    private String primaryBranchID;
    private String escute;
    private JobDivision jobDivision;
    private JobLocation jobLocation;
    private AccessTimeDTO accessTimeDTO;
    private UserLoginInfoDTO userLoginInfoDTO;

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

    public UserSpecificationDTO createUserSpecificationDTO() {
        return new UserSpecificationDTO(fullName, email, mobilePhone, immediateSupervisorUserName, primaryBranchID, escute, jobDivision, jobLocation, accessTimeDTO, userLoginInfoDTO);
    }

}
