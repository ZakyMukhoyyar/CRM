package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.MahasiswaDTO;
import com.agit.crm.common.dto.crm.MahasiswaDTOBuilder;
import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganRepository;
import com.agit.crm.domain.crm.Mahasiswa;
import com.agit.crm.domain.crm.MahasiswaBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class MahasiswaDTOAssembler implements IObjectAssembler<Mahasiswa, MahasiswaDTO> {

    private LowonganRepository lowonganRepository;
    private LowonganDTOAssembler lowonganDTOAssembler;

    public void setLowonganRepository(LowonganRepository lowonganRepository) {
        this.lowonganRepository = lowonganRepository;
    }

    public void setLowonganDTOAssembler(LowonganDTOAssembler lowonganDTOAssembler) {
        this.lowonganDTOAssembler = lowonganDTOAssembler;
    }

    @Override
    public MahasiswaDTO toDTO(Mahasiswa domainObject) {
        return new MahasiswaDTOBuilder()
                .setIdMahasiswa(domainObject.getIdMahasiswa())
                .setUsername(domainObject.getUsername())
                .setPassword(domainObject.getPassword())
                .setRetypedPassword(domainObject.getRetypedPassword())
                .setNamaLengkap(domainObject.getNamaLengkap())
                .setEmail(domainObject.getEmail())
                .setTanggalLahir(domainObject.getTanggalLahir())
                .setDomisili(domainObject.getDomisili())
                .setNoHP(domainObject.getNoHP())
                .setNoKTP(domainObject.getNoKTP())
                .setIpk(domainObject.getIpk())
                .setJenisKelaminType(domainObject.getJenisKelaminType())
                .setPendidikanType(domainObject.getPendidikanType())
                .setNamaCivitas(domainObject.getNamaCivitas())
                .setMinat(domainObject.getMinat())
                .setKetrampilan1(domainObject.getKetrampilan1())
                .setKetrampilan2(domainObject.getKetrampilan2())
                .setKetrampilan3(domainObject.getKetrampilan3())
                .setKetrampilan4(domainObject.getKetrampilan4())
                .setKetrampilan5(domainObject.getKetrampilan5())
                .setTingkat1(domainObject.getTingkat1())
                .setTingkat2(domainObject.getTingkat2())
                .setTingkat3(domainObject.getTingkat3())
                .setTingkat4(domainObject.getTingkat4())
                .setTingkat5(domainObject.getTingkat5())
                .setUploadCV(domainObject.getUploadCV())
                .setLowongansDTO(domainObject.getLowongans() == null ? Collections.EMPTY_LIST : lowonganDTOAssembler.toDTOs(domainObject.getLowongans()))
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getCreatedDate())
                .setStatusApprove(domainObject.getStatusApprove())
                .createMahasiswaDTO();
    }

    @Override
    public Mahasiswa toDomain(MahasiswaDTO dtoObject) {
        return new MahasiswaBuilder()
                .setIdMahasiswa(dtoObject.getIdMahasiswa())
                .setUsername(dtoObject.getUsername())
                .setPassword(dtoObject.getPassword())
                .setRetypedPassword(dtoObject.getRetypedPassword())
                .setNamaLengkap(dtoObject.getNamaLengkap())
                .setEmail(dtoObject.getEmail())
                .setTanggalLahir(dtoObject.getTanggalLahir())
                .setDomisili(dtoObject.getDomisili())
                .setNoHP(dtoObject.getNoHP())
                .setNoKTP(dtoObject.getNoKTP())
                .setIpk(dtoObject.getIpk())
                .setJenisKelaminType(dtoObject.getJenisKelaminType())
                .setPendidikanType(dtoObject.getPendidikanType())
                .setNamaCivitas(dtoObject.getNamaCivitas())
                .setMinat(dtoObject.getMinat())
                .setKetrampilan1(dtoObject.getKetrampilan1())
                .setKetrampilan2(dtoObject.getKetrampilan2())
                .setKetrampilan3(dtoObject.getKetrampilan3())
                .setKetrampilan4(dtoObject.getKetrampilan4())
                .setKetrampilan5(dtoObject.getKetrampilan5())
                .setTingkat1(dtoObject.getTingkat1())
                .setTingkat2(dtoObject.getTingkat2())
                .setTingkat3(dtoObject.getTingkat3())
                .setTingkat4(dtoObject.getTingkat4())
                .setTingkat5(dtoObject.getTingkat5())
                .setUploadCV(dtoObject.getUploadCV())
                .setLowongans(dtoObject.getLowongansDTO() == null ? Collections.EMPTY_LIST : lowonganDTOAssembler.toDomains(dtoObject.getLowongansDTO()))
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getCreatedDate())
                .setStatusApprove(dtoObject.getStatusApprove())
                .createMahasiswa();
    }

    public List<MahasiswaDTO> mDomain2mDTO(List<Mahasiswa> arg0) {
        List<MahasiswaDTO> res = new ArrayList();
        if (arg0 != null) {
            for (Mahasiswa o : arg0) {
                res.add(toDTO(o));
            }
        }
        return res;
    }

    public List<Lowongan> lDTO2lDomain(List<LowonganDTO> arg0) {
        List<Lowongan> res = new ArrayList<>();
        if (arg0 != null) {
            for (LowonganDTO o : arg0) {
                Lowongan lowongan = lowonganRepository.findByID(o.getIdLowongan());
                if (lowongan == null) {
                    lowongan = lowonganDTOAssembler.toDomain(o);
                } else {
                    lowongan.assignNewLowongan(lowonganDTOAssembler.toDomain(o));
                }
                res.add(lowongan);
            }

        }
        return res;
    }

    public List<LowonganDTO> lDomain2lDTO(List<Lowongan> arg0) {
        List<LowonganDTO> res = new ArrayList<>();
        if (arg0 != null) {
            for (Lowongan o : arg0) {
                res.add(new LowonganDTOAssembler().toDTO(o));
            }

        }
        return res;
    }
}
