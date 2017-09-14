/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.application.impl;

import com.agit.crm.common.application.KomentarEventService;
import com.agit.crm.common.dto.crm.KomentarEventDTO;
import com.agit.crm.domain.crm.KomentarEvent;
import com.agit.crm.domain.crm.KomentarEventBuilder;
import com.agit.crm.domain.crm.KomentarEventRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.KomentarEventDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author user
 */
public class KomentarEventServiceImpl implements KomentarEventService{

    private KomentarEventRepository komentarEventRepository;
    private KomentarEventDTOAssembler komentarEventDTOAssembler;

    public void setKomentarEventRepository(KomentarEventRepository komentarEventRepository) {
        this.komentarEventRepository = komentarEventRepository;
    }

    public void setKomentarEventDTOAssembler(KomentarEventDTOAssembler komentarEventDTOAssembler) {
        this.komentarEventDTOAssembler = komentarEventDTOAssembler;
    }

   
    @Override
    public void saveOrUpdate(KomentarEventDTO komentarEvent) {
        KomentarEvent t = komentarEventRepository.findByID(komentarEvent.getKomentarID());

        if (t == null) {
            t = komentarEventDTOAssembler.toDomain(komentarEvent);
        } else {
            KomentarEvent newKomentar = komentarEventDTOAssembler.toDomain(komentarEvent);
            t.assignNewKomentar(newKomentar);

        }
        komentarEventRepository.saveOrUpdate(t);
    }

    @Override
    public void delete(KomentarEventDTO komentarEvent) {
        KomentarEvent p = komentarEventDTOAssembler.toDomain(komentarEvent);
        komentarEventRepository.delete(p);
    }

    @Override
    public KomentarEventDTO findByID(String komentarID) {
        Validate.notNull(komentarEventRepository);
        KomentarEvent b = (KomentarEvent) komentarEventRepository.findByID(komentarID);
        if (b != null) {
            return komentarEventDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<KomentarEventDTO> findAll() {
        Validate.notNull(komentarEventRepository);
        return komentarEventDTOAssembler.toDTOs(komentarEventRepository.findAll());
    }

    @Override
    public List<KomentarEventDTO> findByParams(Map map) {
        Validate.notNull(komentarEventRepository);
        List<KomentarEvent> listKomentar = komentarEventRepository.findByParams(map);
        if (listKomentar != null) {
            return (List<KomentarEventDTO>) komentarEventDTOAssembler.toDTOs(listKomentar);
        }
        return null;
    }

    @Override
    public KomentarEventDTO getDummy() {
         KomentarEvent komentarEvent = new KomentarEventBuilder()
                .setKomentarID("K01")
                .setIdEvent("01")
                .setKomentar("AAAAA")
                .setPicture(null)
                .setUserName("AD")
                .setTglKomentar(new Date())
                .setCreatedBy("AD")
                .setCreatedDate(new Date())
                .setModifiedBy("AD")
                .setModifiedDate(new Date())
                .createKomentarEvent();
        return komentarEventDTOAssembler.toDTO(komentarEvent);
    }

    @Override
    public List<KomentarEventDTO> findAllByID(String idEvent) {
        Validate.notNull(komentarEventRepository);
        return komentarEventDTOAssembler.toDTOs(komentarEventRepository.findAllByID(idEvent));
    }
    
}
