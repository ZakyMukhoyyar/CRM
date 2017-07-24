package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class LowonganDTO {

    private String idLowongan;
    private Long userID;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganDTO() {
    }

    public LowonganDTO(String idLowongan, Long userID, String namaLowongan, String deskripsiLowongan, Date tanggalMulai, Date tanggalBerakhir, String minatPekerjaan, String persyaratan, String lokasiKerja, String gaji, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idLowongan = idLowongan;
        this.userID = userID;
        this.namaLowongan = namaLowongan;
        this.deskripsiLowongan = deskripsiLowongan;
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = tanggalBerakhir;
        this.minatPekerjaan = minatPekerjaan;
        this.persyaratan = persyaratan;
        this.lokasiKerja = lokasiKerja;
        this.gaji = gaji;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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
        return "LowonganDTO{" + "idLowongan=" + idLowongan + ", userID=" + userID + ", namaLowongan=" + namaLowongan + ", deskripsiLowongan=" + deskripsiLowongan + ", tanggalMulai=" + tanggalMulai + ", tanggalBerakhir=" + tanggalBerakhir + ", minatPekerjaan=" + minatPekerjaan + ", persyaratan=" + persyaratan + ", lokasiKerja=" + lokasiKerja + ", gaji=" + gaji + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}
