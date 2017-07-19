package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class DataToHrdDTO implements Serializable {

    private String idLowonganHrd;
    private String namaLowonganHrd;
    private String hasilSeleksi;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public DataToHrdDTO() {
    }

    public DataToHrdDTO(String idLowonganHrd, String namaLowonganHrd, String hasilSeleksi, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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
    public String toString() {
        return "DataToHrdDTO{" + "idLowonganHrd=" + idLowonganHrd + ", namaLowonganHrd=" + namaLowonganHrd + ", hasilSeleksi=" + hasilSeleksi + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }
    
}
