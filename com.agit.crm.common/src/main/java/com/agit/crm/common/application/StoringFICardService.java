/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.application;

import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BayuHS
 */
public interface StoringFICardService {

    void SaveOrUpdate(StoringFICardDTO storingFICard);

    void deleteData(StoringFICardDTO storingFICard);

    StoringFICardDTO getDummyData();

    StoringFICardDTO findByID(String storingFICardID);

    List<StoringFICardDTO> findAll();

    List<StoringFICardDTO> findByParams(Map map);

    void eventScheduler();
}
