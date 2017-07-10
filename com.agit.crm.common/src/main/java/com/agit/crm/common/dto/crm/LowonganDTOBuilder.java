package com.agit.crm.common.dto.crm;

import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;


public class LowonganDTOBuilder {

    private String idLowongan;
    private String idUser;
    private String namaLowongan;
    private String deskripsiLowongan;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private String minatPekerjaan;
    private String persyaratan;
    private String lokasiKerja;
    private String gaji;
    private LowonganState lowonganState;
    private List<RiwayatApplyMahasiswaDTO> listRiwayatApplyMahasiswaDTO;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public LowonganDTOBuilder() {
    }

    public LowonganDTOBuilder setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
        return this;
    }

    public LowonganDTOBuilder setIdUser(String idUser) {
        this.idUser = idUser;
        return this;
    }

    public LowonganDTOBuilder setNamaLowongan(String namaLowongan) {
        this.namaLowongan = namaLowongan;
        return this;
    }

    public LowonganDTOBuilder setDeskripsiLowongan(String deskripsiLowongan) {
        this.deskripsiLowongan = deskripsiLowongan;
        return this;
    }

    public LowonganDTOBuilder setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
        return this;
    }

    public LowonganDTOBuilder setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
        return this;
    }

    public LowonganDTOBuilder setMinatPekerjaan(String minatPekerjaan) {
        this.minatPekerjaan = minatPekerjaan;
        return this;
    }

    public LowonganDTOBuilder setPersyaratan(String persyaratan) {
        this.persyaratan = persyaratan;
        return this;
    }

    public LowonganDTOBuilder setLokasiKerja(String lokasiKerja) {
        this.lokasiKerja = lokasiKerja;
        return this;
    }

    public LowonganDTOBuilder setGaji(String gaji) {
        this.gaji = gaji;
        return this;
    }

    public LowonganDTOBuilder setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
        return this;
    }

    public LowonganDTOBuilder setListRiwayatApplyMahasiswaDTO(List<RiwayatApplyMahasiswaDTO> listRiwayatApplyMahasiswaDTO) {
        this.listRiwayatApplyMahasiswaDTO = listRiwayatApplyMahasiswaDTO;
        return this;
    }

    public LowonganDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LowonganDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LowonganDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public LowonganDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public LowonganDTO createLowonganDTO() {
        return new LowonganDTO(idLowongan, idUser, namaLowongan, deskripsiLowongan, tanggalMulai, tanggalBerakhir, minatPekerjaan, persyaratan, lokasiKerja, gaji, lowonganState, listRiwayatApplyMahasiswaDTO, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}
