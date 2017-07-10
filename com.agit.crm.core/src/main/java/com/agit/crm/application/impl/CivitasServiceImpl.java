package com.agit.crm.application.impl;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.domain.crm.Civitas;
import com.agit.crm.domain.crm.CivitasBuilder;
import com.agit.crm.domain.crm.CivitasRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.CivitasDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author 3AD
 */
public class CivitasServiceImpl implements CivitasService {

    private CivitasRepository civitasRepository;
    private CivitasDTOAssembler civitasDTOAssembler;

    public void setCivitasRepository(CivitasRepository civitasRepository) {
        this.civitasRepository = civitasRepository;
    }

    public void setCivitasDTOAssembler(CivitasDTOAssembler civitasDTOAssembler) {
        this.civitasDTOAssembler = civitasDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(CivitasDTO civitas) {
        Civitas t = civitasRepository.findByID(civitas.getCivitasID());

        if (t == null) {
            t = civitasDTOAssembler.toDomain(civitas);
        } else {
            Civitas newCivitas = civitasDTOAssembler.toDomain(civitas);
            t.assignNewCivitas(newCivitas);

        }
        civitasRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(CivitasDTO civitas) {
        Civitas p = civitasDTOAssembler.toDomain(civitas);
        civitasRepository.deleteData(p);
    }

    @Override
    public CivitasDTO getDummyData() {
        Civitas civitas = new CivitasBuilder()
                .setCivitasID("C1")
                .setCreatedBy("aa")
                .setCreatedDate(new Date())
                .setModifiedBy("aa")
                .setModifiedDate(new Date())
                .setNamaCivitas("UDINUS")
                .setStatus(Status.ACTIVE)
                .setUploadCivitas("1")
                .createCivitas();
        return civitasDTOAssembler.toDTO(civitas);
    }

    @Override
    public CivitasDTO findByID(String civitasID) {
        Validate.notNull(civitasRepository);
        Civitas b = (Civitas) civitasRepository.findByID(civitasID);
        if (b != null) {
            return civitasDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<CivitasDTO> findAll() {
        Validate.notNull(civitasRepository);
        return civitasDTOAssembler.toDTOs(civitasRepository.findAll());
    }

    @Override
    public List<CivitasDTO> findByParams(Map map) {
        Validate.notNull(civitasRepository);
        List<Civitas> listcivitas = civitasRepository.findByParams(map);
        if (listcivitas != null) {
            return (List<CivitasDTO>) civitasDTOAssembler.toDTOs(listcivitas);
        }
        return null;
    }

}
