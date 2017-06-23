package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.KeterampilanDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface KeterampilanService {
    
    void SaveOrUpdate(KeterampilanDTO keterampilan);

    void deleteData(KeterampilanDTO keterampilan);

    KeterampilanDTO getDummyData();

    KeterampilanDTO findByID(String idKeterampilan);

    List<KeterampilanDTO> findAll();

    List<KeterampilanDTO> findByParams(Map map);
}
