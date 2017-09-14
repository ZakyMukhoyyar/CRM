/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class KomentarEventDTO implements Serializable{
    private String komentarID;
    private String idEvent;
    private String komentar;
    private String picture;
    private String userName;
    private Date tglKomentar;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    
    public KomentarEventDTO() {
    }

    public KomentarEventDTO(String komentarID, String idEvent, String komentar, String picture, String userName, Date tglKomentar, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.komentarID = komentarID;
        this.idEvent = idEvent;
        this.komentar = komentar;
        this.picture = picture;
        this.userName = userName;
        this.tglKomentar = tglKomentar;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getKomentarID() {
        return komentarID;
    }

    public void setKomentarID(String komentarID) {
        this.komentarID = komentarID;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTglKomentar() {
        return tglKomentar;
    }

    public void setTglKomentar(Date tglKomentar) {
        this.tglKomentar = tglKomentar;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "KomentarEventDTO{" + "komentarID=" + komentarID + ", idEvent=" + idEvent + ", komentar=" + komentar + ", picture=" + picture + ", userName=" + userName + ", tglKomentar=" + tglKomentar + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }
    
    
}
