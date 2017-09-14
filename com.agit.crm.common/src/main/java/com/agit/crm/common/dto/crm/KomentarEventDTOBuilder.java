/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import java.util.Date;


public class KomentarEventDTOBuilder {

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

    public KomentarEventDTOBuilder() {
    }

    public KomentarEventDTOBuilder setKomentarID(String komentarID) {
        this.komentarID = komentarID;
        return this;
    }

    public KomentarEventDTOBuilder setIdEvent(String idEvent) {
        this.idEvent = idEvent;
        return this;
    }

    public KomentarEventDTOBuilder setKomentar(String komentar) {
        this.komentar = komentar;
        return this;
    }

    public KomentarEventDTOBuilder setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public KomentarEventDTOBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public KomentarEventDTOBuilder setTglKomentar(Date tglKomentar) {
        this.tglKomentar = tglKomentar;
        return this;
    }

    public KomentarEventDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KomentarEventDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KomentarEventDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KomentarEventDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KomentarEventDTO createKomentarEventDTO() {
        return new KomentarEventDTO(komentarID, idEvent, komentar, picture, userName, tglKomentar, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
