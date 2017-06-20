package com.agit.crm.common.dto.masterdata;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 3AD
 */
public class DataHistoryDTO implements Serializable {

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

    public DataHistoryDTO() {
    }

    public DataHistoryDTO(String dataHistoryID, String namaPerusahaan, String tahun, String bulan, String jenisProduct, String detailProduct, double jumlahProduct, String createBy, Date createDate, String modifieBy, Date modifieDate) {
        this.dataHistoryID = dataHistoryID;
        this.namaPerusahaan = namaPerusahaan;
        this.tahun = tahun;
        this.bulan = bulan;
        this.jenisProduct = jenisProduct;
        this.detailProduct = detailProduct;
        this.jumlahProduct = jumlahProduct;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifieBy = modifieBy;
        this.modifieDate = modifieDate;
    }

    public String getDataHistoryID() {
        return dataHistoryID;
    }

    public void setDataHistoryID(String dataHistoryID) {
        this.dataHistoryID = dataHistoryID;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getJenisProduct() {
        return jenisProduct;
    }

    public void setJenisProduct(String jenisProduct) {
        this.jenisProduct = jenisProduct;
    }

    public String getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(String detailProduct) {
        this.detailProduct = detailProduct;
    }

    public double getJumlahProduct() {
        return jumlahProduct;
    }

    public void setJumlahProduct(double jumlahProduct) {
        this.jumlahProduct = jumlahProduct;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifieBy() {
        return modifieBy;
    }

    public void setModifieBy(String modifieBy) {
        this.modifieBy = modifieBy;
    }

    public Date getModifieDate() {
        return modifieDate;
    }

    public void setModifieDate(Date modifieDate) {
        this.modifieDate = modifieDate;
    }

    @Override
    public String toString() {
        return "DataHistoryDTO{" + "dataHistoryID=" + dataHistoryID + ", namaPerusahaan=" + namaPerusahaan + ", tahun=" + tahun + ", bulan=" + bulan + ", jenisProduct=" + jenisProduct + ", detailProduct=" + detailProduct + ", jumlahProduct=" + jumlahProduct + ", createBy=" + createBy + ", createDate=" + createDate + ", modifieBy=" + modifieBy + ", modifieDate=" + modifieDate + '}';
    }

}
