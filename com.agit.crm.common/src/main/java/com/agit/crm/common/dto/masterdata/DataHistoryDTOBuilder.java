/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.masterdata;

import java.util.Date;

public class DataHistoryDTOBuilder {

    private String dataHistoryID;
    private String namaPerusahaan;
    private String tahun;
    private String bulan;
    private String jenisProduct;
    private String detailProduct;
    private double jumlahProduct;
    private String createBy;
    private Date createDate;
    private String modifieBy;
    private Date modifieDate;

    public DataHistoryDTOBuilder() {
    }

    public DataHistoryDTOBuilder setDataHistoryID(String dataHistoryID) {
        this.dataHistoryID = dataHistoryID;
        return this;
    }

    public DataHistoryDTOBuilder setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        return this;
    }

    public DataHistoryDTOBuilder setTahun(String tahun) {
        this.tahun = tahun;
        return this;
    }

    public DataHistoryDTOBuilder setBulan(String bulan) {
        this.bulan = bulan;
        return this;
    }

    public DataHistoryDTOBuilder setJenisProduct(String jenisProduct) {
        this.jenisProduct = jenisProduct;
        return this;
    }

    public DataHistoryDTOBuilder setDetailProduct(String detailProduct) {
        this.detailProduct = detailProduct;
        return this;
    }

    public DataHistoryDTOBuilder setJumlahProduct(double jumlahProduct) {
        this.jumlahProduct = jumlahProduct;
        return this;
    }

    public DataHistoryDTOBuilder setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public DataHistoryDTOBuilder setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public DataHistoryDTOBuilder setModifieBy(String modifieBy) {
        this.modifieBy = modifieBy;
        return this;
    }

    public DataHistoryDTOBuilder setModifieDate(Date modifieDate) {
        this.modifieDate = modifieDate;
        return this;
    }

    public DataHistoryDTO createDataHistoryDTO() {
        return new DataHistoryDTO(dataHistoryID, namaPerusahaan, tahun, bulan, jenisProduct, detailProduct, jumlahProduct, createBy, createDate, modifieBy, modifieDate);
    }

}
