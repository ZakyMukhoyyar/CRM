package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTOBuilder;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class RiwayatApplyMahasiswaDTOAssembler implements IObjectAssembler<RiwayatApplyMahasiswa, RiwayatApplyMahasiswaDTO> {
    
    @Override
    public RiwayatApplyMahasiswaDTO toDTO(RiwayatApplyMahasiswa domainObject) {
        return new RiwayatApplyMahasiswaDTOBuilder()
                .setIdRiwayatApplyMahasiswa(domainObject.getIdRiwayatApplyMahasiswa())
                .setIdRiwayatLowongan(domainObject.getIdRiwayatLowongan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setIdUserRiwayat(domainObject.getIdUserRiwayat())
                .setNamaLowonganApply(domainObject.getNamaLowonganApply())
                .setNamaApplyLowongan(domainObject.getNamaApplyLowongan())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setLowonganState(domainObject.getLowonganState())
                .createRiwayatApplyMahasiswaDTO();
    }
    
    @Override
    public RiwayatApplyMahasiswa toDomain(RiwayatApplyMahasiswaDTO dtoObject) {
        return new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa(dtoObject.getIdRiwayatApplyMahasiswa())
                .setIdRiwayatLowongan(dtoObject.getIdRiwayatLowongan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setIdUserRiwayat(dtoObject.getIdUserRiwayat())
                .setNamaLowonganApply(dtoObject.getNamaLowonganApply())
                .setNamaApplyLowongan(dtoObject.getNamaApplyLowongan())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setLowonganState(dtoObject.getLowonganState())
                .createRiwayatApplyMahasiswa();
    }
    
    public List<RiwayatApplyMahasiswa> toDomains(List<RiwayatApplyMahasiswaDTO> arg0) {
        List<RiwayatApplyMahasiswa> res = new ArrayList<>();
        for (RiwayatApplyMahasiswaDTO t : arg0) {
            res.add(new RiwayatApplyMahasiswaDTOAssembler().toDomain(t));
        }
        return res;
    }
    
    public List<RiwayatApplyMahasiswaDTO> toDTOs(List<RiwayatApplyMahasiswa> arg0) {
        List<RiwayatApplyMahasiswaDTO> res = new ArrayList<>();
        for (RiwayatApplyMahasiswa t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
}
