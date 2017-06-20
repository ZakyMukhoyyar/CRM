package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.user;

import com.agit.crm.common.dto.usermanagement.UserSpecificationDTO;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.agit.crm.user.management.domain.user.UserSpecification;
import com.agit.crm.user.management.domain.user.UserSpecificationBuilder;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.IObjectAssembler;

/**
 *
 * @author bayutridewanto
 */
public class UserSpecificationDTOAssembler implements IObjectAssembler<UserSpecification, UserSpecificationDTO> {

    @Override
    public UserSpecificationDTO toDTO(UserSpecification domainObject) {
        return new UserSpecificationDTOBuilder()
                .setAccessTimeDTO(new AccessTimeDTOAssembler().toDTO(domainObject.getAccessTime()))
                .setUserLoginInfoDTO(new UserLoginInfoDTOAssembler().toDTO(domainObject.getUserLoginInfo()))
                .setEmail(domainObject.getEmail())
                .setEscute(domainObject.getEscute())
                .setJobDivision(domainObject.getJobDivision())
                .setJobLocation(domainObject.getJobLocation())
                .setFullName(domainObject.getFullName())
                .setImmediateSupervisorUserName(domainObject.getImmediateSupervisorUserName())
                .setMobilePhone(domainObject.getMobilePhone())
                .setPrimaryBranchID(domainObject.getPrimaryBranchID())
                .createUserSpecificationDTO();
    }

    @Override
    public UserSpecification toDomain(UserSpecificationDTO dtoObject) {
        return new UserSpecificationBuilder()
                .setUserLoginInfo(new UserLoginInfoDTOAssembler().toDomain(dtoObject.getUserLoginInfoDTO()))
                .setAccessTime(new AccessTimeDTOAssembler().toDomain(dtoObject.getAccessTimeDTO()))
                .setEmail(dtoObject.getEmail())
                .setFullName(dtoObject.getFullName())
                .setEscute(dtoObject.getEscute())
                .setJobDivision(dtoObject.getJobDivision())
                .setJobLocation(dtoObject.getJobLocation())
                .setImmediateSupervisorUserName(dtoObject.getImmediateSupervisorUserName())
                .setMobilePhone(dtoObject.getMobilePhone())
                .setPrimaryBranchID(dtoObject.getPrimaryBranchID())
                .createUserSpecification();
    }

}
