package com.agit.crm.shared.report;

/**
 *
 * @author bayutridewanto
 */
public enum GenerateReport {

    REPORT_TICKET("/reportTicket.jasper");

    private String value;

    private GenerateReport(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
