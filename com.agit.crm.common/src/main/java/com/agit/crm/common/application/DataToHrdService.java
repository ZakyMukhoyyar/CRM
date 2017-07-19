package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.DataToHrdDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface DataToHrdService {
    
    void saveOrUpdate(DataToHrdDTO dataToHrd);
    
    void deleteData(DataToHrdDTO dataToHrd);
    
    DataToHrdDTO findByID(String idLowonganHrd);
    
    List<DataToHrdDTO> findAll();
    
    List<DataToHrdDTO> findByParams(Map map);
    
    DataToHrdDTO getDummy();
    
}
