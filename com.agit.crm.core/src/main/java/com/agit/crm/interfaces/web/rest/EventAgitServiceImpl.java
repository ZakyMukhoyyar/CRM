package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.interfaces.web.facade.EventAgitServiceFacade;
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
 * @author 3AD
 */
@Controller
public class EventAgitServiceImpl implements EventAgitServiceFacade {

    @Autowired
    private EventAgitService eventAgitService;

    @Override
    @RequestMapping(value = "/agit.service.eventAgit", method = RequestMethod.POST)
    public ResponseEntity<Void> submitMahasiswa(@RequestBody EventAgitDTO eventAgitDTO) {
        Validate.notNull(eventAgitService);
        eventAgitService.SaveOrUpdate(eventAgitDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/agit.service.eventAgit.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<EventAgitDTO> getDummyMahasiswa() {
        return new ResponseEntity<>(eventAgitService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteMahasiswa(EventAgitDTO eventAgitDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.eventAgit.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventAgitDTO> findByID(@PathVariable("id") String id) {
        EventAgitDTO eventAgitDTO = eventAgitService.findByID(id);
        if (eventAgitDTO != null) {
            return new ResponseEntity<>((eventAgitDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.eventAgit.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<EventAgitDTO>> findAll() {
        return new ResponseEntity<>((eventAgitService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<EventAgitDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
