package com.agit.crm.common.interfaces.web.rest.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate3.Hibernate3Module;

/**
 *
 * @author merlin
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate3Module());
    }
}
