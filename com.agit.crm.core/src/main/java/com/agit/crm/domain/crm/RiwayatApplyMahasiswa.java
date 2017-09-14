package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class RiwayatApplyMahasiswa implements EntityObject<RiwayatApplyMahasiswa> {

    long id;

    private String idRiwayatApplyMahasiswa;
    private String idRiwayatLowongan;
    private String idUserRiwayat;
    private String namaLowonganApply;
    private String namaApplyLowongan;
    private LowonganState lowonganState;
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

    public RiwayatApplyMahasiswa() {
    }

    public RiwayatApplyMahasiswa(String idRiwayatApplyMahasiswa, String idRiwayatLowongan, String idUserRiwayat, String namaLowonganApply, String namaApplyLowongan, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String statusApprove, String jurusan, String minat, String ketrampilan1, String ketrampilan2, String ketrampilan3, String ketrampilan4, String ketrampilan5, String email) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
        this.idRiwayatLowongan = idRiwayatLowongan;
        this.idUserRiwayat = idUserRiwayat;
        this.namaLowonganApply = namaLowonganApply;
        this.namaApplyLowongan = namaApplyLowongan;
        this.lowonganState = lowonganState;
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

    public String getStatusApprove() {
        return statusApprove;
    }

    public void setStatusApprove(String statusApprove) {
        this.statusApprove = statusApprove;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idRiwayatApplyMahasiswa);
        hash = 89 * hash + Objects.hashCode(this.idRiwayatLowongan);
        hash = 89 * hash + Objects.hashCode(this.idUserRiwayat);
        hash = 89 * hash + Objects.hashCode(this.namaLowonganApply);
        hash = 89 * hash + Objects.hashCode(this.namaApplyLowongan);
        hash = 89 * hash + Objects.hashCode(this.lowonganState);
        hash = 89 * hash + Objects.hashCode(this.createdBy);
        hash = 89 * hash + Objects.hashCode(this.createdDate);
        hash = 89 * hash + Objects.hashCode(this.modifiedBy);
        hash = 89 * hash + Objects.hashCode(this.modifiedDate);
        hash = 89 * hash + Objects.hashCode(this.statusApprove);
        hash = 89 * hash + Objects.hashCode(this.jurusan);
        hash = 89 * hash + Objects.hashCode(this.minat);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan1);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan2);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan3);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan4);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan5);
        hash = 89 * hash + Objects.hashCode(this.email);
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
        final RiwayatApplyMahasiswa other = (RiwayatApplyMahasiswa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewRiwayat(RiwayatApplyMahasiswa riwayatApplyMahasiswa) {
        this.idRiwayatApplyMahasiswa = riwayatApplyMahasiswa.idRiwayatApplyMahasiswa;
        this.namaLowonganApply = riwayatApplyMahasiswa.namaLowonganApply;
        this.idRiwayatLowongan = riwayatApplyMahasiswa.idRiwayatLowongan;
        this.idUserRiwayat = riwayatApplyMahasiswa.idUserRiwayat;
        this.namaApplyLowongan = riwayatApplyMahasiswa.namaApplyLowongan;
        this.lowonganState = riwayatApplyMahasiswa.lowonganState;
        this.modifiedBy = riwayatApplyMahasiswa.modifiedBy;
        this.modifiedDate = riwayatApplyMahasiswa.modifiedDate;
        this.statusApprove = riwayatApplyMahasiswa.statusApprove;
        this.jurusan = riwayatApplyMahasiswa.jurusan;
        this.minat = riwayatApplyMahasiswa.minat;
        this.ketrampilan1 = riwayatApplyMahasiswa.ketrampilan1;
        this.ketrampilan2 = riwayatApplyMahasiswa.ketrampilan2;
        this.ketrampilan3 = riwayatApplyMahasiswa.ketrampilan3;
        this.ketrampilan4 = riwayatApplyMahasiswa.ketrampilan4;
        this.ketrampilan5 = riwayatApplyMahasiswa.ketrampilan5;
        this.email = riwayatApplyMahasiswa.email;
    }

    @Override
    public boolean sameIdentityAs(RiwayatApplyMahasiswa other) {
        return this.equals(other);
    }
}
