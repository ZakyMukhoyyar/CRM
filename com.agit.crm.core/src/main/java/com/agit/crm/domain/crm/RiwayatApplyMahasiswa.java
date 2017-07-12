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
    private String namaLowonganApply;
    private String namaApplyLowongan;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyMahasiswa() {
    }

    public RiwayatApplyMahasiswa(String idRiwayatApplyMahasiswa, String idRiwayatLowongan, String namaLowonganApply, String namaApplyLowongan, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
        this.idRiwayatLowongan = idRiwayatLowongan;
        this.namaLowonganApply = namaLowonganApply;
        this.namaApplyLowongan = namaApplyLowongan;
        this.lowonganState = lowonganState;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idRiwayatApplyMahasiswa);
        hash = 59 * hash + Objects.hashCode(this.idRiwayatLowongan);
        hash = 59 * hash + Objects.hashCode(this.namaLowonganApply);
        hash = 59 * hash + Objects.hashCode(this.namaApplyLowongan);
        hash = 59 * hash + Objects.hashCode(this.lowonganState);
        hash = 59 * hash + Objects.hashCode(this.createdBy);
        hash = 59 * hash + Objects.hashCode(this.createdDate);
        hash = 59 * hash + Objects.hashCode(this.modifiedBy);
        hash = 59 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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
        this.namaApplyLowongan = riwayatApplyMahasiswa.namaApplyLowongan;
        this.lowonganState = riwayatApplyMahasiswa.lowonganState;
        this.modifiedBy = riwayatApplyMahasiswa.modifiedBy;
        this.modifiedDate = riwayatApplyMahasiswa.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(RiwayatApplyMahasiswa other) {
        return this.equals(other);
    }
}
