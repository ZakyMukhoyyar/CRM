package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface DomisiliRepository {

    void saveOrUpdate(Domisili domisili);

    void deleteData(Domisili domisili);

    Domisili findByID(String idDomisili);

    List<Domisili> findAll();

    List<Domisili> findByParams(Map map);

}
