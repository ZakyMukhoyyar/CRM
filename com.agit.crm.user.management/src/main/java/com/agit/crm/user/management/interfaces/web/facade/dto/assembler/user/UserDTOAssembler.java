package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.user;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserDTOBuilder;
import com.agit.crm.user.management.domain.role.RoleRepository;
import com.agit.crm.user.management.domain.user.User;
import com.agit.crm.user.management.domain.user.UserBuilder;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.IObjectAssembler;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.role.RoleDTOAssembler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class UserDTOAssembler implements IObjectAssembler<User, UserDTO> {

    private RoleDTOAssembler roleDTOAssembler;
    private RoleRepository roleRepository;
        

    public void setRoleDTOAssembler(RoleDTOAssembler roleDTOAssembler) {
        this.roleDTOAssembler = roleDTOAssembler;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDTO toDTO(User domainObject) {
        return new UserDTOBuilder()
                .setUserID(domainObject.getUserID())
                .setNip(domainObject.getNip())
                .setCreationalDate(domainObject.getCreationalDate())
                .setCreationalBy(domainObject.getCreationalBy())
                .setPassword(domainObject.getPassword())
                .setRoleDTO(roleDTOAssembler.noPrivilegeToDTO(domainObject.getRole()))
                .setUserName(domainObject.getUserName())
                .setUserSpecificationDTO(new UserSpecificationDTOAssembler().toDTO(domainObject.getUserSpecification()))
                .setUserStatus(domainObject.getUserStatus())
                .createUserDTO();
    }

    @Override
    public User toDomain(UserDTO dtoObject) {
        return new UserBuilder()
                .setUserID(dtoObject.getUserID())
                .setNip(dtoObject.getNip())
                .setCreationalDate(dtoObject.getCreationalDate())
                .setCreationalBy(dtoObject.getCreationalBy())
                .setPassword(dtoObject.getPassword())
                .setRole(roleRepository.findByID(dtoObject.getRoleDTO().getRoleID()))
                .setUserName(dtoObject.getUserName())
                .setUserSpecification(new UserSpecificationDTOAssembler().toDomain(dtoObject.getUserSpecificationDTO()))
                .setUserStatus(dtoObject.getUserStatus())
                .createUser();
    }

    public UserDTO toDTOWithPrivilege(User domainObject) {
        return new UserDTOBuilder()
                .setNip(domainObject.getNip())
                .setUserID(domainObject.getUserID())
                .setCreationalDate(domainObject.getCreationalDate())
                .setCreationalBy(domainObject.getCreationalBy())
                .setPassword(domainObject.getPassword())
                .setRoleDTO(roleDTOAssembler.toDTO(domainObject.getRole()))
                .setUserName(domainObject.getUserName())
                .setUserSpecificationDTO(new UserSpecificationDTOAssembler().toDTO(domainObject.getUserSpecification()))
                .setUserStatus(domainObject.getUserStatus())
                .createUserDTO();
    }

    public List<UserDTO> toDTOs(List<User> arg0) {
        List<UserDTO> res = new ArrayList<>();
        for (User o : arg0) {
            res.add(toDTO(o));
        }
        return res;
    }

    public List<User> toDomains(List<UserDTO> arg0) {
        List<User> res = new ArrayList<>();
        for (UserDTO o : arg0) {
            res.add(toDomain(o));
        }
        return res;
    }

}
