package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface JurusanService {

    void SaveOrUpdate(JurusanDTO jurusan);

    void deleteData(JurusanDTO jurusan);

    JurusanDTO getDummyData();

    JurusanDTO findByID(String idJurusan);

    List<JurusanDTO> findAll();

    List<JurusanDTO> findByParams(Map map);

    List<JurusanDTO> findAllByStatus(Status status);
}
