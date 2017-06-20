package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.StatusData;
import java.util.Date;
import java.util.List;

public class PrivilegeDTOBuilder {
    private String privilegeID;
    private String privilegeName;
    private StatusData privilegeStatus;
    private Date creationalDate;
    private String creationalBy;
    private String parentID;
    private boolean menu;
    private String menuName;
    private String tabName;
    private String url;
    private String icon;
    private List<PrivilegeDTO> children;

    public PrivilegeDTOBuilder() {
    }

    public PrivilegeDTOBuilder setPrivilegeID(String privilegeID) {
        this.privilegeID = privilegeID;
        return this;
    }

    public PrivilegeDTOBuilder setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
        return this;
    }

    public PrivilegeDTOBuilder setPrivilegeStatus(StatusData privilegeStatus) {
        this.privilegeStatus = privilegeStatus;
        return this;
    }

    public PrivilegeDTOBuilder setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
        return this;
    }

    public PrivilegeDTOBuilder setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
        return this;
    }

    public PrivilegeDTOBuilder setParentID(String parentID) {
        this.parentID = parentID;
        return this;
    }

    public PrivilegeDTOBuilder setMenu(boolean menu) {
        this.menu = menu;
        return this;
    }

    public PrivilegeDTOBuilder setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public PrivilegeDTOBuilder setTabName(String tabName) {
        this.tabName = tabName;
        return this;
    }

    public PrivilegeDTOBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public PrivilegeDTOBuilder setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public PrivilegeDTOBuilder setChildren(List<PrivilegeDTO> children) {
        this.children = children;
        return this;
    }

    public PrivilegeDTO createPrivilegeDTO() {
        return new PrivilegeDTO(privilegeID, privilegeName, privilegeStatus, creationalDate, creationalBy, parentID, menu, menuName, tabName, url, icon, children);
    }

}
