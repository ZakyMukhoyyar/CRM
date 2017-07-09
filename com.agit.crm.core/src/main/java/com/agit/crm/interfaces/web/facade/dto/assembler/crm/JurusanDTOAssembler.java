package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.common.dto.crm.JurusanDTOBuilder;
import com.agit.crm.domain.crm.Jurusan;
import com.agit.crm.domain.crm.JurusanBuilder;
import com.agit.crm.domain.crm.JurusanRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class JurusanDTOAssembler implements IObjectAssembler<Jurusan, JurusanDTO> {

    private JurusanRepository jurusanRepository;
    private JurusanDTOAssembler jurusanDTOAssembler;

    public void setJurusanRepository(JurusanRepository jurusanRepository) {
        this.jurusanRepository = jurusanRepository;
    }

    public void setJurusanDTOAssembler(JurusanDTOAssembler jurusanDTOAssembler) {
        this.jurusanDTOAssembler = jurusanDTOAssembler;
    }

    @Override
    public JurusanDTO toDTO(Jurusan domainObject) {
        return new JurusanDTOBuilder()
                .setIdJurusan(domainObject.getIdJurusan())
                .setNamaJurusan(domainObject.getNamaJurusan())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createJurusanDTO();
    }

    @Override
    public Jurusan toDomain(JurusanDTO dtoObject) {
        return new JurusanBuilder()                
                .setIdJurusan(dtoObject.getIdJurusan())
                .setNamaJurusan(dtoObject.getNamaJurusan())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createJurusan();
    }

    public List<Jurusan> toDomains(List<JurusanDTO> arg0) {
        List<Jurusan> res = new ArrayList<>();
        for (JurusanDTO t : arg0) {
            res.add(new JurusanDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<JurusanDTO> toDTOs(List<Jurusan> arg0) {
        List<JurusanDTO> res = new ArrayList<>();
        for (Jurusan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }

}
