package com.agit.crm.interfaces.web.facade.dto.assembler.crm;

import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.common.dto.crm.ForumDTOBuilder;
import com.agit.crm.domain.crm.Forum;
import com.agit.crm.domain.crm.ForumBuilder;
import com.agit.crm.domain.crm.ForumRepository;
import com.agit.crm.shared.object.IObjectAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaky
 */
public class ForumDTOAssembler implements IObjectAssembler<Forum, ForumDTO>{
    
    private ForumRepository forumRepository;
    private ForumDTOAssembler forumDTOAssembler;

    public void setForumRepository(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public void setForumDTOAssembler(ForumDTOAssembler forumDTOAssembler) {
        this.forumDTOAssembler = forumDTOAssembler;
    }
    
    @Override
    public ForumDTO toDTO(Forum domainObject) {
        return new ForumDTOBuilder()
                .setIdForum(domainObject.getIdForum())
                .setNamaForum(domainObject.getNamaForum())
                .setDeskripsiForum(domainObject.getDeskripsiForum())
                .setTanggalBerakhir(domainObject.getTanggalBerakhir())
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
                .setTanggalBerakhir(dtoObject.getTanggalBerakhir())
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
