package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;


public class UserSpecificationBuilder {

    private String fullName;
    private String email;
    private String mobilePhone;
    private String immediateSupervisorUserName;
    private String primaryBranchID;
    private String escute;
    private JobDivision jobDivision;
    private JobLocation jobLocation;
    private AccessTime accessTime;
    private UserLoginInfo userLoginInfo;

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

    public UserSpecification createUserSpecification() {
        return new UserSpecification(fullName, email, mobilePhone, immediateSupervisorUserName, primaryBranchID, escute, jobDivision, jobLocation, accessTime, userLoginInfo);
    }
    
}
