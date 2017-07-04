package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.interfaces.web.facade.KetrampilanServiceFacade;
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
public class KetrampilanServiceRestImpl implements KetrampilanServiceFacade {

    @Autowired
    private KetrampilanService ketrampilanService;

    @Override
    @RequestMapping(value = "/agit.service.ketrampilan.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<KetrampilanDTO> findByID(@PathVariable("id") String id) {
        KetrampilanDTO ketrampilanDTO = ketrampilanService.findByID(id);
        if (ketrampilanDTO != null) {
            return new ResponseEntity<>((ketrampilanDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.ketrampilan.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<KetrampilanDTO>> findAll() {
        return new ResponseEntity<>((ketrampilanService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<KetrampilanDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.ketrampilan", method = RequestMethod.POST)
    public ResponseEntity<Void> submitKetrampilan(@RequestBody KetrampilanDTO ketrampilanDTO) {
        Validate.notNull(ketrampilanService);
        ketrampilanService.SaveOrUpdate(ketrampilanDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/agit.service.ketrampilan.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<KetrampilanDTO> getDummyMahasiswa() {
        return new ResponseEntity<>(ketrampilanService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteKetrampilan(KetrampilanDTO ketrampilanDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
