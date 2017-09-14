/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.KomentarEventDTO;
import com.agit.crm.common.dto.crm.KomentarEventDTOBuilder;
import com.agit.crm.domain.crm.KomentarEvent;
import com.agit.crm.domain.crm.KomentarEventBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class KomentarEventDTOAssembler implements IObjectAssembler<KomentarEvent, KomentarEventDTO> {

    @Override
    public KomentarEventDTO toDTO(KomentarEvent domainObject) {
        return new KomentarEventDTOBuilder()
                .setKomentarID(domainObject.getKomentarID())
                .setIdEvent(domainObject.getIdEvent())
                .setKomentar(domainObject.getKomentar())
                .setPicture(domainObject.getPicture())
                .setUserName(domainObject.getUserName())
                .setTglKomentar(domainObject.getTglKomentar())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createKomentarEventDTO();
    }

    @Override
    public KomentarEvent toDomain(KomentarEventDTO dtoObject) {
        return new KomentarEventBuilder()
                .setKomentarID(dtoObject.getKomentarID())
                .setIdEvent(dtoObject.getIdEvent())
                .setKomentar(dtoObject.getKomentar())
                .setPicture(dtoObject.getPicture())
                .setUserName(dtoObject.getUserName())
                .setTglKomentar(dtoObject.getTglKomentar())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createKomentarEvent();
    }
    public List<KomentarEvent> toDomains(List<KomentarEventDTO> arg0) {
        List<KomentarEvent> res = new ArrayList<>();
        for (KomentarEventDTO t : arg0) {
            res.add(this.toDomain(t));
        }
        return res;
    }

    public List<KomentarEventDTO> toDTOs(List<KomentarEvent> arg0) {
        List<KomentarEventDTO> res = new ArrayList<>();
        for (KomentarEvent t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
