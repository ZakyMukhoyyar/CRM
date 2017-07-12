package com.agit.crm.bpm.application.impl;

import com.agit.crm.bpm.api.application.TaskQueryService;
import com.agit.crm.bpm.application.WorkflowAPI;
import com.agit.crm.bpm.domain.wr.WorkflowRequest;
import com.agit.crm.bpm.domain.wr.WorkflowRequestBuilder;
//import com.agit.crm.common.application.ProjectService;
//import com.agit.crm.common.dto.property.ProjectDTO;
import com.agit.crm.shared.type.MessageNameType;
import com.agit.crm.shared.type.TaskNameType;
import com.agit.crm.util.JDCStringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 *
 * @author lintang
 */
public class TaskQueryServiceImpl implements TaskQueryService {

//    private final static String BPM_PATH = "bpm/agitJDC-v.1.2.0.bpmn20.xml";
    private final static String BPM_PATH = null;

    private Set<String> set;

    private WorkflowAPI workflowAPI;
//    private ProjectService projectService;

    public void setWorkflowAPI(WorkflowAPI workflowAPI) {
        this.workflowAPI = workflowAPI;
    }

//    public void setProjectService(ProjectService projectService) {
//        this.projectService = projectService;
//    }

    @Override
    public boolean startBPMProjectingByThisUserID(String projectID, String userID) {
        return startBPMProjectingByThisUserID(projectID, userID, BPM_PATH);
    }

    @Override
    public boolean startBPMProjectingByThisUserID(String projectID, String userID, String path) {
        Deployment deployment = workflowAPI.deploy(path, "projecting");

        if (!JDCStringUtil.hasValue(deployment)) {
            return false;
        }

        WorkflowRequest wfRequest = new WorkflowRequestBuilder()
                .setInitiator(userID)
                .setJsonObjectOfNewValue("")
                .setProcessDecisionReason("")
                .setProcessDefintionKey("projecting")
                .setProcessInstanceID(UUID.randomUUID().toString())
                .setProcessVariable(projectID)
                .setTaskDecisionStatus("")
                .setTaskDefinitionKey("")
                .setProjectID(projectID)
                .createWorkflowRequest();

        ProcessInstance processInstance = workflowAPI.startBpmnModelProcess(wfRequest.getProcessDefintionKey(), setProcessVars(wfRequest));

        if (!JDCStringUtil.hasValue(processInstance)) {
            return false;
        }

        Map<String, Object> map = workflowAPI.getGlobalRuntimeVariable(processInstance);
        map.put("processInstanceID", processInstance.getId());
        workflowAPI.setGlobalRuntimeVariable(processInstance, map);

        return claimAndExecuteThisTask(projectID, TaskNameType.SUBMIT_PROJECT, userID);
    }

//    @Override
//    public List<ProjectDTO> getAllProjectForThisUserID(String userID) {
//        set = new HashSet();
//
//        List<ProjectDTO> projectDTOs = new ArrayList();
//        List<Task> tasks = workflowAPI.getListOfTaskForThisUserID(userID);
//
//        for (Task task : tasks) {
//            String projectID = getGlobalVariableByProcessInstanceID(task.getProcessInstanceId()).get("projectID").toString();
//
//            if (set.contains(projectID)) {
//                continue;
//            }
//
//            set.add(projectID);
//            ProjectDTO projectDTO = projectService.findByID(projectID);
//            projectDTOs.add(projectDTO);
//        }
//
//        return projectDTOs;
//    }

//    @Override
//    public List<ProjectDTO> getAllProjectByTaskNameForThisUserID(TaskNameType taskName, String userID) {
//        set = new HashSet();
//
//        List<ProjectDTO> projectDTOs = new ArrayList();
//        List<Task> tasks = workflowAPI.getListOfTaskForThisUserID(userID);
//
//        for (Task task : tasks) {
//            if (task.getName().equalsIgnoreCase(taskName.getTaskName())) {
//                String projectID = getGlobalVariableByProcessInstanceID(task.getProcessInstanceId()).get("projectID").toString();
//
//                if (set.contains(projectID)) {
//                    continue;
//                }
//
//                set.add(projectID);
//                ProjectDTO projectDTO = projectService.findByID(projectID);
//                projectDTOs.add(projectDTO);
//            }
//        }
//
//        return projectDTOs;
//    }

    @Override
    public boolean eskalasi(String projectID, TaskNameType taskName, String userID) {
        return claimAndExecuteThisTask(projectID, taskName, userID);
    }

    @Override
    public boolean konfirmasiGateway(String projectID, String userID) {
        return claimAndExecuteThisTask(projectID, TaskNameType.CONFIRM_PROJECT, userID);
    }

    @Override
    public boolean konfirmasiDone(String projectID, String userID) {
        return claimAndExecuteThisTask(projectID, TaskNameType.CONFIRM_PROJECT, userID);
    }

    @Override
    public boolean selesaikanThisLevel(String projectID, TaskNameType taskName, String userID) {
        Map<String, Object> map = getGlobalVariableByProjectID(projectID);

        workflowAPI.messageEventReceived(MessageNameType.APPROVED.getMessageName(), map.get("processInstanceID").toString(), map);

        String processInstanceID = startProcessInstanceByMessage(MessageNameType.APPROVED, map);

        map.put("processInstanceID", processInstanceID);
        setGlobalVariable(map);

        return Boolean.TRUE;
    }

