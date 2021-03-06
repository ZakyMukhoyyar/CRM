package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface LowonganRepository {

    void saveOrUpdate(Lowongan lowongan);

    void deleteData(Lowongan lowongan);

    Lowongan findByID(String idLowongan);

    List<Lowongan> findAll();

    List<Lowongan> findByParams(Map map);

    List<Lowongan> findAllByStatus(Status status);

    Lowongan findByIDUser(String userID);
}
