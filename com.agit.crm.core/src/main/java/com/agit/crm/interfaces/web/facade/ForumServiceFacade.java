package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.ForumDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Zaky
 */
public interface ForumServiceFacade {

    ResponseEntity<Void> submitForum(ForumDTO forumDTO);

    ResponseEntity<Void> deleteForum(ForumDTO forumDTO);

    ResponseEntity<ForumDTO> findByID(String idForum);

    ResponseEntity<List<ForumDTO>> findAll();

    ResponseEntity<List<ForumDTO>> findByParams(Map map);
    
}
