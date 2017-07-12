package com.agit.crm.acm.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lintang
 */
public class ACMTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(ACMTemplate.class);
    protected ACMConfigurator acmConfigurator;

    public ACMTemplate(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

    public ACMConfigurator getAcmConfigurator() {
        return acmConfigurator;
    }

    public void setAcmConfigurator(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

    /*functional void*/
    public <T> T execute(ACMCallBack<T> acmCallBack) {
        T result = acmCallBack.executeInACMContext();
        return result;
    }

}
