package com.agit.crm.common.dto.crm;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zaky
 */
public class JurusanDTO implements Serializable{
    
    private String idJurusan;
    private String namaJurusan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public JurusanDTO() {
    }

    public JurusanDTO(String idJurusan, String namaJurusan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idJurusan = idJurusan;
        this.namaJurusan = namaJurusan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
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
        return "JurusanDTO{" + "idJurusan=" + idJurusan + ", namaJurusan=" + namaJurusan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }
    
    
    
}
