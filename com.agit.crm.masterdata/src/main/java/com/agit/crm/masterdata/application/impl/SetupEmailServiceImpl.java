/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.masterdata.application.impl;

import com.agit.crm.common.application.masterdata.SetupEmailService;
import com.agit.crm.common.dto.masterdata.SetupEmailDTO;
import com.agit.crm.common.dto.masterdata.SetupEmailDTOBuilder;
import com.agit.crm.masterdata.domain.SetupEmail;
import com.agit.crm.masterdata.domain.SetupEmailRepository;
import com.agit.crm.masterdata.interfaces.web.facade.dto.assembler.SetupEmailDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author TriAA
 */
public class SetupEmailServiceImpl implements SetupEmailService {

    private SetupEmailRepository setupEmailRepository;
    private SetupEmailDTOAssembler setupEmailDTOAssembler;

    public void setSetupEmailRepository(SetupEmailRepository setupEmailRepository) {
        this.setupEmailRepository = setupEmailRepository;
    }

    public void setSetupEmailDTOAssembler(SetupEmailDTOAssembler setupEmailDTOAssembler) {
        this.setupEmailDTOAssembler = setupEmailDTOAssembler;
    }

    @Override
    public void saveOrUpdate(SetupEmailDTO setupEmail) {
        SetupEmail s = setupEmailRepository.findByID(setupEmail.getIdEmail());
        if (s == null) {
            s = setupEmailDTOAssembler.toDomain(setupEmail);
        } else {
            SetupEmail newSetupEmail = setupEmailDTOAssembler.toDomain(setupEmail);
            s.assignNewSetupEmail(newSetupEmail);
        }
        setupEmailRepository.saveOrUpdate(s);
    }

    @Override
    public void delete(SetupEmailDTO setupEmail) {
        SetupEmail p = setupEmailDTOAssembler.toDomain(setupEmail);
        setupEmailRepository.delete(p);
    }

    @Override
    public SetupEmailDTO findByID(String idEmail) {
        Validate.notNull(setupEmailRepository);
        SetupEmail b = (SetupEmail) setupEmailRepository.findByID(idEmail);
        if (b != null) {
            return setupEmailDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<SetupEmailDTO> findAll() {
        Validate.notNull(setupEmailRepository);
        return setupEmailDTOAssembler.toDTOs(setupEmailRepository.findAll());
    }

    @Override
    public List<SetupEmailDTO> findByParams(Map map) {
        Validate.notNull(setupEmailRepository);
        List<SetupEmail> listSetupEmails = setupEmailRepository.findByParams(map);
        if (listSetupEmails != null) {
            return (List<SetupEmailDTO>) setupEmailDTOAssembler.toDTOs(listSetupEmails);
        }
        return null;
    }

    @Override
    public SetupEmailDTO getDummy() {
        return new SetupEmailDTOBuilder()
                .setIdEmail("E01")
                .setContent("Content")
                .setParameter("parameter")
                .setSubject("Subject")
                .setTemplateTitle("Template")
                .setCreatedBy("Create")
                .setCreatedDate(new Date())
                .setModifiedBy("Modify")
                .setModifiedDate(new Date())
                .createSetupEmailDTO();
    }

}
