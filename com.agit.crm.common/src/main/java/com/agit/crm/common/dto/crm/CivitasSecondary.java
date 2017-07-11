/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;

/**
 *
 * @author 3AD
 */
public class CivitasSecondary {

    @ReadableColumn(column = "no", index = 1)
    private String no;
    @ReadableColumn(column = "namaCivitas", index = 2)
    private String namaCivitas;
    @ReadableColumn(column = "status", index = 3)
    private String status;

    public CivitasSecondary() {
    }

    public CivitasSecondary(String no, String namaCivitas, String status) {
        this.no = no;
        this.namaCivitas = namaCivitas;
        this.status = status;
    }

    @ReadableValue(column = "no", index = 1)
    public String getNo() {
        return no;
    }

    @ReadableValue(column = "namaCivitas", index = 2)
    public String getNamaCivitas() {
        return namaCivitas;
    }

    @ReadableValue(column = "status", index = 3)
    public String getStatus() {
        return status;
    }

    @WritableValue(column = "no", index = 1)
    public void setNo(String no) {
        this.no = no;
    }

    @WritableValue(column = "namaCivitas", index = 2)
    public void setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
    }

    @WritableValue(column = "status", index = 3)
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CivitasSecondary{" + "no=" + no + ", namaCivitas=" + namaCivitas + ", status=" + status + '}';
    }

}
