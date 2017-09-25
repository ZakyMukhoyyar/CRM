package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.type.StatusData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public interface UserRepository {

    void saveOrUpdate(User user);

    User findByID(String userName);

    User findByKtp(String ktp);

    User findByEmail(String email);

    User findByRemote(String userName, String remote);

    List<User> findAllUser();

    List<User> findByParameter(String fullName, String userName, String roleID, StatusData userStatus);

    List<User> findByRoleID(String roleID);

    int releaseAll();

    int count(String roleID);

    User findByUserID(String userID);

    List<User> findAllByMahasiswa(long roleid);

    List<User> findByParamsMap(Map map);

    List<User> findByUsername(String userName);
}
