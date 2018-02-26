/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.storing.fi.card;

import com.agit.crm.shared.status.StatusResult;
import java.util.Date;

public class StoringFICardBuilder {

    private long id;
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

    public StoringFICardBuilder() {
    }

    public StoringFICardBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public StoringFICardBuilder setStoringFICardID(String storingFICardID) {
        this.storingFICardID = storingFICardID;
        return this;
    }

    public StoringFICardBuilder setPointCheck1(String pointCheck1) {
        this.pointCheck1 = pointCheck1;
        return this;
    }

    public StoringFICardBuilder setPointCheck2(String pointCheck2) {
        this.pointCheck2 = pointCheck2;
        return this;
    }

    public StoringFICardBuilder setPointCheck3(String pointCheck3) {
        this.pointCheck3 = pointCheck3;
        return this;
    }

    public StoringFICardBuilder setPointCheck4(String pointCheck4) {
        this.pointCheck4 = pointCheck4;
        return this;
    }

    public StoringFICardBuilder setPointCheck5(String pointCheck5) {
        this.pointCheck5 = pointCheck5;
        return this;
    }

    public StoringFICardBuilder setImageScan(String imageScan) {
        this.imageScan = imageScan;
        return this;
    }

    public StoringFICardBuilder setPdfScan(String pdfScan) {
        this.pdfScan = pdfScan;
        return this;
    }

    public StoringFICardBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public StoringFICardBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public StoringFICardBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public StoringFICardBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public StoringFICardBuilder setStatusResult(StatusResult statusResult) {
        this.statusResult = statusResult;
        return this;
    }

    public StoringFICard createStoringFICard() {
        return new StoringFICard(id, storingFICardID, pointCheck1, pointCheck2, pointCheck3, pointCheck4, pointCheck5, imageScan, pdfScan, createdBy, createdDate, modifiedBy, modifiedDate, statusResult);
    }

}
