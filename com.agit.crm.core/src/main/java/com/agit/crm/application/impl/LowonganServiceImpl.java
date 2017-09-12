package com.agit.crm.application.impl;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganBuilder;
import com.agit.crm.domain.crm.LowonganRepository;
import com.agit.crm.domain.crm.LowonganStatus;
import com.agit.crm.domain.crm.LowonganStatusBuilder;
import com.agit.crm.domain.crm.LowonganStatusRepository;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaBuilder;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.LowonganDTOAssembler;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.LowonganStatusDTOAssembler;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.RiwayatApplyMahasiswaDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.status.Status;
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
    private LowonganStatusRepository lowonganStatusRepository;
    private LowonganStatusDTOAssembler lowonganStatusDTOAssembler;

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

    public void setLowonganStatusRepository(LowonganStatusRepository lowonganStatusRepository) {
        this.lowonganStatusRepository = lowonganStatusRepository;
    }

    public void setLowonganStatusDTOAssembler(LowonganStatusDTOAssembler lowonganStatusDTOAssembler) {
        this.lowonganStatusDTOAssembler = lowonganStatusDTOAssembler;
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

        /* Riwayat Apply Mahasiswa Dummy */
        /*dummy1*/
        RiwayatApplyMahasiswa riwayatApplyMahasiswa1 = new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa("RAM001")
                //                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .createRiwayatApplyMahasiswa();
        /*dummy2*/
        RiwayatApplyMahasiswa riwayatApplyMahasiswa2 = new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa("RAM002")
                //                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .createRiwayatApplyMahasiswa();
        List<RiwayatApplyMahasiswa> riwayatApplyMahasiswas = new ArrayList<>();
        riwayatApplyMahasiswas.add(riwayatApplyMahasiswa1);
        riwayatApplyMahasiswas.add(riwayatApplyMahasiswa2);

        /* Lowongan Status Dummy */
        /*dummy1*/
        LowonganStatus lowonganStatus1 = new LowonganStatusBuilder()
                .setIdLowonganStatus("LS001")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("admin")
                .setCreatedDate(new Date())
                .setModifiedBy("user")
                .setModifiedDate(new Date())
                .createLowonganStatus();
        /*dummy2*/
        LowonganStatus lowonganStatus2 = new LowonganStatusBuilder()
                .setIdLowonganStatus("LS002")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("admin")
                .setCreatedDate(new Date())
                .setModifiedBy("user")
                .setModifiedDate(new Date())
                .createLowonganStatus();
        List<LowonganStatus> lowonganStatuses = new ArrayList<>();
        lowonganStatuses.add(lowonganStatus1);
        lowonganStatuses.add(lowonganStatus2);

        /* Lowongan Dummy1 */
        Lowongan lowongan1 = new LowonganBuilder()
                .setIdLowongan("L001")
                .setNamaLowongan("namaLow1")
                .setDeskripsiLowongan("descLow1")
                .setTanggalMulai(new Date())
                .setTanggalBerakhir(new Date())
                .setMinatPekerjaan("minat1")
                .setPersyaratan("persyaratan1")
                .setLokasiKerja("lokasi1")
                .setGaji("Rp 2.000.000 - Rp 3.000.000")
                .setCreatedBy("admin")
                .setUserID(Long.MIN_VALUE)
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createLowongan();
        return lowonganDTOAssembler.toDTO(lowongan1);

//        Lowongan lowongan2 = new LowonganBuilder()
//                .setIdLowongan("L002")
//                .setNamaLowongan("namaLow2")
//                .setDeskripsiLowongan("descLow2")
//                .setTanggalMulai(new Date())
//                .setTanggalBerakhir(new Date())
//                .setMinatPekerjaan("minat2")
//                .setPersyaratan("persyaratan2")
//                .setLokasiKerja("lokasi2")
//                .setGaji("Rp 2.000.000 - Rp 3.000.000")
//                .setIdUser("User2")
//                .setListLowonganStatuses(lowonganStatuses)
//                .setListRiwayatApplyMahasiswa(riwayatApplyMahasiswas)
//                .setCreatedBy("admin")
//                .setCreatedDate(new Date())
//                .setModifiedBy("user")
//                .setModifiedDate(new Date())
//                .createLowongan();
//        return lowonganDTOAssembler.toDTO(lowongan2);
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

    @Override
    public LowonganDTO findByIDUser(String userID) {
        Validate.notNull(lowonganRepository);
        Lowongan b = (Lowongan) lowonganRepository.findByIDUser(userID);
        if (b != null) {
            return lowonganDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public void eventScheduler() {

        List<Lowongan> list = lowonganRepository.findAll();
        Date dateNow = new Date();
        int year = dateNow.getYear();
        int month = dateNow.getMonth();
        int date = dateNow.getDate();

        for (Lowongan evt : list) {
            int getEndDateDTO = evt.getTanggalBerakhir().getDate() + 1;
            int getEndMonthDTO = evt.getTanggalBerakhir().getMonth();
            int getEndYearDTO = evt.getTanggalBerakhir().getYear();
            Date dateDTO = new Date(getEndYearDTO, getEndMonthDTO, getEndDateDTO);
            int compareDate = dateNow.compareTo(dateDTO);
            if (compareDate == 1) {
                evt.setStatus(Status.INACTIVE);
            } else {
                evt.setStatus(Status.ACTIVE);
            }
            lowonganRepository.saveOrUpdate(evt);
        }
    }

    @Override
    public List<LowonganDTO> findAllByStatus(Status status) {
        Validate.notNull(lowonganRepository);
        List<Lowongan> listLowongan = lowonganRepository.findAllByStatus(status);
        if (listLowongan != null) {
            return (List<LowonganDTO>) lowonganDTOAssembler.toDTOs(listLowongan);
        }
        return null;
    }

}
