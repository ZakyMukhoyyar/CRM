package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.EventDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface EventService {
    
    void SaveOrUpdate(EventDTO event);

    void deleteData(EventDTO event);

    EventDTO getDummyData();

    EventDTO findByID(String idEvent);

    List<EventDTO> findAll();

    List<EventDTO> findByParams(Map map);
}
