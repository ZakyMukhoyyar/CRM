/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 3AD
 */
public class RiwayatApplyEventDTO implements Serializable {

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

    public RiwayatApplyEventDTO() {
    }

    public RiwayatApplyEventDTO(String idRiwayatApplyEvent, String idRiwayatEvent, String idUserRiwayat, String namaEvent, String namaPelamar, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
        this.idRiwayatEvent = idRiwayatEvent;
        this.idUserRiwayat = idUserRiwayat;
        this.namaEvent = namaEvent;
        this.namaPelamar = namaPelamar;
        this.lowonganState = lowonganState;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdRiwayatApplyEvent() {
        return idRiwayatApplyEvent;
    }

    public void setIdRiwayatApplyEvent(String idRiwayatApplyEvent) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
    }

    public String getIdRiwayatEvent() {
        return idRiwayatEvent;
    }

    public void setIdRiwayatEvent(String idRiwayatEvent) {
        this.idRiwayatEvent = idRiwayatEvent;
    }

    public String getIdUserRiwayat() {
        return idUserRiwayat;
    }

    public void setIdUserRiwayat(String idUserRiwayat) {
        this.idUserRiwayat = idUserRiwayat;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getNamaPelamar() {
        return namaPelamar;
    }

    public void setNamaPelamar(String namaPelamar) {
        this.namaPelamar = namaPelamar;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
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

    @Override
    public String toString() {
        return "RiwayatApplyEventDTO{" + "idRiwayatApplyEvent=" + idRiwayatApplyEvent + ", idRiwayatEvent=" + idRiwayatEvent + ", idUserRiwayat=" + idUserRiwayat + ", namaEvent=" + namaEvent + ", namaPelamar=" + namaPelamar + ", lowonganState=" + lowonganState + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
