package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.KomentarForumDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface KomentarForumService {

    void saveOrUpdate(KomentarForumDTO komentarForum);

    void delete(KomentarForumDTO komentarForum);

    KomentarForumDTO findByID(String komentarID);

    List<KomentarForumDTO> findAll();

    List<KomentarForumDTO> findByParams(Map map);

    KomentarForumDTO getDummy();

    List<KomentarForumDTO> findAllByID(String idForum);
}
