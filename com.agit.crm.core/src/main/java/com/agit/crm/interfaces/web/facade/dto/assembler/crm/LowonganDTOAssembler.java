package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.LowonganDTOBuilder;
import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class LowonganDTOAssembler implements IObjectAssembler<Lowongan, LowonganDTO> {

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
}
