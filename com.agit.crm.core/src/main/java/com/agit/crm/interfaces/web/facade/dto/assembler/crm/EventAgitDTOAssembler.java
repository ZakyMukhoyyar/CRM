package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.common.dto.crm.EventAgitDTOBuilder;
import com.agit.crm.domain.crm.EventAgit;
import com.agit.crm.domain.crm.EventAgitBuilder;
import com.agit.crm.domain.crm.EventAgitRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class EventAgitDTOAssembler implements IObjectAssembler<EventAgit, EventAgitDTO> {
    
    private EventAgitRepository eventAgitRepository;
    private EventAgitDTOAssembler eventAgitDTOAssembler;

    public void setEventAgitRepository(EventAgitRepository eventAgitRepository) {
        this.eventAgitRepository = eventAgitRepository;
    }

    public void setEventAgitDTOAssembler(EventAgitDTOAssembler eventAgitDTOAssembler) {
        this.eventAgitDTOAssembler = eventAgitDTOAssembler;
    }

    @Override
    public EventAgitDTO toDTO(EventAgit domainObject) {
        return new EventAgitDTOBuilder()
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
                .createEventAgitDTO();
    }

    @Override
    public EventAgit toDomain(EventAgitDTO dtoObject) {
        return new EventAgitBuilder()
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
                .createEventAgit();
    }
    
    public List<EventAgit> toDomains(List<EventAgitDTO> arg0) {
        List<EventAgit> res = new ArrayList<>();
        for (EventAgitDTO t : arg0) {
            res.add(new EventAgitDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<EventAgitDTO> toDTOs(List<EventAgit> arg0) {
        List<EventAgitDTO> res = new ArrayList<>();
        for (EventAgit t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
    
    
}
