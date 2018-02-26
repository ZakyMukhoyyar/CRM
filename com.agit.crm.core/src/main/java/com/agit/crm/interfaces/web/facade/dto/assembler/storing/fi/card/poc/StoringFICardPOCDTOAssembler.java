/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade.dto.assembler.storing.fi.card.poc;

import com.agit.crm.common.dto.storing.fi.card.poc.StoringFICardPOCDTO;
import com.agit.crm.common.dto.storing.fi.card.poc.StoringFICardPOCDTOBuilder;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOC;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOCBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class StoringFICardPOCDTOAssembler implements IObjectAssembler<StoringFICardPOC, StoringFICardPOCDTO> {

    @Override
    public StoringFICardPOCDTO toDTO(StoringFICardPOC domainObject) {
        return new StoringFICardPOCDTOBuilder()
                .setStoringFICardPocID(domainObject.getStoringFICardPocID())
                .setFiCard(domainObject.getFiCard())
                .setFrameNumber(domainObject.getFileName())
                .setStage1(domainObject.getStage1())
                .setStage2(domainObject.getStage2())
                .setStage3(domainObject.getStage3())
                .setStage4(domainObject.getStage4())
                .setStage4PoinCheck5(domainObject.getStage4PoinCheck5())
                .setStage1PoinCheck1(domainObject.getStage1PoinCheck1())
                .setStage1PoinCheck2(domainObject.getStage1PoinCheck2())
                .setStage1PoinCheck3(domainObject.getStage1PoinCheck3())
                .setStage1PoinCheck4(domainObject.getStage1PoinCheck4())
                .setStage1PoinCheck5(domainObject.getStage1PoinCheck5())
                .setStage1PoinCheck6(domainObject.getStage1PoinCheck6())
                .setStage2PoinCheck1(domainObject.getStage2PoinCheck1())
                .setStage2PoinCheck2(domainObject.getStage2PoinCheck2())
                .setStage2PoinCheck3(domainObject.getStage2PoinCheck3())
                .setStage2PoinCheck4(domainObject.getStage2PoinCheck4())
                .setStage2PoinCheck5(domainObject.getStage2PoinCheck5())
                .setStage3PoinCheck1(domainObject.getStage3PoinCheck1())
                .setStage3PoinCheck2(domainObject.getStage3PoinCheck2())
                .setStage4PoinCheck1(domainObject.getStage4PoinCheck1())
                .setStage4PoinCheck2(domainObject.getStage4PoinCheck2())
                .setStage4PoinCheck3(domainObject.getStage4PoinCheck3())
                .setStage4PoinCheck4(domainObject.getStage4PoinCheck4())
                .setPathFile(domainObject.getPathFile())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setStatusResult(domainObject.getStatusResult())
                .createStoringFICardPOCDTO();
    }

    @Override
    public StoringFICardPOC toDomain(StoringFICardPOCDTO dtoObject) {
        return new StoringFICardPOCBuilder()
                .setStoringFICardPocID(dtoObject.getStoringFICardPocID())
                .setFiCard(dtoObject.getFiCard())
                .setFrameNumber(dtoObject.getFileName())
                .setStage1(dtoObject.getStage1())
                .setStage2(dtoObject.getStage2())
                .setStage3(dtoObject.getStage3())
                .setStage4(dtoObject.getStage4())
                .setStage4PoinCheck5(dtoObject.getStage4PoinCheck5())
                .setStage1PoinCheck1(dtoObject.getStage1PoinCheck1())
                .setStage1PoinCheck2(dtoObject.getStage1PoinCheck2())
                .setStage1PoinCheck3(dtoObject.getStage1PoinCheck3())
                .setStage1PoinCheck4(dtoObject.getStage1PoinCheck4())
                .setStage1PoinCheck5(dtoObject.getStage1PoinCheck5())
                .setStage1PoinCheck6(dtoObject.getStage1PoinCheck6())
                .setStage2PoinCheck1(dtoObject.getStage2PoinCheck1())
                .setStage2PoinCheck2(dtoObject.getStage2PoinCheck2())
                .setStage2PoinCheck3(dtoObject.getStage2PoinCheck3())
                .setStage2PoinCheck4(dtoObject.getStage2PoinCheck4())
                .setStage2PoinCheck5(dtoObject.getStage2PoinCheck5())
                .setStage3PoinCheck1(dtoObject.getStage3PoinCheck1())
                .setStage3PoinCheck2(dtoObject.getStage3PoinCheck2())
                .setStage4PoinCheck1(dtoObject.getStage4PoinCheck1())
                .setStage4PoinCheck2(dtoObject.getStage4PoinCheck2())
                .setStage4PoinCheck3(dtoObject.getStage4PoinCheck3())
                .setStage4PoinCheck4(dtoObject.getStage4PoinCheck4())
                .setPathFile(dtoObject.getPathFile())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setStatusResult(dtoObject.getStatusResult())
                .createStoringFICardPOC();
    }

    public List<StoringFICardPOC> toDomains(List<StoringFICardPOCDTO> arg0) {
        List<StoringFICardPOC> res = new ArrayList<>();
        for (StoringFICardPOCDTO t : arg0) {
            res.add(new StoringFICardPOCDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<StoringFICardPOCDTO> toDTOs(List<StoringFICardPOC> arg0) {
        List<StoringFICardPOCDTO> res = new ArrayList<>();
        for (StoringFICardPOC t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
