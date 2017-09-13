package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface DomisiliService {

    void SaveOrUpdate(DomisiliDTO domisili);

    void deleteData(DomisiliDTO domisili);

    DomisiliDTO getDummyData();

    DomisiliDTO findByID(String idDomisili);

    List<DomisiliDTO> findAll();

    List<DomisiliDTO> findByParams(Map map);

    List<DomisiliDTO> findAllByStatus(Status status);

}
