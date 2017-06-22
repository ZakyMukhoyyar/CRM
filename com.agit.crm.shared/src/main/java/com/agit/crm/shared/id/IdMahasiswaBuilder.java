package com.agit.crm.shared.id;


public class IdMahasiswaBuilder {

    private String id;

    public IdMahasiswaBuilder() {
    }

    public IdMahasiswaBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public IdMahasiswa createIdMahasiswa() {
        return new IdMahasiswa(id);
    }
    
}
