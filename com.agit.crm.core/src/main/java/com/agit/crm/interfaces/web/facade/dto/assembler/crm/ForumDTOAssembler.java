package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.common.dto.crm.ForumDTOBuilder;
import com.agit.crm.domain.crm.Forum;
import com.agit.crm.domain.crm.ForumBuilder;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class ForumDTOAssembler implements IObjectAssembler<Forum, ForumDTO> {

    private KomentarForumDTOAssembler komentarForumDTOAssembler;

    public void setKomentarForumDTOAssembler(KomentarForumDTOAssembler komentarForumDTOAssembler) {
        this.komentarForumDTOAssembler = komentarForumDTOAssembler;
    }

    @Override
    public ForumDTO toDTO(Forum domainObject) {
        return new ForumDTOBuilder()
                .setIdForum(domainObject.getIdForum())
                .setNamaForum(domainObject.getNamaForum())
                .setDeskripsiForum(domainObject.getDeskripsiForum())
                //                .setKomentarDTO(domainObject.getKomentar() == null ? Collections.EMPTY_LIST : komentarForumDTOAssembler.toDTOs(domainObject.getKomentar()))
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getCreatedDate())
                .setStatus(domainObject.getStatus())
                .createForumDTO();
    }

    @Override
    public Forum toDomain(ForumDTO dtoObject) {
        return new ForumBuilder()
                .setIdForum(dtoObject.getIdForum())
                .setNamaForum(dtoObject.getNamaForum())
                .setDeskripsiForum(dtoObject.getDeskripsiForum())
                //                .setKomentar(dtoObject.getKomentarDTO() == null ? Collections.EMPTY_LIST : komentarForumDTOAssembler.toDomains(dtoObject.getKomentarDTO()))
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getCreatedDate())
                .setStatus(dtoObject.getStatus())
                .createForum();
    }

    public List<Forum> toDomains(List<ForumDTO> arg0) {
        List<Forum> res = new ArrayList<>();
        for (ForumDTO t : arg0) {
            res.add(new ForumDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<ForumDTO> toDTOs(List<Forum> arg0) {
        List<ForumDTO> res = new ArrayList<>();
        for (Forum t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }

}
