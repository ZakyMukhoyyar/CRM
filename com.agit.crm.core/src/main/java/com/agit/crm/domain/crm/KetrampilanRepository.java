package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface KetrampilanRepository {
    
    void saveOrUpdate(Ketrampilan Ketrampilan);
    
    void deleteData(Ketrampilan Ketrampilan);
    
    Ketrampilan findByID(String idKetrampilan);
    
    List<Ketrampilan> findAll();
    
    List<Ketrampilan> findByParams(Map map);
    
}
