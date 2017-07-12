package com.agit.crm.bpm.api.application;

//import com.agit.crm.common.dto.property.ProjectDTO;
import com.agit.crm.shared.type.MessageNameType;
import com.agit.crm.shared.type.TaskNameType;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public interface TaskQueryService {

    public boolean startBPMProjectingByThisUserID(String projectID, String userID);

    public boolean startBPMProjectingByThisUserID(String projectID, String userID, String path);

//    public List<ProjectDTO> getAllProjectForThisUserID(String userID);
//
//    public List<ProjectDTO> getAllProjectByTaskNameForThisUserID(TaskNameType taskName, String userID);

    public boolean eskalasi(String projectID, TaskNameType taskName, String userID);

    public boolean konfirmasiGateway(String projectID, String userID);

    public boolean konfirmasiDone(String projectID, String userID);

    public boolean selesaikanThisLevel(String projectID, TaskNameType taskName, String userID);

    public boolean tolakThisLevel(String projectID, TaskNameType taskName, String userID);

    public boolean reopen(String projectID);

    public boolean submitReopen(String projectID, String userID);

    public boolean claimThisTask(String projectID, TaskNameType taskName, String userID);

    public boolean executeThisTask(String projectID, TaskNameType taskName, String userID);

    public boolean claimAndExecuteThisTask(String projectID, TaskNameType taskName, String userID);

    public boolean callMessageService(MessageNameType messageName, String projectID);

    public boolean callMessageService(MessageNameType messageName, String projectID, boolean check);

    public Map<String, Object> getGlobalVariableByProcessInstanceID(String processInstanceID);

    public Map<String, Object> getGlobalVariableByProjectID(String projectID);

    public void setGlobalVariable(String processInstanceID, Map<String, Object> map);

    public void setGlobalVariable(Map<String, Object> map);

    public String getProcessInstanceIDFromMessageEventByProjectID(MessageNameType messageName, String projectID);

    public String startProcessInstanceByMessage(MessageNameType messageName, Map<String, Object> arg0);
}
