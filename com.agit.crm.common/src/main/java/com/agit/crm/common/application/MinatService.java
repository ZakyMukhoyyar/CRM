package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.MinatDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface MinatService {
    
    void SaveOrUpdate(MinatDTO minat);

    void deleteData(MinatDTO minat);

    MinatDTO getDummyData();

    MinatDTO findByID(String idMinat);

    List<MinatDTO> findAll();

    List<MinatDTO> findByParams(Map map);
    
}
