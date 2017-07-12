package com.agit.crm.bpm.domain.pvm;

import com.agit.crm.util.JDCStringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.ImplementationType;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class ProcessVirtualMachine {

    public static Process buildDefaultProcessFlowDefinition(String processID) throws IOException {
        Process process = new Process();
        process.setId(processID);
        process.addFlowElement(createStartEvent());
        process.addFlowElement(createUserTask("task1", "Submit object approval", "U1"));
        process.addFlowElement(createUserTask("task2", "Authorize object approval", "U2"));
        process.addFlowElement(createUserTask("task3", "Update module state", "U3"));
        process.addFlowElement(createExclusiveGateway());
        process.addFlowElement(createEndEvent());
        process.addFlowElement(createSequenceFlow("start", "task1"));
        process.addFlowElement(createSequenceFlow("task1", "task2"));
        process.addFlowElement(createSequenceFlow("task2", "gate1"));
        process.addFlowElement(createSequenceFlowWithExpression("gate1", "task1", "${processDecision eq T}"));
        process.addFlowElement(createSequenceFlowWithExpression("gate1", "task3", "${processDecision eq Y}"));
        process.addFlowElement(createSequenceFlow("task3", "end"));
        return process;
    }

    public static BpmnModel buildProcessBpmnModelForThisProcessDefinition(Process process) {
        BpmnModel model = new BpmnModel();
        Validate.notNull(process);
        model.addProcess(process);
        return model;
    }

    public static void generateGraphicalDiagramFor(BpmnModel bpmnModel) {
        Validate.notNull(bpmnModel);
        new BpmnAutoLayout(bpmnModel).execute();
    }

    public static Deployment deploy(ProcessEngine processEngine, BpmnModel bpmnModel, String bpmnFileName, String deploymentName) {
        Validate.notNull(bpmnModel);
        return processEngine
                .getRepositoryService()
                .createDeployment()
                .addBpmnModel(bpmnFileName, bpmnModel)
                .name(deploymentName)
                .deploy();
    }

    public static Deployment deploy(ProcessEngine processEngine, String classPath, String deploymentName) {
        return processEngine
                .getRepositoryService()
                .createDeployment()
                .addClasspathResource(classPath)
                .enableDuplicateFiltering()
                .name(deploymentName)
                .deploy();
    }

    public static List<Deployment> getListOfDeploymentInThisAVMEngine(ProcessEngine processEngine) {
        return processEngine
                .getRepositoryService()
                .createDeploymentQuery()
                .orderByDeploymenTime()
                .asc()
                .list();
    }

    public static void undeploy(ProcessEngine processEngine, List<Deployment> deploymentIDs, boolean cascade) throws Exception {
        Validate.notNull(deploymentIDs);
        for (Deployment deployment : deploymentIDs) {
            String deploymentID = deployment.getId();
            processEngine.getRepositoryService().deleteDeployment(deploymentID, cascade);
            System.out.printf("Undeployed %s \n", deploymentID);
        }
    }

    public static void undeploy(ProcessEngine processEngine, String deploymentID, boolean cascade) throws Exception {
        Validate.notNull(deploymentID);
        processEngine.getRepositoryService().deleteDeployment(deploymentID, cascade);
        System.out.printf("Undeployed %s \n", deploymentID);
    }

    public static void saveDiagramToPNG(ProcessEngine processEngine, String filePath, ProcessInstance processInstance) throws IOException {
        Validate.notNull(processInstance);
        InputStream processDiagram = processEngine.getRepositoryService().getProcessDiagram(processInstance.getProcessDefinitionId());
//        FileUtils.copyInputStreamToFile(processDiagram, new File(filePath));
    }

    public static void saveDiagramToXML(ProcessEngine processEngine, Deployment deployment, String bpmnFile, String filePath) throws IOException {
        Validate.notNull(deployment);
        InputStream processBpmn = processEngine.getRepositoryService().getResourceAsStream(deployment.getId(), bpmnFile);
//        FileUtils.copyInputStreamToFile(processBpmn, new File(filePath));
    }

    public static ProcessInstance startBpmnModelProcess(ProcessEngine processEngine, Process process, Map arg0) {
        Validate.notNull(process);
        return processEngine.getRuntimeService()
                .startProcessInstanceByKey(process.getId(), arg0);
    }

    public static ProcessInstance startBpmnModelProcess(ProcessEngine processEngine, ProcessDefinition processDefinition, Map arg0) {
        Validate.notNull(processDefinition);
        return processEngine.getRuntimeService()
                .startProcessInstanceByKey(processDefinition.getKey(), arg0);
    }

    public static ProcessInstance startBpmnModelProcess(ProcessEngine processEngine, String processDefinitionKey, Map<String, Object> arg0) {
        return processEngine.getRuntimeService()
                .startProcessInstanceByKey(processDefinitionKey, arg0);
    }

    /*helper*/
    private static UserTask createUserTask(String id, String name, String assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;
    }

    private static UserTask createUserTaskWithGroup(String id, String name, String assignee, List<String> candidateUsers, List<String> candidateGroups) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        userTask.setCandidateUsers(candidateUsers);
        userTask.setCandidateGroups(candidateGroups);
        return userTask;
    }

    private static SequenceFlow createSequenceFlow(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }

    private static SequenceFlow createSequenceFlowWithExpression(String from, String to, String expression) {
        SequenceFlow flow = new SequenceFlow();
        flow.setConditionExpression(expression);
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }

    private static StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        return startEvent;
    }

    private static EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        return endEvent;
    }

    private static ServiceTask createServiceTask(String serviceID, String serviceName) {
        ServiceTask serviceTask = new ServiceTask();
        serviceTask.setId(serviceID);
        serviceTask.setName(serviceName);
        serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_CLASS);
        return serviceTask;
    }

    /*adding gateway element*/
    private static ExclusiveGateway createExclusiveGateway() {
        ExclusiveGateway exclusiveGateway = new ExclusiveGateway();
        exclusiveGateway.setId("gate1");
        return exclusiveGateway;
    }

    public static ProcessInstance startProcessInstanceByMessage(ProcessEngine processEngine, String messageName, Map<String, Object> arg0) {
        return processEngine.getRuntimeService()
                .startProcessInstanceByMessage(messageName, arg0);
    }

    public static boolean messageEventReceived(ProcessEngine processEngine, String messageName, String processInstanceID, Map<String, Object> arg0) {
        return messageEventReceived(processEngine, messageName, processInstanceID, arg0, Boolean.FALSE);
    }

    public static boolean messageEventReceived(ProcessEngine processEngine, String messageName, String processInstanceID, Map<String, Object> arg0, boolean check) {
        List<Execution> e = processEngine.getRuntimeService().createExecutionQuery().messageEventSubscriptionName(messageName).list();

        if (JDCStringUtil.hasValue(e)) {
            for (Execution ex : e) {
                if (ex.getProcessInstanceId().equals(processInstanceID)) {
                    processEngine.getRuntimeService().messageEventReceived(messageName, ex.getId(), arg0);

                    if (check) {
                        startProcessInstanceByMessage(processEngine, messageName, arg0);
                    }

//                    if (messageName.equalsIgnoreCase(MessageNameType.BANDING_REJECT_APPROVAL.getMessageName())
//                            || messageName.equalsIgnoreCase(MessageNameType.OVERRIDE_REJECT_APPROVAL.getMessageName())
//                            || messageName.equalsIgnoreCase(MessageNameType.ESKALASI_REJECT_APPROVAL.getMessageName())) {
//                        continue;
//                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static String getExecutionIDFromMessageEventByProjectID(ProcessEngine processEngine, String messageName, String projectID) {
        List<Execution> e = processEngine.getRuntimeService().createExecutionQuery().messageEventSubscriptionName(messageName).processVariableValueEquals("projectID", projectID).list();
        if (JDCStringUtil.hasValue(e)) {
            for (Execution ex : e) {
                return ex.getId();
            }
        }
        return null;
    }

    public static String getProcessInstanceIDFromMessageEventByProjectID(ProcessEngine processEngine, String messageName, String projectID) {
        List<Execution> e = processEngine.getRuntimeService().createExecutionQuery().messageEventSubscriptionName(messageName).processVariableValueEquals("projectID", projectID).list();
        if (JDCStringUtil.hasValue(e)) {
            for (Execution ex : e) {
                return ex.getProcessInstanceId();
            }
        }
        return null;
    }
}
