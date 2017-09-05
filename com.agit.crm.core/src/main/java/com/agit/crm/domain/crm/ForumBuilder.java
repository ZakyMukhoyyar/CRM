/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;

public class ForumBuilder {

    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private List<KomentarForum> komentar;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public ForumBuilder() {
    }

    public ForumBuilder setIdForum(String idForum) {
        this.idForum = idForum;
        return this;
    }

    public ForumBuilder setNamaForum(String namaForum) {
        this.namaForum = namaForum;
        return this;
    }

    public ForumBuilder setDeskripsiForum(String deskripsiForum) {
        this.deskripsiForum = deskripsiForum;
        return this;
    }

    public ForumBuilder setKomentar(List<KomentarForum> komentar) {
        this.komentar = komentar;
        return this;
    }

    public ForumBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ForumBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ForumBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ForumBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ForumBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Forum createForum() {
        return new Forum(idForum, namaForum, deskripsiForum, komentar, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
