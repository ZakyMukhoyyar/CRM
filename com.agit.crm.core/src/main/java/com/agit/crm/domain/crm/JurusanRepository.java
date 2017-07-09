package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface JurusanRepository {
    
    void saveOrUpdate(Jurusan jurusan);
    
    void deleteData (Jurusan jurusan);
    
    Jurusan findByID (String idJurusan);
    
    List<Jurusan> findAll();
    
    List<Jurusan> findByParams(Map map);
    
}
