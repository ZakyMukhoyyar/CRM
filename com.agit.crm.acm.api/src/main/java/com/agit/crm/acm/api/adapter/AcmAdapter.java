package com.agit.crm.acm.api.adapter;

import com.agit.crm.user.management.domain.user.User;
import java.util.List;

/**
 *
 * @author lintang
 */
public interface AcmAdapter {

    public boolean isUserExistInCandidateUser(String userID, List<User> members);

    public User getUserProperty(String userID);

    public List<String> getRoleSetup(String projectID, String roleName);
}
