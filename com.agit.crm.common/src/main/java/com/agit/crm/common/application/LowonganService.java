package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface LowonganService {

    void SaveOrUpdate(LowonganDTO lowongan);

    void deleteData(LowonganDTO lowongan);

    LowonganDTO getDummyData();

    LowonganDTO findByID(String idLowongan);

    List<LowonganDTO> findAll();

    List<LowonganDTO> findByParams(Map map);

    LowonganDTO findByIDUser(String userID);

    List<LowonganDTO> findAllByStatus(Status status);

    /* service untuk update status */
    void eventScheduler();

}
