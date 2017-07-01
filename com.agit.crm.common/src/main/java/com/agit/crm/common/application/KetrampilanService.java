package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.KetrampilanDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface KetrampilanService {
    
    void SaveOrUpdate(KetrampilanDTO Ketrampilan);

    void deleteData(KetrampilanDTO Ketrampilan);

    KetrampilanDTO getDummyData();

    KetrampilanDTO findByID(String idKetrampilan);

    List<KetrampilanDTO> findAll();

    List<KetrampilanDTO> findByParams(Map map);
}
