/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.facade.dto.assembler.storing.fi.card;

import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTOBuilder;
import com.agit.crm.domain.storing.fi.card.StoringFICard;
import com.agit.crm.domain.storing.fi.card.StoringFICardBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BayuHS
 */
public class StoringFICardDTOAssembler implements IObjectAssembler<StoringFICard, StoringFICardDTO> {

    @Override
    public StoringFICardDTO toDTO(StoringFICard domainObject) {
        return new StoringFICardDTOBuilder()
                .setStoringFICardID(domainObject.getStoringFICardID())
                .setPointCheck1(domainObject.getPointCheck1())
                .setPointCheck2(domainObject.getPointCheck2())
                .setPointCheck3(domainObject.getPointCheck3())
                .setPointCheck4(domainObject.getPointCheck4())
                .setPointCheck5(domainObject.getPointCheck5())
                .setImageScan(domainObject.getImageScan())
                .setPdfScan(domainObject.getPdfScan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setStatusResult(domainObject.getStatusResult())
                .createStoringFICardDTO();
    }

    @Override
    public StoringFICard toDomain(StoringFICardDTO dtoObject) {
        return new StoringFICardBuilder()
                .setStoringFICardID(dtoObject.getStoringFICardID())
                .setPointCheck1(dtoObject.getPointCheck1())
                .setPointCheck2(dtoObject.getPointCheck2())
                .setPointCheck3(dtoObject.getPointCheck3())
                .setPointCheck4(dtoObject.getPointCheck4())
                .setPointCheck5(dtoObject.getPointCheck5())
                .setPdfScan(dtoObject.getPdfScan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setStatusResult(dtoObject.getStatusResult())
                .createStoringFICard();
    }

    public List<StoringFICard> toDomains(List<StoringFICardDTO> arg0) {
        List<StoringFICard> res = new ArrayList<>();
        for (StoringFICardDTO t : arg0) {
            res.add(new StoringFICardDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<StoringFICardDTO> toDTOs(List<StoringFICard> arg0) {
        List<StoringFICardDTO> res = new ArrayList<>();
        for (StoringFICard t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }

}
