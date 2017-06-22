/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.shared.id;


public class IdLowonganBuilder {

    private String id;

    public IdLowonganBuilder() {
    }

    public IdLowonganBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public IdLowongan createIdLowongan() {
        return new IdLowongan(id);
    }
    
}
