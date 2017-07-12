package com.agit.crm.bpm.application.impl;

import com.agit.crm.bpm.application.WorkflowAPI;
import com.agit.crm.bpm.domain.htm.HumanTaskManager;
import com.agit.crm.bpm.domain.pvm.ProcessVirtualMachine;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 *
 * @author lintang
 */
public class WorkflowAPIImpl implements WorkflowAPI {

    /*get object from activiti engine - infrastructure*/
    private ProcessEngine processEngine;

    /*for spring injector*/
    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @Override
    public Process buildDefaultProcessFlowDefinition(String processID) throws IOException {
        return ProcessVirtualMachine.buildDefaultProcessFlowDefinition(processID);
    }

    @Override
    public BpmnModel buildProcessBpmnModelForThisProcessDefinition(Process process) {
        return ProcessVirtualMachine.buildProcessBpmnModelForThisProcessDefinition(process);
    }

    @Override
    public void generateGraphicalDiagramFor(BpmnModel bpmnModel) {
        ProcessVirtualMachine.generateGraphicalDiagramFor(bpmnModel);
    }

    @Override
    public Deployment deploy(BpmnModel bpmnModel, String bpmnFileName, String deploymentName) {
        return ProcessVirtualMachine.deploy(processEngine, bpmnModel, bpmnFileName, deploymentName);
    }

    @Override
    public Deployment deploy(String classPath, String deploymentName) {
        return ProcessVirtualMachine.deploy(processEngine, classPath, deploymentName);
    }

    @Override
    public List<Deployment> getListOfDeploymentInThisAVMEngine() {
        return ProcessVirtualMachine.getListOfDeploymentInThisAVMEngine(processEngine);
    }

    @Override
    public void undeploy(List<Deployment> deploymentIDs, boolean cascade) throws Exception {
        ProcessVirtualMachine.undeploy(processEngine, deploymentIDs, cascade);
    }

    @Override
    public void undeploy(String deploymentID, boolean cascade) throws Exception {
        ProcessVirtualMachine.deploy(processEngine, deploymentID, deploymentID);
    }

    @Override
    public void saveDiagramToPNG(String filePath, ProcessInstance processInstance) throws IOException {
        ProcessVirtualMachine.saveDiagramToPNG(processEngine, filePath, processInstance);
    }

    @Override
    public void saveDiagramToXML(Deployment deployment, String bpmnFile, String filePath) throws IOException {
        ProcessVirtualMachine.saveDiagramToXML(processEngine, deployment, bpmnFile, filePath);
    }

    @Override
    public ProcessInstance startBpmnModelProcess(Process process, Map arg0) {
        return ProcessVirtualMachine.startBpmnModelProcess(processEngine, process, arg0);
    }

    @Override
    public ProcessInstance startBpmnModelProcess(ProcessDefinition processDefinition, Map arg0) {
        return ProcessVirtualMachine.startBpmnModelProcess(processEngine, processDefinition, arg0);
    }

    @Override
    public ProcessInstance startBpmnModelProcess(String processDefinitionKey, Map<String, Object> arg0) {
        return ProcessVirtualMachine.startBpmnModelProcess(processEngine, processDefinitionKey, arg0);
    }

    @Override
    public List<Task> getCurrentTaskOfProcessInstance(ProcessInstance processInstance) {
        return HumanTaskManager.getCurrentTaskOfProcessInstance(processEngine, processInstance);
    }

    @Override
    public ProcessDefinition getListOfProcess(Deployment createdDeployment) {
        return HumanTaskManager.getListOfProcess(processEngine, createdDeployment);
    }

    @Override
    public User createUserForThisProcessEngine(String id, String email, String password, String groupId) {
        return HumanTaskManager.createUserForThisProcessEngine(processEngine, id, email, password, groupId);
    }

    @Override
    public Group createGroupForThisProcessEngine(String id, String name, String type) {
        return HumanTaskManager.createGroupForThisProcessEngine(processEngine, id, name, type);
    }

    @Override
    public void killThisProcessInstance(ProcessInstance processInstance) {
        HumanTaskManager.killThisProcessInstance(processEngine, processInstance);
    }

    @Override
    public List<User> getListUsers() {
        return HumanTaskManager.getListUsers(processEngine);
    }

    @Override
    public void deleteThisUser(User user) {
        HumanTaskManager.deleteThisUser(processEngine, user);
    }

    @Override
    public List<Group> getListGroups() {
        return HumanTaskManager.getListGroups(processEngine);
    }

    @Override
    public void deleteThisGroup(Group group) {
        HumanTaskManager.deleteThisGroup(processEngine, group);
    }

    @Override
    public List<Task> getListOfTaskForThisUser(User user) {
        return HumanTaskManager.getListOfTaskForThisUser(processEngine, user);
    }

