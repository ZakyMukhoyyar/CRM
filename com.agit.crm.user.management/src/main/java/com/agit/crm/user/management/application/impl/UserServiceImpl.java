package com.agit.crm.user.management.application.impl;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.crm.shared.status.StatusCode;
import com.agit.crm.shared.type.ReleaseType;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.user.management.domain.user.User;
import com.agit.crm.user.management.domain.user.UserRepository;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.user.UserDTOAssembler;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.user.UserLoginInfoDTOAssembler;
import java.util.List;
import org.apache.commons.lang.Validate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author bayutridewanto
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDTOAssembler userDTOAssembler;

    @Override
    public void saveOrUpdate(UserDTO userDTO) {
        User user = userRepository.findByID(userDTO.getUserName());
        if (user == null) {
            user = userDTOAssembler.toDomain(userDTO);
        } else {
            /* update specification */
            user.assignNewSpecification(userDTOAssembler.toDomain(userDTO));
        }

        userRepository.saveOrUpdate(user);
    }

    @Override
    public UserDTO findByID(String userName) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByID(userName);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public UserDTO findByRemote(String remote) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByRemote(remote);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public List<UserDTO> findAllUser() {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findAllUser();
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public List<UserDTO> findByParameter(String fullName, String userName, String roleID, StatusData userStatus) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByParameter(fullName, userName, roleID, userStatus);
        if (users != null) {
            return userDTOAssembler.toDTOs(users);
        }

        return null;
    }

    @Override
    public StatusCode release(String releaseType, String release) {
        Validate.notNull(userRepository);
        User user;
        if (releaseType.equals(ReleaseType.USERNAME.name())) {
            user = userRepository.findByID(release);
        } else {
            user = userRepository.findByRemote(release);
        }
        if (user != null) {
            user.getUserSpecification().getUserLoginInfo().assignDeleteRemote();
            userRepository.saveOrUpdate(user);
            return StatusCode.CREATED;
        }
        return StatusCode.FOUND;
    }

    @Override
    public StatusCode releaseAll() {
        Validate.notNull(userRepository);
        userRepository.releaseAll();
        return StatusCode.CREATED;
    }

    @Override
    public int count(String roleID) {
        Validate.notNull(userRepository);
        return userRepository.count(roleID);
    }

    @Override
    public StatusCode updatePassword(String userName, String newPassword) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.assignNewPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode updateLockUnlock(String userName, Integer loginAttempt) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.getUserSpecification().getUserLoginInfo().assignNewLoginAttempt(loginAttempt);
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode updateLoginInfo(String userName, UserLoginInfoDTO loginInfo) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.getUserSpecification().assignNewLoginInfo(new UserLoginInfoDTOAssembler().toDomain(loginInfo));
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode delete(String userName) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.assignNewStatus(StatusData.DELETED);
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public Boolean isNotExistUserName(String userName) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        return user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean isNotExistIPAddress(String ipAddress) {
        Validate.notNull(userRepository);
        User user = userRepository.findByRemote(ipAddress);
        return user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserDTOAssembler(UserDTOAssembler userDTOAssembler) {
        this.userDTOAssembler = userDTOAssembler;
    }

    @Override
    public UserDTO findByKtp(String ktp) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByKtp(ktp);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

}
