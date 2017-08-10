package com.agit.crm.application.impl;

import com.agit.crm.common.application.LowonganStatusService;
import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import com.agit.crm.domain.crm.LowonganStatus;
import com.agit.crm.domain.crm.LowonganStatusBuilder;
import com.agit.crm.domain.crm.LowonganStatusRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.LowonganStatusDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class LowonganStatusServiceImpl implements LowonganStatusService {

    private LowonganStatusRepository lowonganStatusRepository;
    private LowonganStatusDTOAssembler lowonganStatusDTOAssembler;

    public void setLowonganStatusRepository(LowonganStatusRepository lowonganStatusRepository) {
        this.lowonganStatusRepository = lowonganStatusRepository;
    }

    public void setLowonganStatusDTOAssembler(LowonganStatusDTOAssembler lowonganStatusDTOAssembler) {
        this.lowonganStatusDTOAssembler = lowonganStatusDTOAssembler;
    }

    @Override
    public void saveOrUpdate(LowonganStatusDTO lowonganStatusDTO) {
        LowonganStatus ls = lowonganStatusRepository.findByID(lowonganStatusDTO.getIdLowonganStatus());
        if (ls == null) {
            ls = lowonganStatusDTOAssembler.toDomain(lowonganStatusDTO);
        } else {
            LowonganStatus newLowonganStatus = lowonganStatusDTOAssembler.toDomain(lowonganStatusDTO);
            ls.assignNewLowonganStatus(newLowonganStatus);
        }
        lowonganStatusRepository.saveOrUpdate(ls);
    }

    @Override
    public void deleteData(LowonganStatusDTO lowonganStatusDTO) {
        LowonganStatus ls = lowonganStatusDTOAssembler.toDomain(lowonganStatusDTO);
        lowonganStatusRepository.deleteData(ls);
    }

    @Override
    public LowonganStatusDTO findByID(String idLowonganStatus) {
        Validate.notNull(lowonganStatusRepository);
        LowonganStatus b = lowonganStatusRepository.findByID(idLowonganStatus);
        if (b != null) {
            return lowonganStatusDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<LowonganStatusDTO> findAll() {
        Validate.notNull(lowonganStatusRepository);
        return lowonganStatusDTOAssembler.toDTOs(lowonganStatusRepository.findAll());
    }

    @Override
    public List<LowonganStatusDTO> findByParams(Map map) {
        Validate.notNull(lowonganStatusRepository);
        List<LowonganStatus> listLowonganStatus = lowonganStatusRepository.findByParams(map);
        if (listLowonganStatus != null) {
            return (List<LowonganStatusDTO>) lowonganStatusDTOAssembler.toDTOs(listLowonganStatus);
        }
        return null;
    }

    @Override
    public LowonganStatusDTO getDummy() {
        LowonganStatus lowonganStatus = new LowonganStatusBuilder()
                .setIdUser("USER001")
                .setIdLowongan("LOW001")
                .setIdLowonganStatus("LS001")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("SYSTEM")
                .setCreatedDate(new Date())
                .setModifiedBy("SYSTEM")
                .setModifiedDate(new Date())
                .createLowonganStatus();
        return lowonganStatusDTOAssembler.toDTO(lowonganStatus);
    }

    @Override
    public List<LowonganStatusDTO> findByParams2(Map map2) {
        Validate.notNull(lowonganStatusRepository);
        List<LowonganStatus> listLowonganStatus = lowonganStatusRepository.findByParams2(map2);
        if (listLowonganStatus != null) {
            return (List<LowonganStatusDTO>) lowonganStatusDTOAssembler.toDTOs(listLowonganStatus);
        }
        return null;
    }

}
