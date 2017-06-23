package com.agit.crm.application.impl;

import com.agit.crm.common.application.EventService;
import com.agit.crm.common.dto.crm.EventDTO;
import com.agit.crm.domain.crm.Event;
import com.agit.crm.domain.crm.EventBuilder;
import com.agit.crm.domain.crm.EventRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.EventDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class EventServiceImpl implements EventService {
    
    private EventRepository eventRepository;
    private EventDTOAssembler eventDTOAssembler;

    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void setEventDTOAssembler(EventDTOAssembler eventDTOAssembler) {
        this.eventDTOAssembler = eventDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(EventDTO event) {
        Event t = eventRepository.findByID(event.getIdEvent());

        if (t == null) {
            t = eventDTOAssembler.toDomain(event);
        } else {
            Event newEvent = eventDTOAssembler.toDomain(event);
            t.assignNewEvent(newEvent);

        }
        eventRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(EventDTO event) {
        Event p = eventDTOAssembler.toDomain(event);
        eventRepository.deleteData(p);
    }

    @Override
    public EventDTO getDummyData() {
        Event event = new EventBuilder()
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
                .setStatus(true)
                .createEvent();
        return eventDTOAssembler.toDTO(event);
    }

    @Override
    public EventDTO findByID(String idEvent) {
        Validate.notNull(eventRepository);
        Event b = (Event) eventRepository.findByID(idEvent);
        if (b != null) {
            return eventDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<EventDTO> findAll() {
        Validate.notNull(eventRepository);
        return eventDTOAssembler.toDTOs(eventRepository.findAll());
    }

    @Override
    public List<EventDTO> findByParams(Map map) {
        Validate.notNull(eventRepository);
        List<Event> listEvent = eventRepository.findByParams(map);
        if (listEvent != null) {
            return (List<EventDTO>) eventDTOAssembler.toDTOs(listEvent);
        }
        return null;
    }
    
    
    
}
