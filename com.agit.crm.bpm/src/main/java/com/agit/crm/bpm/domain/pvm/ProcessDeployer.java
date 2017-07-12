package com.agit.crm.bpm.domain.pvm;

import java.util.List;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.apache.commons.lang.Validate;

/**
 *
 * @author lintang
 */
public class ProcessDeployer {

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
}
