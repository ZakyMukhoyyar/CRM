package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface MahasiswaRepository {

    void saveOrUpdate(Mahasiswa mahasiswa);

    Mahasiswa findByID(String idMahasiswa);

    List<Mahasiswa> findAll();

    void deleteData(Mahasiswa mahasiswa);

    List<Mahasiswa> findByParams(Map map);

    Mahasiswa findByNamaLengkap(String namaApplyLowongan);
}
