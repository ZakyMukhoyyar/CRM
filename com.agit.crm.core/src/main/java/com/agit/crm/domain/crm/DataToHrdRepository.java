package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface DataToHrdRepository {
    
    void saveOrUpdate(DataToHrd dataToHrd);
    
    void deleteData(DataToHrd dataToHrd);
    
    DataToHrd findByID(String idLowonganHrd);
    
    List<DataToHrd> findAll();
    
    List<DataToHrd> findByParams(Map map);
}
