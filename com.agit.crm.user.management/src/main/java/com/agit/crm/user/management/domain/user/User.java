package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.user.management.domain.role.Role;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class User implements EntityObject<User> {

    /* id for attriute*/
    long id;
    
    private String userID;
    private String nip;
    
    private String userName;
    private String password;
    private Role role;
    
    private StatusData userStatus;
    private UserSpecification userSpecification;

    /* Creational */
    private Date creationalDate;
    private String creationalBy;

    public User() {
    }

    public User(String userID, String nip, String userName, String password, Role role, StatusData userStatus, UserSpecification userSpecification, Date creationalDate, String creationalBy) {
        this.userID = userID;
        this.nip = nip;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.userStatus = userStatus;
        this.userSpecification = userSpecification;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
    }

    public String getUserID() {
        return userID;
    }

    public String getNip() {
        return nip;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public StatusData getUserStatus() {
        return userStatus;
    }

    public UserSpecification getUserSpecification() {
        return userSpecification;
    }

    public Date getCreationalDate() {
        return creationalDate;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.userID);
        hash = 41 * hash + Objects.hashCode(this.nip);
        hash = 41 * hash + Objects.hashCode(this.userName);
        hash = 41 * hash + Objects.hashCode(this.password);
        hash = 41 * hash + Objects.hashCode(this.role);
        hash = 41 * hash + Objects.hashCode(this.userStatus);
        hash = 41 * hash + Objects.hashCode(this.userSpecification);
        hash = 41 * hash + Objects.hashCode(this.creationalDate);
        hash = 41 * hash + Objects.hashCode(this.creationalBy);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean sameIdentityAs(User other) {
        return this.equals(other);
    }

    /*user status which purposes update status of data*/
    public void assignNewSpecification(User user) {
        this.role = user.getRole();
        this.userStatus = user.getUserStatus();
        this.userSpecification = user.getUserSpecification();
    }
    
    public void assignNewStatus(StatusData status) {
        this.userStatus = status;
    }

    public void assignNewUserData(Role role, UserSpecification userSpecification) {
        this.role = role;
        this.userSpecification = userSpecification;
    }

    public void assignNewPassword(String password) {
        this.password = password;
    }
    
}
