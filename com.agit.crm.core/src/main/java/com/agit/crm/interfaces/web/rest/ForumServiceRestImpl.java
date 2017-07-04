package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.ForumService;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.interfaces.web.facade.ForumServiceFacade;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Zaky
 */
@Controller
public class ForumServiceRestImpl implements ForumServiceFacade{
    
    @Autowired
    private ForumService forumService;

    @Override
    @RequestMapping(value = "/agit.service.forum", method = RequestMethod.POST)
    public ResponseEntity<Void> submitForum(@RequestBody ForumDTO forumDTO) {
        Validate.notNull(forumService);
        forumService.SaveOrUpdate(forumDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/agit.service.forum.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<ForumDTO> getDummyForum() {
        return new ResponseEntity<>(forumService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteForum(ForumDTO forumDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.forum.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<ForumDTO> findByID(@PathVariable("id")  String id) {
        ForumDTO forumDTO = forumService.findByID(id);
        if (forumDTO != null) {
            return new ResponseEntity<>((forumDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.forum.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<ForumDTO>> findAll() {
        return new ResponseEntity<>((forumService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<ForumDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
