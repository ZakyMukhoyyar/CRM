package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface CivitasService {

    void SaveOrUpdate(CivitasDTO civitas);

    void deleteData(CivitasDTO civitas);

    CivitasDTO getDummyData();

    CivitasDTO findByID(String civitasID);

    List<CivitasDTO> findAll();

    List<CivitasDTO> findByParams(Map map);

    List<CivitasDTO> findAllByStatus(Status status);
}
