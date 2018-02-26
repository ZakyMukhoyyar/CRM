/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.storing.fi.card.poc;

import com.agit.crm.shared.status.StatusResult;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class StoringFICardPOCDTO implements Serializable {

    private String storingFICardPocID;
    private String fiCard;
    private String frameNumber;
    private String fileName;
    private String stage1;
    private String stage2;
    private String stage3;
    private String stage4;
    private String stage4PoinCheck5;
    private String stage1PoinCheck1;
    private String stage1PoinCheck2;
    private String stage1PoinCheck3;
    private String stage1PoinCheck4;
    private String stage1PoinCheck5;
    private String stage1PoinCheck6;
    private String stage2PoinCheck1;
    private String stage2PoinCheck2;
    private String stage2PoinCheck3;
    private String stage2PoinCheck4;
    private String stage2PoinCheck5;
    private String stage3PoinCheck1;
    private String stage3PoinCheck2;
    private String stage4PoinCheck1;
    private String stage4PoinCheck2;
    private String stage4PoinCheck3;
    private String stage4PoinCheck4;
    private String pathFile;

    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private StatusResult statusResult;

    public StoringFICardPOCDTO() {
    }

    public StoringFICardPOCDTO(String storingFICardPocID, String fiCard, String frameNumber, String fileName, String stage1, String stage2, String stage3, String stage4, String stage4PoinCheck5, String stage1PoinCheck1, String stage1PoinCheck2, String stage1PoinCheck3, String stage1PoinCheck4, String stage1PoinCheck5, String stage1PoinCheck6, String stage2PoinCheck1, String stage2PoinCheck2, String stage2PoinCheck3, String stage2PoinCheck4, String stage2PoinCheck5, String stage3PoinCheck1, String stage3PoinCheck2, String stage4PoinCheck1, String stage4PoinCheck2, String stage4PoinCheck3, String stage4PoinCheck4, String pathFile, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, StatusResult statusResult) {
        this.storingFICardPocID = storingFICardPocID;
        this.fiCard = fiCard;
        this.frameNumber = frameNumber;
        this.fileName = fileName;
        this.stage1 = stage1;
        this.stage2 = stage2;
        this.stage3 = stage3;
        this.stage4 = stage4;
        this.stage4PoinCheck5 = stage4PoinCheck5;
        this.stage1PoinCheck1 = stage1PoinCheck1;
        this.stage1PoinCheck2 = stage1PoinCheck2;
        this.stage1PoinCheck3 = stage1PoinCheck3;
        this.stage1PoinCheck4 = stage1PoinCheck4;
        this.stage1PoinCheck5 = stage1PoinCheck5;
        this.stage1PoinCheck6 = stage1PoinCheck6;
        this.stage2PoinCheck1 = stage2PoinCheck1;
        this.stage2PoinCheck2 = stage2PoinCheck2;
        this.stage2PoinCheck3 = stage2PoinCheck3;
        this.stage2PoinCheck4 = stage2PoinCheck4;
        this.stage2PoinCheck5 = stage2PoinCheck5;
        this.stage3PoinCheck1 = stage3PoinCheck1;
        this.stage3PoinCheck2 = stage3PoinCheck2;
        this.stage4PoinCheck1 = stage4PoinCheck1;
        this.stage4PoinCheck2 = stage4PoinCheck2;
        this.stage4PoinCheck3 = stage4PoinCheck3;
        this.stage4PoinCheck4 = stage4PoinCheck4;
        this.pathFile = pathFile;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.statusResult = statusResult;
    }

    public String getStoringFICardPocID() {
        return storingFICardPocID;
    }

    public void setStoringFICardPocID(String storingFICardPocID) {
        this.storingFICardPocID = storingFICardPocID;
    }

    public String getFiCard() {
        return fiCard;
    }

    public void setFiCard(String fiCard) {
        this.fiCard = fiCard;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStage1() {
        return stage1;
    }

    public void setStage1(String stage1) {
        this.stage1 = stage1;
    }

    public String getStage2() {
        return stage2;
    }

    public void setStage2(String stage2) {
        this.stage2 = stage2;
    }

    public String getStage3() {
        return stage3;
    }

    public void setStage3(String stage3) {
        this.stage3 = stage3;
    }

    public String getStage4() {
        return stage4;
    }

    public void setStage4(String stage4) {
        this.stage4 = stage4;
    }

    public String getStage4PoinCheck5() {
        return stage4PoinCheck5;
    }

    public void setStage4PoinCheck5(String stage4PoinCheck5) {
        this.stage4PoinCheck5 = stage4PoinCheck5;
    }

    public String getStage1PoinCheck1() {
        return stage1PoinCheck1;
    }

    public void setStage1PoinCheck1(String stage1PoinCheck1) {
        this.stage1PoinCheck1 = stage1PoinCheck1;
    }

    public String getStage1PoinCheck2() {
        return stage1PoinCheck2;
    }

    public void setStage1PoinCheck2(String stage1PoinCheck2) {
        this.stage1PoinCheck2 = stage1PoinCheck2;
    }

    public String getStage1PoinCheck3() {
        return stage1PoinCheck3;
    }

    public void setStage1PoinCheck3(String stage1PoinCheck3) {
        this.stage1PoinCheck3 = stage1PoinCheck3;
    }

    public String getStage1PoinCheck4() {
        return stage1PoinCheck4;
    }

    public void setStage1PoinCheck4(String stage1PoinCheck4) {
        this.stage1PoinCheck4 = stage1PoinCheck4;
    }

    public String getStage1PoinCheck5() {
        return stage1PoinCheck5;
    }

    public void setStage1PoinCheck5(String stage1PoinCheck5) {
        this.stage1PoinCheck5 = stage1PoinCheck5;
    }

    public String getStage1PoinCheck6() {
        return stage1PoinCheck6;
    }

    public void setStage1PoinCheck6(String stage1PoinCheck6) {
        this.stage1PoinCheck6 = stage1PoinCheck6;
    }

    public String getStage2PoinCheck1() {
        return stage2PoinCheck1;
    }

    public void setStage2PoinCheck1(String stage2PoinCheck1) {
        this.stage2PoinCheck1 = stage2PoinCheck1;
    }

    public String getStage2PoinCheck2() {
        return stage2PoinCheck2;
    }

    public void setStage2PoinCheck2(String stage2PoinCheck2) {
        this.stage2PoinCheck2 = stage2PoinCheck2;
    }

    public String getStage2PoinCheck3() {
        return stage2PoinCheck3;
    }

    public void setStage2PoinCheck3(String stage2PoinCheck3) {
        this.stage2PoinCheck3 = stage2PoinCheck3;
    }

    public String getStage2PoinCheck4() {
        return stage2PoinCheck4;
    }

    public void setStage2PoinCheck4(String stage2PoinCheck4) {
        this.stage2PoinCheck4 = stage2PoinCheck4;
    }

    public String getStage2PoinCheck5() {
        return stage2PoinCheck5;
    }

    public void setStage2PoinCheck5(String stage2PoinCheck5) {
        this.stage2PoinCheck5 = stage2PoinCheck5;
    }

    public String getStage3PoinCheck1() {
        return stage3PoinCheck1;
    }

    public void setStage3PoinCheck1(String stage3PoinCheck1) {
        this.stage3PoinCheck1 = stage3PoinCheck1;
    }

    public String getStage3PoinCheck2() {
        return stage3PoinCheck2;
    }

    public void setStage3PoinCheck2(String stage3PoinCheck2) {
        this.stage3PoinCheck2 = stage3PoinCheck2;
    }

    public String getStage4PoinCheck1() {
        return stage4PoinCheck1;
    }

    public void setStage4PoinCheck1(String stage4PoinCheck1) {
        this.stage4PoinCheck1 = stage4PoinCheck1;
    }

    public String getStage4PoinCheck2() {
        return stage4PoinCheck2;
    }

    public void setStage4PoinCheck2(String stage4PoinCheck2) {
        this.stage4PoinCheck2 = stage4PoinCheck2;
    }

    public String getStage4PoinCheck3() {
        return stage4PoinCheck3;
    }

    public void setStage4PoinCheck3(String stage4PoinCheck3) {
        this.stage4PoinCheck3 = stage4PoinCheck3;
    }

    public String getStage4PoinCheck4() {
        return stage4PoinCheck4;
    }

    public void setStage4PoinCheck4(String stage4PoinCheck4) {
        this.stage4PoinCheck4 = stage4PoinCheck4;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
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

    public StatusResult getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(StatusResult statusResult) {
        this.statusResult = statusResult;
    }

    @Override
    public String toString() {
        return "StoringFICardPOCDTO{" + "storingFICardPocID=" + storingFICardPocID + ", fiCard=" + fiCard + ", frameNumber=" + frameNumber + ", fileName=" + fileName + ", stage1=" + stage1 + ", stage2=" + stage2 + ", stage3=" + stage3 + ", stage4=" + stage4 + ", stage4PoinCheck5=" + stage4PoinCheck5 + ", stage1PoinCheck1=" + stage1PoinCheck1 + ", stage1PoinCheck2=" + stage1PoinCheck2 + ", stage1PoinCheck3=" + stage1PoinCheck3 + ", stage1PoinCheck4=" + stage1PoinCheck4 + ", stage1PoinCheck5=" + stage1PoinCheck5 + ", stage1PoinCheck6=" + stage1PoinCheck6 + ", stage2PoinCheck1=" + stage2PoinCheck1 + ", stage2PoinCheck2=" + stage2PoinCheck2 + ", stage2PoinCheck3=" + stage2PoinCheck3 + ", stage2PoinCheck4=" + stage2PoinCheck4 + ", stage2PoinCheck5=" + stage2PoinCheck5 + ", stage3PoinCheck1=" + stage3PoinCheck1 + ", stage3PoinCheck2=" + stage3PoinCheck2 + ", stage4PoinCheck1=" + stage4PoinCheck1 + ", stage4PoinCheck2=" + stage4PoinCheck2 + ", stage4PoinCheck3=" + stage4PoinCheck3 + ", stage4PoinCheck4=" + stage4PoinCheck4 + ", pathFile=" + pathFile + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", statusResult=" + statusResult + '}';
    }

}
