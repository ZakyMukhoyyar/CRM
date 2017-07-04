package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.EventAgitDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author 3AD
 */
public interface EventAgitServiceFacade {

    ResponseEntity<Void> submitMahasiswa(EventAgitDTO eventAgitDTO);

    ResponseEntity<Void> deleteMahasiswa(EventAgitDTO eventAgitDTO);

    ResponseEntity<EventAgitDTO> findByID(String idEventO);

    ResponseEntity<List<EventAgitDTO>> findAll();

    ResponseEntity<List<EventAgitDTO>> findByParams(Map map);
}
