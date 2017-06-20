package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.object.ValueObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class UserLoginInfo implements ValueObject<UserLoginInfo> {

    private Date lastLogin;
    private Date lastLoginFailed;
    private int loginAttempt;
    private Date loginDate;
    private Date logoutDate;
    private Date credentialsExpiredDate;
    private String remoteAddress;
    private String remoteHost;
    private String sessionID;

    public UserLoginInfo() {
    }

    public UserLoginInfo(Date lastLogin, Date lastLoginFailed, int loginAttempt, Date loginDate, Date logoutDate, Date credentialsExpiredDate, String remoteAddress, String remoteHost, String sessionID) {
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

    public String getSessionID() {
        return sessionID;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public Date getLastLoginFailed() {
        return lastLoginFailed;
    }

    public int getLoginAttempt() {
        return loginAttempt;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.lastLogin);
        hash = 97 * hash + Objects.hashCode(this.lastLoginFailed);
        hash = 97 * hash + this.loginAttempt;
        hash = 97 * hash + Objects.hashCode(this.loginDate);
        hash = 97 * hash + Objects.hashCode(this.logoutDate);
        hash = 97 * hash + Objects.hashCode(this.credentialsExpiredDate);
        hash = 97 * hash + Objects.hashCode(this.remoteAddress);
        hash = 97 * hash + Objects.hashCode(this.remoteHost);
        hash = 97 * hash + Objects.hashCode(this.sessionID);
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
        final UserLoginInfo other = (UserLoginInfo) obj;
        if (!Objects.equals(this.lastLogin, other.lastLogin)) {
            return false;
        }
        if (!Objects.equals(this.lastLoginFailed, other.lastLoginFailed)) {
            return false;
        }
        if (this.loginAttempt != other.loginAttempt) {
            return false;
        }
        if (!Objects.equals(this.loginDate, other.loginDate)) {
            return false;
        }
        if (!Objects.equals(this.logoutDate, other.logoutDate)) {
            return false;
        }
        if (!Objects.equals(this.credentialsExpiredDate, other.credentialsExpiredDate)) {
            return false;
        }
        if (!Objects.equals(this.remoteAddress, other.remoteAddress)) {
            return false;
        }
        if (!Objects.equals(this.remoteHost, other.remoteHost)) {
            return false;
        }
        if (!Objects.equals(this.sessionID, other.sessionID)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(UserLoginInfo other) {
        return this.equals(other);
    }

    public void assignNewLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public void assignDeleteRemote() {
        this.remoteAddress=null;
        this.remoteHost=null;
    }

}
