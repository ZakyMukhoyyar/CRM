package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.CivitasDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author 3AD
 */
public interface CivitasServiceFacade {

    ResponseEntity<Void> submitCivitas(CivitasDTO civitasDTO);

    ResponseEntity<Void> deleteCivitas(CivitasDTO civitasDTO);

    ResponseEntity<CivitasDTO> findByID(String civitasID);

    ResponseEntity<List<CivitasDTO>> findAll();

    ResponseEntity<List<CivitasDTO>> findByParams(Map map);
}
