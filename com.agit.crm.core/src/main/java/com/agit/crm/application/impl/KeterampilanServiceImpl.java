package com.agit.crm.application.impl;

import com.agit.crm.common.application.KeterampilanService;
import com.agit.crm.common.dto.crm.KeterampilanDTO;
import com.agit.crm.domain.crm.Keterampilan;
import com.agit.crm.domain.crm.KeterampilanBuilder;
import com.agit.crm.domain.crm.KeterampilanRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.KeterampilanDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class KeterampilanServiceImpl implements KeterampilanService{
    
    private KeterampilanRepository keterampilanRepository;
    private KeterampilanDTOAssembler keterampilanDTOAssembler;

    public void setKeterampilanRepository(KeterampilanRepository keterampilanRepository) {
        this.keterampilanRepository = keterampilanRepository;
    }

    public void setKeterampilanDTOAssembler(KeterampilanDTOAssembler keterampilanDTOAssembler) {
        this.keterampilanDTOAssembler = keterampilanDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(KeterampilanDTO keterampilan) {
        Keterampilan t = keterampilanRepository.findByID(keterampilan.getIdKeterampilan());

        if (t == null) {
            t = keterampilanDTOAssembler.toDomain(keterampilan);
        } else {
            Keterampilan newKeterampilan = keterampilanDTOAssembler.toDomain(keterampilan);
            t.assignNewKeterampilan(newKeterampilan);

        }
        keterampilanRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(KeterampilanDTO keterampilan) {
        Keterampilan p = keterampilanDTOAssembler.toDomain(keterampilan);
        keterampilanRepository.deleteData(p);
    }

    @Override
    public KeterampilanDTO getDummyData() {
        Keterampilan keterampilan = new KeterampilanBuilder()
                .setIdKeterampilan("11")
                .setNamaKeterampilan("namaKeterampilan")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(true)
                .createKeterampilan();
        return keterampilanDTOAssembler.toDTO(keterampilan);
    }

    @Override
    public KeterampilanDTO findByID(String idKeterampilan) {
        Validate.notNull(keterampilanRepository);
        Keterampilan b = (Keterampilan) keterampilanRepository.findByID(idKeterampilan);
        if (b != null) {
            return keterampilanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<KeterampilanDTO> findAll() {
        Validate.notNull(keterampilanRepository);
        return keterampilanDTOAssembler.toDTOs(keterampilanRepository.findAll());
    }

    @Override
    public List<KeterampilanDTO> findByParams(Map map) {
        Validate.notNull(keterampilanRepository);
        List<Keterampilan> listKeterampilan = keterampilanRepository.findByParams(map);
        if (listKeterampilan != null) {
            return (List<KeterampilanDTO>) keterampilanDTOAssembler.toDTOs(listKeterampilan);
        }
        return null;
    }
    
    
    
}
