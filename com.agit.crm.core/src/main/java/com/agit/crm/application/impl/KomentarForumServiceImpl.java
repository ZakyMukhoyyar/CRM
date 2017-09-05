package com.agit.crm.application.impl;

import com.agit.crm.common.application.KomentarForumService;
import com.agit.crm.common.dto.crm.KomentarForumDTO;
import com.agit.crm.domain.crm.KomentarForum;
import com.agit.crm.domain.crm.KomentarForumBuilder;
import com.agit.crm.domain.crm.KomentarForumRepository;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.KomentarForumDTOAssembler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author 3AD
 */
public class KomentarForumServiceImpl implements KomentarForumService {

    private KomentarForumRepository komentarForumRepository;
    private KomentarForumDTOAssembler komentarForumDTOAssembler;

    public void setKomentarForumRepository(KomentarForumRepository komentarForumRepository) {
        this.komentarForumRepository = komentarForumRepository;
    }

    public void setKomentarForumDTOAssembler(KomentarForumDTOAssembler komentarForumDTOAssembler) {
        this.komentarForumDTOAssembler = komentarForumDTOAssembler;
    }

    @Override
    public void saveOrUpdate(KomentarForumDTO komentarForum) {
        KomentarForum t = komentarForumRepository.findByID(komentarForum.getKomentarID());

        if (t == null) {
            t = komentarForumDTOAssembler.toDomain(komentarForum);
        } else {
            KomentarForum newKomentar = komentarForumDTOAssembler.toDomain(komentarForum);
            t.assignNewKomentar(newKomentar);

        }
        komentarForumRepository.saveOrUpdate(t);
    }

    @Override
    public void delete(KomentarForumDTO komentarForum) {
        KomentarForum p = komentarForumDTOAssembler.toDomain(komentarForum);
        komentarForumRepository.delete(p);
    }

    @Override
    public KomentarForumDTO findByID(String komentarID) {
        Validate.notNull(komentarForumRepository);
        KomentarForum b = (KomentarForum) komentarForumRepository.findByID(komentarID);
        if (b != null) {
            return komentarForumDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<KomentarForumDTO> findAll() {
        Validate.notNull(komentarForumRepository);
        return komentarForumDTOAssembler.toDTOs(komentarForumRepository.findAll());
    }

    @Override
    public List<KomentarForumDTO> findByParams(Map map) {
        Validate.notNull(komentarForumRepository);
        List<KomentarForum> listKomentar = komentarForumRepository.findByParams(map);
        if (listKomentar != null) {
            return (List<KomentarForumDTO>) komentarForumDTOAssembler.toDTOs(listKomentar);
        }
        return null;
    }

    @Override
    public KomentarForumDTO getDummy() {
        KomentarForum komentarForum = new KomentarForumBuilder()
                .setKomentarID("K01")
                .setKomentar("AAAAA")
                .setPicture(null)
                .setUserName("AD")
                .setTglKomentar(new Date())
                .setCreatedBy("AD")
                .setCreatedDate(new Date())
                .setModifiedBy("AD")
                .setModifiedDate(new Date())
                .createKomentarForum();
        return komentarForumDTOAssembler.toDTO(komentarForum);
    }

}
