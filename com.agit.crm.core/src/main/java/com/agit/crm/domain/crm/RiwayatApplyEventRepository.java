package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface RiwayatApplyEventRepository {

    void saveOrUpdate(RiwayatApplyEvent riwayatApplyEvent);

    void delete(RiwayatApplyEvent riwayatApplyEvent);

    RiwayatApplyEvent findByID(String idRiwayatApplyEvent);

    List<RiwayatApplyEvent> findAll();

    List<RiwayatApplyEvent> findByParams(Map map);
}
