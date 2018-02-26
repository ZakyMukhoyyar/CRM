/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.storing.fi.card.poc;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;

/**
 *
 * @author BayuHS
 */
public class StoringFICardPOCSecondary {

    private String storingFICardPocID;

    @ReadableColumn(column = "fiCard", index = 1)
    private String fiCard;

    @ReadableColumn(column = "frameNumber", index = 2)
    private String frameNumber;

    @ReadableColumn(column = "fileName", index = 3)
    private String fileName;

    @ReadableColumn(column = "stage1", index = 4)
    private String stage1;

    @ReadableColumn(column = "stage2", index = 5)
    private String stage2;

    @ReadableColumn(column = "stage3", index = 6)
    private String stage3;

    @ReadableColumn(column = "stage4", index = 7)
    private String stage4;

    @ReadableColumn(column = "stage4PoinCheck5", index = 8)
    private String stage4PoinCheck5;

    @ReadableColumn(column = "stage1PoinCheck1", index = 9)
    private String stage1PoinCheck1;

    @ReadableColumn(column = "stage1PoinCheck2", index = 10)
    private String stage1PoinCheck2;

    @ReadableColumn(column = "stage1PoinCheck3", index = 11)
    private String stage1PoinCheck3;

    @ReadableColumn(column = "stage1PoinCheck4", index = 12)
    private String stage1PoinCheck4;

    @ReadableColumn(column = "stage1PoinCheck5", index = 13)
    private String stage1PoinCheck5;

    @ReadableColumn(column = "stage1PoinCheck6", index = 14)
    private String stage1PoinCheck6;

    @ReadableColumn(column = "stage2PoinCheck1", index = 15)
    private String stage2PoinCheck1;

    @ReadableColumn(column = "stage2PoinCheck2", index = 16)
    private String stage2PoinCheck2;

    @ReadableColumn(column = "stage2PoinCheck3", index = 17)
    private String stage2PoinCheck3;

    @ReadableColumn(column = "stage2PoinCheck4", index = 18)
    private String stage2PoinCheck4;

    @ReadableColumn(column = "stage2PoinCheck5", index = 19)
    private String stage2PoinCheck5;

    @ReadableColumn(column = "stage3PoinCheck1", index = 20)
    private String stage3PoinCheck1;

    @ReadableColumn(column = "stage3PoinCheck2", index = 21)
    private String stage3PoinCheck2;

    @ReadableColumn(column = "stage4PoinCheck1", index = 22)
    private String stage4PoinCheck1;

    @ReadableColumn(column = "stage4PoinCheck2", index = 23)
    private String stage4PoinCheck2;

    @ReadableColumn(column = "stage4PoinCheck3", index = 24)
    private String stage4PoinCheck3;

    @ReadableColumn(column = "stage4PoinCheck4", index = 25)
    private String stage4PoinCheck4;

    @ReadableColumn(column = "pathFile", index = 26)
    private String pathFile;

    public StoringFICardPOCSecondary() {
    }

    public String getStoringFICardPocID() {
        return storingFICardPocID;
    }

    @ReadableValue(column = "fiCard", index = 1)
    public String getFiCard() {
        return fiCard;
    }

    @ReadableValue(column = "frameNumber", index = 2)
    public String getFrameNumber() {
        return frameNumber;
    }

    @ReadableValue(column = "fileName", index = 3)
    public String getFileName() {
        return fileName;
    }

    @ReadableValue(column = "stage1", index = 4)
    public String getStage1() {
        return stage1;
    }

    @ReadableValue(column = "stage2", index = 5)
    public String getStage2() {
        return stage2;
    }

    @ReadableValue(column = "stage3", index = 6)
    public String getStage3() {
        return stage3;
    }

    @ReadableValue(column = "stage4", index = 7)
    public String getStage4() {
        return stage4;
    }

    @ReadableValue(column = "stage4PoinCheck5", index = 8)
    public String getStage4PoinCheck5() {
        return stage4PoinCheck5;
    }

