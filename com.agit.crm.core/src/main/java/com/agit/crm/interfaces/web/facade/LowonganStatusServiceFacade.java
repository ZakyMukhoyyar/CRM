package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaky
 */
public interface LowonganStatusServiceFacade {

    ResponseEntity<Void> submitLowonganStatus(LowonganStatusDTO lowonganStatusDTO);

    ResponseEntity<Void> deleteLowonganStatus(LowonganStatusDTO lowonganStatusDTO);

    ResponseEntity<LowonganStatusDTO> findByID(String idLowonganStatus);

    ResponseEntity<List<LowonganStatusDTO>> findAll();

    ResponseEntity<List<LowonganStatusDTO>> findByParams(Map map);
        
}
