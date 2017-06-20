package com.agit.crm.main.viewmodel;

import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.CommonViewModel;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class DashboardVM {

    /* data user */
    private String userNPWP;
    private String role;
    private String uriPhoto;

    @Init
    public void init(@ContextParam(ContextType.COMPONENT) Window window) {
        userNPWP = SecurityUtil.getUserName();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();
        switch (role) {
            default:
                uriPhoto = "/images/background.png";
                break;
        }
    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    /* Getter&Setter */
    public String getUserNPWP() {
        return userNPWP;
    }

    public void setUserNPWP(String userNPWP) {
        this.userNPWP = userNPWP;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUriPhoto() {
        return uriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        this.uriPhoto = uriPhoto;
    }

}
