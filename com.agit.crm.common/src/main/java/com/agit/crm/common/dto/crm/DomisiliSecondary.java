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
    @ReadableColumn(column = "status", index = 5)
    private String status;

    public DomisiliSecondary() {
    }

    public DomisiliSecondary(String idDomisili, String namaProvinsi, String namaKabupaten, String namaKota, String status) {
        this.idDomisili = idDomisili;
        this.namaProvinsi = namaProvinsi;
        this.namaKabupaten = namaKabupaten;
        this.namaKota = namaKota;
        this.status = status;
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

    @ReadableValue(column = "status", index = 5)
    public String getStatus() {
        return status;
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

    @WritableValue(column = "status", index = 5)
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DomisiliSecondary{" + "idDomisili=" + idDomisili + ", namaProvinsi=" + namaProvinsi + ", namaKabupaten=" + namaKabupaten + ", namaKota=" + namaKota + ", status=" + status + '}';
    }

}
