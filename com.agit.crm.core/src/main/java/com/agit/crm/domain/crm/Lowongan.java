package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class Lowongan implements EntityObject<Lowongan> {

    long id;
    private String idLowongan;
    private String idUser;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private List<LowonganStatus> listLowonganStatuses;
    private List<RiwayatApplyMahasiswa> listRiwayatApplyMahasiswa;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Lowongan() {
    }

    public Lowongan(String idLowongan, String idUser, String namaLowongan, String deskripsiLowongan, Date tanggalMulai, Date tanggalBerakhir, String minatPekerjaan, String persyaratan, String lokasiKerja, String gaji, List<LowonganStatus> listLowonganStatuses, List<RiwayatApplyMahasiswa> listRiwayatApplyMahasiswa, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idLowongan = idLowongan;
        this.idUser = idUser;
        this.namaLowongan = namaLowongan;
        this.deskripsiLowongan = deskripsiLowongan;
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = tanggalBerakhir;
        this.minatPekerjaan = minatPekerjaan;
        this.persyaratan = persyaratan;
        this.lokasiKerja = lokasiKerja;
        this.gaji = gaji;
        this.listLowonganStatuses = listLowonganStatuses;
        this.listRiwayatApplyMahasiswa = listRiwayatApplyMahasiswa;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public List<LowonganStatus> getListLowonganStatuses() {
        return listLowonganStatuses;
    }

    public void setListLowonganStatuses(List<LowonganStatus> listLowonganStatuses) {
        this.listLowonganStatuses = listLowonganStatuses;
    }

    public List<RiwayatApplyMahasiswa> getListRiwayatApplyMahasiswa() {
        return listRiwayatApplyMahasiswa;
    }

    public void setListRiwayatApplyMahasiswa(List<RiwayatApplyMahasiswa> listRiwayatApplyMahasiswa) {
        this.listRiwayatApplyMahasiswa = listRiwayatApplyMahasiswa;
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
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idLowongan);
        hash = 67 * hash + Objects.hashCode(this.idUser);
        hash = 67 * hash + Objects.hashCode(this.namaLowongan);
        hash = 67 * hash + Objects.hashCode(this.deskripsiLowongan);
        hash = 67 * hash + Objects.hashCode(this.tanggalMulai);
        hash = 67 * hash + Objects.hashCode(this.tanggalBerakhir);
        hash = 67 * hash + Objects.hashCode(this.minatPekerjaan);
        hash = 67 * hash + Objects.hashCode(this.persyaratan);
        hash = 67 * hash + Objects.hashCode(this.lokasiKerja);
        hash = 67 * hash + Objects.hashCode(this.gaji);
        hash = 67 * hash + Objects.hashCode(this.listLowonganStatuses);
        hash = 67 * hash + Objects.hashCode(this.listRiwayatApplyMahasiswa);
        hash = 67 * hash + Objects.hashCode(this.createdBy);
        hash = 67 * hash + Objects.hashCode(this.createdDate);
        hash = 67 * hash + Objects.hashCode(this.modifiedBy);
        hash = 67 * hash + Objects.hashCode(this.modifiedDate);
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
        this.namaLowongan = lowongan.namaLowongan;
        this.deskripsiLowongan = lowongan.deskripsiLowongan;
        this.tanggalMulai = lowongan.tanggalMulai;
        this.tanggalBerakhir = lowongan.tanggalBerakhir;
        this.minatPekerjaan = lowongan.minatPekerjaan;
        this.persyaratan = lowongan.persyaratan;
        this.lokasiKerja = lowongan.lokasiKerja;
        this.gaji = lowongan.gaji;
        this.idUser = lowongan.idUser;
        this.listRiwayatApplyMahasiswa =lowongan.listRiwayatApplyMahasiswa;
        this.listLowonganStatuses = lowongan.listLowonganStatuses;
        this.modifiedBy = lowongan.modifiedBy;
        this.modifiedDate = lowongan.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(Lowongan other) {
        return this.equals(other);
    }

}
