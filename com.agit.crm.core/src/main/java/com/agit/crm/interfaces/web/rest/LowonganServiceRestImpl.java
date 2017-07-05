package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.interfaces.web.facade.LowonganServiceFacade;
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
public class LowonganServiceRestImpl implements LowonganServiceFacade {

    @Autowired
    private LowonganService lowonganService;

    @Override
    @RequestMapping(value = "/agit.service.lowongan", method = RequestMethod.POST)
    public ResponseEntity<Void> submitLowongan(@RequestBody LowonganDTO lowonganDTO) {
        Validate.notNull(lowonganService);
        lowonganService.SaveOrUpdate(lowonganDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/agit.service.lowongan.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<LowonganDTO> getDummyMahasiswa() {
        return new ResponseEntity<>(lowonganService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteLowongan(LowonganDTO lowonganDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.lowongan.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<LowonganDTO> findByID(@PathVariable("id") String id) {
        LowonganDTO lowonganDTO = lowonganService.findByID(id);
        if (lowonganDTO != null) {
            return new ResponseEntity<>((lowonganDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.lowongan.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<LowonganDTO>> findAll() {
        return new ResponseEntity<>((lowonganService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<LowonganDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
