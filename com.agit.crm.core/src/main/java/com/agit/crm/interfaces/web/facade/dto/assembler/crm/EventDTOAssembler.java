package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.EventDTO;
import com.agit.crm.common.dto.crm.EventDTOBuilder;
import com.agit.crm.domain.crm.Event;
import com.agit.crm.domain.crm.EventBuilder;
import com.agit.crm.domain.crm.EventRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class EventDTOAssembler implements IObjectAssembler<Event, EventDTO> {
    
    private EventRepository eventRepository;
    private EventDTOAssembler eventDTOAssembler;

    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void setEventDTOAssembler(EventDTOAssembler eventDTOAssembler) {
        this.eventDTOAssembler = eventDTOAssembler;
    }

    @Override
    public EventDTO toDTO(Event domainObject) {
        return new EventDTOBuilder()
                .setIdEvent(domainObject.getIdEvent())
                .setNamaEvent(domainObject.getNamaEvent())
                .setDeskripsiEvent(domainObject.getDeskripsiEvent())
                .setStartDate(domainObject.getStartDate())
                .setEndDate(domainObject.getEndDate())
                .setAttachment(domainObject.getAttachment())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getCreatedDate())
                .setStatus(domainObject.getStatus())
                .createEventDTO();
    }

    @Override
    public Event toDomain(EventDTO dtoObject) {
        return new EventBuilder()
                .setIdEvent(dtoObject.getIdEvent())
                .setNamaEvent(dtoObject.getNamaEvent())
                .setDeskripsiEvent(dtoObject.getDeskripsiEvent())
                .setStartDate(dtoObject.getStartDate())
                .setEndDate(dtoObject.getEndDate())
                .setAttachment(dtoObject.getAttachment())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getCreatedDate())
                .setStatus(dtoObject.getStatus())
                .createEvent();
    }
    
    public List<Event> toDomains(List<EventDTO> arg0) {
        List<Event> res = new ArrayList<>();
        for (EventDTO t : arg0) {
            res.add(new EventDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<EventDTO> toDTOs(List<Event> arg0) {
        List<EventDTO> res = new ArrayList<>();
        for (Event t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
    
    
}
