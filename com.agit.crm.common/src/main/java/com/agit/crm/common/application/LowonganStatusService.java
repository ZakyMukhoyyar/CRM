package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface LowonganStatusService {

    void saveOrUpdate(LowonganStatusDTO lowonganStatusDTO);

    void deleteData(LowonganStatusDTO lowonganStatusDTO);

    LowonganStatusDTO findByID(String idLowonganStatus);

    List<LowonganStatusDTO> findAll();

    List<LowonganStatusDTO> findByParams(Map map);

    LowonganStatusDTO getDummy();

    LowonganStatusDTO findByIDUser(String idUser);
}
