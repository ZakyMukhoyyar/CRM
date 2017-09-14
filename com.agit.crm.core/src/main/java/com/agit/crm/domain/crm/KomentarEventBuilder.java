/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import java.util.Date;


public class KomentarEventBuilder {

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

    public KomentarEventBuilder() {
    }

    public KomentarEventBuilder setKomentarID(String komentarID) {
        this.komentarID = komentarID;
        return this;
    }

    public KomentarEventBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public KomentarEventBuilder setKomentar(String komentar) {
        this.komentar = komentar;
        return this;
    }

    public KomentarEventBuilder setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public KomentarEventBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public KomentarEventBuilder setTglKomentar(Date tglKomentar) {
        this.tglKomentar = tglKomentar;
        return this;
    }

    public KomentarEventBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KomentarEventBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KomentarEventBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KomentarEventBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KomentarEvent createKomentarEvent() {
        return new KomentarEvent(komentarID, idEvent, komentar, picture, userName, tglKomentar, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
