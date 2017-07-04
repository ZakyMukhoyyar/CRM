/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.KetrampilanDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author 3AD
 */
public interface KetrampilanServiceFacade {

    ResponseEntity<Void> submitKetrampilan(KetrampilanDTO ketrampilanDTO);

    ResponseEntity<Void> deleteKetrampilan(KetrampilanDTO ketrampilanDTO);

    ResponseEntity<KetrampilanDTO> findByID(String idKetrampilan);

    ResponseEntity<List<KetrampilanDTO>> findAll();

    ResponseEntity<List<KetrampilanDTO>> findByParams(Map map);
}
