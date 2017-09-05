package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.KomentarForumDTO;
import com.agit.crm.common.dto.crm.KomentarForumDTOBuilder;
import com.agit.crm.domain.crm.KomentarForum;
import com.agit.crm.domain.crm.KomentarForumBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3AD
 */
public class KomentarForumDTOAssembler implements IObjectAssembler<KomentarForum, KomentarForumDTO> {

    @Override
    public KomentarForumDTO toDTO(KomentarForum domainObject) {
        return new KomentarForumDTOBuilder()
                .setKomentarID(domainObject.getKomentarID())
                .setKomentar(domainObject.getKomentar())
                .setPicture(domainObject.getPicture())
                .setUserName(domainObject.getUserName())
                .setTglKomentar(domainObject.getTglKomentar())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createKomentarForumDTO();

    }

    @Override
    public KomentarForum toDomain(KomentarForumDTO dtoObject) {
        return new KomentarForumBuilder()
                .setKomentarID(dtoObject.getKomentarID())
                .setKomentar(dtoObject.getKomentar())
                .setPicture(dtoObject.getPicture())
                .setUserName(dtoObject.getUserName())
                .setTglKomentar(dtoObject.getTglKomentar())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createKomentarForum();
    }

    public List<KomentarForum> toDomains(List<KomentarForumDTO> arg0) {
        List<KomentarForum> res = new ArrayList<>();
        for (KomentarForumDTO t : arg0) {
            res.add(this.toDomain(t));
        }
        return res;
    }

    public List<KomentarForumDTO> toDTOs(List<KomentarForum> arg0) {
        List<KomentarForumDTO> res = new ArrayList<>();
        for (KomentarForum t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}
