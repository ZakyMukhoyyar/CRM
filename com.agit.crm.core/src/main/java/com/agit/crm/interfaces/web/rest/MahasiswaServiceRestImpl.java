package com.agit.crm.interfaces.web.rest;

import com.agit.crm.common.application.MahasiswaService;
import com.agit.crm.common.dto.crm.MahasiswaDTO;
import com.agit.crm.interfaces.web.facade.MahasiswaServiceFacade;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bayu Hendra Setiawan
 */
@Controller
public class MahasiswaServiceRestImpl implements MahasiswaServiceFacade {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Override
    @RequestMapping(value = "/agit.service.mahasiswa", method = RequestMethod.POST)
    public ResponseEntity<Void> submitMahasiswa(MahasiswaDTO mahasiswaDTO) {
        Validate.notNull(mahasiswaService);
        mahasiswaService.SaveOrUpdate(mahasiswaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/agit.service.mahasiswa.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<MahasiswaDTO> getDummyMahasiswa() {
        return new ResponseEntity<>(mahasiswaService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteMahasiswa(MahasiswaDTO mahasiswaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/agit.service.mahasiswa.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<MahasiswaDTO> findByID(@PathVariable("id") String id) {
        MahasiswaDTO mahasiswaDTO = mahasiswaService.findByID(id);
        if (mahasiswaDTO != null) {
            return new ResponseEntity<>((mahasiswaDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/agit.service.mahasiswa.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<MahasiswaDTO>> findAll() {
        return new ResponseEntity<>((mahasiswaService.findAll()), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<MahasiswaDTO>> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
