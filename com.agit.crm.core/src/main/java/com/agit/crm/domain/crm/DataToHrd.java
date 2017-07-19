package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class DataToHrd implements EntityObject<DataToHrd> {

    long id;
    private String idLowonganHrd;
    private String namaLowonganHrd;
    private String hasilSeleksi;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DataToHrd() {
    }

    public DataToHrd(String idLowonganHrd, String namaLowonganHrd, String hasilSeleksi, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idLowonganHrd = idLowonganHrd;
        this.namaLowonganHrd = namaLowonganHrd;
        this.hasilSeleksi = hasilSeleksi;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdLowonganHrd() {
        return idLowonganHrd;
    }

    public void setIdLowonganHrd(String idLowonganHrd) {
        this.idLowonganHrd = idLowonganHrd;
    }

    public String getNamaLowonganHrd() {
        return namaLowonganHrd;
    }

    public void setNamaLowonganHrd(String namaLowonganHrd) {
        this.namaLowonganHrd = namaLowonganHrd;
    }

    public String getHasilSeleksi() {
        return hasilSeleksi;
    }

    public void setHasilSeleksi(String hasilSeleksi) {
        this.hasilSeleksi = hasilSeleksi;
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
        hash = 47 * hash + Objects.hashCode(this.idLowonganHrd);
        hash = 47 * hash + Objects.hashCode(this.namaLowonganHrd);
        hash = 47 * hash + Objects.hashCode(this.hasilSeleksi);
        hash = 47 * hash + Objects.hashCode(this.createdBy);
        hash = 47 * hash + Objects.hashCode(this.createdDate);
        hash = 47 * hash + Objects.hashCode(this.modifiedBy);
        hash = 47 * hash + Objects.hashCode(this.modifiedDate);
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
        final DataToHrd other = (DataToHrd) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewDataToHrd(DataToHrd dataToHrd) {
        this.idLowonganHrd = dataToHrd.idLowonganHrd;
        this.namaLowonganHrd = dataToHrd.namaLowonganHrd;
        this.hasilSeleksi = dataToHrd.hasilSeleksi;
        this.createdBy = dataToHrd.createdBy;
        this.createdDate = dataToHrd.createdDate;
        this.modifiedBy = dataToHrd.modifiedBy;
        this.modifiedDate = dataToHrd.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(DataToHrd other) {
        return this.equals(other);
    }

}
