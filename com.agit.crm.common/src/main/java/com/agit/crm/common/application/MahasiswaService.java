package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.MahasiswaDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface MahasiswaService {

    void SaveOrUpdate(MahasiswaDTO mahasiswa);

    void deleteData(MahasiswaDTO mahasiswa);

    MahasiswaDTO getDummyData();

    MahasiswaDTO findByID(String idMahasiswa);

    List<MahasiswaDTO> findAll();

    List<MahasiswaDTO> findByParams(Map map);

}
