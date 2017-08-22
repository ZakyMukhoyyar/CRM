package com.agit.crm.application.impl;

import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.domain.crm.Jurusan;
import com.agit.crm.domain.crm.JurusanBuilder;
import com.agit.crm.domain.crm.JurusanRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.JurusanDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class JurusanServiceImpl implements JurusanService {
    
    private JurusanRepository jurusanRepository;
    private JurusanDTOAssembler jurusanDTOAssembler;

    public void setJurusanRepository(JurusanRepository jurusanRepository) {
        this.jurusanRepository = jurusanRepository;
    }

    public void setJurusanDTOAssembler(JurusanDTOAssembler jurusanDTOAssembler) {
        this.jurusanDTOAssembler = jurusanDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(JurusanDTO jurusan) {
        Jurusan t = jurusanRepository.findByID(jurusan.getIdJurusan());

        if (t == null) {
            t = jurusanDTOAssembler.toDomain(jurusan);
        } else {
            Jurusan newJurusan = jurusanDTOAssembler.toDomain(jurusan);
            t.assignNewJurusan(newJurusan);

        }
        jurusanRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(JurusanDTO jurusan) {
        Jurusan p = jurusanDTOAssembler.toDomain(jurusan);
        jurusanRepository.deleteData(p);
    }

    @Override
    public JurusanDTO getDummyData() {
        Jurusan jurusan = new JurusanBuilder()
                .setIdJurusan("1")
                .setNamaJurusan("Teknik Informatika")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createJurusan();
        return jurusanDTOAssembler.toDTO(jurusan);
    }

    @Override
    public JurusanDTO findByID(String idJurusan) {
        Validate.notNull(jurusanRepository);
        Jurusan b = (Jurusan) jurusanRepository.findByID(idJurusan);
        if (b != null) {
            return jurusanDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<JurusanDTO> findAll() {
        Validate.notNull(jurusanRepository);
        return jurusanDTOAssembler.toDTOs(jurusanRepository.findAll());
    }

    @Override
    public List<JurusanDTO> findByParams(Map map) {
        Validate.notNull(jurusanRepository);
        List<Jurusan> listJurusan = jurusanRepository.findByParams(map);
        if (listJurusan != null) {
            return (List<JurusanDTO>) jurusanDTOAssembler.toDTOs(listJurusan);
        }
        return null;
    }
    
    
    
}
