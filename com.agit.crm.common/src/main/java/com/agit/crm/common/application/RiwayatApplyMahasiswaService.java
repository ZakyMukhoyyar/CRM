package com.agit.crm.common.application;

import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface RiwayatApplyMahasiswaService {

    void SaveOrUpdate(RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa);

    void deleteData(RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa);

    RiwayatApplyMahasiswaDTO getDummyData();

    RiwayatApplyMahasiswaDTO findByID(String idRiwayatApplyMahasiswa);

    List<RiwayatApplyMahasiswaDTO> findAll();

    List<RiwayatApplyMahasiswaDTO> findByParams(Map map);
}
