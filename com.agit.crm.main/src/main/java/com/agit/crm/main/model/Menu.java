package com.agit.crm.main.model;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String menuId;
    private String menuLevel;
    private String menuIdId;
    private String menuType;
    private String isActive;
    private String menuName;
    private String parentId;
    private String pathContent;
    private Integer sortChild;
    private String keterangan;
    private String flagDelete;
    private Date createDate;
    private Date updateDate;

    private String logId;

    public Menu() {
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuLevel() {
        return this.menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuIdId() {
        return menuIdId;
    }

    public void setMenuIdId(String menuIdId) {
        this.menuIdId = menuIdId;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPathContent() {
        return this.pathContent;
    }

    public void setPathContent(String pathContent) {
        this.pathContent = pathContent;
    }

    public Integer getSortChild() {
        return this.sortChild;
    }

    public void setSortChild(Integer sortChild) {
        this.sortChild = sortChild;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(String flagDelete) {
        this.flagDelete = flagDelete;
    }
}
