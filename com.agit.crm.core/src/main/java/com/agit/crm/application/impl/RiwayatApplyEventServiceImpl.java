package com.agit.crm.application.impl;

import com.agit.crm.common.application.RiwayatApplyEventService;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTOBuilder;
import com.agit.crm.domain.crm.RiwayatApplyEvent;
import com.agit.crm.domain.crm.RiwayatApplyEventRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.RiwayatApplyEventDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author 3AD
 */
public class RiwayatApplyEventServiceImpl implements RiwayatApplyEventService {

    private RiwayatApplyEventRepository riwayatApplyEventRepository;
    private RiwayatApplyEventDTOAssembler riwayatApplyEventDTOAssembler;

    public void setRiwayatApplyEventRepository(RiwayatApplyEventRepository riwayatApplyEventRepository) {
        this.riwayatApplyEventRepository = riwayatApplyEventRepository;
    }

    public void setRiwayatApplyEventDTOAssembler(RiwayatApplyEventDTOAssembler riwayatApplyEventDTOAssembler) {
        this.riwayatApplyEventDTOAssembler = riwayatApplyEventDTOAssembler;
    }

    @Override
    public void saveOrUpdate(RiwayatApplyEventDTO riwayatApplyEvent) {
        RiwayatApplyEvent t = riwayatApplyEventRepository.findByID(riwayatApplyEvent.getIdRiwayatApplyEvent());

        if (t == null) {
            t = riwayatApplyEventDTOAssembler.toDomain(riwayatApplyEvent);
        } else {
            RiwayatApplyEvent newRiwayat = riwayatApplyEventDTOAssembler.toDomain(riwayatApplyEvent);
            t.assignNewRiwayatEvent(newRiwayat);

        }
        riwayatApplyEventRepository.saveOrUpdate(t);
    }

    @Override
    public void delete(RiwayatApplyEventDTO riwayatApplyEvent) {
        RiwayatApplyEvent p = riwayatApplyEventDTOAssembler.toDomain(riwayatApplyEvent);
        riwayatApplyEventRepository.delete(p);
    }

    @Override
    public RiwayatApplyEventDTO findByID(String idRiwayatApplyEvent) {
        Validate.notNull(riwayatApplyEventRepository);
        RiwayatApplyEvent b = (RiwayatApplyEvent) riwayatApplyEventRepository.findByID(idRiwayatApplyEvent);
        if (b != null) {
            return riwayatApplyEventDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<RiwayatApplyEventDTO> findAll() {
        Validate.notNull(riwayatApplyEventRepository);
        return riwayatApplyEventDTOAssembler.toDTOs(riwayatApplyEventRepository.findAll());
    }

    @Override
    public List<RiwayatApplyEventDTO> findByParams(Map map) {
        Validate.notNull(riwayatApplyEventRepository);
        List<RiwayatApplyEvent> listRiwayatApplyEvent = riwayatApplyEventRepository.findByParams(map);
        if (listRiwayatApplyEvent != null) {
            return (List<RiwayatApplyEventDTO>) riwayatApplyEventDTOAssembler.toDTOs(listRiwayatApplyEvent);
        }
        return null;
    }

    @Override
    public RiwayatApplyEventDTO getDummy() {
        return new RiwayatApplyEventDTOBuilder()
                .setIdRiwayatApplyEvent("RAE0001")
                .setIdRiwayatEvent("EVT01")
                .setIdUserRiwayat("USER001")
                .setNamaPelamar("Peserta")
                .setNamaEvent("Bootcamp Ke-1")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("SYSTEM")
                .setCreatedDate(new Date())
                .setModifiedBy("SYSTEM")
                .setModifiedDate(new Date())
                .createRiwayatApplyEventDTO();
    }

}
