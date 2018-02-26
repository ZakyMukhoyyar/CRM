package com.agit.crm.domain.storing.fi.card.poc;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface StoringFICardPOCRepository {

    void saveOrUpdate(StoringFICardPOC storingFICardPOC);

    void deleteData(StoringFICardPOC storingFICardPOC);

    StoringFICardPOC findByID(String storingFICardPocID);

    List<StoringFICardPOC> findAll();

    List<StoringFICardPOC> findByParams(Map map);

}
