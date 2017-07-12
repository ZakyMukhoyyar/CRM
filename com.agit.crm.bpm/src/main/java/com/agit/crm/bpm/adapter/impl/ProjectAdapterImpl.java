package com.agit.crm.bpm.adapter.impl;

import com.agit.crm.bpm.api.adapter.ProjectAdapter;
//import com.agit.crm.common.application.ProjectService;
//import com.agit.crm.common.dto.property.ProjectDTO;

/**
 *
 * @author lintang
 */
public class ProjectAdapterImpl implements ProjectAdapter {

//    private ProjectService projectService;
//
//    public void setProjectService(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @Override
//    public void closeProject(String projectID) {
//        ProjectDTO projectDTO = projectService.findByID(projectID);
//        projectDTO.setStatus(0);
//
//        projectService.saveOrUpdate(projectDTO);
//    }

    @Override
    public boolean projectState(String projectID) {
        return Boolean.FALSE;
    }

    @Override
    public void informUser(String projectID) {
        printLogHead("[IU] INFORM USER");
        printOutput("[IU] Informing...");
        printOutput("[IU] Done...");
        printLogEnd();
    }

//    @Override
//    public void updateProjectDone(String projectID) {
//        ProjectDTO projectDTO = projectService.findByID(projectID);
//        projectDTO.setStatus(0);
//
//        projectService.saveOrUpdate(projectDTO);
//    }

    private static void printOutput(String message) {
        System.out.println("--> " + message);
    }

    private static void printLogger(String message) {
        String line = "\n-------------------------------------------------------------\n";
        System.out.print((line + message + line));
    }

    private static void printLogHead(String message) {
        String line = "\n=============================================================\n";
        System.out.print(line + message + line);
    }

    private static void printLogEnd() {
        String line = "\n=============================================================\n";
    }

    private static void printEmptyRow() {
        System.out.print("");
    }

}
