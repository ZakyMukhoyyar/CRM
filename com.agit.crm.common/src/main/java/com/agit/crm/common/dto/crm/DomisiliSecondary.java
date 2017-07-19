package com.agit.crm.common.dto.crm;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class DomisiliSecondary {

    @ReadableColumn(column = "idDomisili", index = 1)
    private String idDomisili;
    @ReadableColumn(column = "namaProvinsi", index = 2)
    private String namaProvinsi;
    @ReadableColumn(column = "namaKabupaten", index = 3)
    private String namaKabupaten;
    @ReadableColumn(column = "namaKota", index = 4)
    private String namaKota;

    public DomisiliSecondary() {
    }

    @ReadableValue(column = "idDomisili", index = 1)
    public String getIdDomisili() {
        return idDomisili;
    }

    @ReadableValue(column = "namaProvinsi", index = 2)
    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    @ReadableValue(column = "namaKabupaten", index = 3)
    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    @ReadableValue(column = "namaKota", index = 4)
    public String getNamaKota() {
        return namaKota;
    }

    @WritableValue(column = "idDomisili", index = 1)
    public void setIdDomisili(String idDomisili) {
        this.idDomisili = idDomisili;
    }

    @WritableValue(column = "namaProvinsi", index = 2)
    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    @WritableValue(column = "namaKabupaten", index = 3)
    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }

    @WritableValue(column = "namaKota", index = 4)
    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    @Override
    public String toString() {
        return "DomisiliSecondary{" + "idDomisili=" + idDomisili + ", namaProvinsi=" + namaProvinsi + ", namaKabupaten=" + namaKabupaten + ", namaKota=" + namaKota + '}';
    }

}
