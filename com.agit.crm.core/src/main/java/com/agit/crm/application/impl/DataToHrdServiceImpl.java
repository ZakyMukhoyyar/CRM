package com.agit.crm.application.impl;

import com.agit.crm.common.application.DataToHrdService;
import com.agit.crm.common.dto.crm.DataToHrdDTO;
import com.agit.crm.domain.crm.DataToHrd;
import com.agit.crm.domain.crm.DataToHrdBuilder;
import com.agit.crm.domain.crm.DataToHrdRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.DataToHrdDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class DataToHrdServiceImpl implements DataToHrdService {
    
    private DataToHrdRepository dataToHrdRepository;
    private DataToHrdDTOAssembler dataToHrdDTOAssembler;

    public void setDataToHrdRepository(DataToHrdRepository dataToHrdRepository) {
        this.dataToHrdRepository = dataToHrdRepository;
    }

    public void setDataToHrdDTOAssembler(DataToHrdDTOAssembler dataToHrdDTOAssembler) {
        this.dataToHrdDTOAssembler = dataToHrdDTOAssembler;
    }

    @Override
    public void saveOrUpdate(DataToHrdDTO dataToHrd) {
        DataToHrd t = dataToHrdRepository.findByID(dataToHrd.getIdLowonganHrd());

        if (t == null) {
            t = dataToHrdDTOAssembler.toDomain(dataToHrd);
        } else {
            DataToHrd newDataToHrd = dataToHrdDTOAssembler.toDomain(dataToHrd);
            t.assignNewDataToHrd(newDataToHrd);

        }
        dataToHrdRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(DataToHrdDTO dataToHrd) {
        DataToHrd p = dataToHrdDTOAssembler.toDomain(dataToHrd);
        dataToHrdRepository.deleteData(p);
    }

    @Override
    public DataToHrdDTO findByID(String idLowonganHrd) {
        Validate.notNull(dataToHrdRepository);
        DataToHrd b = (DataToHrd) dataToHrdRepository.findByID(idLowonganHrd);
        if (b != null) {
            return dataToHrdDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<DataToHrdDTO> findAll() {
        Validate.notNull(dataToHrdRepository);
        return dataToHrdDTOAssembler.toDTOs(dataToHrdRepository.findAll());
    }

    @Override
    public List<DataToHrdDTO> findByParams(Map map) {
        Validate.notNull(dataToHrdRepository);
        List<DataToHrd> listdataToHrd = dataToHrdRepository.findByParams(map);
        if (listdataToHrd != null) {
            return (List<DataToHrdDTO>) dataToHrdDTOAssembler.toDTOs(listdataToHrd);
        }
        return null;
    }

    @Override
    public DataToHrdDTO getDummy() {
        DataToHrd dataToHrd = new DataToHrdBuilder()
                .setIdLowonganHrd("AppLow001")
                .setNamaLowonganHrd("Test Lowongan")
                .setCreatedBy("HRD")
                .setCreatedDate(new Date())
                .setModifiedBy("HRDSecond")
                .setModifiedDate(new Date())
                .createDataToHrd();
        return dataToHrdDTOAssembler.toDTO(dataToHrd);
    }
    
    
    
}
