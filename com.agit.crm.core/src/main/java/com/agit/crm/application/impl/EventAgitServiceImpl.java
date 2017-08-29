package com.agit.crm.application.impl;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.domain.crm.EventAgit;
import com.agit.crm.domain.crm.EventAgitBuilder;
import com.agit.crm.domain.crm.EventAgitRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.EventAgitDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class EventAgitServiceImpl implements EventAgitService {

    private EventAgitRepository eventAgitRepository;
    private EventAgitDTOAssembler eventAgitDTOAssembler;

    public void setEventAgitRepository(EventAgitRepository eventAgitRepository) {
        this.eventAgitRepository = eventAgitRepository;
    }

    public void setEventAgitDTOAssembler(EventAgitDTOAssembler eventAgitDTOAssembler) {
        this.eventAgitDTOAssembler = eventAgitDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(EventAgitDTO eventAgit) {
        EventAgit t = eventAgitRepository.findByID(eventAgit.getIdEvent());

        if (t == null) {
            t = eventAgitDTOAssembler.toDomain(eventAgit);
        } else {
            EventAgit newEventAgit = eventAgitDTOAssembler.toDomain(eventAgit);
            t.assignNewEventAgit(newEventAgit);

        }
        eventAgitRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(EventAgitDTO eventAgit) {
        EventAgit p = eventAgitDTOAssembler.toDomain(eventAgit);
        eventAgitRepository.deleteData(p);
    }

    @Override
    public EventAgitDTO getDummyData() {
        EventAgit event = new EventAgitBuilder()
                .setIdEvent("11")
                .setNamaEvent("namaEvent")
                .setDeskripsiEvent("deskripsiEvent")
                .setStartDate(new Date())
                .setEndDate(new Date())
                .setAttachment("iniAttachment")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createEventAgit();
        return eventAgitDTOAssembler.toDTO(event);
    }

    @Override
    public EventAgitDTO findByID(String idEvent) {
        Validate.notNull(eventAgitRepository);
        EventAgit b = (EventAgit) eventAgitRepository.findByID(idEvent);
        if (b != null) {
            return eventAgitDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<EventAgitDTO> findAll() {
        Validate.notNull(eventAgitRepository);
        return eventAgitDTOAssembler.toDTOs(eventAgitRepository.findAll());
    }

    @Override
    public List<EventAgitDTO> findByParams(Map map) {
        Validate.notNull(eventAgitRepository);
        List<EventAgit> listEventAgit = eventAgitRepository.findByParams(map);
        if (listEventAgit != null) {
            return (List<EventAgitDTO>) eventAgitDTOAssembler.toDTOs(listEventAgit);
        }
        return null;
    }

    @Override
    public void eventScheduler() {
        List<EventAgit> list = eventAgitRepository.findAll();
        Date dateNow = new Date();
        int year = dateNow.getYear();
        int month = dateNow.getMonth();
        int date = dateNow.getDate();

        for (EventAgit evt : list) {
            int getEndDateDTO = evt.getEndDate().getDate() + 1;
            int getEndMonthDTO = evt.getEndDate().getMonth();
            int getEndYearDTO = evt.getEndDate().getYear();
            Date dateDTO = new Date(getEndYearDTO, getEndMonthDTO, getEndDateDTO);
            int compareDate = dateNow.compareTo(dateDTO);
            if (compareDate == 1) {
                evt.setStatus(Status.INACTIVE);
            } else {
                evt.setStatus(Status.ACTIVE);
            }
            eventAgitRepository.saveOrUpdate(evt);
        }
    }

}
