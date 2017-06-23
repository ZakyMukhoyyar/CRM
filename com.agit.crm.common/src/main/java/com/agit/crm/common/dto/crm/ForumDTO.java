package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class ForumDTO implements Serializable{
    
    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean status;

    public ForumDTO() {
    }

    public ForumDTO(String idForum, String namaForum, String deskripsiForum, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean status) {
        this.idForum = idForum;
        this.namaForum = namaForum;
        this.deskripsiForum = deskripsiForum;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdForum() {
        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }

    public String getNamaForum() {
        return namaForum;
    }

    public void setNamaForum(String namaForum) {
        this.namaForum = namaForum;
    }

    public String getDeskripsiForum() {
        return deskripsiForum;
    }

    public void setDeskripsiForum(String deskripsiForum) {
        this.deskripsiForum = deskripsiForum;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ForumDTO{" + "idForum=" + idForum + ", namaForum=" + namaForum + ", deskripsiForum=" + deskripsiForum + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", status=" + status + '}';
    }
    
    
    
}
