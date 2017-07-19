package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.common.dto.crm.DomisiliDTOBuilder;
import com.agit.crm.domain.crm.Domisili;
import com.agit.crm.domain.crm.Domisili;
import com.agit.crm.domain.crm.DomisiliBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3AD
 */
public class DomisiliDTOAssembler implements IObjectAssembler<Domisili, DomisiliDTO> {

    @Override
    public DomisiliDTO toDTO(Domisili domainObject) {
        return new DomisiliDTOBuilder()
                .setIdDomisili(domainObject.getIdDomisili())
                .setNamaProvinsi(domainObject.getNamaProvinsi())
                .setNamaKabupaten(domainObject.getNamaKabupaten())
                .setNamaKota(domainObject.getNamaKota())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createDomisiliDTO();
    }

    @Override
    public Domisili toDomain(DomisiliDTO dtoObject) {
        return new DomisiliBuilder()
                .setIdDomisili(dtoObject.getIdDomisili())
                .setNamaProvinsi(dtoObject.getNamaProvinsi())
                .setNamaKabupaten(dtoObject.getNamaKabupaten())
                .setNamaKota(dtoObject.getNamaKota())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createDomisili();
    }

    public List<Domisili> toDomains(List<DomisiliDTO> arg0) {
        List<Domisili> res = new ArrayList<>();
        for (DomisiliDTO t : arg0) {
            res.add(new DomisiliDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<DomisiliDTO> toDTOs(List<Domisili> arg0) {
        List<DomisiliDTO> res = new ArrayList<>();
        for (Domisili t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
