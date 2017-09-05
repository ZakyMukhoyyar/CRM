/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import java.util.Date;

public class KomentarForumDTOBuilder {

    private String komentarID;
    private String komentar;
    private String picture;
    private String userName;
    private Date tglKomentar;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public KomentarForumDTOBuilder() {
    }

    public KomentarForumDTOBuilder setKomentarID(String komentarID) {
        this.komentarID = komentarID;
        return this;
    }

    public KomentarForumDTOBuilder setKomentar(String komentar) {
        this.komentar = komentar;
        return this;
    }

    public KomentarForumDTOBuilder setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public KomentarForumDTOBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public KomentarForumDTOBuilder setTglKomentar(Date tglKomentar) {
        this.tglKomentar = tglKomentar;
        return this;
    }

    public KomentarForumDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KomentarForumDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KomentarForumDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KomentarForumDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KomentarForumDTO createKomentarForumDTO() {
        return new KomentarForumDTO(komentarID, komentar, picture, userName, tglKomentar, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
