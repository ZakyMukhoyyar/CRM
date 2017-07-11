package com.agit.crm.shared.report;

/**
 *
 * @author bayutridewanto
 */
public enum FileReport {

    REPORT_TEST("/reportExample.jasper");

    private String jasperName;

    private FileReport(String jasperName) {
        this.jasperName = jasperName;
    }

    public String getJasperName() {
        return jasperName;
    }

    public void setJasperName(String jasperName) {
        this.jasperName = jasperName;
    }

}
