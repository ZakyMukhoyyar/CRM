/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.masterdata.interfaces.web.facade.dto.assembler;

import com.agit.crm.common.dto.masterdata.SetupEmailDTO;
import com.agit.crm.common.dto.masterdata.SetupEmailDTOBuilder;
import com.agit.crm.masterdata.domain.SetupEmail;
import com.agit.crm.masterdata.domain.SetupEmailBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TriAA
 */
public class SetupEmailDTOAssembler implements IObjectAssembler<SetupEmail, SetupEmailDTO> {

    @Override
    public SetupEmailDTO toDTO(SetupEmail domainObject) {
        return new SetupEmailDTOBuilder()
                .setIdEmail(domainObject.getIdEmail())
                .setContent(domainObject.getContent())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setParameter(domainObject.getParameter())
                .setSubject(domainObject.getSubject())
                .setTemplateTitle(domainObject.getTemplateTitle())
                .createSetupEmailDTO();
    }

    @Override
    public SetupEmail toDomain(SetupEmailDTO dtoObject) {
        return new SetupEmailBuilder()
                .setIdEmail(dtoObject.getIdEmail())
                .setContent(dtoObject.getContent())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setParameter(dtoObject.getParameter())
                .setSubject(dtoObject.getSubject())
                .setTemplateTitle(dtoObject.getTemplateTitle())
                .createSetupEmail();
    }

    public List<SetupEmail> toDomains(List<SetupEmailDTO> arg0) {
        List<SetupEmail> res = new ArrayList<>();
        for (SetupEmailDTO t : arg0) {
            res.add(new SetupEmailDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<SetupEmailDTO> toDTOs(List<SetupEmail> arg0) {
        List<SetupEmailDTO> res = new ArrayList<>();
        for (SetupEmail t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;

    }
}
