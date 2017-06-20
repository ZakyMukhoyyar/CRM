package com.agit.crm.shared.object;

/**
 *
 * @author bayutridewanto
 */
public enum Modul {

    REPORT("http://localhost:9090/fnd/api/");

    private String url;

    private Modul(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
