package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
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

    List<Domisili> findAllByStatus(Status status);

}
