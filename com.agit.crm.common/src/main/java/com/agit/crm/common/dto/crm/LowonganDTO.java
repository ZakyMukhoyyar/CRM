package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class LowonganDTO {

    private Long userID;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;
    
    
    private String idLowongan;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private Boolean freelance;
    
    

    public LowonganDTO() {
    }

    public LowonganDTO(Long userID, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status, String idLowongan, String namaLowongan, String deskripsiLowongan, Date tanggalMulai, Date tanggalBerakhir, String minatPekerjaan, String persyaratan, String lokasiKerja, String gaji, Boolean freelance) {
        this.userID = userID;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.idLowongan = idLowongan;
        this.namaLowongan = namaLowongan;
        this.deskripsiLowongan = deskripsiLowongan;
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = tanggalBerakhir;
        this.minatPekerjaan = minatPekerjaan;
        this.persyaratan = persyaratan;
        this.lokasiKerja = lokasiKerja;
        this.gaji = gaji;
        this.freelance = freelance;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
    }

    public String getNamaLowongan() {
        return namaLowongan;
    }

    public void setNamaLowongan(String namaLowongan) {
        this.namaLowongan = namaLowongan;
    }

    public String getDeskripsiLowongan() {
        return deskripsiLowongan;
    }

    public void setDeskripsiLowongan(String deskripsiLowongan) {
        this.deskripsiLowongan = deskripsiLowongan;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public void setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    public String getMinatPekerjaan() {
        return minatPekerjaan;
    }

    public void setMinatPekerjaan(String minatPekerjaan) {
        this.minatPekerjaan = minatPekerjaan;
    }

    public String getPersyaratan() {
        return persyaratan;
    }

    public void setPersyaratan(String persyaratan) {
        this.persyaratan = persyaratan;
    }

    public String getLokasiKerja() {
        return lokasiKerja;
    }

    public void setLokasiKerja(String lokasiKerja) {
        this.lokasiKerja = lokasiKerja;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public Boolean getFreelance() {
        return freelance;
    }

    public void setFreelance(Boolean freelance) {
        this.freelance = freelance;
    }

    @Override
    public String toString() {
        return "LowonganDTO{" + "userID=" + userID + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", status=" + status + ", idLowongan=" + idLowongan + ", namaLowongan=" + namaLowongan + ", deskripsiLowongan=" + deskripsiLowongan + ", tanggalMulai=" + tanggalMulai + ", tanggalBerakhir=" + tanggalBerakhir + ", minatPekerjaan=" + minatPekerjaan + ", persyaratan=" + persyaratan + ", lokasiKerja=" + lokasiKerja + ", gaji=" + gaji + ", freelance=" + freelance + '}';
    }
    
}
