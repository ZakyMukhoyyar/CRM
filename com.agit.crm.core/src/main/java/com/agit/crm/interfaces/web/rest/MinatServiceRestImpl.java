package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.interfaces.web.facade.MinatServiceFacade;
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
public class MinatServiceRestImpl implements MinatServiceFacade{
    
    @Autowired
    private MinatService minatService;

    @Override
    @RequestMapping(value = "/agit.service.minat.submit", method = RequestMethod.POST)
    public ResponseEntity<Void> submitMinat(@RequestBody MinatDTO minatDTO) {
        Validate.notNull(minatService);
        minatService.SaveOrUpdate(minatDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteMinat(MinatDTO minatDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.minat.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<MinatDTO> findByID(@PathVariable("id") String id) {
        MinatDTO minatDTO = minatService.findByID(id);
        if (minatDTO != null) {
            return new ResponseEntity<>((minatDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.minat.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<MinatDTO>> findAll() {
        return new ResponseEntity<>((minatService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<MinatDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(value = "/agit.service.minat.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<MinatDTO> getDummyMinat(){
        return new ResponseEntity<>(minatService.getDummyData(), HttpStatus.FOUND);
    }
    
}
