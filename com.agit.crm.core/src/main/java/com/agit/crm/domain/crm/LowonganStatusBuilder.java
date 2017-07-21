package com.agit.crm.domain.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;


public class LowonganStatusBuilder {
    private String idLowonganStatus;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganStatusBuilder() {
    }

    public LowonganStatusBuilder setIdLowonganStatus(String idLowonganStatus) {
        this.idLowonganStatus = idLowonganStatus;
        return this;
    }

    public LowonganStatusBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public LowonganStatusBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LowonganStatusBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LowonganStatusBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public LowonganStatusBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public LowonganStatus createLowonganStatus() {
        return new LowonganStatus(idLowonganStatus, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
