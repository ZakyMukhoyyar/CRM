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
    private String statusApprove;
    private String jurusan;
    private String minat;
    private String ketrampilan1;
    private String ketrampilan2;
    private String ketrampilan3;
    private String ketrampilan4;
    private String ketrampilan5;
    private String email;

    public RiwayatApplyMahasiswaDTO() {
    }

    public RiwayatApplyMahasiswaDTO(String idRiwayatApplyMahasiswa, String idRiwayatLowongan, LowonganState lowonganState, String idUserRiwayat, String namaLowonganApply, String namaApplyLowongan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String statusApprove, String jurusan, String minat, String ketrampilan1, String ketrampilan2, String ketrampilan3, String ketrampilan4, String ketrampilan5, String email) {
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
        this.statusApprove = statusApprove;
        this.jurusan = jurusan;
        this.minat = minat;
        this.ketrampilan1 = ketrampilan1;
        this.ketrampilan2 = ketrampilan2;
        this.ketrampilan3 = ketrampilan3;
        this.ketrampilan4 = ketrampilan4;
        this.ketrampilan5 = ketrampilan5;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
    }

    public String getKetrampilan1() {
        return ketrampilan1;
    }

    public void setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
    }

    public String getKetrampilan2() {
        return ketrampilan2;
    }

    public void setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
    }

    public String getKetrampilan3() {
        return ketrampilan3;
    }

    public void setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
    }

    public String getKetrampilan4() {
        return ketrampilan4;
    }

    public void setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
    }

    public String getKetrampilan5() {
        return ketrampilan5;
    }

    public void setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
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

    public String getStatusApprove() {
        return statusApprove;
    }

    public void setStatusApprove(String statusApprove) {
        this.statusApprove = statusApprove;
    }

    @Override
    public String toString() {
        return "RiwayatApplyMahasiswaDTO{" + "idRiwayatApplyMahasiswa=" + idRiwayatApplyMahasiswa + ", idRiwayatLowongan=" + idRiwayatLowongan + ", lowonganState=" + lowonganState + ", idUserRiwayat=" + idUserRiwayat + ", namaLowonganApply=" + namaLowonganApply + ", namaApplyLowongan=" + namaApplyLowongan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", statusApprove=" + statusApprove + ", jurusan=" + jurusan + ", minat=" + minat + ", ketrampilan1=" + ketrampilan1 + ", ketrampilan2=" + ketrampilan2 + ", ketrampilan3=" + ketrampilan3 + ", ketrampilan4=" + ketrampilan4 + ", ketrampilan5=" + ketrampilan5 + ", email=" + email + '}';
    }

}
