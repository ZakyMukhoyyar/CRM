package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class Lowongan implements EntityObject<Lowongan> {

    long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;
    
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
    private Boolean freelance;

    public Lowongan() {
    }

    public Lowongan(String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status, String idLowongan, Long userID, String namaLowongan, String deskripsiLowongan, Date tanggalMulai, Date tanggalBerakhir, String minatPekerjaan, String persyaratan, String lokasiKerja, String gaji, Boolean freelance) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
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
        this.freelance = freelance;
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

    public Boolean getFreelance() {
        return freelance;
    }

    public void setFreelance(Boolean freelance) {
        this.freelance = freelance;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.createdBy);
        hash = 61 * hash + Objects.hashCode(this.createdDate);
        hash = 61 * hash + Objects.hashCode(this.modifiedBy);
        hash = 61 * hash + Objects.hashCode(this.modifiedDate);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + Objects.hashCode(this.idLowongan);
        hash = 61 * hash + Objects.hashCode(this.userID);
        hash = 61 * hash + Objects.hashCode(this.namaLowongan);
        hash = 61 * hash + Objects.hashCode(this.deskripsiLowongan);
        hash = 61 * hash + Objects.hashCode(this.tanggalMulai);
        hash = 61 * hash + Objects.hashCode(this.tanggalBerakhir);
        hash = 61 * hash + Objects.hashCode(this.minatPekerjaan);
        hash = 61 * hash + Objects.hashCode(this.persyaratan);
        hash = 61 * hash + Objects.hashCode(this.lokasiKerja);
        hash = 61 * hash + Objects.hashCode(this.gaji);
        hash = 61 * hash + Objects.hashCode(this.freelance);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lowongan other = (Lowongan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    public void assignNewLowongan(Lowongan lowongan) {
        this.idLowongan = lowongan.idLowongan;
        this.createdBy = lowongan.createdBy;
        this.createdDate = lowongan.createdDate;
        this.modifiedBy = lowongan.modifiedBy;
        this.modifiedDate = lowongan.modifiedDate;
        this.status = lowongan.status;
        
        this.userID = lowongan.userID;
        this.namaLowongan = lowongan.namaLowongan;
        this.deskripsiLowongan = lowongan.deskripsiLowongan;
        this.tanggalMulai = lowongan.tanggalMulai;
        this.tanggalBerakhir = lowongan.tanggalBerakhir;
        this.minatPekerjaan = lowongan.minatPekerjaan;
        this.persyaratan = lowongan.persyaratan;
        this.lokasiKerja = lowongan.lokasiKerja;
        this.gaji = lowongan.gaji;
        this.freelance = lowongan.freelance;
    }

    @Override
    public boolean sameIdentityAs(Lowongan other) {
        return this.equals(other);
    }

}
