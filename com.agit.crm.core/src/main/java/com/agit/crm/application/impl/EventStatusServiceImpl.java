package com.agit.crm.application.impl;

import com.agit.crm.common.application.EventStatusService;
import com.agit.crm.common.dto.crm.EventStatusDTO;
import com.agit.crm.domain.crm.EventStatus;
import com.agit.crm.domain.crm.EventStatusBuilder;
import com.agit.crm.domain.crm.EventStatusRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.EventStatusDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class EventStatusServiceImpl implements EventStatusService {

    private EventStatusRepository eventStatusRepository;
    private EventStatusDTOAssembler eventStatusDTOAssembler;

    public void setEventStatusRepository(EventStatusRepository eventStatusRepository) {
        this.eventStatusRepository = eventStatusRepository;
    }

    public void setEventStatusDTOAssembler(EventStatusDTOAssembler eventStatusDTOAssembler) {
        this.eventStatusDTOAssembler = eventStatusDTOAssembler;
    }
    
    @Override
    public EventStatusDTO getDummy() {
        EventStatus eventStatus = new EventStatusBuilder()
                .setIdEventStatus("ES0001")
                .setIdEvent("EVT0001")
                .setIdUser("USER0001")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("SYSTEM")
                .setCreatedDate(new Date())
                .setModifiedBy("SYSTEM")
                .setModifiedDate(new Date())
                .createEventStatus();
        return eventStatusDTOAssembler.toDTO(eventStatus);
    }
    
    @Override
    public void saveOrUpdate(EventStatusDTO eventStatusDTO) {

        EventStatus ls = eventStatusRepository.findByID(eventStatusDTO.getIdEventStatus());
        if (ls == null) {
            ls = eventStatusDTOAssembler.toDomain(eventStatusDTO);
        } else {
            EventStatus newEventStatus = eventStatusDTOAssembler.toDomain(eventStatusDTO);
            ls.assignNewEventStatus(newEventStatus);
        }
        eventStatusRepository.saveOrUpdate(ls);
    }

    @Override
    public void deleteData(EventStatusDTO eventStatusDTO) {
        EventStatus ls = eventStatusDTOAssembler.toDomain(eventStatusDTO);
        eventStatusRepository.deleteData(ls);
    }

    @Override
    public EventStatusDTO findByID(String idEventStatus) {
        Validate.notNull(eventStatusRepository);
        EventStatus b = eventStatusRepository.findByID(idEventStatus);
        if (b != null) {
            return eventStatusDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<EventStatusDTO> findAll() {
        Validate.notNull(eventStatusRepository);
        return eventStatusDTOAssembler.toDTOs(eventStatusRepository.findAll());
    }

    @Override
    public List<EventStatusDTO> findByParams(Map map) {
        Validate.notNull(eventStatusRepository);
        List<EventStatus> listEventStatus = eventStatusRepository.findByParams(map);
        if (listEventStatus != null) {
            return (List<EventStatusDTO>) eventStatusDTOAssembler.toDTOs(listEventStatus);
        }
        return null;
    }

    @Override
    public List<EventStatusDTO> findByParams2(Map map2) {
        Validate.notNull(eventStatusRepository);
        List<EventStatus> listEventStatus = eventStatusRepository.findByParams2(map2);
        if (listEventStatus != null) {
            return (List<EventStatusDTO>) eventStatusDTOAssembler.toDTOs(listEventStatus);
        }
        return null;
    }

}
