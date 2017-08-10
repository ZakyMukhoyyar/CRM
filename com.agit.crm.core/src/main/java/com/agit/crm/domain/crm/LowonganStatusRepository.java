package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface LowonganStatusRepository {

    void saveOrUpdate(LowonganStatus lowonganStatus);

    void deleteData(LowonganStatus lowonganStatus);

    LowonganStatus findByID(String idLowonganStatus);

    List<LowonganStatus> findAll();

    List<LowonganStatus> findByParams(Map map);

    List<LowonganStatus> findByParams2(Map map2);

}
