package com.agit.crm.application.impl;

import com.agit.crm.common.application.RiwayatApplyMahasiswaService;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTO;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaBuilder;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.RiwayatApplyMahasiswaDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class RiwayatApplyMahasiswaServiceImpl implements RiwayatApplyMahasiswaService {

    private RiwayatApplyMahasiswaRepository riwayatApplyMahasiswaRepository;
    private RiwayatApplyMahasiswaDTOAssembler riwayatApplyMahasiswaDTOAssembler;

    public void setRiwayatApplyMahasiswaRepository(RiwayatApplyMahasiswaRepository riwayatApplyMahasiswaRepository) {
        this.riwayatApplyMahasiswaRepository = riwayatApplyMahasiswaRepository;
    }

    public void setRiwayatApplyMahasiswaDTOAssembler(RiwayatApplyMahasiswaDTOAssembler riwayatApplyMahasiswaDTOAssembler) {
        this.riwayatApplyMahasiswaDTOAssembler = riwayatApplyMahasiswaDTOAssembler;
    }

    @Override
    public void deleteData(RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa) {
        RiwayatApplyMahasiswa p = riwayatApplyMahasiswaDTOAssembler.toDomain(riwayatApplyMahasiswa);
        riwayatApplyMahasiswaRepository.deleteData(p);
    }

    @Override
    public RiwayatApplyMahasiswaDTO getDummyData() {
        RiwayatApplyMahasiswa riwayatApplyMahasiswa = new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa("11")
                .setNamaLowonganApply("namaLowonganApply")
                .setNamaApplyLowongan("namaApplyLowongan")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setLowonganState(LowonganState.CLOSE)
                .createRiwayatApplyMahasiswa();
        return riwayatApplyMahasiswaDTOAssembler.toDTO(riwayatApplyMahasiswa);
    }

    @Override
    public RiwayatApplyMahasiswaDTO findByID(String idRiwayatApplyMahasiswa) {
        Validate.notNull(riwayatApplyMahasiswaRepository);
        RiwayatApplyMahasiswa b = (RiwayatApplyMahasiswa) riwayatApplyMahasiswaRepository.findByID(idRiwayatApplyMahasiswa);
        if (b != null) {
            return riwayatApplyMahasiswaDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<RiwayatApplyMahasiswaDTO> findAll() {
        Validate.notNull(riwayatApplyMahasiswaRepository);
        return riwayatApplyMahasiswaDTOAssembler.toDTOs(riwayatApplyMahasiswaRepository.findAll());
    }

    @Override
    public List<RiwayatApplyMahasiswaDTO> findByParams(Map map) {
        Validate.notNull(riwayatApplyMahasiswaRepository);
        List<RiwayatApplyMahasiswa> listRiwayatApplyMahasiswa = riwayatApplyMahasiswaRepository.findByParams(map);
        if (listRiwayatApplyMahasiswa != null) {
            return (List<RiwayatApplyMahasiswaDTO>) riwayatApplyMahasiswaDTOAssembler.toDTOs(listRiwayatApplyMahasiswa);
        }
        return null;
    }

    @Override
    public void SaveOrUpdate(RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa) {
        RiwayatApplyMahasiswa t = riwayatApplyMahasiswaRepository.findByID(riwayatApplyMahasiswa.getIdRiwayatApplyMahasiswa());

        if (t == null) {
            t = riwayatApplyMahasiswaDTOAssembler.toDomain(riwayatApplyMahasiswa);
        } else {
            RiwayatApplyMahasiswa newRiwayat = riwayatApplyMahasiswaDTOAssembler.toDomain(riwayatApplyMahasiswa);
            t.assignNewRiwayat(newRiwayat);

        }
        riwayatApplyMahasiswaRepository.saveOrUpdate(t);
    }

}
