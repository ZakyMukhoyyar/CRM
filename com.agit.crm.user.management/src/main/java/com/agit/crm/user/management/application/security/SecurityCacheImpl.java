package com.agit.crm.user.management.application.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public class SecurityCacheImpl implements SecurityCache {

    private static SecurityCacheImpl _instance = new SecurityCacheImpl();
    private static SecurityCacheImpl _authority = new SecurityCacheImpl();

    private Map<String, Object> map;

    public SecurityCacheImpl() {
        map = new HashMap<>();
    }

    @Override
    public Object put(String key, Object value) {
        Collections.synchronizedMap(map);
        return map.put(key, value);
    }

    @Override
    public Object remove(String key) {
        Collections.synchronizedMap(map);
        return map.remove(key);
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public static void setInstance(SecurityCacheImpl _instance) {
        SecurityCacheImpl._instance = _instance;
    }

    public static SecurityCacheImpl getInstance() {
        return _instance;
    }

    public static SecurityCacheImpl getAuthority() {
        return _authority;
    }

    public static void setAuthority(SecurityCacheImpl _authority) {
        SecurityCacheImpl._authority = _authority;
    }

}
