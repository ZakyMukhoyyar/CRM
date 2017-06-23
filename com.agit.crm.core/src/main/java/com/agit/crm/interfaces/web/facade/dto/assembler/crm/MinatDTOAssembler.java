package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.common.dto.crm.MinatDTOBuilder;
import com.agit.crm.domain.crm.Minat;
import com.agit.crm.domain.crm.MinatBuilder;
import com.agit.crm.domain.crm.MinatRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class MinatDTOAssembler implements IObjectAssembler<Minat, MinatDTO>{
    
    private MinatRepository minatRepository;
    private MinatDTOAssembler minatDTOAssembler;

    public void setMinatRepository(MinatRepository minatRepository) {
        this.minatRepository = minatRepository;
    }

    public void setMinatDTOAssembler(MinatDTOAssembler minatDTOAssembler) {
        this.minatDTOAssembler = minatDTOAssembler;
    }

    @Override
    public MinatDTO toDTO(Minat domainObject) {
        return new MinatDTOBuilder()
                .setIdMinat(domainObject.getIdMinat())
                .setNamaMinat(domainObject.getNamaMinat())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setStatus(domainObject.getStatus())
                .createMinatDTO();
    }

    @Override
    public Minat toDomain(MinatDTO dtoObject) {
        return new MinatBuilder()
                .setIdMinat(dtoObject.getIdMinat())
                .setNamaMinat(dtoObject.getNamaMinat())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setStatus(dtoObject.getStatus())
                .createMinat();
    }
    
    public List<Minat> toDomains(List<MinatDTO> arg0) {
        List<Minat> res = new ArrayList<>();
        for (MinatDTO t : arg0) {
            res.add(new MinatDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<MinatDTO> toDTOs(List<Minat> arg0) {
        List<MinatDTO> res = new ArrayList<>();
        for (Minat t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
    
    
}
