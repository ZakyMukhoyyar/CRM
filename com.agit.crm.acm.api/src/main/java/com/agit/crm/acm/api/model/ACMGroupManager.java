package com.agit.crm.acm.api.model;

import java.util.List;
import java.util.Map;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;

/**
 *
 * @author lintang
 */
public class ACMGroupManager extends GroupEntityManager implements GroupIdentityManager {
    
  protected ACMConfigurator acmConfigurator;
  protected ACMGroupCache acmGroupCache;  

    public ACMGroupManager(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

    public ACMGroupManager(ACMConfigurator acmConfigurator, ACMGroupCache acmGroupCache) {
        this.acmConfigurator = acmConfigurator;
        this.acmGroupCache = acmGroupCache;
    }

    @Override
    public Group createNewGroup(String groupId) {
        throw new ActivitiException("ACM group manager doesn't support creating a new group");
    }

    @Override
    public void insertGroup(Group group) {
        throw new ActivitiException("ACM group manager doesn't support inserting a new group");
    }

    @Override
    public void updateGroup(Group updatedGroup) {
        throw new ActivitiException("ACM group manager doesn't support updating a new group");
    }

    @Override
    public void deleteGroup(String groupId) {
        throw new ActivitiException("ACM group manager doesn't support deleting a new group");
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        return new GroupQueryImpl(Context.getProcessEngineConfiguration().getCommandExecutor());
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        if (query.getUserId() != null) {
            return findGroupsByUser(query.getUserId());
        } else {
            throw new ActivitiIllegalArgumentException("This query is not supported by the ACMGroupManager");
        }
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        return findGroupByQueryCriteria(query, null).size();
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {
        return super.findGroupsByUser(userId);
    }

    @Override
    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new ActivitiException("LDAP group manager doesn't support findGroupsByNativeQuery");
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new ActivitiException("LDAP group manager doesn't support findGroupCountByNativeQuery");
    }

    @Override
    public boolean isNewGroup(Group group) {
        throw new ActivitiException("LDAP group manager doesn't support isNewGroup");
    }
    
}
