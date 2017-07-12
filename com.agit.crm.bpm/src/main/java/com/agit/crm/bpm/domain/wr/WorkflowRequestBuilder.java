package com.agit.crm.bpm.domain.wr;


public class WorkflowRequestBuilder {
    private String processDefintionKey;
    private String processInstanceID;
    private String taskDefinitionKey;
    private Object processVariable;
    private String initiator;
    private String taskDecisionStatus;
    private String processDecisionReason;
    private String jsonObjectOfNewValue;
    private String projectID;

    public WorkflowRequestBuilder() {
    }

    public WorkflowRequestBuilder setProcessDefintionKey(String processDefintionKey) {
        this.processDefintionKey = processDefintionKey;
        return this;
    }

    public WorkflowRequestBuilder setProcessInstanceID(String processInstanceID) {
        this.processInstanceID = processInstanceID;
        return this;
    }

    public WorkflowRequestBuilder setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
        return this;
    }

    public WorkflowRequestBuilder setProcessVariable(Object processVariable) {
        this.processVariable = processVariable;
        return this;
    }

    public WorkflowRequestBuilder setInitiator(String initiator) {
        this.initiator = initiator;
        return this;
    }

    public WorkflowRequestBuilder setTaskDecisionStatus(String taskDecisionStatus) {
        this.taskDecisionStatus = taskDecisionStatus;
        return this;
    }

    public WorkflowRequestBuilder setProcessDecisionReason(String processDecisionReason) {
        this.processDecisionReason = processDecisionReason;
        return this;
    }

    public WorkflowRequestBuilder setJsonObjectOfNewValue(String jsonObjectOfNewValue) {
        this.jsonObjectOfNewValue = jsonObjectOfNewValue;
        return this;
    }

    public WorkflowRequestBuilder setProjectID(String projectID) {
        this.projectID = projectID;
        return this;
    }

    public WorkflowRequest createWorkflowRequest() {
        return new WorkflowRequest(processDefintionKey, processInstanceID, taskDefinitionKey, processVariable, initiator, taskDecisionStatus, processDecisionReason, jsonObjectOfNewValue, projectID);
    }
    
}
