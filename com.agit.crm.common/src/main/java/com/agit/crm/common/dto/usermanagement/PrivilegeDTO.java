package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.shared.type.StatusData;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class PrivilegeDTO implements Serializable {

    private String privilegeID;
    private String privilegeName;
    private StatusData privilegeStatus;

    /* Creational */
    private Date creationalDate;
    private String creationalBy;
    
    private String parentID;
    
    /* Menu */
    private boolean menu;
    private String menuName;
    private String tabName;
    private String url;
    private String icon;
    
    private List<PrivilegeDTO> children;

    public PrivilegeDTO() {
    }

    public PrivilegeDTO(String privilegeID, String privilegeName, StatusData privilegeStatus, Date creationalDate, String creationalBy, String parentID, boolean menu, String menuName, String tabName, String url, String icon, List<PrivilegeDTO> children) {
        this.privilegeID = privilegeID;
        this.privilegeName = privilegeName;
        this.privilegeStatus = privilegeStatus;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
        this.parentID = parentID;
        this.menu = menu;
        this.menuName = menuName;
        this.tabName = tabName;
        this.url = url;
        this.icon = icon;
        this.children = children;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public List<PrivilegeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<PrivilegeDTO> children) {
        this.children = children;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPrivilegeID() {
        return privilegeID;
    }

    public void setPrivilegeID(String privilegeID) {
        this.privilegeID = privilegeID;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public StatusData getPrivilegeStatus() {
        return privilegeStatus;
    }

    public void setPrivilegeStatus(StatusData privilegeStatus) {
        this.privilegeStatus = privilegeStatus;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    public void setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT+7")
    public Date getCreationalDate() {
        return creationalDate;
    }

    @Override
    public String toString() {
        return "PrivilegeDTO{" + "privilegeID=" + privilegeID + ", privilegeName=" + privilegeName + ", privilegeStatus=" + privilegeStatus + ", creationalDate=" + creationalDate + ", creationalBy=" + creationalBy + ", parentID=" + parentID + ", menu=" + menu + ", menuName=" + menuName + ", tabName=" + tabName + ", url=" + url + ", icon=" + icon + ", children=" + children + '}';
    }
    public static PrivilegeDTO getInstance() {
        PrivilegeDTO privilege = new PrivilegeDTOBuilder()
                .setCreationalBy("creationalBy")
                .setCreationalDate(new Date())
                .setIcon("icon")
                .setMenu(true)
                .setMenuName("menuName")
                .setParentID("parentID")
                .setPrivilegeID("privilegeID")
                .setPrivilegeName("privilegeName")
                .setPrivilegeStatus(StatusData.ACTIVE)
                .setTabName("tabName")
                .setUrl("url")
                .createPrivilegeDTO();
        return privilege;
    }
    
    public static PrivilegeDTO getInstance2() {
        PrivilegeDTO privilege = new PrivilegeDTOBuilder()
                .setCreationalBy("SUPERADMIN")
                .setCreationalDate(new Date())
                .setIcon("icon")
                .setMenu(true)
                .setMenuName("menuName")
                .setParentID("parentID")
                .setPrivilegeID("privilegeID")
                .setPrivilegeName("privilegeName")
                .setPrivilegeStatus(StatusData.INACTIVE)
                .setTabName("tabName")
                .setUrl("url")
                .createPrivilegeDTO();
        return privilege;
    }
}
