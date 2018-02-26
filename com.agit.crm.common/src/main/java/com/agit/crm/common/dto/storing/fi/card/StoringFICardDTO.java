/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.storing.fi.card;

import com.agit.crm.shared.status.StatusResult;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class StoringFICardDTO implements Serializable {

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

    public StoringFICardDTO() {
    }

    public StoringFICardDTO(String storingFICardID, String pointCheck1, String pointCheck2, String pointCheck3, String pointCheck4, String pointCheck5, String imageScan, String pdfScan, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, StatusResult statusResult) {
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

    @Override
    public String toString() {
        return "StoringFICardDTO{" + "storingFICardID=" + storingFICardID + ", pointCheck1=" + pointCheck1 + ", pointCheck2=" + pointCheck2 + ", pointCheck3=" + pointCheck3 + ", pointCheck4=" + pointCheck4 + ", pointCheck5=" + pointCheck5 + ", imageScan=" + imageScan + ", pdfScan=" + pdfScan + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", statusResult=" + statusResult + '}';
    }

}
