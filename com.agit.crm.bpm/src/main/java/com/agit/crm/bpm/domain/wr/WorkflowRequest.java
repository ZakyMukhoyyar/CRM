package com.agit.crm.bpm.domain.wr;

import java.io.Serializable;

/**
 *
 * @author lintang
 */
public class WorkflowRequest implements Serializable {

    private String processDefintionKey;
    private String processInstanceID;
    private String taskDefinitionKey;
    private Object processVariable;
    private String initiator;
    private String taskDecisionStatus;
    private String processDecisionReason;
    private String jsonObjectOfNewValue;
    private String projectID;

    public WorkflowRequest() {
    }

    public WorkflowRequest(String processDefintionKey, String processInstanceID, String taskDefinitionKey, Object processVariable, String initiator, String taskDecisionStatus, String processDecisionReason, String jsonObjectOfNewValue, String projectID) {
        this.processDefintionKey = processDefintionKey;
        this.processInstanceID = processInstanceID;
        this.taskDefinitionKey = taskDefinitionKey;
        this.processVariable = processVariable;
        this.initiator = initiator;
        this.taskDecisionStatus = taskDecisionStatus;
        this.processDecisionReason = processDecisionReason;
        this.jsonObjectOfNewValue = jsonObjectOfNewValue;
        this.projectID = projectID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProcessDefintionKey() {
        return processDefintionKey;
    }

    public void setProcessDefintionKey(String processDefintionKey) {
        this.processDefintionKey = processDefintionKey;
    }

    public String getProcessInstanceID() {
        return processInstanceID;
    }

    public void setProcessInstanceID(String processInstanceID) {
        this.processInstanceID = processInstanceID;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public Object getProcessVariable() {
        return processVariable;
    }

    public void setProcessVariable(Object processVariable) {
        this.processVariable = processVariable;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getTaskDecisionStatus() {
        return taskDecisionStatus;
    }

    public void setTaskDecisionStatus(String taskDecisionStatus) {
        this.taskDecisionStatus = taskDecisionStatus;
    }

    public String getProcessDecisionReason() {
        return processDecisionReason;
    }

    public void setProcessDecisionReason(String processDecisionReason) {
        this.processDecisionReason = processDecisionReason;
    }

    public String getJsonObjectOfNewValue() {
        return jsonObjectOfNewValue;
    }

    public void setJsonObjectOfNewValue(String jsonObjectOfNewValue) {
        this.jsonObjectOfNewValue = jsonObjectOfNewValue;
    }

}
