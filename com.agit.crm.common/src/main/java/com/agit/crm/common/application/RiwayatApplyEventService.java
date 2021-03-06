package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.shared.state.LowonganState;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface RiwayatApplyEventService {

    void saveOrUpdate(RiwayatApplyEventDTO riwayatApplyEvent);

    void delete(RiwayatApplyEventDTO riwayatApplyEvent);

    RiwayatApplyEventDTO findByID(String idRiwayatApplyEvent);

    List<RiwayatApplyEventDTO> findAll();

    List<RiwayatApplyEventDTO> findByParams(Map map);

    RiwayatApplyEventDTO getDummy();

    List<RiwayatApplyEventDTO> findAllByStatus(String idRiwayatEvent, LowonganState lowonganState);

    List<RiwayatApplyEventDTO> findIdEvent(String idRiwayatEvent);

}
