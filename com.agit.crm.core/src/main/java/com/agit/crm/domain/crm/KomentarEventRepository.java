/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public interface KomentarEventRepository {
    void saveOrUpdate(KomentarEvent komentarEvent);

    void delete(KomentarEvent komentarEvent);

    KomentarEvent findByID(String komentarID);

    List<KomentarEvent> findAll();

    List<KomentarEvent> findByParams(Map map);

    List<KomentarEvent> findAllByID(String idEvent);
}
