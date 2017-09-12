package com.agit.crm.domain.crm;

import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface ForumRepository {

    void saveOrUpdate(Forum forum);

    void deleteData(Forum forum);

    Forum findByID(String idForum);

    List<Forum> findAll();

    List<Forum> findByParams(Map map);

    List<Forum> findAllByStatus(Status status);

}
