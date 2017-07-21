package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.LowonganStatusService;
import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import com.agit.crm.interfaces.web.facade.LowonganStatusServiceFacade;
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
public class LowonganStatusServiceRestImpl implements LowonganStatusServiceFacade {

    @Autowired
    private LowonganStatusService lowonganStatusService;

    @Override
    @RequestMapping(value = "/agit.service.lowonganStatus.submit", method = RequestMethod.POST)
    public ResponseEntity<Void> submitLowonganStatus(@RequestBody LowonganStatusDTO lowonganStatusDTO) {
        Validate.notNull(lowonganStatusService);
        lowonganStatusService.saveOrUpdate(lowonganStatusDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteLowonganStatus(LowonganStatusDTO lowonganStatusDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.lowonganStatus.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<LowonganStatusDTO> findByID(@PathVariable("id") String id) {
        LowonganStatusDTO lowonganStatusDTO = lowonganStatusService.findByID(id);
        if (lowonganStatusDTO != null) {
            return new ResponseEntity<>((lowonganStatusDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.lowonganStatus.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<LowonganStatusDTO>> findAll() {
        return new ResponseEntity<>((lowonganStatusService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<LowonganStatusDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping(value = "/agit.service.lowonganStatus.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<LowonganStatusDTO> getDummyLowonganStatus() {
        return new ResponseEntity<>(lowonganStatusService.getDummy(), HttpStatus.FOUND);
    }

}
