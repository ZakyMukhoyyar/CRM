package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.DataToHrdService;
import com.agit.crm.common.dto.crm.DataToHrdDTO;
import com.agit.crm.interfaces.web.facade.DataToHrdServiceFacade;
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
public class DataToHrdRestImpl implements DataToHrdServiceFacade{
    
    @Autowired
    private DataToHrdService dataToHrdService;
    
    @Override
    @RequestMapping(value = "/agit.service.dataToHrd", method = RequestMethod.POST)
    public ResponseEntity<Void> submitDataToHrd(@RequestBody DataToHrdDTO dataToHrdDTO) {
        Validate.notNull(dataToHrdService);
        dataToHrdService.saveOrUpdate(dataToHrdDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/agit.service.dataToHrd.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<DataToHrdDTO> getDummyMahasiswa() {
        return new ResponseEntity<>(dataToHrdService.getDummy(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteDataToHrd(DataToHrdDTO dataToHrdDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.dataToHrd.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataToHrdDTO> findByID(@PathVariable("id") String id) {
        DataToHrdDTO dataToHrdDTO = dataToHrdService.findByID(id);
        if (dataToHrdDTO != null) {
            return new ResponseEntity<>((dataToHrdDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.dataToHrd.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<DataToHrdDTO>> findAll() {
        return new ResponseEntity<>((dataToHrdService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<DataToHrdDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
