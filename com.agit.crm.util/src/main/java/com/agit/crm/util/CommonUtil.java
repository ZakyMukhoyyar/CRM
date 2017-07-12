package com.agit.crm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public class CommonUtil {
    public static Map<String, Object> convertObject2Map(Object o) {
        ObjectMapper m = new ObjectMapper();
        return m.convertValue(o, Map.class);
    }
    
    public static Object convertMap2Object(Map<String, Object> o, Class c) {
        ObjectMapper m = new ObjectMapper();
        return m.convertValue(o, c);
    }
    
    public static Object convertMap2DTO(Map<String, Object> o, Class c) {
        Map<String, Object> map = new HashMap();
        
        for (Map.Entry thisEntry : o.entrySet()) {
            String key = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, thisEntry.getKey().toString());
            Object obj = thisEntry.getValue();
            
            map.put(key, obj);
        }
        
        ObjectMapper m = new ObjectMapper();
        return m.convertValue(map, c);
    }
    
    public static Map<String, Object> convertDTO2Map(Object o) {
        Map<String, Object> map = new HashMap();
        
        for (Map.Entry thisEntry : CommonUtil.convertObject2Map(o).entrySet()) {
            String key = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, thisEntry.getKey().toString());
            Object obj = thisEntry.getValue();
            
            map.put(key, obj);
        }
        return map;
    }
    
    public static String Pojo2JsonString(Object object) throws JsonProcessingException{
        ObjectMapper o = new ObjectMapper();
        String jsonObjectStr = o.writeValueAsString(object);
        return jsonObjectStr;
    }
}