    @Override
    public boolean tolakThisLevel(String projectID, TaskNameType taskName, String userID) {
        Map<String, Object> map = getGlobalVariableByProjectID(projectID);

        workflowAPI.messageEventReceived(MessageNameType.REJECTED.getMessageName(), map.get("processInstanceID").toString(), map);

        String processInstanceID = startProcessInstanceByMessage(MessageNameType.REJECTED, map);

        map.put("processInstanceID", processInstanceID);
        setGlobalVariable(map);

        return Boolean.TRUE;
    }

    @Override
    public boolean reopen(String projectID) {
        Map<String, Object> map = getGlobalVariableByProjectID(projectID);

        workflowAPI.messageEventReceived(MessageNameType.ESCALATED.getMessageName(), map.get("processInstanceID").toString(), map);

        String processInstanceID = startProcessInstanceByMessage(MessageNameType.ESCALATED, map);

        map.put("processInstanceID", processInstanceID);
        setGlobalVariable(map);

        return Boolean.TRUE;
    }

    @Override
    public boolean submitReopen(String projectID, String userID) {
        return claimAndExecuteThisTask(projectID, TaskNameType.REOPEN, userID);
    }

    @Override
    public boolean claimThisTask(String projectID, TaskNameType taskName, String userID) {
        List<Task> tasks = workflowAPI.getCurrentTaskByProjectID(projectID);

        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName.getTaskName())) {
                workflowAPI.claimTaskByThisUser(userID, task.getId(), null);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean executeThisTask(String projectID, TaskNameType taskName, String userID) {
        List<Task> tasks = workflowAPI.getCurrentTaskByProjectID(projectID);

        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName.getTaskName())) {
                workflowAPI.completeTaskByThisUser(userID, task.getId(), null);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean claimAndExecuteThisTask(String projectID, TaskNameType taskName, String userID) {
        return claimThisTask(projectID, taskName, userID) && executeThisTask(projectID, taskName, userID);
    }

    @Override
    public boolean callMessageService(MessageNameType messageName, String projectID) {
        return callMessageService(messageName, projectID, Boolean.FALSE);
    }

    @Override
    public boolean callMessageService(MessageNameType messageName, String projectID, boolean check) {
        String executionID = workflowAPI.getExecutionIDFromMessageEventByProjectID(messageName.getMessageName(), projectID);
        String processInstanceID = getProcessInstanceIDFromMessageEventByProjectID(messageName, projectID);
        Map<String, Object> map = getGlobalVariableByProjectID(projectID);

        if (JDCStringUtil.hasValue(processInstanceID)) {
            map.put("processInstanceID", processInstanceID);
        }

        if (JDCStringUtil.hasValue(executionID)) {
            if (check) {
                workflowAPI.messageEventReceived(messageName.getMessageName(), processInstanceID, map, check);
            } else {
                workflowAPI.messageEventReceived(messageName.getMessageName(), processInstanceID, map);
            }
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> getGlobalVariableByProcessInstanceID(String processInstanceID) {
        return workflowAPI.getGlobalRuntimeVariable(processInstanceID);
    }

    @Override
    public Map<String, Object> getGlobalVariableByProjectID(String projectID) {
        List<Task> tasks = workflowAPI.getCurrentTaskByProjectID(projectID);

        for (Task task : tasks) {
            return getGlobalVariableByProcessInstanceID(task.getProcessInstanceId());
        }
        return null;
    }

    @Override
    public void setGlobalVariable(String processInstanceID, Map<String, Object> map) {
        workflowAPI.setGlobalRuntimeVariable(processInstanceID, map);
    }

    @Override
    public void setGlobalVariable(Map<String, Object> map) {
        workflowAPI.setGlobalRuntimeVariable(map.get("processInstanceID").toString(), map);
    }

    @Override
    public String getProcessInstanceIDFromMessageEventByProjectID(MessageNameType messageName, String projectID) {
        return workflowAPI.getProcessInstanceIDFromMessageEventByProjectID(messageName.getMessageName(), projectID);
    }

    @Override
    public String startProcessInstanceByMessage(MessageNameType messageName, Map<String, Object> arg0) {
        return workflowAPI.startProcessInstanceByMessage(messageName.getMessageName(), arg0).getProcessInstanceId();
    }

    private Map<String, Object> setProcessVars(WorkflowRequest wfRequest) {
        Map<String, Object> processVars = new HashMap<>();
        processVars.put("processInitiator", wfRequest.getInitiator());
        processVars.put("processID", wfRequest.getProcessDefintionKey());
        processVars.put("processInstanceID", wfRequest.getProcessInstanceID());
        processVars.put("processVariable", wfRequest.getProcessVariable());
        processVars.put("processDecision", wfRequest.getTaskDecisionStatus());
        processVars.put("processTaskDefinitionKey", wfRequest.getTaskDefinitionKey());
        processVars.put("processDecisionReason", wfRequest.getProcessDecisionReason());
        processVars.put("jsonObjectOfNewValue", wfRequest.getJsonObjectOfNewValue());
        processVars.put("projectID", wfRequest.getProjectID());
        return processVars;
    }
}
