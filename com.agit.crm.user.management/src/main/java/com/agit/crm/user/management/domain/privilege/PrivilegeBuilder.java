package com.agit.crm.user.management.domain.privilege;

import com.agit.crm.shared.type.StatusData;
import java.util.Date;

public class PrivilegeBuilder {
    private String privilegeID;
    private String privilegeName;
    private StatusData privilegeStatus;
    private String parentID;
    private Date creationalDate;
    private String creationalBy;
    private boolean menu;
    private String menuName;
    private String tabName;
    private String url;
    private String icon;

    public PrivilegeBuilder() {
    }

    public PrivilegeBuilder setPrivilegeID(String privilegeID) {
        this.privilegeID = privilegeID;
        return this;
    }

    public PrivilegeBuilder setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
        return this;
    }

    public PrivilegeBuilder setPrivilegeStatus(StatusData privilegeStatus) {
        this.privilegeStatus = privilegeStatus;
        return this;
    }

    public PrivilegeBuilder setParentID(String parentID) {
        this.parentID = parentID;
        return this;
    }

    public PrivilegeBuilder setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
        return this;
    }

    public PrivilegeBuilder setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
        return this;
    }

    public PrivilegeBuilder setMenu(boolean menu) {
        this.menu = menu;
        return this;
    }

    public PrivilegeBuilder setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public PrivilegeBuilder setTabName(String tabName) {
        this.tabName = tabName;
        return this;
    }

    public PrivilegeBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public PrivilegeBuilder setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Privilege createPrivilege() {
        return new Privilege(privilegeID, privilegeName, privilegeStatus, parentID, creationalDate, creationalBy, menu, menuName, tabName, url, icon);
    }
    
}
