package com.agit.crm.domain.crm;

import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.shared.state.LowonganState;
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

    List<RiwayatApplyEvent> findAllByStatus(String idRiwayatEvent, LowonganState lowonganState);

    List<RiwayatApplyEvent> findIdEvent(String idRiwayatEvent);

}
