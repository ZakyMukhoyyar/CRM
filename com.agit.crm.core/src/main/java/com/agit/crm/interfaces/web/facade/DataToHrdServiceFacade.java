package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.DataToHrdDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaky
 */
public interface DataToHrdServiceFacade {
    
    ResponseEntity<Void> submitDataToHrd(DataToHrdDTO dataToHrdDTO);
    
    ResponseEntity<Void> deleteDataToHrd(DataToHrdDTO dataToHrdDTO);
    
    ResponseEntity<DataToHrdDTO> findByID(String idLowonganHrd);
    
    ResponseEntity<List<DataToHrdDTO>> findAll();
    
    ResponseEntity<List<DataToHrdDTO>> findByParams(Map map);
    
}
