package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.EventStatusDTO;
import com.agit.crm.common.dto.crm.EventStatusDTOBuilder;
import com.agit.crm.domain.crm.EventStatus;
import com.agit.crm.domain.crm.EventStatusBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class EventStatusDTOAssembler implements IObjectAssembler<EventStatus, EventStatusDTO>{

    @Override
    public EventStatusDTO toDTO(EventStatus domainObject) {
        return new EventStatusDTOBuilder()
                .setIdEventStatus(domainObject.getIdEventStatus())
                .setIdEvent(domainObject.getIdEvent())
                .setIdUser(domainObject.getIdUser())
                .setLowonganState(domainObject.getLowonganState())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createEventStatusDTO();
    }

    @Override
    public EventStatus toDomain(EventStatusDTO dtoObject) {
        return new EventStatusBuilder()
                .setIdEventStatus(dtoObject.getIdEventStatus())
                .setIdEvent(dtoObject.getIdEvent())
                .setIdUser(dtoObject.getIdUser())
                .setLowonganState(dtoObject.getLowonganState())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createEventStatus();
    }
    
    public List<EventStatus> toDomains(List<EventStatusDTO> arg0) {
        List<EventStatus> res = new ArrayList<>();
        for (EventStatusDTO t : arg0) {
            res.add(new EventStatusDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<EventStatusDTO> toDTOs(List<EventStatus> arg0) {
        List<EventStatusDTO> res = new ArrayList<>();
        for (EventStatus t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
    
}
