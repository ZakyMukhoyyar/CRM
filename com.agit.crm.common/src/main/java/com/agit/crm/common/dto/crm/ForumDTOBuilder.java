/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;

public class ForumDTOBuilder {

    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private List<KomentarForumDTO> komentarDTO;
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

    public ForumDTOBuilder setKomentarDTO(List<KomentarForumDTO> komentarDTO) {
        this.komentarDTO = komentarDTO;
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
        return new ForumDTO(idForum, namaForum, deskripsiForum, komentarDTO, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
