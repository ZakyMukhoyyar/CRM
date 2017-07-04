package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.Date;


public class MinatBuilder {
    private String idMinat;
    private String namaMinat;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public MinatBuilder() {
    }

    public MinatBuilder setIdMinat(String idMinat) {
        this.idMinat = idMinat;
        return this;
    }

    public MinatBuilder setNamaMinat(String namaMinat) {
        this.namaMinat = namaMinat;
        return this;
    }

    public MinatBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public MinatBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public MinatBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public MinatBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public MinatBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Minat createMinat() {
        return new Minat(idMinat, namaMinat, createdBy, createdDate, modifiedBy, modifiedDate, status);
    }
    
}
