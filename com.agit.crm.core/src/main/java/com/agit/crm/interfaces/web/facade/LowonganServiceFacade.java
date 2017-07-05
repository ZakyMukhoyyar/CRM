package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.LowonganDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author 3AD
 */
public interface LowonganServiceFacade {

    ResponseEntity<Void> submitLowongan(LowonganDTO lowonganDTO);

    ResponseEntity<Void> deleteLowongan(LowonganDTO lowonganDTO);

    ResponseEntity<LowonganDTO> findByID(String idLowongan);

    ResponseEntity<List<LowonganDTO>> findAll();

    ResponseEntity<List<LowonganDTO>> findByParams(Map map);
}
