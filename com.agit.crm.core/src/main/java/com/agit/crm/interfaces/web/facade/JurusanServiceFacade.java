package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.JurusanDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaky
 */
public interface JurusanServiceFacade {

    ResponseEntity<Void> submitJurusan(JurusanDTO jurusanDTO);

    ResponseEntity<Void> deleteJurusan(JurusanDTO jurusanDTO);

    ResponseEntity<JurusanDTO> findByID(String idJurusan);

    ResponseEntity<List<JurusanDTO>> findAll();

    ResponseEntity<List<JurusanDTO>> findByParams(Map map);
    
}
