package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.crm.CivitasDTOBuilder;
import com.agit.crm.domain.crm.Civitas;
import com.agit.crm.domain.crm.CivitasBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3AD
 */
public class CivitasDTOAssembler implements IObjectAssembler<Civitas, CivitasDTO> {

    @Override
    public CivitasDTO toDTO(Civitas domainObject) {
        return new CivitasDTOBuilder()
                .setCivitasID(domainObject.getCivitasID())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setNamaCivitas(domainObject.getNamaCivitas())
                .setStatus(domainObject.getStatus())
                .setUploadCivitas(domainObject.getUploadCivitas())
                .createCivitasDTO();
    }

    @Override
    public Civitas toDomain(CivitasDTO dtoObject) {
        return new CivitasBuilder()
                .setCivitasID(dtoObject.getCivitasID())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setNamaCivitas(dtoObject.getNamaCivitas())
                .setStatus(dtoObject.getStatus())
                .setUploadCivitas(dtoObject.getUploadCivitas())
                .createCivitas();
    }

    public List<Civitas> toDomains(List<CivitasDTO> arg0) {
        List<Civitas> res = new ArrayList<>();
        for (CivitasDTO t : arg0) {
            res.add(new CivitasDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<CivitasDTO> toDTOs(List<Civitas> arg0) {
        List<CivitasDTO> res = new ArrayList<>();
        for (Civitas t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }
}
