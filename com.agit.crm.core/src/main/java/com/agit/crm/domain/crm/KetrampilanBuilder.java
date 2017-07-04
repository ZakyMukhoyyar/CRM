package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class KetrampilanBuilder {

    private String idKetrampilan;
    private String namaKetrampilan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public KetrampilanBuilder() {
    }

    public KetrampilanBuilder setIdKetrampilan(String idKetrampilan) {
        this.idKetrampilan = idKetrampilan;
        return this;
    }

    public KetrampilanBuilder setNamaKetrampilan(String namaKetrampilan) {
        this.namaKetrampilan = namaKetrampilan;
        return this;
    }

    public KetrampilanBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public KetrampilanBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public KetrampilanBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public KetrampilanBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public KetrampilanBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Ketrampilan createKetrampilan() {
        return new Ketrampilan(idKetrampilan, namaKetrampilan, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }

}
