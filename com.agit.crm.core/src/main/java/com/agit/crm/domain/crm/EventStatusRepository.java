package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface EventStatusRepository {
    
    void saveOrUpdate (EventStatus eventStatus);
    
    void deleteData (EventStatus eventStatus);
    
    EventStatus findByID(String idEventStatus);

    List<EventStatus> findAll();

    List<EventStatus> findByParams(Map map);

    List<EventStatus> findByParams2(Map map2);
}
