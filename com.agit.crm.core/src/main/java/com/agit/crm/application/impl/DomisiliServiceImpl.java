package com.agit.crm.application.impl;

import com.agit.crm.common.application.DomisiliService;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.domain.crm.Domisili;
import com.agit.crm.domain.crm.DomisiliBuilder;
import com.agit.crm.domain.crm.DomisiliRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.DomisiliDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class DomisiliServiceImpl implements DomisiliService {

    DomisiliRepository domisiliRepository;
    DomisiliDTOAssembler domisiliDTOAssembler;

    public void setDomisiliRepository(DomisiliRepository domisiliRepository) {
        this.domisiliRepository = domisiliRepository;
    }

    public void setDomisiliDTOAssembler(DomisiliDTOAssembler domisiliDTOAssembler) {
        this.domisiliDTOAssembler = domisiliDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(DomisiliDTO domisili) {
        Domisili t = domisiliRepository.findByID(domisili.getIdDomisili());

        if (t == null) {
            t = domisiliDTOAssembler.toDomain(domisili);
        } else {
            Domisili newDomisili = domisiliDTOAssembler.toDomain(domisili);
            t.assignNewDomisili(newDomisili);

        }
        domisiliRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(DomisiliDTO domisili) {
        Domisili p = domisiliDTOAssembler.toDomain(domisili);
        domisiliRepository.deleteData(p);
    }

    @Override
    public DomisiliDTO getDummyData() {
        Domisili domisili = new DomisiliBuilder()
                .setIdDomisili("DOMISILI1")
                .setNamaProvinsi("namaProvinsi")
                .setNamaKabupaten("namaKabupaten")
                .setNamaKota("namaKota")
                .setCreatedBy("createdBy")
                .setCreatedDate(new Date())
                .setModifiedBy("modifiedBy")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createDomisili();
        return domisiliDTOAssembler.toDTO(domisili);
    }

    @Override
    public DomisiliDTO findByID(String idDomisili) {
        Validate.notNull(domisiliRepository);
        Domisili b = (Domisili) domisiliRepository.findByID(idDomisili);
        if (b != null) {
            return domisiliDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<DomisiliDTO> findAll() {
        Validate.notNull(domisiliRepository);
        return domisiliDTOAssembler.toDTOs(domisiliRepository.findAll());
    }

    @Override
    public List<DomisiliDTO> findByParams(Map map) {
        Validate.notNull(domisiliRepository);
        List<Domisili> listDomisili = domisiliRepository.findByParams(map);
        if (listDomisili != null) {
            return (List<DomisiliDTO>) domisiliDTOAssembler.toDTOs(listDomisili);
        }
        return null;
    }

}
