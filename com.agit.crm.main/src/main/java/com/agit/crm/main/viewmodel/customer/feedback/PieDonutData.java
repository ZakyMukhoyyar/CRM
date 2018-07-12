package com.agit.crm.main.viewmodel.customer.feedback;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author lintang
 */
public class PieDonutData {

    private static final Map<String, Double> browsers;
    private static final Map<String, Map<String, Double>> versions;

    static {
        browsers = new LinkedHashMap<String, Double>();
        versions = new LinkedHashMap<String, Map<String, Double>>();
        browsers.put("DKI JAKARTA", 55.11);
        Map<String, Double> msie = new LinkedHashMap<String, Double>();
        msie.put("Jakarta Pusat", 10.85);
        msie.put("Jakarta Selatan", 7.35);
        msie.put("Jakarta Timur", 33.06);
        msie.put("Jakarta Barat", 2.81);
        versions.put("DKI JAKARTA", msie);
        browsers.put("Jawa Barat", 21.63);
        Map<String, Double> firefox = new LinkedHashMap<String, Double>();
        firefox.put("Bandung", 0.20);
        firefox.put("Sukabumi", 0.83);
        firefox.put("Pangandaran", 1.58);
        firefox.put("Bogor", 13.12);
        firefox.put("Purwakarta", 5.43);
        versions.put("Jawa Barat", firefox);
        browsers.put("Jawa Tengah", 11.94);
        Map<String, Double> chrome = new LinkedHashMap<String, Double>();
        chrome.put("Semarang", 0.12);
        chrome.put("Pekalongan", 0.19);
        chrome.put("Tegal", 0.12);
        chrome.put("Kendal", 0.36);
        chrome.put("Demak", 0.32);
        chrome.put("Kudus", 9.91);
        chrome.put("Rembang", 0.50);
        chrome.put("Solo", 0.22);
        versions.put("Jawa Tengah", chrome);
        browsers.put("Jawa Timur", 7.15);
        Map<String, Double> safari = new LinkedHashMap<String, Double>();
        safari.put("Surabaya", 4.55);
        safari.put("Pacitan", 1.42);
        safari.put("Tuban", 0.23);
        safari.put("Probolinggo", 0.21);
        safari.put("Madiun", 0.20);
        safari.put("Malang", 0.19);
        safari.put("Magetan", 0.14);
        versions.put("Jawa Timur", safari);
        browsers.put("DIY Yogyakarta", 2.14);
        Map<String, Double> opera = new LinkedHashMap<String, Double>();
        opera.put("Yogyakarta", 0.12);
        opera.put("Gunung Kidul", 0.37);
        opera.put("Wates", 1.65);
        versions.put("DIY Yogyakarta", opera);
    }

    public static Map<String, Double> getBrowsers() {
        return browsers;
    }

    public static Map<String, Double> getVersions(String browser) {
        return versions.get(browser);
    }
}
