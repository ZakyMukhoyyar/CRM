package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface MinatRepository {

    void saveOrUpdate(Minat minat);

    void deleteData(Minat minat);

    Minat findByID(String idMinat);

    List<Minat> findAll();

    List<Minat> findByParams(Map map);

    List<Minat> findAllByStatus(Status status);

}
