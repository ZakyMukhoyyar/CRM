package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class ForumBuilder {
    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private Date tanggalBerakhir;
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

    public ForumBuilder setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
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
        return new Forum(idForum, namaForum, deskripsiForum, tanggalBerakhir, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
