package com.agit.crm.shared.zul;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.zkoss.util.resource.LabelLocator2;

/**
 *
 * @author bayutridewanto
 */
public class LabelLocator implements LabelLocator2 {

    private final Logger logger = LoggerFactory.getLogger(LabelLocator.class);

    private String resourceName;

    public LabelLocator(String name) {
        this.resourceName = name;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public InputStream locate(Locale locale) {
        Resource resource = new ClassPathResource(resourceName + ".properties");
        try {
            return resource.getInputStream();
        } catch (IOException e) {
            if (logger.isDebugEnabled()) {
                logger.error("IOException for resource name: " + resourceName, e);
            }
            return null;
        }
    }

    @Override
    public String getCharset() {
        return "UTF-8";
    }
}
