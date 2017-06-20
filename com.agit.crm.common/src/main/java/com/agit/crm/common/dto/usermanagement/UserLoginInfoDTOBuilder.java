package com.agit.crm.common.dto.usermanagement;

import java.util.Date;

public class UserLoginInfoDTOBuilder {
    private Date lastLogin;
    private Date lastLoginFailed;
    private int loginAttempt;
    private Date loginDate;
    private Date logoutDate;
    private Date credentialsExpiredDate;
    private String remoteAddress;
    private String remoteHost;
    private String sessionID;

    public UserLoginInfoDTOBuilder() {
    }

    public UserLoginInfoDTOBuilder setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public UserLoginInfoDTOBuilder setLastLoginFailed(Date lastLoginFailed) {
        this.lastLoginFailed = lastLoginFailed;
        return this;
    }

    public UserLoginInfoDTOBuilder setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
        return this;
    }

    public UserLoginInfoDTOBuilder setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
    }

    public UserLoginInfoDTOBuilder setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
        return this;
    }

    public UserLoginInfoDTOBuilder setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
        return this;
    }

    public UserLoginInfoDTOBuilder setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
        return this;
    }

    public UserLoginInfoDTOBuilder setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
        return this;
    }

    public UserLoginInfoDTOBuilder setSessionID(String sessionID) {
        this.sessionID = sessionID;
        return this;
    }

    public UserLoginInfoDTO createUserLoginInfoDTO() {
        return new UserLoginInfoDTO(lastLogin, lastLoginFailed, loginAttempt, loginDate, logoutDate, credentialsExpiredDate, remoteAddress, remoteHost, sessionID);
    }

}
