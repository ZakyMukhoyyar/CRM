package com.agit.crm.user.management.domain.privilege;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.StatusData;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class Privilege implements EntityObject<Privilege> {

    /* id for attribute */
    long id;

    private String privilegeID;
    private String privilegeName;
    private StatusData privilegeStatus;
    private String parentID;

    /* Creational */
    private Date creationalDate;
    private String creationalBy;


    /* Menu */
    private boolean menu;
    private String menuName;
    private String tabName;
    private String url;
    private String icon;

    public Privilege() {
    }

    public Privilege(String privilegeID, String privilegeName, StatusData privilegeStatus, String parentID, Date creationalDate, String creationalBy, boolean menu, String menuName, String tabName, String url, String icon) {
        this.privilegeID = privilegeID;
        this.privilegeName = privilegeName;
        this.privilegeStatus = privilegeStatus;
        this.parentID = parentID;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
        this.menu = menu;
        this.menuName = menuName;
        this.tabName = tabName;
        this.url = url;
        this.icon = icon;
    }

    public String getParentID() {
        return parentID;
    }

    public String getPrivilegeID() {
        return privilegeID;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public StatusData getPrivilegeStatus() {
        return privilegeStatus;
    }

    public Date getCreationalDate() {
        return creationalDate;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    public boolean isMenu() {
        return menu;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getUrl() {
        return url;
    }

    public String getIcon() {
        return icon;
    }

    public String getTabName() {
        return tabName;
    }

    public void assignNewPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public void assignNewPrivilegeStatus(StatusData privilegeStatus) {
        this.privilegeStatus = privilegeStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.privilegeID);
        hash = 83 * hash + Objects.hashCode(this.privilegeName);
        hash = 83 * hash + Objects.hashCode(this.privilegeStatus);
        hash = 83 * hash + Objects.hashCode(this.parentID);
        hash = 83 * hash + Objects.hashCode(this.creationalDate);
        hash = 83 * hash + Objects.hashCode(this.creationalBy);
        hash = 83 * hash + (this.menu ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.menuName);
        hash = 83 * hash + Objects.hashCode(this.tabName);
        hash = 83 * hash + Objects.hashCode(this.url);
        hash = 83 * hash + Objects.hashCode(this.icon);
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
        final Privilege other = (Privilege) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(Privilege other) {
        return this.equals(other);
    }

    public void assignNewSpecification(String privilegeName, StatusData privilegeStatus, String parentID, boolean menu, String menuName, String tabName, String url, String icon) {
        this.privilegeName = privilegeName;
        this.privilegeStatus = privilegeStatus;
        this.parentID = parentID;
        this.menu = menu;
        this.menuName = menuName;
        this.tabName = tabName;
        this.url = url;
        this.icon = icon;
    }
}
