package com.agit.crm.bpm.application;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

/**
 *
 * @author ndru
 */
public interface WorkflowAPI {

    /* 1. build flow definition*/
    Process buildDefaultProcessFlowDefinition(String processID) throws IOException;

    /* 2. build bpmn model*/
    BpmnModel buildProcessBpmnModelForThisProcessDefinition(Process process);

    /*3. Generate graphical information*/
    void generateGraphicalDiagramFor(BpmnModel bpmnModel);

    /*4. Deploy model*/
    Deployment deploy(BpmnModel bpmnModel, String bpmnFileName, String deploymentName);

    Deployment deploy(String classPath, String deploymentName);

    /*5. List of deployment*/
    List<Deployment> getListOfDeploymentInThisAVMEngine();

    /*6. Undeploy model*/
    void undeploy(List<Deployment> deploymentIDs, boolean cascade) throws Exception;

    /*7. save model to xml*/
    void saveDiagramToXML(Deployment deployment, String bpmnFile, String filePath) throws IOException;

    /*8. start a process*/
    ProcessInstance startBpmnModelProcess(Process process, Map arg0);

    /*9. check list of task*/
    List<Task> getCurrentTaskOfProcessInstance(ProcessInstance processInstance);

    /*10. save model to PNG*/
    void saveDiagramToPNG(String filePath, ProcessInstance processInstance) throws IOException;

    /*11. create user*/
    User createUserForThisProcessEngine(String id, String email, String password, String groupId);

    /*11.1 List of user*/
    List<User> getListUsers();

    /*11.2 Delete user*/
    void deleteThisUser(User user);

    /*11.3 find user*/
    User findUserById(String userID);

    /*12. create group*/
    Group createGroupForThisProcessEngine(String id, String name, String type);

    /*12.1 list of group*/
    List<Group> getListGroups();

    /*12.2 delete group*/
    void deleteThisGroup(Group group);

    /*13. terminate process instance*/
    void killThisProcessInstance(ProcessInstance processInstance);

    /*14. Task Service*/
    List<Task> getListOfTaskForThisUser(User user);

    List<Task> getListOfTaskByActivityIDForThisUser(String user, String activityID);

    List<Task> getListOfTaskByActivityID(String activityID);

    Map<String, Object> getProcessVariableForThisTask(Task task);

    /*15. Execute to completion of my task*/
    void executeToCompleteByThisUser(User user, Process process, ProcessInstance processInstance, String taskDefinitionKey, Map<String, Object> map);

    Map<String, Object> getGlobalRuntimeVariable(ProcessInstance processInstance);

    void setGlobalRuntimeVariable(ProcessInstance processInstance, Map<String, Object> varContainer);

    ProcessDefinition getListOfProcess(Deployment createdDeployment);

    ProcessInstance startBpmnModelProcess(ProcessDefinition processDefinition, Map arg0);

    ProcessInstance startBpmnModelProcess(String processDefinitionKey, Map<String, Object> arg0);

    void executeToCompleteByThisUser(String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable);

    Map<String, Object> getGlobalRuntimeVariable(String processInstanceID);

    void undeploy(String deploymentID, boolean cascade) throws Exception;

//    Process generateBusinessFlowFromACM(AvmBusinessProcess acmProcess);
    List<Task> getListOfTaskInThisAVMEngine();

    void setGlobalRuntimeVariable(String processInstanceID, Map<String, Object> varContainer);

    List<Task> getListOfTaskForThisUserID(String user);

    public void claimTaskByThisUser(String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable);

    public void claimTaskByThisUser(String userID, String taskID, Map<String, Object> processVariable);

    public void completeTaskByThisUser(String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable);

    public void completeTaskByThisUser(String userID, String taskID, Map<String, Object> processVariable);

    public List<Task> getCurrentTaskByProjectIDAndUserID(String projectID, String userID);

    public List<Task> getCurrentTaskByProjectID(String projectID);

    public ProcessInstance startProcessInstanceByMessage(String messageName, Map<String, Object> processVariables);

    public boolean messageEventReceived(String messageName, String processInstanceID, Map<String, Object> arg0);

    public boolean messageEventReceived(String messageName, String executionID, Map<String, Object> map, boolean check);
    
    public String getExecutionIDFromMessageEventByProjectID(String messageName, String projectID);
    
    public String getProcessInstanceIDFromMessageEventByProjectID(String messageName, String projectID);
}
