package com.agit.crm.infrastructure.report;

import java.util.HashMap;
import java.util.Map;

import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.beans.BeanMap;

/**
 *
 * @author bayutridewanto
 *
 * @param <T> report template type
 */
public abstract class AbstractReportServiceImpl<T> implements ReportService, InitializingBean {

    private HTreeMap<String, T> reportTemplateMap = null;
    private double reportTemplateCacheSizeGb = 0.1;

    /**
     * Convert a bean to parameter map
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> convertToParamMap(Object bean) {
        final HashMap<String, Object> map = new HashMap<>();
        if (bean == null) {
            return map;
        }
        BeanMap bm = BeanMap.create(bean);
        for (Object k : bm.keySet()) {
            Object v = bm.get(k);
            if (v != null) {
                map.put(String.valueOf(k), v);
            }
        }
        return map;
    }

    protected T getTemplateFromCache(String key) {
        return this.reportTemplateMap.get(key);
    }

    protected void putTemplateToCache(String key, T template) {
        this.reportTemplateMap.put(key, template);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.reportTemplateMap = DBMaker.newCacheDirect(this.reportTemplateCacheSizeGb);
    }

    public void setReportTemplateCacheSizeGb(double reportTemplateCacheSizeGb) {
        this.reportTemplateCacheSizeGb = reportTemplateCacheSizeGb;
    }

    @Override
    public void flushTemplateCache() {
        reportTemplateMap.clear();
    }

}
