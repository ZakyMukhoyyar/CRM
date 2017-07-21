package com.agit.crm.application.impl;

import com.agit.crm.common.application.MahasiswaService;
import com.agit.crm.common.dto.crm.MahasiswaDTO;
import com.agit.crm.domain.crm.Lowongan;
import com.agit.crm.domain.crm.LowonganBuilder;
import com.agit.crm.domain.crm.LowonganRepository;
import com.agit.crm.domain.crm.LowonganStatus;
import com.agit.crm.domain.crm.LowonganStatusBuilder;
import com.agit.crm.domain.crm.Mahasiswa;
import com.agit.crm.domain.crm.MahasiswaBuilder;
import com.agit.crm.domain.crm.MahasiswaRepository;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswa;
import com.agit.crm.domain.crm.RiwayatApplyMahasiswaBuilder;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.LowonganDTOAssembler;
import com.agit.crm.interfaces.web.facade.dto.assembler.crm.MahasiswaDTOAssembler;
import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class MahasiswaServiceImpl implements MahasiswaService {

    private MahasiswaRepository mahasiswaRepository;
    private MahasiswaDTOAssembler mahasiswaDTOAssembler;
    private LowonganRepository lowonganRepository;
    private LowonganDTOAssembler lowonganDTOAssembler;

    public void setMahasiswaRepository(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public void setMahasiswaDTOAssembler(MahasiswaDTOAssembler mahasiswaDTOAssembler) {
        this.mahasiswaDTOAssembler = mahasiswaDTOAssembler;
    }

    public void setLowonganRepository(LowonganRepository lowonganRepository) {
        this.lowonganRepository = lowonganRepository;
    }

    public void setLowonganDTOAssembler(LowonganDTOAssembler lowonganDTOAssembler) {
        this.lowonganDTOAssembler = lowonganDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(MahasiswaDTO mahasiswa) {
        Mahasiswa t = mahasiswaRepository.findByID(mahasiswa.getIdMahasiswa());

        if (t == null) {
            t = mahasiswaDTOAssembler.toDomain(mahasiswa);
        } else {
            Mahasiswa newMahasiswa = mahasiswaDTOAssembler.toDomain(mahasiswa);
            t.assignNewMahasiswa(newMahasiswa);

        }
        mahasiswaRepository.saveOrUpdate(t);
    }

    @Override
    public void deleteData(MahasiswaDTO mahasiswa) {
        Mahasiswa p = mahasiswaDTOAssembler.toDomain(mahasiswa);
        mahasiswaRepository.deleteData(p);
    }

    @Override
    public MahasiswaDTO getDummyData() {
        
        /* Riwayat Apply Mahasiswa Dummy */
        /*dummy1*/
        RiwayatApplyMahasiswa riwayatApplyMahasiswa1 = new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa("RAM001")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .createRiwayatApplyMahasiswa();
        /*dummy2*/
        RiwayatApplyMahasiswa riwayatApplyMahasiswa2 = new RiwayatApplyMahasiswaBuilder()
                .setIdRiwayatApplyMahasiswa("RAM002")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .createRiwayatApplyMahasiswa();
        List<RiwayatApplyMahasiswa> riwayatApplyMahasiswas = new ArrayList<>();
        riwayatApplyMahasiswas.add(riwayatApplyMahasiswa1);
        riwayatApplyMahasiswas.add(riwayatApplyMahasiswa2);
        
        /* Lowongan Status Dummy */
        /*dummy1*/
        LowonganStatus lowonganStatus1 = new LowonganStatusBuilder()
                .setIdLowonganStatus("LS001")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("admin")
                .setCreatedDate(new Date())
                .setModifiedBy("user")
                .setModifiedDate(new Date())
                .createLowonganStatus();
        /*dummy2*/
        LowonganStatus lowonganStatus2 = new LowonganStatusBuilder()
                .setIdLowonganStatus("LS002")
                .setLowonganState(LowonganState.APPLY)
                .setCreatedBy("admin")
                .setCreatedDate(new Date())
                .setModifiedBy("user")
                .setModifiedDate(new Date())
                .createLowonganStatus();        
        List<LowonganStatus> lowonganStatuses = new ArrayList<>();
        lowonganStatuses.add(lowonganStatus1);
        lowonganStatuses.add(lowonganStatus2);
        
        Lowongan lowongan1 = new LowonganBuilder()
                .setIdLowongan("L001")
                .setNamaLowongan("namaLowongan")
                .setDeskripsiLowongan("deskripsiLowongan")
                .setTanggalMulai(new Date())
                .setTanggalBerakhir(new Date())
                .setMinatPekerjaan("minatPekerjaan")
                .setPersyaratan("persyaratan")
                .setLokasiKerja("lokasiKerja")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setListRiwayatApplyMahasiswa(riwayatApplyMahasiswas)
                .setListLowonganStatuses(lowonganStatuses)                
                .createLowongan();
        Lowongan lowongan2 = new LowonganBuilder()
                .setIdLowongan("L002")
                .setNamaLowongan("namaLowongan")
                .setDeskripsiLowongan("deskripsiLowongan")
                .setTanggalMulai(new Date())
                .setTanggalBerakhir(new Date())
                .setMinatPekerjaan("minatPekerjaan")
                .setPersyaratan("persyaratan")
                .setLokasiKerja("lokasiKerja")
                .setCreatedBy("created by")
                .setCreatedDate(new Date())
                .setModifiedBy("modified by")
                .setModifiedDate(new Date())
                .setListRiwayatApplyMahasiswa(riwayatApplyMahasiswas)
                .setListLowonganStatuses(lowonganStatuses)
                .createLowongan();        
        List<Lowongan> lowongans = new ArrayList<>();
        lowongans.add(lowongan1);
        lowongans.add(lowongan2);

        Mahasiswa mahasiswa = new MahasiswaBuilder()
                .setIdMahasiswa("M001")
                .setUsername("username")
                .setPassword("password")
                .setRetypedPassword("retypedPassword")
                .setNamaLengkap("namaLengkap")
                .setEmail("email")
                .setTanggalLahir(new Date())
                .setDomisili("domisili")
                .setNoHP("noHP")
                .setNoKTP("noKTP")
                .setIpk("nilaiIpk")
                .setJenisKelaminType(JenisKelaminType.WANITA)
                .setPendidikanType(PendidikanType.DIII)
                .setNamaCivitas("namaCivitas")
                .setMinat("minat")
                .setKetrampilan1("ketrampilan1")
                .setKetrampilan2("ketrampilan2")
                .setKetrampilan3("ketrampilan3")
                .setKetrampilan4("ketrampilan4")
                .setKetrampilan5("ketrampilan5")
                .setTingkatanType1(TingkatanType.KOMPETEN)
                .setTingkatanType2(TingkatanType.MENENGAH)
                .setTingkatanType3(TingkatanType.MENENGAH)
                .setTingkatanType4(TingkatanType.PEMULA)
                .setTingkatanType5(TingkatanType.PEMULA)
                .setUploadCV("uploadCV")
                .setCreatedBy("createdBy")
                .setCreatedDate(new Date())
                .setModifiedBy("modifiedBy")
                .setModifiedDate(new Date())
                .setStatusApprove(Boolean.TRUE)
                .setJurusan("IPS")
                .setLowongans(lowongans)
                .createMahasiswa();
        return mahasiswaDTOAssembler.toDTO(mahasiswa);
    }

    @Override
    public MahasiswaDTO findByID(String idMahasiswa) {
        Validate.notNull(mahasiswaRepository);
        Mahasiswa b = mahasiswaRepository.findByID(idMahasiswa);
        if (b != null) {
            return mahasiswaDTOAssembler.toDTO(b);
        }
        return null;
    }

    @Override
    public List<MahasiswaDTO> findAll() {
        Validate.notNull(mahasiswaRepository);
        List<Mahasiswa> listMahasiswa = mahasiswaRepository.findAll();
        if (listMahasiswa != null) {
            return mahasiswaDTOAssembler.mDomain2mDTO(listMahasiswa);
        }
        return null;
    }

    @Override
    public List<MahasiswaDTO> findByParams(Map map) {
        Validate.notNull(mahasiswaRepository);
        List<Mahasiswa> listMahasiswa = mahasiswaRepository.findByParams(map);
        if (listMahasiswa != null) {
            return (List<MahasiswaDTO>) mahasiswaDTOAssembler.mDomain2mDTO(listMahasiswa);
        }
        return null;
    }

    @Override
    public MahasiswaDTO findByNamaLengkap(String namaLengkap) {
        Validate.notNull(mahasiswaRepository);
        Mahasiswa b = mahasiswaRepository.findByNamaLengkap(namaLengkap);
        if (b != null) {
            return mahasiswaDTOAssembler.toDTO(b);
        }
        return null;
    }

}
