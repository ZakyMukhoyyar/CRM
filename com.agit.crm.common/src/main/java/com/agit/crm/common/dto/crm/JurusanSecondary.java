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
 * @author Zaky
 */
public class JurusanSecondary {
    
    @ReadableColumn (column = "idJurusan", index = 1)
    private String idJurusan;
    @ReadableColumn (column = "namaJurusan", index = 2)
    private String namaJurusan;

    public JurusanSecondary() {
    }

    public JurusanSecondary(String idJurusan, String namaJurusan) {
        this.idJurusan = idJurusan;
        this.namaJurusan = namaJurusan;
    }

    @WritableValue(column = "idJurusan", index = 1)
    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    @WritableValue(column = "namaJurusan", index = 2)
    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    @ReadableValue(column = "idJurusan", index = 1)
    public String getIdJurusan() {
        return idJurusan;
    }

    @ReadableValue(column = "namaJurusan", index = 2)
    public String getNamaJurusan() {
        return namaJurusan;
    }
    
    @Override
    public String toString() {
        return "JurusanSecondary{" + "idJurusan=" + idJurusan + ", namaJurusan=" + namaJurusan + '}';
    }
    
}
