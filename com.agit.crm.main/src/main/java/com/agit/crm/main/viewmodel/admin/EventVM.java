package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.EventService;
import com.agit.crm.common.dto.crm.EventDTO;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

/**
 *
 * @author 3AD
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class EventVM {

    @WireVariable
    EventService eventService;

    /* Object Binding UI CRM */
    private EventDTO eventDTO = new EventDTO();
    private List<EventDTO> eventDTOs = new ArrayList<>();

}
