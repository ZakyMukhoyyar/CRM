package com.agit.crm.shared.type;

/**
 *
 * @author bayutridewanto
 */
public enum TaskNameType {

    IDE("IDE"),
    SA("SA"),
    SRE("SRE"),
    CA("CA"),
    DV("DV"),
    PO("PO"),
    FDE("FDE"),
    DR("DR"),
    PPD("PPD");

    private String taskName;

    private TaskNameType(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}
