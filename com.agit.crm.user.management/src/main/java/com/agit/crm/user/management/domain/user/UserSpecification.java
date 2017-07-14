package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.object.ValueObject;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
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

    private String escute;
    private JobDivision jobDivision;
    private JobLocation jobLocation;

    private AccessTime accessTime;
    private UserLoginInfo userLoginInfo;

    public UserSpecification() {
    }

    public UserSpecification(String fullName, String email, String mobilePhone, String immediateSupervisorUserName, String primaryBranchID, String ktp, String escute, JobDivision jobDivision, JobLocation jobLocation, AccessTime accessTime, UserLoginInfo userLoginInfo) {
        this.fullName = fullName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.immediateSupervisorUserName = immediateSupervisorUserName;
        this.primaryBranchID = primaryBranchID;
        this.ktp = ktp;
        this.escute = escute;
        this.jobDivision = jobDivision;
        this.jobLocation = jobLocation;
        this.accessTime = accessTime;
        this.userLoginInfo = userLoginInfo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getImmediateSupervisorUserName() {
        return immediateSupervisorUserName;
    }

    public String getPrimaryBranchID() {
        return primaryBranchID;
    }

    public String getEscute() {
        return escute;
    }

    public JobDivision getJobDivision() {
        return jobDivision;
    }

    public JobLocation getJobLocation() {
        return jobLocation;
    }

    public AccessTime getAccessTime() {
        return accessTime;
    }

    public UserLoginInfo getUserLoginInfo() {
        return userLoginInfo;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.fullName);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.mobilePhone);
        hash = 89 * hash + Objects.hashCode(this.immediateSupervisorUserName);
        hash = 89 * hash + Objects.hashCode(this.primaryBranchID);
        hash = 89 * hash + Objects.hashCode(this.ktp);
        hash = 89 * hash + Objects.hashCode(this.escute);
        hash = 89 * hash + Objects.hashCode(this.jobDivision);
        hash = 89 * hash + Objects.hashCode(this.jobLocation);
        hash = 89 * hash + Objects.hashCode(this.accessTime);
        hash = 89 * hash + Objects.hashCode(this.userLoginInfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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
