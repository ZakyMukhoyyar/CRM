/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
public class KomentarEvent implements EntityObject<KomentarEvent>{

    long id;
    private String komentarID;
    private String idEvent;
    private String komentar;
    private String picture;
    private String userName;
    private Date tglKomentar;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public KomentarEvent() {
    }

    public KomentarEvent(String komentarID, String idEvent, String komentar, String picture, String userName, Date tglKomentar, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.komentarID = komentarID;
        this.idEvent = idEvent;
        this.komentar = komentar;
        this.picture = picture;
        this.userName = userName;
        this.tglKomentar = tglKomentar;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getKomentarID() {
        return komentarID;
    }

    public void setKomentarID(String komentarID) {
        this.komentarID = komentarID;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTglKomentar() {
        return tglKomentar;
    }

    public void setTglKomentar(Date tglKomentar) {
        this.tglKomentar = tglKomentar;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.komentarID);
        hash = 43 * hash + Objects.hashCode(this.idEvent);
        hash = 43 * hash + Objects.hashCode(this.komentar);
        hash = 43 * hash + Objects.hashCode(this.picture);
        hash = 43 * hash + Objects.hashCode(this.userName);
        hash = 43 * hash + Objects.hashCode(this.tglKomentar);
        hash = 43 * hash + Objects.hashCode(this.createdBy);
        hash = 43 * hash + Objects.hashCode(this.createdDate);
        hash = 43 * hash + Objects.hashCode(this.modifiedBy);
        hash = 43 * hash + Objects.hashCode(this.modifiedDate);
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
        final KomentarEvent other = (KomentarEvent) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void assignNewKomentar(KomentarEvent komentarEvent) {
        this.komentarID = komentarEvent.komentarID;
        this.idEvent = komentarEvent.idEvent;
        this.komentar = komentarEvent.komentar;
        this.picture = komentarEvent.picture;
        this.userName = komentarEvent.userName;
        this.tglKomentar = komentarEvent.tglKomentar;
        this.modifiedBy = komentarEvent.modifiedBy;
        this.modifiedDate = komentarEvent.modifiedDate;
    }
    @Override
    public boolean sameIdentityAs(KomentarEvent other) {
         return this.equals(other);
    }
    
}
