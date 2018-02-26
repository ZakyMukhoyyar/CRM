/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.application;

import com.agit.crm.common.dto.storing.fi.card.poc.StoringFICardPOCDTO;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public interface StoringFICardPOCService {

    void SaveOrUpdate(StoringFICardPOCDTO storingFICardPOC);

    void deleteData(StoringFICardPOCDTO storingFICard);

    StoringFICardPOCDTO findByID(String storingFICardPocID);

    List<StoringFICardPOCDTO> findAll();

    void eventStoringPOCScheduler();
}
