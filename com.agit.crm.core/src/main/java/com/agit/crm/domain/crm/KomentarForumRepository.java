package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 3AD
 */
public interface KomentarForumRepository {

    void saveOrUpdate(KomentarForum komentarForum);

    void delete(KomentarForum komentarForum);

    KomentarForum findByID(String komentarID);

    List<KomentarForum> findAll();

    List<KomentarForum> findByParams(Map map);
}
