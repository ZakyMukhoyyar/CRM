package com.agit.crm.acm.api.adapter.impl;

import com.agit.crm.acm.api.adapter.AcmAdapter;
import com.agit.crm.user.management.domain.user.User;
import com.agit.crm.user.management.domain.user.UserRepository;
import com.agit.crm.util.JDCStringUtil;
import com.agit.crm.acm.api.model.ACMRole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lintang
 */
public class AcmAdapterImpl implements AcmAdapter {

    private ACMRole acmRole;
    private UserRepository userRepository;

    public void setAcmRole(ACMRole acmRole) {
        this.acmRole = acmRole;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUserExistInCandidateUser(String userID, List<User> members) {
        Map<String, User> cancidateUsers = new HashMap();
        if (JDCStringUtil.hasValue(members)) {
            for (User member : members) {
                cancidateUsers.put(member.getUserID(), member);
            }

            if (cancidateUsers.containsKey(userID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserProperty(String userID) {
        return userRepository.findByID(userID);
    }

    @Override
    public List<String> getRoleSetup(String projectID, String roleName) {
        String role = acmRole.getRole(roleName);
        List<String> roles = new ArrayList();
        roles.addAll(getListUserID(role));
        roles.add("SUPERADMIN");
        return roles;
    }

    private List<String> getListUserID(String role) {
        List<User> users = userRepository.findByRoleID(role);
        List<String> strings = new ArrayList();
        for (User u : users) {
            strings.add(u.getUserName());
        }
        return strings;
    }

}
