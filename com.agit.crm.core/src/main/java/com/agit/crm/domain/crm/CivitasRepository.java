package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface CivitasRepository {

    void saveOrUpdate(Civitas civitas);

    void deleteData(Civitas civitas);

    Civitas findByID(String civitasID);

    List<Civitas> findAll();

    List<Civitas> findByParams(Map map);
    
    List<Civitas> findAllByStatus(Status status);
}
