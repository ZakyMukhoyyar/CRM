/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.storing.fi.card;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.status.StatusResult;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author BayuHS
 */
public class StoringFICard implements EntityObject<StoringFICard> {

    long id;
    private String storingFICardID;
    private String pointCheck1;
    private String pointCheck2;
    private String pointCheck3;
    private String pointCheck4;
    private String pointCheck5;
    private String imageScan;
    private String pdfScan;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private StatusResult statusResult;

    public StoringFICard() {
    }

    public StoringFICard(long id, String storingFICardID, String pointCheck1, String pointCheck2, String pointCheck3, String pointCheck4, String pointCheck5, String imageScan, String pdfScan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, StatusResult statusResult) {
        this.id = id;
        this.storingFICardID = storingFICardID;
        this.pointCheck1 = pointCheck1;
        this.pointCheck2 = pointCheck2;
        this.pointCheck3 = pointCheck3;
        this.pointCheck4 = pointCheck4;
        this.pointCheck5 = pointCheck5;
        this.imageScan = imageScan;
        this.pdfScan = pdfScan;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.statusResult = statusResult;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoringFICardID() {
        return storingFICardID;
    }

    public void setStoringFICardID(String storingFICardID) {
        this.storingFICardID = storingFICardID;
    }

    public String getPointCheck1() {
        return pointCheck1;
    }

    public void setPointCheck1(String pointCheck1) {
        this.pointCheck1 = pointCheck1;
    }

    public String getPointCheck2() {
        return pointCheck2;
    }

    public void setPointCheck2(String pointCheck2) {
        this.pointCheck2 = pointCheck2;
    }

    public String getPointCheck3() {
        return pointCheck3;
    }

    public void setPointCheck3(String pointCheck3) {
        this.pointCheck3 = pointCheck3;
    }

    public String getPointCheck4() {
        return pointCheck4;
    }

    public void setPointCheck4(String pointCheck4) {
        this.pointCheck4 = pointCheck4;
    }

    public String getPointCheck5() {
        return pointCheck5;
    }

    public void setPointCheck5(String pointCheck5) {
        this.pointCheck5 = pointCheck5;
    }

    public StatusResult getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(StatusResult statusResult) {
        this.statusResult = statusResult;
    }

    public String getImageScan() {
        return imageScan;
    }

    public void setImageScan(String imageScan) {
        this.imageScan = imageScan;
    }

    public String getPdfScan() {
        return pdfScan;
    }

    public void setPdfScan(String pdfScan) {
        this.pdfScan = pdfScan;
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

    public void assignNewStoring(StoringFICard storingFICard) {
        this.storingFICardID = storingFICard.storingFICardID;
        this.pointCheck1 = storingFICard.pointCheck1;
        this.pointCheck2 = storingFICard.pointCheck2;
        this.pointCheck3 = storingFICard.pointCheck3;
        this.pointCheck4 = storingFICard.pointCheck4;
        this.pointCheck5 = storingFICard.pointCheck5;
        this.statusResult = storingFICard.statusResult;
        this.imageScan = storingFICard.imageScan;
        this.pdfScan = storingFICard.pdfScan;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.storingFICardID);
        hash = 53 * hash + Objects.hashCode(this.pointCheck1);
        hash = 53 * hash + Objects.hashCode(this.pointCheck2);
        hash = 53 * hash + Objects.hashCode(this.pointCheck3);
        hash = 53 * hash + Objects.hashCode(this.pointCheck4);
        hash = 53 * hash + Objects.hashCode(this.pointCheck5);
        hash = 53 * hash + Objects.hashCode(this.imageScan);
        hash = 53 * hash + Objects.hashCode(this.pdfScan);
        hash = 53 * hash + Objects.hashCode(this.statusResult);
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
        final StoringFICard other = (StoringFICard) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(StoringFICard other) {
        return this.equals(other);
    }

}