    @Override
    public List<Task> getListOfTaskForThisUserID(String user) {
        return HumanTaskManager.getListOfTaskForThisUserID(processEngine, user);
    }

    @Override
    public List<Task> getListOfTaskInThisAVMEngine() {
        return HumanTaskManager.getListOfTaskInThisAVMEngine(processEngine);
    }

    @Override
    public User findUserById(String userID) {
        return HumanTaskManager.findUserById(processEngine, userID);
    }

    @Override
    public void executeToCompleteByThisUser(User user, Process process, ProcessInstance processInstance, String taskDefinitionKey, Map<String, Object> map) {
        HumanTaskManager.executeToCompleteByThisUser(processEngine, user, process, processInstance, taskDefinitionKey, map);
    }

    @Override
    public void executeToCompleteByThisUser(String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable) {
        HumanTaskManager.executeToCompleteByThisUser(processEngine, userID, processDefinitionKey, processInstanceID, taskDefinitionKey, processVariable);
    }

    @Override
    public Map<String, Object> getGlobalRuntimeVariable(ProcessInstance processInstance) {
        return HumanTaskManager.getGlobalRuntimeVariable(processEngine, processInstance);
    }

    @Override
    public Map<String, Object> getGlobalRuntimeVariable(String processInstanceID) {
        return HumanTaskManager.getGlobalRuntimeVariable(processEngine, processInstanceID);
    }

    @Override
    public void setGlobalRuntimeVariable(ProcessInstance processInstance, Map<String, Object> varContainer) {
        HumanTaskManager.setGlobalRuntimeVariable(processEngine, processInstance, varContainer);
    }

    @Override
    public void setGlobalRuntimeVariable(String processInstanceID, Map<String, Object> varContainer) {
        HumanTaskManager.setGlobalRuntimeVariable(processEngine, processInstanceID, varContainer);
    }

    @Override
    public Map<String, Object> getProcessVariableForThisTask(Task task) {
        return HumanTaskManager.getProcessVariableForThisTask(processEngine, task);
    }

    @Override
    public List<Task> getListOfTaskByActivityIDForThisUser(String user, String activityID) {
        return HumanTaskManager.getListOfTaskByActivityIDForThisUser(processEngine, user, activityID);
    }

    @Override
    public List<Task> getListOfTaskByActivityID(String activityID) {
        return HumanTaskManager.getListOfTaskByActivityID(processEngine, activityID);
    }

    @Override
    public void claimTaskByThisUser(String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable) {
        HumanTaskManager.claimTaskByThisUser(processEngine, userID, processDefinitionKey, processInstanceID, taskDefinitionKey, processVariable);
    }

    @Override
    public void claimTaskByThisUser(String userID, String taskID, Map<String, Object> processVariable) {
        HumanTaskManager.claimTaskByThisUser(processEngine, userID, taskID, processVariable);
    }

    @Override
    public void completeTaskByThisUser(String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable) {
        HumanTaskManager.completeTaskByThisUser(processEngine, userID, processDefinitionKey, processInstanceID, taskDefinitionKey, processVariable);
    }

    @Override
    public void completeTaskByThisUser(String userID, String taskID, Map<String, Object> processVariable) {
        HumanTaskManager.completeTaskByThisUser(processEngine, userID, taskID, processVariable);
    }

    @Override
    public List<Task> getCurrentTaskByProjectIDAndUserID(String projectID, String userID) {
        return HumanTaskManager.getCurrentTaskByProjectIDAndUserID(processEngine, projectID, userID);
    }

    @Override
    public List<Task> getCurrentTaskByProjectID(String projectID) {
        return HumanTaskManager.getCurrentTaskByProjectID(processEngine, projectID);
    }

    @Override
    public ProcessInstance startProcessInstanceByMessage(String messageName, Map<String, Object> arg0) {
        return ProcessVirtualMachine.startProcessInstanceByMessage(processEngine, messageName, arg0);
    }

    @Override
    public boolean messageEventReceived(String messageName, String processInstanceID, Map<String, Object> arg0) {
        return messageEventReceived(messageName, processInstanceID, arg0, Boolean.FALSE);
    }

    @Override
    public boolean messageEventReceived(String messageName, String executionID, Map<String, Object> arg0, boolean check) {
        return ProcessVirtualMachine.messageEventReceived(processEngine, messageName, executionID, arg0, check);
    }

    @Override
    public String getExecutionIDFromMessageEventByProjectID(String messageName, String projectID) {
        return ProcessVirtualMachine.getExecutionIDFromMessageEventByProjectID(processEngine, messageName, projectID);
    }

    @Override
    public String getProcessInstanceIDFromMessageEventByProjectID(String messageName, String projectID) {
        return ProcessVirtualMachine.getProcessInstanceIDFromMessageEventByProjectID(processEngine, messageName, projectID);
    }
}
