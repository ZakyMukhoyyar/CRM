/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.interfaces.web.rest.hibernate;

import com.fasterxml.jackson.datatype.hibernate3.Hibernate3Module;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate3Module());
    }
}
