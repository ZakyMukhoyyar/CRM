/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.crm;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;
import com.agit.crm.shared.status.Status;

/**
 *
 * @author Zaky
 */
public class JurusanSecondary {

    @ReadableColumn(column = "idJurusan", index = 1)
    private String idJurusan;
    @ReadableColumn(column = "namaJurusan", index = 2)
    private String namaJurusan;
    @ReadableColumn(column = "status", index = 3)
    private String status;

    public JurusanSecondary() {
    }

    public JurusanSecondary(String idJurusan, String namaJurusan, String status) {
        this.idJurusan = idJurusan;
        this.namaJurusan = namaJurusan;
        this.status = status;
    }

    @WritableValue(column = "idJurusan", index = 1)
    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    @WritableValue(column = "namaJurusan", index = 2)
    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    @WritableValue(column = "status", index = 3)
    public void setStatus(String status) {
        this.status = status;
    }

    @ReadableValue(column = "idJurusan", index = 1)
    public String getIdJurusan() {
        return idJurusan;
    }

    @ReadableValue(column = "namaJurusan", index = 2)
    public String getNamaJurusan() {
        return namaJurusan;
    }

    @ReadableValue(column = "status", index = 3)
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "JurusanSecondary{" + "idJurusan=" + idJurusan + ", namaJurusan=" + namaJurusan + ", status=" + status + '}';
    }

}
