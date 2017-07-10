package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class RiwayatApplyMahasiswaDTO {

    private String idRiwayatApplyMahasiswa;
    private LowonganState lowonganState;
    private String namaLowonganApply;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyMahasiswaDTO() {
    }

    public RiwayatApplyMahasiswaDTO(String idRiwayatApplyMahasiswa, LowonganState lowonganState, String namaLowonganApply, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
        this.lowonganState = lowonganState;
        this.namaLowonganApply = namaLowonganApply;
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

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
    }

    public String getNamaLowonganApply() {
        return namaLowonganApply;
    }

    public void setNamaLowonganApply(String namaLowonganApply) {
        this.namaLowonganApply = namaLowonganApply;
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
        return "RiwayatApplyMahasiswaDTO{" + "idRiwayatApplyMahasiswa=" + idRiwayatApplyMahasiswa + ", lowonganState=" + lowonganState + ", namaLowonganApply=" + namaLowonganApply + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
