package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import com.agit.crm.common.dto.crm.LowonganStatusDTOBuilder;
import com.agit.crm.domain.crm.LowonganStatus;
import com.agit.crm.domain.crm.LowonganStatusBuilder;
import com.agit.crm.domain.crm.LowonganStatusRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class LowonganStatusDTOAssembler implements IObjectAssembler<LowonganStatus, LowonganStatusDTO>{
    
    private LowonganStatusRepository lowonganStatusRepository;
    private LowonganStatusDTOAssembler lowonganStatusDTOAssembler;

    public void setLowonganStatusRepository(LowonganStatusRepository lowonganStatusRepository) {
        this.lowonganStatusRepository = lowonganStatusRepository;
    }

    public void setLowonganStatusDTOAssembler(LowonganStatusDTOAssembler lowonganStatusDTOAssembler) {
        this.lowonganStatusDTOAssembler = lowonganStatusDTOAssembler;
    }

    @Override
    public LowonganStatusDTO toDTO(LowonganStatus domainObject) {
        return new LowonganStatusDTOBuilder()
                .setIdLowonganStatus(domainObject.getIdLowonganStatus())
                .setLowonganState(domainObject.getLowonganState())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createLowonganStatusDTO();
    }

    @Override
    public LowonganStatus toDomain(LowonganStatusDTO dtoObject) {
        return new LowonganStatusBuilder()
                .setIdLowonganStatus(dtoObject.getIdLowonganStatus())
                .setLowonganState(dtoObject.getLowonganState())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createLowonganStatus();
    }
    
    public List<LowonganStatus> toDomains(List<LowonganStatusDTO> arg0){
        List<LowonganStatus> res = new ArrayList<>();
        for(LowonganStatusDTO ls : arg0){
            res.add(new LowonganStatusDTOAssembler().toDomain(ls));
        }
        return res;
    }
    
    public List<LowonganStatusDTO> toDTOs(List<LowonganStatus> arg0){
        List<LowonganStatusDTO> res = new ArrayList<>();
        for(LowonganStatus ls : arg0){
            res.add(this.toDTO(ls));
        }
        return res;
    }
    
    
}
