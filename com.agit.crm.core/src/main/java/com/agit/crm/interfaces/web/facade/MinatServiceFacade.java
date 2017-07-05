package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.MinatDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaky
 */
public interface MinatServiceFacade {    

    ResponseEntity<Void> submitMinat(MinatDTO minatDTO);

    ResponseEntity<Void> deleteMinat(MinatDTO minatDTO);

    ResponseEntity<MinatDTO> findByID(String idMinat);

    ResponseEntity<List<MinatDTO>> findAll();

    ResponseEntity<List<MinatDTO>> findByParams(Map map);
}
