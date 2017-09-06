/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import java.util.Date;

public class KomentarForumBuilder {

    private String komentarID;
    private String idForum;
    private String komentar;
    private String picture;
    private String userName;
    private Date tglKomentar;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public KomentarForumBuilder() {
    }

    public KomentarForumBuilder setKomentarID(String komentarID) {
        this.komentarID = komentarID;
        return this;
    }

    public KomentarForumBuilder setIdForum(String idForum) {
        this.idForum = idForum;
        return this;
    }

    public KomentarForumBuilder setKomentar(String komentar) {
        this.komentar = komentar;
        return this;
    }

    public KomentarForumBuilder setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public KomentarForumBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public KomentarForumBuilder setTglKomentar(Date tglKomentar) {
        this.tglKomentar = tglKomentar;
        return this;
    }

    public KomentarForumBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KomentarForumBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KomentarForumBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KomentarForumBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KomentarForum createKomentarForum() {
        return new KomentarForum(komentarID, idForum, komentar, picture, userName, tglKomentar, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
