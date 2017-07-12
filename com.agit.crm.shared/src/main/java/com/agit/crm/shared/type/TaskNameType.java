package com.agit.crm.shared.type;

/**
 *
 * @author bayutridewanto
 */
public enum TaskNameType {

    START("START"),
    SUBMIT_PROJECT("SUBMIT_PROJECT"),
    CONFIRM_PROJECT("CONFIRM_PROJECT"),
    REOPEN("REOPEN"),
    FINISH("FINISH");

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
