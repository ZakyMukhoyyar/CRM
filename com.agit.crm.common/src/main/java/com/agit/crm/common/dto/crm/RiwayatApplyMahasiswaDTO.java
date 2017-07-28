package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class RiwayatApplyMahasiswaDTO {

    private String idRiwayatApplyMahasiswa;
    private String idRiwayatLowongan;
    private LowonganState lowonganState;
    private String idUserRiwayat;
    private String namaLowonganApply;
    private String namaApplyLowongan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyMahasiswaDTO() {
    }

    public RiwayatApplyMahasiswaDTO(String idRiwayatApplyMahasiswa, String idRiwayatLowongan, LowonganState lowonganState, String idUserRiwayat, String namaLowonganApply, String namaApplyLowongan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
        this.idRiwayatLowongan = idRiwayatLowongan;
        this.lowonganState = lowonganState;
        this.idUserRiwayat = idUserRiwayat;
        this.namaLowonganApply = namaLowonganApply;
        this.namaApplyLowongan = namaApplyLowongan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdRiwayatApplyMahasiswa() {
        return idRiwayatApplyMahasiswa;
    }

    public void setIdRiwayatApplyMahasiswa(String idRiwayatApplyMahasiswa) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
    }

    public String getIdRiwayatLowongan() {
        return idRiwayatLowongan;
    }

    public void setIdRiwayatLowongan(String idRiwayatLowongan) {
        this.idRiwayatLowongan = idRiwayatLowongan;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
    }

    public String getIdUserRiwayat() {
        return idUserRiwayat;
    }

    public void setIdUserRiwayat(String idUserRiwayat) {
        this.idUserRiwayat = idUserRiwayat;
    }

    public String getNamaLowonganApply() {
        return namaLowonganApply;
    }

    public void setNamaLowonganApply(String namaLowonganApply) {
        this.namaLowonganApply = namaLowonganApply;
    }

    public String getNamaApplyLowongan() {
        return namaApplyLowongan;
    }

    public void setNamaApplyLowongan(String namaApplyLowongan) {
        this.namaApplyLowongan = namaApplyLowongan;
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
        return "RiwayatApplyMahasiswaDTO{" + "idRiwayatApplyMahasiswa=" + idRiwayatApplyMahasiswa + ", idRiwayatLowongan=" + idRiwayatLowongan + ", lowonganState=" + lowonganState + ", idUserRiwayat=" + idUserRiwayat + ", namaLowonganApply=" + namaLowonganApply + ", namaApplyLowongan=" + namaApplyLowongan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