    @ReadableValue(column = "stage1PoinCheck1", index = 9)
    public String getStage1PoinCheck1() {
        return stage1PoinCheck1;
    }

    @ReadableValue(column = "stage1PoinCheck2", index = 10)
    public String getStage1PoinCheck2() {
        return stage1PoinCheck2;
    }

    @ReadableValue(column = "stage1PoinCheck3", index = 11)
    public String getStage1PoinCheck3() {
        return stage1PoinCheck3;
    }

    @ReadableValue(column = "stage1PoinCheck4", index = 12)
    public String getStage1PoinCheck4() {
        return stage1PoinCheck4;
    }

    @ReadableValue(column = "stage1PoinCheck5", index = 13)
    public String getStage1PoinCheck5() {
        return stage1PoinCheck5;
    }

    @ReadableValue(column = "stage1PoinCheck6", index = 14)
    public String getStage1PoinCheck6() {
        return stage1PoinCheck6;
    }

    @ReadableValue(column = "stage2PoinCheck1", index = 15)
    public String getStage2PoinCheck1() {
        return stage2PoinCheck1;
    }

    @ReadableValue(column = "stage2PoinCheck2", index = 16)
    public String getStage2PoinCheck2() {
        return stage2PoinCheck2;
    }

    @ReadableValue(column = "stage2PoinCheck3", index = 17)
    public String getStage2PoinCheck3() {
        return stage2PoinCheck3;
    }

    @ReadableValue(column = "stage2PoinCheck4", index = 18)
    public String getStage2PoinCheck4() {
        return stage2PoinCheck4;
    }

    @ReadableValue(column = "stage2PoinCheck5", index = 19)
    public String getStage2PoinCheck5() {
        return stage2PoinCheck5;
    }

    @ReadableValue(column = "stage3PoinCheck1", index = 20)
    public String getStage3PoinCheck1() {
        return stage3PoinCheck1;
    }

    @ReadableValue(column = "stage3PoinCheck2", index = 21)
    public String getStage3PoinCheck2() {
        return stage3PoinCheck2;
    }

    @ReadableValue(column = "stage4PoinCheck1", index = 22)
    public String getStage4PoinCheck1() {
        return stage4PoinCheck1;
    }

    @ReadableValue(column = "stage4PoinCheck2", index = 23)
    public String getStage4PoinCheck2() {
        return stage4PoinCheck2;
    }

    @ReadableValue(column = "stage4PoinCheck3", index = 24)
    public String getStage4PoinCheck3() {
        return stage4PoinCheck3;
    }

    @ReadableValue(column = "stage4PoinCheck3", index = 25)
    public String getStage4PoinCheck4() {
        return stage4PoinCheck3;
    }

    @ReadableValue(column = "pathFile", index = 26)
    public String getPathFile() {
        return pathFile;
    }

    public void setStoringFICardPocID(String storingFICardPocID) {
        this.storingFICardPocID = storingFICardPocID;
    }

    @WritableValue(column = "fiCard", index = 1)
    public void setFiCard(String fiCard) {
        this.fiCard = fiCard;
    }

    @WritableValue(column = "frameNumber", index = 2)
    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    @WritableValue(column = "fileName", index = 3)
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @WritableValue(column = "stage1", index = 4)
    public void setStage1(String stage1) {
        this.stage1 = stage1;
    }

    @WritableValue(column = "stage2", index = 5)
    public void setStage2(String stage2) {
        this.stage2 = stage2;
    }

    @WritableValue(column = "stage3", index = 6)
    public void setStage3(String stage3) {
        this.stage3 = stage3;
    }

    @WritableValue(column = "stage4", index = 7)
    public void setStage4(String stage4) {
        this.stage4 = stage4;
    }

