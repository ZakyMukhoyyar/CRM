package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface EventRepository {
    
    void saveOrUpdate (Event event);
    
    void deleteData (Event event);
    
    Event findByID(String idEvent);
    
    List<Event> findAll();
    
    List<Event> findByParams(Map map);
    
}
