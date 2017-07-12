package com.agit.crm.acm.api.model;

import com.agit.crm.acm.api.model.ACMGroupCache.ACMGroupCacheListener;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.activiti.engine.runtime.ClockReader;

/**
 *
 * @author lintang
 */
public class ACMGroupManagerFactory implements SessionFactory {

    protected ACMConfigurator acmConfigurator;
    protected ACMGroupCache acmGroupCache;
    protected ACMGroupCacheListener acmCacheListener;

    public ACMGroupManagerFactory(ACMConfigurator acmConfigurator, ClockReader clockReader) {
        this.acmConfigurator = acmConfigurator;
        if (acmConfigurator.getGroupCacheSize() > 0) {
            acmGroupCache = new ACMGroupCache(acmConfigurator.getGroupCacheSize(),clockReader,acmConfigurator.getGroupCacheExpirationTime());
            if (acmCacheListener != null) {
                acmGroupCache.setACMCacheListener(acmCacheListener);
            }
        }
    }

    @Override
    public Class<?> getSessionType() {
         return GroupIdentityManager.class;
    }

    @Override
    public Session openSession() {
        if (acmGroupCache == null) {
            return new ACMGroupManager(acmConfigurator);
        } else {
            return new ACMGroupManager(acmConfigurator, acmGroupCache);
        }
    }

    public ACMConfigurator getAcmConfigurator() {
        return acmConfigurator;
    }

    public void setAcmConfigurator(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }
    
}
