package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.common.dto.crm.KetrampilanDTOBuilder;
import com.agit.crm.domain.crm.Ketrampilan;
import com.agit.crm.domain.crm.KetrampilanBuilder;
import com.agit.crm.domain.crm.KetrampilanRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import com.agit.crm.shared.status.Status;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class KetrampilanDTOAssembler implements IObjectAssembler<Ketrampilan, KetrampilanDTO>{
    
    private KetrampilanRepository ketrampilanRepository;
    private KetrampilanDTOAssembler ketrampilanDTOAssembler;

    public void setKetrampilanRepository(KetrampilanRepository ketrampilanRepository) {
        this.ketrampilanRepository = ketrampilanRepository;
    }

    public void setKetrampilanDTOAssembler(KetrampilanDTOAssembler ketrampilanDTOAssembler) {
        this.ketrampilanDTOAssembler = ketrampilanDTOAssembler;
    }

    @Override
    public KetrampilanDTO toDTO(Ketrampilan domainObject) {
        return new KetrampilanDTOBuilder()
                .setIdKetrampilan(domainObject.getIdKetrampilan())
                .setNamaKetrampilan(domainObject.getNamaKetrampilan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setStatus(Status.ACTIVE)
                .createKetrampilanDTO();
    }

    @Override
    public Ketrampilan toDomain(KetrampilanDTO dtoObject) {
        return new KetrampilanBuilder()
                .setIdKetrampilan(dtoObject.getIdKetrampilan())
                .setNamaKetrampilan(dtoObject.getNamaKetrampilan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setStatus(Status.ACTIVE)
                .createKetrampilan();
    }
    
    public List<Ketrampilan> toDomains(List<KetrampilanDTO> arg0) {
        List<Ketrampilan> res = new ArrayList<>();
        for (KetrampilanDTO t : arg0) {
            res.add(new KetrampilanDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<KetrampilanDTO> toDTOs(List<Ketrampilan> arg0) {
        List<KetrampilanDTO> res = new ArrayList<>();
        for (Ketrampilan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
}
