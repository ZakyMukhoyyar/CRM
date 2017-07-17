package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Zaky
 */
public class Forum implements EntityObject<Forum> {

    long id;
    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Status status;

    public Forum() {
    }

    public Forum(String idForum, String namaForum, String deskripsiForum, Date tanggalMulai, Date tanggalBerakhir, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Status status) {
        this.idForum = idForum;
        this.namaForum = namaForum;
        this.deskripsiForum = deskripsiForum;
        this.tanggalMulai = tanggalMulai;
        this.tanggalBerakhir = tanggalBerakhir;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getIdForum() {
        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }

    public String getNamaForum() {
        return namaForum;
    }

    public void setNamaForum(String namaForum) {
        this.namaForum = namaForum;
    }

    public String getDeskripsiForum() {
        return deskripsiForum;
    }

    public void setDeskripsiForum(String deskripsiForum) {
        this.deskripsiForum = deskripsiForum;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idForum);
        hash = 53 * hash + Objects.hashCode(this.namaForum);
        hash = 53 * hash + Objects.hashCode(this.deskripsiForum);
        hash = 53 * hash + Objects.hashCode(this.tanggalMulai);
        hash = 53 * hash + Objects.hashCode(this.tanggalBerakhir);
        hash = 53 * hash + Objects.hashCode(this.createdBy);
        hash = 53 * hash + Objects.hashCode(this.createdDate);
        hash = 53 * hash + Objects.hashCode(this.modifiedBy);
        hash = 53 * hash + Objects.hashCode(this.modifiedDate);
        hash = 53 * hash + Objects.hashCode(this.status);
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
        final Forum other = (Forum) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewForum(Forum forum){
        this.idForum = forum.idForum;
        this.namaForum = forum.namaForum;
        this.deskripsiForum = forum.deskripsiForum;
        this.tanggalMulai = forum.tanggalMulai;
        this.tanggalBerakhir = tanggalBerakhir;
        this.createdBy = forum.createdBy;
        this.createdDate = forum.createdDate;
        this.modifiedBy = forum.modifiedBy;
        this.modifiedDate = forum.modifiedDate;
        this.status = forum.status;
    }
    
    @Override
    public boolean sameIdentityAs(Forum other) {
        return this.equals(other);
    }

}
