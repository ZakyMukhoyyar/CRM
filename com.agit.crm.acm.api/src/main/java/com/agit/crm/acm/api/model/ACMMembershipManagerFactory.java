package com.agit.crm.acm.api.model;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.MembershipIdentityManager;

/**
 *
 * @author lintang
 */
public class ACMMembershipManagerFactory implements SessionFactory {

    protected ACMConfigurator acmConfigurator;

    public ACMMembershipManagerFactory(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

    @Override
    public Class<?> getSessionType() {
        return MembershipIdentityManager.class;
    }

    @Override
    public Session openSession() {
        throw new UnsupportedOperationException("Memberships are not supported in ACM");
    }

    public ACMConfigurator getAcmConfigurator() {
        return acmConfigurator;
    }

    public void setAcmConfigurator(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

}
