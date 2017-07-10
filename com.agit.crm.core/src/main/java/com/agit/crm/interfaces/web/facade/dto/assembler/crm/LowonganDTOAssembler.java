package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.LowonganDTOBuilder;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTO;
import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganBuilder;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class LowonganDTOAssembler implements IObjectAssembler<Lowongan, LowonganDTO> {

    private RiwayatApplyMahasiswaRepository riwayatApplyMahasiswaRepository;
    private RiwayatApplyMahasiswaDTOAssembler riwayatApplyMahasiswaDTOAssembler;

    public void setRiwayatApplyMahasiswaRepository(RiwayatApplyMahasiswaRepository riwayatApplyMahasiswaRepository) {
        this.riwayatApplyMahasiswaRepository = riwayatApplyMahasiswaRepository;
    }

    public void setRiwayatApplyMahasiswaDTOAssembler(RiwayatApplyMahasiswaDTOAssembler riwayatApplyMahasiswaDTOAssembler) {
        this.riwayatApplyMahasiswaDTOAssembler = riwayatApplyMahasiswaDTOAssembler;
    }

    @Override
    public LowonganDTO toDTO(Lowongan domainObject) {
        return new LowonganDTOBuilder()
                .setIdLowongan(domainObject.getIdLowongan())
                .setNamaLowongan(domainObject.getNamaLowongan())
                .setDeskripsiLowongan(domainObject.getDeskripsiLowongan())
                .setTanggalMulai(domainObject.getTanggalMulai())
                .setTanggalBerakhir(domainObject.getTanggalBerakhir())
                .setMinatPekerjaan(domainObject.getMinatPekerjaan())
                .setPersyaratan(domainObject.getPersyaratan())
                .setLokasiKerja(domainObject.getLokasiKerja())
                .setGaji(domainObject.getGaji())
                .setLowonganState(domainObject.getLowonganState())
                .setIdUser(domainObject.getIdUser())
                .setListRiwayatApplyMahasiswaDTO(domainObject.getListRiwayatApplyMahasiswa() == null ? Collections.EMPTY_LIST : riwayatApplyMahasiswaDTOAssembler.toDTOs(domainObject.getListRiwayatApplyMahasiswa()))
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createLowonganDTO();
    }

    @Override
    public Lowongan toDomain(LowonganDTO dtoObject) {
        return new LowonganBuilder()
                .setIdLowongan(dtoObject.getIdLowongan())
                .setNamaLowongan(dtoObject.getNamaLowongan())
                .setDeskripsiLowongan(dtoObject.getDeskripsiLowongan())
                .setTanggalMulai(dtoObject.getTanggalMulai())
                .setTanggalBerakhir(dtoObject.getTanggalBerakhir())
                .setMinatPekerjaan(dtoObject.getMinatPekerjaan())
                .setPersyaratan(dtoObject.getPersyaratan())
                .setLokasiKerja(dtoObject.getLokasiKerja())
                .setGaji(dtoObject.getGaji())
                .setIdUser(dtoObject.getIdUser())
                .setLowonganState(dtoObject.getLowonganState())
                .setListRiwayatApplyMahasiswa(dtoObject.getListRiwayatApplyMahasiswaDTO() == null ? Collections.EMPTY_LIST : riwayatApplyMahasiswaDTOAssembler.toDomains(dtoObject.getListRiwayatApplyMahasiswaDTO()))
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createLowongan();
    }

    public List<Lowongan> toDomains(List<LowonganDTO> arg0) {
        List<Lowongan> res = new ArrayList<>();
        for (LowonganDTO t : arg0) {
            res.add(new LowonganDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<LowonganDTO> toDTOs(List<Lowongan> arg0) {
        List<LowonganDTO> res = new ArrayList<>();
        for (Lowongan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }

    public List<LowonganDTO> lDomain2lDTO(List<Lowongan> arg0) {
        List<LowonganDTO> res = new ArrayList();
        if (arg0 != null) {
            for (Lowongan o : arg0) {
                res.add(toDTO(o));
            }
        }
        return res;
    }

    public List<RiwayatApplyMahasiswa> RAMDTO2RAMDomain(List<RiwayatApplyMahasiswaDTO> arg0) {
        List<RiwayatApplyMahasiswa> res = new ArrayList<>();
        if (arg0 != null) {
            for (RiwayatApplyMahasiswaDTO o : arg0) {
                RiwayatApplyMahasiswa riwayatApplyMahasiswa = riwayatApplyMahasiswaRepository.findByID(o.getIdRiwayatApplyMahasiswa());
                if (riwayatApplyMahasiswa == null) {
                    riwayatApplyMahasiswa = riwayatApplyMahasiswaDTOAssembler.toDomain(o);
                } else {
                    riwayatApplyMahasiswa.assignNewRiwayat(riwayatApplyMahasiswaDTOAssembler.toDomain(o));
                }
                res.add(riwayatApplyMahasiswa);
            }

        }
        return res;
    }

    public List<RiwayatApplyMahasiswaDTO> RAMDomain2RAMDTO(List<RiwayatApplyMahasiswa> arg0) {
        List<RiwayatApplyMahasiswaDTO> res = new ArrayList<>();
        if (arg0 != null) {
            for (RiwayatApplyMahasiswa o : arg0) {
                res.add(new RiwayatApplyMahasiswaDTOAssembler().toDTO(o));
            }

        }
        return res;
    }
}
