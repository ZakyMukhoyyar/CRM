package com.agit.crm.infrastructure.report;

/**
 *
 * @author bayutridewanto
 */
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

public class MessageSourceStaticContextUtil implements InitializingBean, ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, MessageSource> beanMap = ctx.getBeansOfType(MessageSource.class);
        MessageCode.setMessageSources(beanMap.values());
    }
}
