package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.interfaces.web.facade.JurusanServiceFacade;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Zaky
 */
public class JurusanServiceImpl implements JurusanServiceFacade {
    
    @Autowired
    private JurusanService jurusanService;

    public void setJurusanService(JurusanService jurusanService) {
        this.jurusanService = jurusanService;
    }

    @Override
    @RequestMapping(value = "/agit.service.jurusan.submit", method = RequestMethod.POST)
    public ResponseEntity<Void> submitJurusan(@RequestBody JurusanDTO jurusanDTO) {
        Validate.notNull(jurusanService);
        jurusanService.SaveOrUpdate(jurusanDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/agit.service.jurusan.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<JurusanDTO> getDummyJurusan() {
        return new ResponseEntity<>(jurusanService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteJurusan(JurusanDTO jurusanDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.jurusan.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<JurusanDTO> findByID(@PathVariable("id")  String id) {
        JurusanDTO jurusanDTO = jurusanService.findByID(id);
        if (jurusanDTO != null) {
            return new ResponseEntity<>((jurusanDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.jurusan.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<JurusanDTO>> findAll() {
        return new ResponseEntity<>((jurusanService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<JurusanDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
