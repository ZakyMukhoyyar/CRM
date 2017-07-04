package com.agit.crm.application.impl;

import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.domain.crm.Ketrampilan;
import com.agit.crm.domain.crm.KetrampilanBuilder;
import com.agit.crm.domain.crm.KetrampilanRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.KetrampilanDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class KetrampilanServiceImpl implements KetrampilanService{
    
    private KetrampilanRepository ketrampilanRepository;
    private KetrampilanDTOAssembler ketrampilanDTOAssembler;

    public void setKetrampilanRepository(KetrampilanRepository ketrampilanRepository) {
        this.ketrampilanRepository = ketrampilanRepository;
    }

    public void setKetrampilanDTOAssembler(KetrampilanDTOAssembler ketrampilanDTOAssembler) {
        this.ketrampilanDTOAssembler = ketrampilanDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(KetrampilanDTO ketrampilan) {
        Ketrampilan t = ketrampilanRepository.findByID(ketrampilan.getIdKetrampilan());

        if (t == null) {
            t = ketrampilanDTOAssembler.toDomain(ketrampilan);
        } else {
            Ketrampilan newKetrampilan = ketrampilanDTOAssembler.toDomain(ketrampilan);
            t.assignNewKetrampilan(newKetrampilan);

        }
        ketrampilanRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(KetrampilanDTO ketrampilan) {
        Ketrampilan p = ketrampilanDTOAssembler.toDomain(ketrampilan);
        ketrampilanRepository.deleteData(p);
    }

    @Override
    public KetrampilanDTO getDummyData() {
        Ketrampilan ketrampilan = new KetrampilanBuilder()
                .setIdKetrampilan("11")
                .setNamaKetrampilan("namaKetrampilan")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createKetrampilan();
        return ketrampilanDTOAssembler.toDTO(ketrampilan);
    }

    @Override
    public KetrampilanDTO findByID(String idKetrampilan) {
        Validate.notNull(ketrampilanRepository);
        Ketrampilan b = (Ketrampilan) ketrampilanRepository.findByID(idKetrampilan);
        if (b != null) {
            return ketrampilanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<KetrampilanDTO> findAll() {
        Validate.notNull(ketrampilanRepository);
        return ketrampilanDTOAssembler.toDTOs(ketrampilanRepository.findAll());
    }

    @Override
    public List<KetrampilanDTO> findByParams(Map map) {
        Validate.notNull(ketrampilanRepository);
        List<Ketrampilan> listKetrampilan = ketrampilanRepository.findByParams(map);
        if (listKetrampilan != null) {
            return (List<KetrampilanDTO>) ketrampilanDTOAssembler.toDTOs(listKetrampilan);
        }
        return null;
    }
    
    
    
}
