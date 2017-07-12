package com.agit.crm.acm.api.model;

import org.activiti.engine.cfg.AbstractProcessEngineConfigurator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.runtime.Clock;
import org.activiti.engine.runtime.ClockReader;

/**
 *
 * @author lintang
 */
public class ACMConfigurator extends AbstractProcessEngineConfigurator {

    // Pluggable factories
    protected ACMUserManagerFactory acmUserManagerFactory;
    protected ACMGroupManagerFactory acmGroupManagerFactory;
    protected ACMMembershipManagerFactory acmMembershipManagerFactory;

    // Pluggable query helper bean
    protected ACMQueryBuilder ldapQueryBuilder = new ACMQueryBuilder();

    private Clock clock;

    // Group caching
    protected int groupCacheSize = -1;
    protected long groupCacheExpirationTime = 3600000L; // default: one hour

    @Override
    public void beforeInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        /*nothing to do*/
    }

    @Override
    public void configure(ProcessEngineConfigurationImpl processEngineConfiguration) {
        clock = processEngineConfiguration.getClock();
        acmUserManagerFactory = getAcmUserManagerFactory();
        processEngineConfiguration.getSessionFactories().put(acmUserManagerFactory.getSessionType(), acmUserManagerFactory);

        acmGroupManagerFactory = getAcmGroupManagerFactory(clock);
        processEngineConfiguration.getSessionFactories().put(acmGroupManagerFactory.getSessionType(), acmGroupManagerFactory);
    }

    /*setter getter*/
    public ACMUserManagerFactory getAcmUserManagerFactory() {
        if (this.acmUserManagerFactory != null) {
            this.acmUserManagerFactory.setAcmConfigurator(this);
            return this.acmUserManagerFactory;
        }
        return new ACMUserManagerFactory(this);
    }

    public ACMGroupManagerFactory getAcmGroupManagerFactory(ClockReader clockReader) {
        if (this.acmGroupManagerFactory != null) {
            this.acmGroupManagerFactory.setAcmConfigurator(this);
            return this.acmGroupManagerFactory;
        }
        return new ACMGroupManagerFactory(this, clockReader);
    }

    public ACMMembershipManagerFactory getAcmMembershipManagerFactory() {
        if (this.acmMembershipManagerFactory != null) {
            this.acmMembershipManagerFactory.setAcmConfigurator(this);
        }
        return new ACMMembershipManagerFactory(this);
    }

    public Clock getClock() {
        return clock;
    }

    public int getGroupCacheSize() {
        return groupCacheSize;
    }

    public void setGroupCacheSize(int groupCacheSize) {
        this.groupCacheSize = groupCacheSize;
    }

    public long getGroupCacheExpirationTime() {
        return groupCacheExpirationTime;
    }

    public void setGroupCacheExpirationTime(long groupCacheExpirationTime) {
        this.groupCacheExpirationTime = groupCacheExpirationTime;
    }

    public ACMQueryBuilder getLdapQueryBuilder() {
        return ldapQueryBuilder;
    }

    public void setLdapQueryBuilder(ACMQueryBuilder ldapQueryBuilder) {
        this.ldapQueryBuilder = ldapQueryBuilder;
    }

}
