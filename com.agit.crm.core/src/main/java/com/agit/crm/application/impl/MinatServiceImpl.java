package com.agit.crm.application.impl;

import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.domain.crm.Minat;
import com.agit.crm.domain.crm.MinatBuilder;
import com.agit.crm.domain.crm.MinatRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.MinatDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class MinatServiceImpl implements MinatService {

    private MinatRepository minatRepository;
    private MinatDTOAssembler minatDTOAssembler;

    public void setMinatRepository(MinatRepository minatRepository) {
        this.minatRepository = minatRepository;
    }

    public void setMinatDTOAssembler(MinatDTOAssembler minatDTOAssembler) {
        this.minatDTOAssembler = minatDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(MinatDTO minat) {
        Minat t = minatRepository.findByID(minat.getIdMinat());

        if (t == null) {
            t = minatDTOAssembler.toDomain(minat);
        } else {
            Minat newMinat = minatDTOAssembler.toDomain(minat);
            t.assignNewMinat(newMinat);

        }
        minatRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(MinatDTO minat) {
        Minat p = minatDTOAssembler.toDomain(minat);
        minatRepository.deleteData(p);
    }

    @Override
    public MinatDTO getDummyData() {
        Minat minat = new MinatBuilder()
                .setIdMinat("11")
                .setNamaMinat("namaMinat")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createMinat();
        return minatDTOAssembler.toDTO(minat);
    }

    @Override
    public MinatDTO findByID(String idMinat) {
        Validate.notNull(minatRepository);
        Minat b = (Minat) minatRepository.findByID(idMinat);
        if (b != null) {
            return minatDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<MinatDTO> findAll() {
        Validate.notNull(minatRepository);
        return minatDTOAssembler.toDTOs(minatRepository.findAll());
    }

    @Override
    public List<MinatDTO> findByParams(Map map) {
        Validate.notNull(minatRepository);
        List<Minat> listMinat = minatRepository.findByParams(map);
        if (listMinat != null) {
            return (List<MinatDTO>) minatDTOAssembler.toDTOs(listMinat);
        }
        return null;
    }

    @Override
    public List<MinatDTO> findAllByStatus(Status status) {
        Validate.notNull(minatRepository);
        List<Minat> listMinat = minatRepository.findAllByStatus(status);
        if (listMinat != null) {
            return (List<MinatDTO>) minatDTOAssembler.toDTOs(listMinat);
        }
        return null;
    }

    @Override
    public List<MinatDTO> toBandBox(String namaMinat, Status status) {
        Validate.notNull(minatRepository);
        List<Minat> listMinat = minatRepository.toBandBox(namaMinat, status);
        if (listMinat != null) {
            return (List<MinatDTO>) minatDTOAssembler.toDTOs(listMinat);
        }
        return null;
    }

}
