package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.interfaces.web.facade.CivitasServiceFacade;
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
public class CivitasServiceRestImpl implements CivitasServiceFacade {

    @Autowired
    private CivitasService civitasService;

    @Override
    @RequestMapping(value = "/agit.service.civitas", method = RequestMethod.POST)
    public ResponseEntity<Void> submitCivitas(@RequestBody CivitasDTO civitasDTO) {
        Validate.notNull(civitasService);
        civitasService.SaveOrUpdate(civitasDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/agit.service.civitas.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<CivitasDTO> getDummyMahasiswa() {
        return new ResponseEntity<>(civitasService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteCivitas(CivitasDTO civitasDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.civitas.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<CivitasDTO> findByID(@PathVariable("id") String id) {
        CivitasDTO civitasDTO = civitasService.findByID(id);
        if (civitasDTO != null) {
            return new ResponseEntity<>((civitasDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.civitas.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<CivitasDTO>> findAll() {
        return new ResponseEntity<>((civitasService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<CivitasDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
