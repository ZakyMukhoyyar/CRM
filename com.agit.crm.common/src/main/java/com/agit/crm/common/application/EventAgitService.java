package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface EventAgitService {
    
    void SaveOrUpdate(EventAgitDTO eventAgit);

    void deleteData(EventAgitDTO eventAgit);

    EventAgitDTO getDummyData();

    EventAgitDTO findByID(String idEvent);

    List<EventAgitDTO> findAll();

    List<EventAgitDTO> findByParams(Map map);
    
    List<EventAgitDTO> findAllByStatus(Status status);
    
    /* service untuk update status */
    void eventScheduler();
}
