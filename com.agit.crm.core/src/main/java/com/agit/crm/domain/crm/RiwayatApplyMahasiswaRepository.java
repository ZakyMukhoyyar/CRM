package com.agit.crm.domain.crm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public interface RiwayatApplyMahasiswaRepository {

    void saveOrUpdate(RiwayatApplyMahasiswa riwayatApplyMahasiswa);

    void deleteData(RiwayatApplyMahasiswa riwayatApplyMahasiswa);

    RiwayatApplyMahasiswa findByID(String idRiwayatApplyMahasiswa);

    List<RiwayatApplyMahasiswa> findAll();

    List<RiwayatApplyMahasiswa> findAllRiwayataLowongan(String idRiwayatLowongan);

    List<RiwayatApplyMahasiswa> findByParams(Map map);

    RiwayatApplyMahasiswa findByIDUser(String idUserRiwayat);

}
