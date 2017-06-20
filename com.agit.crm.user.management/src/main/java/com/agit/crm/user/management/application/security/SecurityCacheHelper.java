package com.agit.crm.user.management.application.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author bayutridewanto
 */
public final class SecurityCacheHelper {
    
    public static String USER_DETAIL = "USER_DETAIL";
    public static String MENU = "MENU";
    public static String ROOT = "ROOT";
    public static String SYS_PAR = "SYS_PAR";
    
    private SecurityCacheHelper() {
    }

    /* common instance cache, cacheType is static String above */
    public static Object getObjectInCache(String cacheType, String key) {
        return (Object) SecurityCacheImpl.getInstance().get(cacheType + key);
    }
    
    public static void putObjectInCache(String cacheType, String key, Object value) {
        SecurityCacheImpl.getInstance().put(cacheType + key, value);
    }
    
    public static void invalidate(String cacheType, String key) {
        SecurityCacheImpl.getInstance().remove(cacheType + key);
    }
    
    public static List<GrantedAuthority> getAuthorities(String roleID) {
        return (List<GrantedAuthority>) SecurityCacheImpl.getAuthority().get(roleID);
    }

    /* this cache for updating role-authorities */
    public static void setAuthorities(String roleID, List<GrantedAuthority> authorities) {
        SecurityCacheImpl.getAuthority().put(roleID, authorities);
    }

    /* cache remove when privilege is updated */
    public static void removeAllAuthorities() {
        SecurityCacheImpl.getAuthority().setMap(new HashMap<String, Object>());
        invalidate(MENU, MENU);
        invalidate(ROOT, ROOT);
        SecurityCacheImpl cache = SecurityCacheImpl.getInstance();
        Map<String, Object> users = new HashMap<>();
        users.putAll(cache.getMap());
        for (Map.Entry<String, Object> entrySet : users.entrySet()) {
            if (entrySet.getKey().contains(USER_DETAIL)) {
                SecurityCacheImpl.getInstance().remove(entrySet.getKey());
            }
        }
    }

    /* cache remove when role is updated */
    public static void removeAuthorities(String roleID) {
        SecurityCacheImpl.getAuthority().remove(roleID);
    }
    
}
