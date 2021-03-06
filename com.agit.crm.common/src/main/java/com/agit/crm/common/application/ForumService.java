package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.shared.status.Status;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public interface ForumService {

    void SaveOrUpdate(ForumDTO forum);

    void deleteData(ForumDTO forum);

    ForumDTO getDummyData();

    ForumDTO findByID(String idForum);

    List<ForumDTO> findAll();

    List<ForumDTO> findByParams(Map map);

    List<ForumDTO> findAllByStatus(Status status);

}
