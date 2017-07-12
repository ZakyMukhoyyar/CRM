package com.agit.crm.bpm.domain.htm;

import com.agit.crm.util.JDCStringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.bpmn.model.Process;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class HumanTaskManager {

    public static List<Task> getCurrentTaskOfProcessInstance(ProcessEngine processEngine, ProcessInstance processInstance) {
        Validate.notNull(processInstance);
        return processEngine
                .getTaskService()
                .createTaskQuery()
                .processInstanceId(processInstance.getId())
                .list();
    }

    public static ProcessDefinition getListOfProcess(ProcessEngine processEngine, Deployment createdDeployment) {
        return processEngine.getRepositoryService().createProcessDefinitionQuery().deploymentId(createdDeployment.getId()).singleResult();
    }

    public static User createUserForThisProcessEngine(ProcessEngine processEngine, String id, String email, String password, String groupId) {
        IdentityService identityService = processEngine.getIdentityService();
        Validate.notNull(identityService);
        User user = identityService.newUser(id);
        user.setEmail(email);
        user.setPassword(password);
        identityService.saveUser(user);
        identityService.createMembership(id, groupId);
        return user;
    }

    public static Group createGroupForThisProcessEngine(ProcessEngine processEngine, String id, String name, String type) {
        IdentityService identityService = processEngine.getIdentityService();
        Group group = identityService.newGroup(id);
        group.setName(name);
        group.setType(type);
        identityService.saveGroup(group);
        return group;
    }

    public static void killThisProcessInstance(ProcessEngine processEngine, ProcessInstance processInstance) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.deleteProcessInstance(processInstance.getId(), "Forcefully terminating the instance");
        System.out.printf("Process instance %s terminated%n", processInstance.getId());
    }

    public static List<User> getListUsers(ProcessEngine processEngine) {
        List<User> users = processEngine.getIdentityService()
                .createUserQuery()
                .orderByUserId()
                .asc().list();

        if (users.isEmpty()) {
            System.err.println("No users found.");
        }
        for (User user : users) {
            System.out.printf("%s\t%s\t%s\n", user.getId(), user.getEmail(), user.getPassword());
        }
        return users;
    }

    public static void deleteThisUser(ProcessEngine processEngine, User user) {
        IdentityService identityService = processEngine.getIdentityService();
        identityService.deleteUser(user.getId());
    }

    public static List<Group> getListGroups(ProcessEngine processEngine) {
        List<Group> groups = processEngine.getIdentityService()
                .createGroupQuery()
                .orderByGroupId().asc().list();

        if (groups.isEmpty()) {
            System.err.println("No groups found.");
        }
        for (Group group : groups) {
            System.out.printf("%s\t%s\t%s\n", group.getId(), group.getName(), group.getType());
        }
        return groups;
    }

    public static void deleteThisGroup(ProcessEngine processEngine, Group group) {
        processEngine.getIdentityService().deleteGroup(group.getId());
    }

    public static List<Task> getListOfTaskForThisUser(ProcessEngine processEngine, User user) {
        return processEngine.getTaskService().createTaskQuery().taskCandidateOrAssigned(user.getId()).list();
    }

    public static List<Task> getListOfTaskForThisUserID(ProcessEngine processEngine, String user) {
        return processEngine.getTaskService().createTaskQuery().taskCandidateOrAssigned(user).list();
    }

    public static List<Task> getListOfTaskInThisAVMEngine(ProcessEngine processEngine) {
        return processEngine.getTaskService().createTaskQuery().list();
    }

    public static User findUserById(ProcessEngine processEngine, String userID) {
        return processEngine.getIdentityService().createUserQuery().userId(userID).singleResult();
    }

    public static void executeToCompleteByThisUser(ProcessEngine processEngine, User user, Process process, ProcessInstance processInstance, String taskDefinitionKey, Map<String, Object> map) {
        Authentication.setAuthenticatedUserId(user.getId());
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .processDefinitionKey(process.getId())
                .taskDefinitionKey(taskDefinitionKey).list();

        Map<String, Object> m = getGlobalRuntimeVariable(processEngine, processInstance);
        if (JDCStringUtil.hasValue(map)) {
            for (String s : map.keySet()) {
                m.put(s, map.get(s));
            }
            setGlobalRuntimeVariable(processEngine, processInstance, m);
        }

        for (Task task : tasks) {
            processEngine.getTaskService().claim(task.getId(), user.getId());
            processEngine.getTaskService().complete(task.getId(), m);
        }
    }

    public static void executeToCompleteByThisUser(ProcessEngine processEngine, String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable) {
        Authentication.setAuthenticatedUserId(userID);
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskDefinitionKey(taskDefinitionKey).list();

        for (Task task : tasks) {
            if (task.getProcessInstanceId().equalsIgnoreCase(processInstanceID)) {
                processEngine.getTaskService().claim(task.getId(), userID);
                processEngine.getTaskService().complete(task.getId(), processVariable);
            }
        }
    }

    public static Map<String, Object> getGlobalRuntimeVariable(ProcessEngine processEngine, ProcessInstance processInstance) {
        return processEngine.getRuntimeService().getVariables(processInstance.getId());
    }

    public static Map<String, Object> getGlobalRuntimeVariable(ProcessEngine processEngine, String processInstanceID) {
        return processEngine.getRuntimeService().getVariables(processInstanceID);
    }

    public static void setGlobalRuntimeVariable(ProcessEngine processEngine, ProcessInstance processInstance, Map<String, Object> varContainer) {
        processEngine.getRuntimeService().setVariables(processInstance.getId(), varContainer);
    }

    public static void setGlobalRuntimeVariable(ProcessEngine processEngine, String processInstanceID, Map<String, Object> varContainer) {
        processEngine.getRuntimeService().setVariables(processInstanceID, varContainer);
    }

    public static Map<String, Object> getProcessVariableForThisTask(ProcessEngine processEngine, Task task) {
        return processEngine.getRuntimeService().getVariables(task.getProcessInstanceId());
    }

    public static List<Task> getListOfTaskByActivityIDForThisUser(ProcessEngine processEngine, String user, String activityID) {
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskCandidateOrAssigned(user).list();
        List<Task> taskTemps = new ArrayList();

        for (Task task : tasks) {
            String processInstanceID = task.getProcessInstanceId();

            if (processEngine.getRuntimeService().getActiveActivityIds(processInstanceID).get(0).equals(activityID)) {
                taskTemps.add(task);
            }
        }

        return taskTemps;
    }

    public static List<Task> getListOfTaskByActivityID(ProcessEngine processEngine, String activityID) {
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().list();
        List<Task> taskTemps = new ArrayList();

        for (Task task : tasks) {
            String processInstanceID = task.getProcessInstanceId();

            if (processEngine.getRuntimeService().getActiveActivityIds(processInstanceID).get(0).equals(activityID)) {
                taskTemps.add(task);
            }
        }

        return taskTemps;
    }

    public static void claimTaskByThisUser(ProcessEngine processEngine, String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable) {
        Authentication.setAuthenticatedUserId(userID);
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskDefinitionKey(taskDefinitionKey).list();

        for (Task task : tasks) {
            if (task.getProcessInstanceId().equalsIgnoreCase(processInstanceID)) {
                processEngine.getTaskService().claim(task.getId(), userID);
            }
        }
    }

    public static void claimTaskByThisUser(ProcessEngine processEngine, String userID, String taskID, Map<String, Object> processVariable) {
        Authentication.setAuthenticatedUserId(userID);
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskCandidateOrAssigned(userID).list();

        for (Task task : tasks) {
            if (task.getId().equalsIgnoreCase(taskID)) {
                processEngine.getTaskService().claim(task.getId(), userID);
            }
        }
    }

    public static void completeTaskByThisUser(ProcessEngine processEngine, String userID, String processDefinitionKey, String processInstanceID, String taskDefinitionKey, Map<String, Object> processVariable) {
        Authentication.setAuthenticatedUserId(userID);
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskCandidateOrAssigned(userID).list();

        for (Task task : tasks) {
            if (task.getProcessInstanceId().equalsIgnoreCase(processInstanceID)) {
                processEngine.getTaskService().complete(task.getId(), processVariable);
            }
        }
    }

    public static void completeTaskByThisUser(ProcessEngine processEngine, String userID, String taskID, Map<String, Object> processVariable) {
        Authentication.setAuthenticatedUserId(userID);
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskCandidateOrAssigned(userID).list();

        for (Task task : tasks) {
            if (task.getId().equalsIgnoreCase(taskID)) {
                processEngine.getTaskService().complete(task.getId(), processVariable);
            }
        }
    }

    public static List<Task> getCurrentTaskByProjectIDAndUserID(ProcessEngine processEngine, String projectID, String userID) {
        return processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(userID)
                .processVariableValueEquals("projectID", projectID)
                .orderByDueDate().desc().list();

    }

    public static List<Task> getCurrentTaskByProjectID(ProcessEngine processEngine, String projectID) {
        return processEngine.getTaskService()
                .createTaskQuery()
                .processVariableValueEquals("projectID", projectID).list();

    }

}
