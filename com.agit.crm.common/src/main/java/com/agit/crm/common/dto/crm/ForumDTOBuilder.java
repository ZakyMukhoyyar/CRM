package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class ForumDTOBuilder {
    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private Date tanggalBerakhir;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public ForumDTOBuilder() {
    }

    public ForumDTOBuilder setIdForum(String idForum) {
        this.idForum = idForum;
        return this;
    }

    public ForumDTOBuilder setNamaForum(String namaForum) {
        this.namaForum = namaForum;
        return this;
    }

    public ForumDTOBuilder setDeskripsiForum(String deskripsiForum) {
        this.deskripsiForum = deskripsiForum;
        return this;
    }

    public ForumDTOBuilder setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
        return this;
    }

    public ForumDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public ForumDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ForumDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ForumDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public ForumDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ForumDTO createForumDTO() {
        return new ForumDTO(idForum, namaForum, deskripsiForum, tanggalBerakhir, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
