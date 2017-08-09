package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;


public class LowonganStatusDTOBuilder {
    private String idUser;
    private String idLowongan;
    private String idLowonganStatus;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganStatusDTOBuilder() {
    }

    public LowonganStatusDTOBuilder setIdUser(String idUser) {
        this.idUser = idUser;
        return this;
    }

    public LowonganStatusDTOBuilder setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
        return this;
    }

    public LowonganStatusDTOBuilder setIdLowonganStatus(String idLowonganStatus) {
        this.idLowonganStatus = idLowonganStatus;
        return this;
    }

    public LowonganStatusDTOBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public LowonganStatusDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LowonganStatusDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LowonganStatusDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public LowonganStatusDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public LowonganStatusDTO createLowonganStatusDTO() {
        return new LowonganStatusDTO(idUser, idLowongan, idLowonganStatus, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
