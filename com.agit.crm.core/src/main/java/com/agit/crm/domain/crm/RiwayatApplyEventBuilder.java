/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;

public class RiwayatApplyEventBuilder {

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

    public RiwayatApplyEventBuilder() {
    }

    public RiwayatApplyEventBuilder setIdRiwayatApplyEvent(String idRiwayatApplyEvent) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
        return this;
    }

    public RiwayatApplyEventBuilder setIdRiwayatEvent(String idRiwayatEvent) {
        this.idRiwayatEvent = idRiwayatEvent;
        return this;
    }

    public RiwayatApplyEventBuilder setIdUserRiwayat(String idUserRiwayat) {
        this.idUserRiwayat = idUserRiwayat;
        return this;
    }

    public RiwayatApplyEventBuilder setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
        return this;
    }

    public RiwayatApplyEventBuilder setNamaPelamar(String namaPelamar) {
        this.namaPelamar = namaPelamar;
        return this;
    }

    public RiwayatApplyEventBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public RiwayatApplyEventBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public RiwayatApplyEventBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public RiwayatApplyEventBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public RiwayatApplyEventBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public RiwayatApplyEvent createRiwayatApplyEvent() {
        return new RiwayatApplyEvent(idRiwayatApplyEvent, idRiwayatEvent, idUserRiwayat, namaEvent, namaPelamar, lowonganState, createdBy, createdDate, modifiedBy, modifiedDate);
    }

}
