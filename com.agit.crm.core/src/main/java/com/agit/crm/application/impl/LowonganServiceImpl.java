package com.agit.crm.application.impl;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganBuilder;
import com.agit.crm.domain.crm.LowonganRepository;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaBuilder;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.LowonganDTOAssembler;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.RiwayatApplyMahasiswaDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class LowonganServiceImpl implements LowonganService {

    private LowonganRepository lowonganRepository;
    private LowonganDTOAssembler lowonganDTOAssembler;
    private RiwayatApplyMahasiswaRepository riwayatApplyMahasiswaRepository;
    private RiwayatApplyMahasiswaDTOAssembler riwayatApplyMahasiswaDTOAssembler;

    public void setRiwayatApplyMahasiswaRepository(RiwayatApplyMahasiswaRepository riwayatApplyMahasiswaRepository) {
        this.riwayatApplyMahasiswaRepository = riwayatApplyMahasiswaRepository;
    }

    public void setRiwayatApplyMahasiswaDTOAssembler(RiwayatApplyMahasiswaDTOAssembler riwayatApplyMahasiswaDTOAssembler) {
        this.riwayatApplyMahasiswaDTOAssembler = riwayatApplyMahasiswaDTOAssembler;
    }

    public void setLowonganRepository(LowonganRepository lowonganRepository) {
        this.lowonganRepository = lowonganRepository;
    }

    public void setLowonganDTOAssembler(LowonganDTOAssembler lowonganDTOAssembler) {
        this.lowonganDTOAssembler = lowonganDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(LowonganDTO lowongan) {
        Lowongan t = lowonganRepository.findByID(lowongan.getIdLowongan());

        if (t == null) {
            t = lowonganDTOAssembler.toDomain(lowongan);
        } else {
            Lowongan newLowongan = lowonganDTOAssembler.toDomain(lowongan);
            t.assignNewLowongan(newLowongan);

        }
        lowonganRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(LowonganDTO lowongan) {
        Lowongan p = lowonganDTOAssembler.toDomain(lowongan);
        lowonganRepository.deleteData(p);
    }

    @Override
    public LowonganDTO getDummyData() {

        RiwayatApplyMahasiswa riwayatApplyMahasiswa1 = new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa("11")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setLowonganState(LowonganState.CLOSE)
                .createRiwayatApplyMahasiswa();
        List<RiwayatApplyMahasiswa> riwayatApplyMahasiswas = new ArrayList<>();
        riwayatApplyMahasiswas.add(riwayatApplyMahasiswa1);

        Lowongan lowongan = new LowonganBuilder()
                .setIdLowongan("11")
                .setNamaLowongan("namaLowongan")
                .setDeskripsiLowongan("deskripsiLowongan")
                .setTanggalMulai(new Date())
                .setTanggalBerakhir(new Date())
                .setMinatPekerjaan("minatPekerjaan")
                .setPersyaratan("persyaratan")
                .setLokasiKerja("lokasiKerja")
                .setGaji("Rp 2.000.000 - Rp 3.000.000")
                .setCreatedBy("created by")
                .setLowonganState(LowonganState.APPLY)
                .setIdUser("idUser")
                .setListRiwayatApplyMahasiswa(riwayatApplyMahasiswas)
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .createLowongan();
        return lowonganDTOAssembler.toDTO(lowongan);
    }

    @Override
    public LowonganDTO findByID(String idLowongan) {
        Validate.notNull(lowonganRepository);
        Lowongan b = (Lowongan) lowonganRepository.findByID(idLowongan);
        if (b != null) {
            return lowonganDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<LowonganDTO> findByParams(Map map) {
        Validate.notNull(lowonganRepository);
        List<Lowongan> listLowongan = lowonganRepository.findByParams(map);
        if (listLowongan != null) {
            return (List<LowonganDTO>) lowonganDTOAssembler.toDTOs(listLowongan);
        }
        return null;
    }

    @Override
    public List<LowonganDTO> findAll() {
        Validate.notNull(lowonganRepository);
        return lowonganDTOAssembler.toDTOs(lowonganRepository.findAll());
    }

}
