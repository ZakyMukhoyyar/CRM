package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface KetrampilanService {

    void SaveOrUpdate(KetrampilanDTO ketrampilan);

    void deleteData(KetrampilanDTO ketrampilan);

    KetrampilanDTO getDummyData();

    KetrampilanDTO findByID(String idKetrampilan);

    List<KetrampilanDTO> findAll();

    List<KetrampilanDTO> findByParams(Map map);

    List<KetrampilanDTO> findAllByStatus(Status status);
}
