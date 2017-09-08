package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.EventStatusDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface EventStatusService {

    EventStatusDTO getDummy();

    void saveOrUpdate(EventStatusDTO eventStatus);

    void deleteData(EventStatusDTO eventStatus);

    EventStatusDTO findByID(String idEventStatus);

    List<EventStatusDTO> findAll();

    List<EventStatusDTO> findByParams(Map map);

    List<EventStatusDTO> findByParams2(Map map2);

}
