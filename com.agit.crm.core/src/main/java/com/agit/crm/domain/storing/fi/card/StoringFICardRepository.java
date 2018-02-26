package com.agit.crm.domain.storing.fi.card;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface StoringFICardRepository {

    void saveOrUpdate(StoringFICard storingFICard);

    void deleteData(StoringFICard storingFICard);

    StoringFICard findByID(String storingFICardID);

    List<StoringFICard> findAll();

    List<StoringFICard> findByParams(Map map);

}
