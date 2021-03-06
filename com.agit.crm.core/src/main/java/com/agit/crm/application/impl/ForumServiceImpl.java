package com.agit.crm.application.impl;

import com.agit.crm.common.application.ForumService;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.domain.crm.Forum;
import com.agit.crm.domain.crm.ForumBuilder;
import com.agit.crm.domain.crm.ForumRepository;
import com.agit.crm.domain.crm.KomentarForum;
import com.agit.crm.domain.crm.KomentarForumBuilder;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.ForumDTOAssembler;
import com.agit.crm.shared.status.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Zaky
 */
public class ForumServiceImpl implements ForumService {

    private ForumRepository forumRepository;
    private ForumDTOAssembler forumDTOAssembler;

    public void setForumRepository(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public void setForumDTOAssembler(ForumDTOAssembler forumDTOAssembler) {
        this.forumDTOAssembler = forumDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(ForumDTO forum) {
        Forum t = forumRepository.findByID(forum.getIdForum());

        if (t == null) {
            t = forumDTOAssembler.toDomain(forum);
        } else {
            Forum newForum = forumDTOAssembler.toDomain(forum);
            t.assignNewForum(newForum);

        }
        forumRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(ForumDTO forum) {
        Forum p = forumDTOAssembler.toDomain(forum);
        forumRepository.deleteData(p);
    }

    @Override
    public ForumDTO getDummyData() {
        KomentarForum komentarForum = new KomentarForumBuilder()
                .setKomentarID("K01")
                .setKomentar("Test")
                .setPicture("Pic")
                .setUserName("AD")
                .setTglKomentar(new Date())
                .setCreatedBy("AD")
                .setCreatedDate(new Date())
                .setModifiedBy("AD")
                .setModifiedDate(new Date())
                .createKomentarForum();
        List<KomentarForum> komentarForums = new ArrayList<>();
        komentarForums.add(komentarForum);

        Forum forum = new ForumBuilder()
                .setIdForum("01")
                .setNamaForum("Nama")
                .setDeskripsiForum("Deskripsi")
                //                .setKomentar(komentarForums)
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setStatus(Status.ACTIVE)
                .createForum();
        return forumDTOAssembler.toDTO(forum);
    }

    @Override
    public ForumDTO findByID(String idForum) {
        Validate.notNull(forumRepository);
        Forum b = (Forum) forumRepository.findByID(idForum);
        if (b != null) {
            return forumDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<ForumDTO> findAll() {
        Validate.notNull(forumRepository);
        return forumDTOAssembler.toDTOs(forumRepository.findAll());
    }

    @Override
    public List<ForumDTO> findByParams(Map map) {
        Validate.notNull(forumRepository);
        List<Forum> listForum = forumRepository.findByParams(map);
        if (listForum != null) {
            return (List<ForumDTO>) forumDTOAssembler.toDTOs(listForum);
        }
        return null;
    }

    @Override
    public List<ForumDTO> findAllByStatus(Status status) {
        Validate.notNull(forumRepository);
        List<Forum> listForum = forumRepository.findAllByStatus(status);
        if (listForum != null) {
            return (List<ForumDTO>) forumDTOAssembler.toDTOs(listForum);
        }
        return null;
    }

}