    @WritableValue(column = "stage4PoinCheck5", index = 8)
    public void setStage4PoinCheck5(String stage4PoinCheck5) {
        this.stage4PoinCheck5 = stage4PoinCheck5;
    }

    @WritableValue(column = "stage1PoinCheck1", index = 9)
    public void setStage1PoinCheck1(String stage1PoinCheck1) {
        this.stage1PoinCheck1 = stage1PoinCheck1;
    }

    @WritableValue(column = "stage1PoinCheck2", index = 10)
    public void setStage1PoinCheck2(String stage1PoinCheck2) {
        this.stage1PoinCheck2 = stage1PoinCheck2;
    }

    @WritableValue(column = "stage1PoinCheck3", index = 11)
    public void setStage1PoinCheck3(String stage1PoinCheck3) {
        this.stage1PoinCheck3 = stage1PoinCheck3;
    }

    @WritableValue(column = "stage1PoinCheck4", index = 12)
    public void setStage1PoinCheck4(String stage1PoinCheck4) {
        this.stage1PoinCheck4 = stage1PoinCheck4;
    }

    @WritableValue(column = "stage1PoinCheck5", index = 13)
    public void setStage1PoinCheck5(String stage1PoinCheck5) {
        this.stage1PoinCheck5 = stage1PoinCheck5;
    }

    @WritableValue(column = "stage1PoinCheck6", index = 14)
    public void setStage1PoinCheck6(String stage1PoinCheck6) {
        this.stage1PoinCheck6 = stage1PoinCheck6;
    }

    @WritableValue(column = "stage2PoinCheck1", index = 15)
    public void setStage2PoinCheck1(String stage2PoinCheck1) {
        this.stage2PoinCheck1 = stage2PoinCheck1;
    }

    @WritableValue(column = "stage2PoinCheck2", index = 16)
    public void setStage2PoinCheck2(String stage2PoinCheck2) {
        this.stage2PoinCheck2 = stage2PoinCheck2;
    }

    @WritableValue(column = "stage2PoinCheck3", index = 17)
    public void setStage2PoinCheck3(String stage2PoinCheck3) {
        this.stage2PoinCheck3 = stage2PoinCheck3;
    }

    @WritableValue(column = "stage2PoinCheck4", index = 18)
    public void setStage2PoinCheck4(String stage2PoinCheck4) {
        this.stage2PoinCheck4 = stage2PoinCheck4;
    }

    @WritableValue(column = "stage2PoinCheck5", index = 19)
    public void setStage2PoinCheck5(String stage2PoinCheck5) {
        this.stage2PoinCheck5 = stage2PoinCheck5;
    }

    @WritableValue(column = "stage3PoinCheck1", index = 20)
    public void setStage3PoinCheck1(String stage3PoinCheck1) {
        this.stage3PoinCheck1 = stage3PoinCheck1;
    }

    @WritableValue(column = "stage3PoinCheck2", index = 21)
    public void setStage3PoinCheck2(String stage3PoinCheck2) {
        this.stage3PoinCheck2 = stage3PoinCheck2;
    }

    @WritableValue(column = "stage4PoinCheck1", index = 22)
    public void setStage4PoinCheck1(String stage4PoinCheck1) {
        this.stage4PoinCheck1 = stage4PoinCheck1;
    }

    @WritableValue(column = "stage4PoinCheck2", index = 23)
    public void setStage4PoinCheck2(String stage4PoinCheck2) {
        this.stage4PoinCheck2 = stage4PoinCheck2;
    }

    @WritableValue(column = "stage4PoinCheck3", index = 24)
    public void setStage4PoinCheck3(String stage4PoinCheck3) {
        this.stage4PoinCheck3 = stage4PoinCheck3;
    }

    @WritableValue(column = "stage4PoinCheck3", index = 25)
    public void setStage4PoinCheck4(String stage4PoinCheck4) {
        this.stage4PoinCheck4 = stage4PoinCheck4;
    }

    @WritableValue(column = "pathFile", index = 26)
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

}
