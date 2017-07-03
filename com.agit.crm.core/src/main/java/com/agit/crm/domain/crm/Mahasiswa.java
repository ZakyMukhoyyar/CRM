package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class Mahasiswa implements EntityObject<Mahasiswa> {

    long id;
    private String idMahasiswa;
    private String username;
    private String password;
    private String retypedPassword;
    private String namaLengkap;
    private String email;
    private Date tanggalLahir;
    private String domisili;
    private String noHP;
    private String noKTP;
    private String ipk;
    private JenisKelaminType jenisKelaminType;
    private PendidikanType pendidikanType;
    private String namaCivitas;
    private String minat;
    private String ketrampilan1;
    private String ketrampilan2;
    private String ketrampilan3;
    private String ketrampilan4;
    private String ketrampilan5;
    private TingkatanType tingkatanType1;
    private TingkatanType tingkatanType2;
    private TingkatanType tingkatanType3;
    private TingkatanType tingkatanType4;
    private TingkatanType tingkatanType5;
    private String uploadCV;
    private List<Lowongan> lowongans;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Boolean statusApprove;

    public Mahasiswa() {
    }

    public Mahasiswa(String idMahasiswa, String username, String password, String retypedPassword, String namaLengkap, String email, Date tanggalLahir, String domisili, String noHP, String noKTP, String ipk, JenisKelaminType jenisKelaminType, PendidikanType pendidikanType, String namaCivitas, String minat, String ketrampilan1, String ketrampilan2, String ketrampilan3, String ketrampilan4, String ketrampilan5, TingkatanType tingkatanType1, TingkatanType tingkatanType2, TingkatanType tingkatanType3, TingkatanType tingkatanType4, TingkatanType tingkatanType5, String uploadCV, List<Lowongan> lowongans, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Boolean statusApprove) {
        this.idMahasiswa = idMahasiswa;
        this.username = username;
        this.password = password;
        this.retypedPassword = retypedPassword;
        this.namaLengkap = namaLengkap;
        this.email = email;
        this.tanggalLahir = tanggalLahir;
        this.domisili = domisili;
        this.noHP = noHP;
        this.noKTP = noKTP;
        this.ipk = ipk;
        this.jenisKelaminType = jenisKelaminType;
        this.pendidikanType = pendidikanType;
        this.namaCivitas = namaCivitas;
        this.minat = minat;
        this.ketrampilan1 = ketrampilan1;
        this.ketrampilan2 = ketrampilan2;
        this.ketrampilan3 = ketrampilan3;
        this.ketrampilan4 = ketrampilan4;
        this.ketrampilan5 = ketrampilan5;
        this.tingkatanType1 = tingkatanType1;
        this.tingkatanType2 = tingkatanType2;
        this.tingkatanType3 = tingkatanType3;
        this.tingkatanType4 = tingkatanType4;
        this.tingkatanType5 = tingkatanType5;
        this.uploadCV = uploadCV;
        this.lowongans = lowongans;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.statusApprove = statusApprove;
    }

    public String getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }

    public JenisKelaminType getJenisKelaminType() {
        return jenisKelaminType;
    }

    public void setJenisKelaminType(JenisKelaminType jenisKelaminType) {
        this.jenisKelaminType = jenisKelaminType;
    }

    public PendidikanType getPendidikanType() {
        return pendidikanType;
    }

    public void setPendidikanType(PendidikanType pendidikanType) {
        this.pendidikanType = pendidikanType;
    }

    public String getNamaCivitas() {
        return namaCivitas;
    }

    public void setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
    }

    public String getKetrampilan1() {
        return ketrampilan1;
    }

    public void setKetrampilan1(String ketrampilan1) {
        this.ketrampilan1 = ketrampilan1;
    }

    public String getKetrampilan2() {
        return ketrampilan2;
    }

    public void setKetrampilan2(String ketrampilan2) {
        this.ketrampilan2 = ketrampilan2;
    }

    public String getKetrampilan3() {
        return ketrampilan3;
    }

    public void setKetrampilan3(String ketrampilan3) {
        this.ketrampilan3 = ketrampilan3;
    }

    public String getKetrampilan4() {
        return ketrampilan4;
    }

    public void setKetrampilan4(String ketrampilan4) {
        this.ketrampilan4 = ketrampilan4;
    }

    public String getKetrampilan5() {
        return ketrampilan5;
    }

    public void setKetrampilan5(String ketrampilan5) {
        this.ketrampilan5 = ketrampilan5;
    }

    public String getUploadCV() {
        return uploadCV;
    }

    public void setUploadCV(String uploadCV) {
        this.uploadCV = uploadCV;
    }

    public List<Lowongan> getLowongans() {
        return lowongans;
    }

    public void setLowongans(List<Lowongan> lowongans) {
        this.lowongans = lowongans;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatusApprove() {
        return statusApprove;
    }

    public void setStatusApprove(Boolean statusApprove) {
        this.statusApprove = statusApprove;
    }

    public TingkatanType getTingkatanType1() {
        return tingkatanType1;
    }

    public void setTingkatanType1(TingkatanType tingkatanType1) {
        this.tingkatanType1 = tingkatanType1;
    }

    public TingkatanType getTingkatanType2() {
        return tingkatanType2;
    }

    public void setTingkatanType2(TingkatanType tingkatanType2) {
        this.tingkatanType2 = tingkatanType2;
    }

    public TingkatanType getTingkatanType3() {
        return tingkatanType3;
    }

    public void setTingkatanType3(TingkatanType tingkatanType3) {
        this.tingkatanType3 = tingkatanType3;
    }

    public TingkatanType getTingkatanType4() {
        return tingkatanType4;
    }

    public void setTingkatanType4(TingkatanType tingkatanType4) {
        this.tingkatanType4 = tingkatanType4;
    }

    public TingkatanType getTingkatanType5() {
        return tingkatanType5;
    }

    public void setTingkatanType5(TingkatanType tingkatanType5) {
        this.tingkatanType5 = tingkatanType5;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idMahasiswa);
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.retypedPassword);
        hash = 89 * hash + Objects.hashCode(this.namaLengkap);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.tanggalLahir);
        hash = 89 * hash + Objects.hashCode(this.domisili);
        hash = 89 * hash + Objects.hashCode(this.noHP);
        hash = 89 * hash + Objects.hashCode(this.noKTP);
        hash = 89 * hash + Objects.hashCode(this.ipk);
        hash = 89 * hash + Objects.hashCode(this.jenisKelaminType);
        hash = 89 * hash + Objects.hashCode(this.pendidikanType);
        hash = 89 * hash + Objects.hashCode(this.namaCivitas);
        hash = 89 * hash + Objects.hashCode(this.minat);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan1);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan2);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan3);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan4);
        hash = 89 * hash + Objects.hashCode(this.ketrampilan5);
        hash = 89 * hash + Objects.hashCode(this.tingkatanType1);
        hash = 89 * hash + Objects.hashCode(this.tingkatanType2);
        hash = 89 * hash + Objects.hashCode(this.tingkatanType3);
        hash = 89 * hash + Objects.hashCode(this.tingkatanType4);
        hash = 89 * hash + Objects.hashCode(this.tingkatanType5);
        hash = 89 * hash + Objects.hashCode(this.uploadCV);
        hash = 89 * hash + Objects.hashCode(this.lowongans);
        hash = 89 * hash + Objects.hashCode(this.createdBy);
        hash = 89 * hash + Objects.hashCode(this.createdDate);
        hash = 89 * hash + Objects.hashCode(this.modifiedBy);
        hash = 89 * hash + Objects.hashCode(this.modifiedDate);
        hash = 89 * hash + Objects.hashCode(this.statusApprove);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mahasiswa other = (Mahasiswa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewMahasiswa(Mahasiswa mahasiswa) {
        this.idMahasiswa = mahasiswa.idMahasiswa;
        this.username = mahasiswa.username;
        this.password = mahasiswa.password;
        this.retypedPassword = mahasiswa.retypedPassword;
        this.namaLengkap = mahasiswa.namaLengkap;
        this.email = mahasiswa.email;
        this.tanggalLahir = mahasiswa.tanggalLahir;
        this.domisili = mahasiswa.domisili;
        this.noHP = mahasiswa.noHP;
        this.noKTP = mahasiswa.noKTP;
        this.ipk = mahasiswa.ipk;
        this.jenisKelaminType = mahasiswa.jenisKelaminType;
        this.pendidikanType = mahasiswa.pendidikanType;
        this.namaCivitas = mahasiswa.namaCivitas;
        this.minat = mahasiswa.minat;
        this.ketrampilan1 = mahasiswa.ketrampilan1;
        this.ketrampilan2 = mahasiswa.ketrampilan2;
        this.ketrampilan3 = mahasiswa.ketrampilan3;
        this.ketrampilan4 = mahasiswa.ketrampilan4;
        this.ketrampilan5 = mahasiswa.ketrampilan5;
        this.tingkatanType1 = mahasiswa.tingkatanType1;
        this.tingkatanType2 = mahasiswa.tingkatanType2;
        this.tingkatanType3 = mahasiswa.tingkatanType3;
        this.tingkatanType4 = mahasiswa.tingkatanType4;
        this.tingkatanType5 = mahasiswa.tingkatanType5;
        this.uploadCV = mahasiswa.uploadCV;
        this.lowongans = mahasiswa.lowongans;
        this.createdBy = mahasiswa.createdBy;
        this.createdDate = mahasiswa.createdDate;
        this.modifiedBy = mahasiswa.modifiedBy;
        this.modifiedDate = mahasiswa.modifiedDate;
        this.statusApprove = mahasiswa.statusApprove;
    }

    @Override
    public boolean sameIdentityAs(Mahasiswa other) {
        return this.equals(other);
    }

}
