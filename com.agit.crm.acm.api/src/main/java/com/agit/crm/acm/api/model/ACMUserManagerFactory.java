package com.agit.crm.acm.api.model;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;

/**
 *
 * @author lintang
 */
public class ACMUserManagerFactory implements SessionFactory {

    protected ACMConfigurator acmConfigurator;

    public ACMUserManagerFactory(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

    @Override
    public Class<?> getSessionType() {
        return UserIdentityManager.class;
    }

    @Override
    public Session openSession() {
        return new ACMUserManager(acmConfigurator);
    }

    public ACMConfigurator getAcmConfigurator() {
        return acmConfigurator;
    }

    public void setAcmConfigurator(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

}
