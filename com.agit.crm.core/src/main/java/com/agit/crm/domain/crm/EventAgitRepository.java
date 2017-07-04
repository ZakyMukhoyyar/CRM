package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface EventAgitRepository {
    
    void saveOrUpdate (EventAgit eventAgit);
    
    void deleteData (EventAgit eventAgit);
    
    EventAgit findByID(String idEvent);
    
    List<EventAgit> findAll();
    
    List<EventAgit> findByParams(Map map);
    
}
