package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface KeterampilanRepository {
    
    void saveOrUpdate(Keterampilan keterampilan);
    
    void deleteData(Keterampilan keterampilan);
    
    Keterampilan findByID(String idKeterampilan);
    
    List<Keterampilan> findAll();
    
    List<Keterampilan> findByParams(Map map);
    
}
