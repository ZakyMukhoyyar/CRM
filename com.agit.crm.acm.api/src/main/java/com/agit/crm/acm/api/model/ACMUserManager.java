package com.agit.crm.acm.api.model;

import com.agit.crm.user.management.domain.user.UserRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.AbstractManager;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lintang
 */
public class ACMUserManager extends AbstractManager implements UserIdentityManager {

    private static Logger logger = LoggerFactory.getLogger(ACMUserManager.class);

    protected ACMConfigurator acmConfigurator;

//    private AcmAdapter acmAdapter = new AcmAdapterImpl();
    private UserRepository userRepository;

    public ACMUserManager(ACMConfigurator acmConfigurator) {
        this.acmConfigurator = acmConfigurator;
    }

    public ACMUserManager() {
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(String userId) {
        throw new ActivitiException("ACM user manager doesn't support creating a new user");
    }

    @Override
    public void insertUser(User user) {
        throw new ActivitiException("ACM user manager doesn't support inserting a new user");
    }

    @Override
    public void updateUser(User updatedUser) {
        throw new ActivitiException("ACM user manager doesn't support updating a new user");
    }

    @Override
    public User findUserById(final String userId) {
        ACMTemplate acmTemplate = new ACMTemplate(acmConfigurator);
        User u = acmTemplate.execute(new ACMCallBack<User>() {

            @Override
            public User executeInACMContext() {

                /*find User*/
                com.agit.crm.user.management.domain.user.User user = userRepository.findByID(userId);

                /*convert User to User Activiti*/
                User u = toUser(user);

                /*return Activiti User*/
                return u;
            }

        });
        return u;
    }

    private User toUser(final com.agit.crm.user.management.domain.user.User o) {
        User u = new User() {

            @Override
            public String getId() {
                return o.getUserID();
            }

            @Override
            public void setId(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getFirstName() {
                return o.getUserName();
            }

            @Override
            public void setFirstName(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getLastName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setLastName(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getEmail() {
                return o.getUserName();
            }

            @Override
            public void setEmail(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getPassword() {
                return o.getPassword();
            }

            @Override
            public void setPassword(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isPictureSet() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return u;
    }

    @Override
    public void deleteUser(String userId) {
        throw new ActivitiException("ACM user manager doesn't support deleting a new user");
    }

    @Override
    public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        if (query.getId() != null) {
            List<User> result = new ArrayList();
            result.add(findUserById(query.getId()));
            return result;
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        return findUserByQueryCriteria(query, null).size();
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {
        throw new ActivitiException("ACM user manager doesn't support querying");
    }

    @Override
    public UserQuery createNewUserQuery() {
        return new UserQueryImpl(Context.getProcessEngineConfiguration().getCommandExecutor());
    }

    @Override
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
        throw new ActivitiException("ACM user manager doesn't support querying");
    }

    @Override
    public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
        throw new ActivitiException("ACM user manager doesn't support querying");
    }

    @Override
    public Boolean checkPassword(String userId, String password) {
        logger.debug("LDAP user manager doesn't support check password. Returning null");
        return null;
    }

    @Override
    public List<User> findPotentialStarterUsers(String proceDefId) {
        throw new ActivitiException("ACM user manager doesn't support querying");
    }

    @Override
    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new ActivitiException("ACM user manager doesn't support querying");
    }

    @Override
    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new ActivitiException("ACM user manager doesn't support querying");
    }

    @Override
    public boolean isNewUser(User user) {
        throw new ActivitiException("ACM user manager doesn't support adding or updating a user");
    }

    @Override
    public Picture getUserPicture(String userId) {
        logger.debug("ACM user manager doesn't support user pictures. Returning null");
        return null;
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        throw new ActivitiException("ACM user manager doesn't support user pictures");
    }

}
