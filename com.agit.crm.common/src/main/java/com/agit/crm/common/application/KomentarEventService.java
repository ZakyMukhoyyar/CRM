/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.KomentarEventDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public interface KomentarEventService {
    void saveOrUpdate(KomentarEventDTO komentarEvent);

    void delete(KomentarEventDTO komentarEvent);

    KomentarEventDTO findByID(String komentarID);

    List<KomentarEventDTO> findAll();

    List<KomentarEventDTO> findByParams(Map map);

    KomentarEventDTO getDummy();

    List<KomentarEventDTO> findAllByID(String idEvent);
}
