package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface KetrampilanRepository {

    void saveOrUpdate(Ketrampilan ketrampilan);

    void deleteData(Ketrampilan ketrampilan);

    Ketrampilan findByID(String idKetrampilan);

    List<Ketrampilan> findAll();

    List<Ketrampilan> findByParams(Map map);

    List<Ketrampilan> findAllByStatus(Status status);

}
