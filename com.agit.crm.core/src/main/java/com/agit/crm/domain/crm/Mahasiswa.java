package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.type.PendidikanType;
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
    private PendidikanType pendidikanType;
    private String namaCivitas;
    private String minat;
    private String ketrampilan1;
    private String ketrampilan2;
    private String ketrampilan3;
    private String ketrampilan4;
    private String ketrampilan5;
    private String tingkat1;
    private String tingkat2;
    private String tingkat3;
    private String tingkat4;
    private String tingkat5;
    private String uploadCV;
    private List<Lowongan> lowongans;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public Mahasiswa() {
    }

    public Mahasiswa(String idMahasiswa, String username, String password, String retypedPassword, String namaLengkap, String email, Date tanggalLahir, String domisili, String noHP, PendidikanType pendidikanType, String namaCivitas, String minat, String ketrampilan1, String ketrampilan2, String ketrampilan3, String ketrampilan4, String ketrampilan5, String tingkat1, String tingkat2, String tingkat3, String tingkat4, String tingkat5, String uploadCV, List<Lowongan> lowongans, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idMahasiswa = idMahasiswa;
        this.username = username;
        this.password = password;
        this.retypedPassword = retypedPassword;
        this.namaLengkap = namaLengkap;
        this.email = email;
        this.tanggalLahir = tanggalLahir;
        this.domisili = domisili;
        this.noHP = noHP;
        this.pendidikanType = pendidikanType;
        this.namaCivitas = namaCivitas;
        this.minat = minat;
        this.ketrampilan1 = ketrampilan1;
        this.ketrampilan2 = ketrampilan2;
        this.ketrampilan3 = ketrampilan3;
        this.ketrampilan4 = ketrampilan4;
        this.ketrampilan5 = ketrampilan5;
        this.tingkat1 = tingkat1;
        this.tingkat2 = tingkat2;
        this.tingkat3 = tingkat3;
        this.tingkat4 = tingkat4;
        this.tingkat5 = tingkat5;
        this.uploadCV = uploadCV;
        this.lowongans = lowongans;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
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

    public String getTingkat1() {
        return tingkat1;
    }

    public void setTingkat1(String tingkat1) {
        this.tingkat1 = tingkat1;
    }

    public String getTingkat2() {
        return tingkat2;
    }

    public void setTingkat2(String tingkat2) {
        this.tingkat2 = tingkat2;
    }

    public String getTingkat3() {
        return tingkat3;
    }

    public void setTingkat3(String tingkat3) {
        this.tingkat3 = tingkat3;
    }

    public String getTingkat4() {
        return tingkat4;
    }

    public void setTingkat4(String tingkat4) {
        this.tingkat4 = tingkat4;
    }

    public String getTingkat5() {
        return tingkat5;
    }

    public void setTingkat5(String tingkat5) {
        this.tingkat5 = tingkat5;
    }

    public String getUploadCV() {
        return uploadCV;
    }

    public void setUploadCV(String uploadCV) {
        this.uploadCV = uploadCV;
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

    public List<Lowongan> getLowongans() {
        return lowongans;
    }

    public void setLowongans(List<Lowongan> lowongans) {
        this.lowongans = lowongans;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idMahasiswa);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.retypedPassword);
        hash = 29 * hash + Objects.hashCode(this.namaLengkap);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.tanggalLahir);
        hash = 29 * hash + Objects.hashCode(this.domisili);
        hash = 29 * hash + Objects.hashCode(this.noHP);
        hash = 29 * hash + Objects.hashCode(this.pendidikanType);
        hash = 29 * hash + Objects.hashCode(this.namaCivitas);
        hash = 29 * hash + Objects.hashCode(this.minat);
        hash = 29 * hash + Objects.hashCode(this.ketrampilan1);
        hash = 29 * hash + Objects.hashCode(this.ketrampilan2);
        hash = 29 * hash + Objects.hashCode(this.ketrampilan3);
        hash = 29 * hash + Objects.hashCode(this.ketrampilan4);
        hash = 29 * hash + Objects.hashCode(this.ketrampilan5);
        hash = 29 * hash + Objects.hashCode(this.tingkat1);
        hash = 29 * hash + Objects.hashCode(this.tingkat2);
        hash = 29 * hash + Objects.hashCode(this.tingkat3);
        hash = 29 * hash + Objects.hashCode(this.tingkat4);
        hash = 29 * hash + Objects.hashCode(this.tingkat5);
        hash = 29 * hash + Objects.hashCode(this.uploadCV);
        hash = 29 * hash + Objects.hashCode(this.lowongans);
        hash = 29 * hash + Objects.hashCode(this.createdBy);
        hash = 29 * hash + Objects.hashCode(this.createdDate);
        hash = 29 * hash + Objects.hashCode(this.modifiedBy);
        hash = 29 * hash + Objects.hashCode(this.modifiedDate);
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
        this.username = mahasiswa.username;
        this.password = mahasiswa.password;
        this.retypedPassword = mahasiswa.retypedPassword;
        this.namaLengkap = mahasiswa.namaLengkap;
        this.email = mahasiswa.email;
        this.tanggalLahir = mahasiswa.tanggalLahir;
        this.domisili = mahasiswa.domisili;
        this.noHP = mahasiswa.noHP;
        this.pendidikanType = mahasiswa.pendidikanType;
        this.namaCivitas = mahasiswa.namaCivitas;
        this.minat = mahasiswa.minat;
        this.ketrampilan1 = mahasiswa.ketrampilan1;
        this.ketrampilan2 = mahasiswa.ketrampilan2;
        this.ketrampilan3 = mahasiswa.ketrampilan3;
        this.ketrampilan4 = mahasiswa.ketrampilan4;
        this.ketrampilan5 = mahasiswa.ketrampilan5;
        this.tingkat1 = mahasiswa.tingkat1;
        this.tingkat2 = mahasiswa.tingkat2;
        this.tingkat3 = mahasiswa.tingkat3;
        this.tingkat4 = mahasiswa.tingkat4;
        this.tingkat5 = mahasiswa.tingkat5;
        this.uploadCV = mahasiswa.uploadCV;
        this.lowongans = mahasiswa.lowongans;
        this.modifiedBy = mahasiswa.modifiedBy;
        this.modifiedDate = mahasiswa.modifiedDate;
    }

    @Override
    public boolean sameIdentityAs(Mahasiswa other) {
        return this.equals(other);
    }

}
