package com.agit.crm.user.management.domain.user;

import java.util.Date;

public class UserLoginInfoBuilder {
    private Date lastLogin;
    private Date lastLoginFailed;
    private int loginAttempt;
    private Date loginDate;
    private Date logoutDate;
    private Date credentialsExpiredDate;
    private String remoteAddress;
    private String remoteHost;
    private String sessionID;

    public UserLoginInfoBuilder() {
    }

    public UserLoginInfoBuilder setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public UserLoginInfoBuilder setLastLoginFailed(Date lastLoginFailed) {
        this.lastLoginFailed = lastLoginFailed;
        return this;
    }

    public UserLoginInfoBuilder setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
        return this;
    }

    public UserLoginInfoBuilder setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
    }

    public UserLoginInfoBuilder setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
        return this;
    }

    public UserLoginInfoBuilder setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
        return this;
    }

    public UserLoginInfoBuilder setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
        return this;
    }

    public UserLoginInfoBuilder setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
        return this;
    }

    public UserLoginInfoBuilder setSessionID(String sessionID) {
        this.sessionID = sessionID;
        return this;
    }

    public UserLoginInfo createUserLoginInfo() {
        return new UserLoginInfo(lastLogin, lastLoginFailed, loginAttempt, loginDate, logoutDate, credentialsExpiredDate, remoteAddress, remoteHost, sessionID);
    }

}
