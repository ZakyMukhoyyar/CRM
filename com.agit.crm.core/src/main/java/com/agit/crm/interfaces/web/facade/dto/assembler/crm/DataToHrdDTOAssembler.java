package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.DataToHrdDTO;
import com.agit.crm.common.dto.crm.DataToHrdDTOBuilder;
import com.agit.crm.domain.crm.DataToHrd;
import com.agit.crm.domain.crm.DataToHrdBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class DataToHrdDTOAssembler implements IObjectAssembler<DataToHrd, DataToHrdDTO>{

    @Override
    public DataToHrdDTO toDTO(DataToHrd domainObject) {
        return new DataToHrdDTOBuilder()
                .setIdLowonganHrd(domainObject.getIdLowonganHrd())
                .setNamaLowonganHrd(domainObject.getNamaLowonganHrd())
                .setHasilSeleksi(domainObject.getHasilSeleksi())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createDataToHrdDTO();
    }

    @Override
    public DataToHrd toDomain(DataToHrdDTO dtoObject) {
        return new DataToHrdBuilder()
                .setIdLowonganHrd(dtoObject.getIdLowonganHrd())
                .setNamaLowonganHrd(dtoObject.getNamaLowonganHrd())
                .setHasilSeleksi(dtoObject.getHasilSeleksi())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createDataToHrd();
    }
    
    public List<DataToHrd> toDomains(List<DataToHrdDTO> arg0) {
        List<DataToHrd> res = new ArrayList<>();
        for (DataToHrdDTO t : arg0) {
            res.add(new DataToHrdDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<DataToHrdDTO> toDTOs(List<DataToHrd> arg0) {
        List<DataToHrdDTO> res = new ArrayList<>();
        for (DataToHrd t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }
    
    
}
