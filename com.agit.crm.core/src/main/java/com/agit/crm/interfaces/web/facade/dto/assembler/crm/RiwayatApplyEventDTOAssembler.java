package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTOBuilder;
import com.agit.crm.domain.crm.RiwayatApplyEvent;
import com.agit.crm.domain.crm.RiwayatApplyEventBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3AD
 */
public class RiwayatApplyEventDTOAssembler implements IObjectAssembler<RiwayatApplyEvent, RiwayatApplyEventDTO> {

    @Override
    public RiwayatApplyEventDTO toDTO(RiwayatApplyEvent domainObject) {
        return new RiwayatApplyEventDTOBuilder()
                .setIdRiwayatApplyEvent(domainObject.getIdRiwayatApplyEvent())
                .setIdRiwayatEvent(domainObject.getIdRiwayatEvent())
                .setIdUserRiwayat(domainObject.getIdUserRiwayat())
                .setNamaEvent(domainObject.getNamaEvent())
                .setNamaPelamar(domainObject.getNamaPelamar())
                .setLowonganState(domainObject.getLowonganState())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createRiwayatApplyEventDTO();
    }

    @Override
    public RiwayatApplyEvent toDomain(RiwayatApplyEventDTO dtoObject) {
        return new RiwayatApplyEventBuilder()
                .setIdRiwayatApplyEvent(dtoObject.getIdRiwayatApplyEvent())
                .setIdRiwayatEvent(dtoObject.getIdRiwayatEvent())
                .setIdUserRiwayat(dtoObject.getIdUserRiwayat())
                .setNamaEvent(dtoObject.getNamaEvent())
                .setNamaPelamar(dtoObject.getNamaPelamar())
                .setLowonganState(dtoObject.getLowonganState())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createRiwayatApplyEvent();
    }

    public List<RiwayatApplyEvent> toDomains(List<RiwayatApplyEventDTO> arg0) {
        List<RiwayatApplyEvent> res = new ArrayList<>();
        for (RiwayatApplyEventDTO t : arg0) {
            res.add(this.toDomain(t));
        }
        return res;
    }

    public List<RiwayatApplyEventDTO> toDTOs(List<RiwayatApplyEvent> arg0) {
        List<RiwayatApplyEventDTO> res = new ArrayList<>();
        for (RiwayatApplyEvent t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
