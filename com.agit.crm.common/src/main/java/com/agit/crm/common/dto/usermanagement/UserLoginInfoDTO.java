package com.agit.crm.common.dto.usermanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bayutridewanto
 */
public class UserLoginInfoDTO implements Serializable {

    private Date lastLogin;
    private Date lastLoginFailed;
    private int loginAttempt;
    private Date loginDate;
    private Date logoutDate;
    private Date credentialsExpiredDate;
    private String remoteAddress;
    private String remoteHost;
    private String sessionID;

    public UserLoginInfoDTO() {
    }

    public UserLoginInfoDTO(Date lastLogin, Date lastLoginFailed, int loginAttempt, Date loginDate, Date logoutDate, Date credentialsExpiredDate, String remoteAddress, String remoteHost, String sessionID) {
        this.lastLogin = lastLogin;
        this.lastLoginFailed = lastLoginFailed;
        this.loginAttempt = loginAttempt;
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
        this.credentialsExpiredDate = credentialsExpiredDate;
        this.remoteAddress = remoteAddress;
        this.remoteHost = remoteHost;
        this.sessionID = sessionID;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    public Date getLastLogin() {
        return lastLogin;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    public Date getLastLoginFailed() {
        return lastLoginFailed;
    }

    public int getLoginAttempt() {
        return loginAttempt;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    public Date getLoginDate() {
        return loginDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    public Date getLogoutDate() {
        return logoutDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT+7")
    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLastLoginFailed(Date lastLoginFailed) {
        this.lastLoginFailed = lastLoginFailed;
    }

    public void setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public void setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public String toString() {
        return "UserLoginInfoDTO{" + "lastLogin=" + lastLogin + ", lastLoginFailed=" + lastLoginFailed + ", loginAttempt=" + loginAttempt + ", loginDate=" + loginDate + ", logoutDate=" + logoutDate + ", credentialsExpiredDate=" + credentialsExpiredDate + ", remoteAddress=" + remoteAddress + ", remoteHost=" + remoteHost + ", sessionID=" + sessionID + '}';
    }
    public static UserLoginInfoDTO getInstance() {
        UserLoginInfoDTO userLoginInfo = new UserLoginInfoDTOBuilder()
                .setCredentialsExpiredDate(new Date())
                .setLastLogin(new Date())
                .setLastLoginFailed(new Date())
                .setLoginAttempt(1)
                .setLoginDate(new Date())
                .setLogoutDate(new Date())
                .setRemoteAddress("remoteAddress")
                .setRemoteHost("remoteHost")
                .setSessionID("sessionID")
                .createUserLoginInfoDTO();
        return userLoginInfo;
    }
}
