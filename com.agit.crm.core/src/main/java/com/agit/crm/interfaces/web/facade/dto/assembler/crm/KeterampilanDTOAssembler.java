package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.KeterampilanDTO;
import com.agit.crm.common.dto.crm.KeterampilanDTOBuilder;
import com.agit.crm.domain.crm.Keterampilan;
import com.agit.crm.domain.crm.KeterampilanBuilder;
import com.agit.crm.domain.crm.KeterampilanRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class KeterampilanDTOAssembler implements IObjectAssembler<Keterampilan, KeterampilanDTO>{
    
    private KeterampilanRepository keterampilanRepository;
    private KeterampilanDTOAssembler keterampilanDTOAssembler;

    public void setKeterampilanRepository(KeterampilanRepository keterampilanRepository) {
        this.keterampilanRepository = keterampilanRepository;
    }

    public void setKeterampilanDTOAssembler(KeterampilanDTOAssembler keterampilanDTOAssembler) {
        this.keterampilanDTOAssembler = keterampilanDTOAssembler;
    }

    @Override
    public KeterampilanDTO toDTO(Keterampilan domainObject) {
        return new KeterampilanDTOBuilder()
                .setIdKeterampilan(domainObject.getIdKeterampilan())
                .setNamaKeterampilan(domainObject.getNamaKeterampilan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createKeterampilanDTO();
    }

    @Override
    public Keterampilan toDomain(KeterampilanDTO dtoObject) {
        return new KeterampilanBuilder()
                .setIdKeterampilan(dtoObject.getIdKeterampilan())
                .setNamaKeterampilan(dtoObject.getNamaKeterampilan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createKeterampilan();
    }
    
    public List<Keterampilan> toDomains(List<KeterampilanDTO> arg0) {
        List<Keterampilan> res = new ArrayList<>();
        for (KeterampilanDTO t : arg0) {
            res.add(new KeterampilanDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<KeterampilanDTO> toDTOs(List<Keterampilan> arg0) {
        List<KeterampilanDTO> res = new ArrayList<>();
        for (Keterampilan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
}
