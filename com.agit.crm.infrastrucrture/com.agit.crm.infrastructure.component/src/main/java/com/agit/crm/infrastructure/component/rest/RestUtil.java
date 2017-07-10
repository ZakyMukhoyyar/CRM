package com.agit.crm.infrastructure.component.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bayutridewanto
 */
public class RestUtil {

    public static ResponseEntity restServiceExchange(Modul modul, String url, HttpMethod httpMethod, HttpEntity request, Class c, Object... varargs) {
        RestTemplate restTemplate = new RestTemplate();
        if (httpMethod.equals(HttpMethod.POST) || httpMethod.equals(HttpMethod.PUT)) {
            c = null;
        }
        ResponseEntity response = restTemplate.exchange(modul.getUrl() + url, httpMethod, request, c, varargs);
        return response;
    }

    public static ResponseEntity restServiceExchange(String url, HttpMethod httpMethod, HttpEntity request, Class c, Object... varargs) {
        RestTemplate restTemplate = new RestTemplate();
        if (httpMethod.equals(HttpMethod.POST) || httpMethod.equals(HttpMethod.PUT)) {
            c = null;
        }
        ResponseEntity response = restTemplate.exchange(url, httpMethod, request, c, varargs);
        return response;
    }

    public static ResponseEntity returnableRestServiceExchange(Modul modul, String url, HttpMethod httpMethod, HttpEntity request, Class c, Object... varargs) {
        return new RestTemplate().exchange(modul.getUrl() + url, httpMethod, request, c, varargs);
    }
}
