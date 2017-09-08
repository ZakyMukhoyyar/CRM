/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;

public class RiwayatApplyEventDTOBuilder {

    private String idRiwayatApplyEvent;
    private String idRiwayatEvent;
    private String idUserRiwayat;
    private String namaEvent;
    private String namaPelamar;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyEventDTOBuilder() {
    }

    public RiwayatApplyEventDTOBuilder setIdRiwayatApplyEvent(String idRiwayatApplyEvent) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setIdRiwayatEvent(String idRiwayatEvent) {
        this.idRiwayatEvent = idRiwayatEvent;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setIdUserRiwayat(String idUserRiwayat) {
        this.idUserRiwayat = idUserRiwayat;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setNamaPelamar(String namaPelamar) {
        this.namaPelamar = namaPelamar;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public RiwayatApplyEventDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public RiwayatApplyEventDTO createRiwayatApplyEventDTO() {
        return new RiwayatApplyEventDTO(idRiwayatApplyEvent, idRiwayatEvent, idUserRiwayat, namaEvent, namaPelamar, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
