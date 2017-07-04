package com.agit.crm.interfaces.web.facade;

import com.agit.crm.common.dto.crm.MahasiswaDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface MahasiswaServiceFacade {

    ResponseEntity<Void> submitMahasiswa(MahasiswaDTO mahasiswaDTO);

    ResponseEntity<Void> deleteMahasiswa(MahasiswaDTO mahasiswaDTO);

    ResponseEntity<MahasiswaDTO> findByID(String idMahasiswa);

    ResponseEntity<List<MahasiswaDTO>> findAll();

    ResponseEntity<List<MahasiswaDTO>> findByParams(Map map);
}
