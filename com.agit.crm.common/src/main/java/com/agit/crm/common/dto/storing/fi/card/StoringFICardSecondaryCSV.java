/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.storing.fi.card;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;
import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author BayuHS
 */
public class StoringFICardSecondaryCSV {

    @CsvBindByPosition(position = 1)
    private String storingFICardID;
    @CsvBindByPosition(position = 2)
    private String pointCheck1;
    @CsvBindByPosition(position = 3)
    private String pointCheck2;
    @CsvBindByPosition(position = 4)
    private String pointCheck3;
    @CsvBindByPosition(position = 5)
    private String pointCheck4;
    @CsvBindByPosition(position = 6)
    private String pointCheck5;

    public StoringFICardSecondaryCSV() {
    }

    @ReadableValue(column = "storingFICardID", index = 1)
    public String getStoringFICardID() {
        return storingFICardID;
    }

    @ReadableValue(column = "pointCheck1", index = 2)
    public String getPointCheck1() {
        return pointCheck1;
    }

    @ReadableValue(column = "pointCheck2", index = 3)
    public String getPointCheck2() {
        return pointCheck2;
    }

    @ReadableValue(column = "pointCheck3", index = 4)
    public String getPointCheck3() {
        return pointCheck3;
    }

    @ReadableValue(column = "pointCheck4", index = 5)
    public String getPointCheck4() {
        return pointCheck4;
    }

    @ReadableValue(column = "pointCheck5", index = 6)
    public String getPointCheck5() {
        return pointCheck5;
    }

    @WritableValue(column = "storingFICardID", index = 1)
    public void setStoringFICardID(String storingFICardID) {
        this.storingFICardID = storingFICardID;
    }

    @WritableValue(column = "pointCheck1", index = 2)
    public void setPointCheck1(String pointCheck1) {
        this.pointCheck1 = pointCheck1;
    }

    @WritableValue(column = "pointCheck2", index = 3)
    public void setPointCheck2(String pointCheck2) {
        this.pointCheck2 = pointCheck2;
    }

    @WritableValue(column = "pointCheck3", index = 4)
    public void setPointCheck3(String pointCheck3) {
        this.pointCheck3 = pointCheck3;
    }

    @WritableValue(column = "pointCheck4", index = 5)
    public void setPointCheck4(String pointCheck4) {
        this.pointCheck4 = pointCheck4;
    }

    @WritableValue(column = "pointCheck5", index = 6)
    public void setPointCheck5(String pointCheck5) {
        this.pointCheck5 = pointCheck5;
    }

    @Override
    public String toString() {
        return "StoringFICardSecondary{" + "storingFICardID=" + storingFICardID + ", pointCheck1=" + pointCheck1 + ", pointCheck2=" + pointCheck2 + ", pointCheck3=" + pointCheck3 + ", pointCheck4=" + pointCheck4 + ", pointCheck5=" + pointCheck5 + '}';
    }

}
