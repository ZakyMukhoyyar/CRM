package com.agit.crm.common.infrastructure.persistence.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate3.Hibernate3Module;

/**
 *
 * @author ndru
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate3Module());
    }
}
