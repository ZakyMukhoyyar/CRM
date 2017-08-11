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
                .setKtp(domainObject.getKtp())
                .setTanggalLahir(domainObject.getTanggalLahir())
                .setDomisili(domainObject.getDomisili())
                .setNoHP(domainObject.getNoHP())
                .setNoKTP(domainObject.getNoKTP())
                .setIpk(domainObject.getIpk())
                .setJenisKelaminType(domainObject.getJenisKelaminType())
                .setPendidikanType(domainObject.getPendidikanType())
                .setNamaCivitas(domainObject.getNamaCivitas())
                .setMinat(domainObject.getMinat())
                .setKetrampilan1(domainObject.getKetrampilan1())
                .setKetrampilan2(domainObject.getKetrampilan2())
                .setKetrampilan3(domainObject.getKetrampilan3())
                .setKetrampilan4(domainObject.getKetrampilan4())
                .setKetrampilan5(domainObject.getKetrampilan5())
                .setTingkatanType1(domainObject.getTingkatanType1())
                .setTingkatanType2(domainObject.getTingkatanType2())
                .setTingkatanType3(domainObject.getTingkatanType3())
                .setTingkatanType4(domainObject.getTingkatanType4())
                .setTingkatanType5(domainObject.getTingkatanType5())
                .setUploadCV(domainObject.getUploadCV())
                .setStatusApprove(domainObject.getStatusApprove())
                .setJurusan(domainObject.getJurusan())
                .setDisableButton(domainObject.getDisableButton())
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
                .setKtp(dtoObject.getKtp())
                .setTanggalLahir(dtoObject.getTanggalLahir())
                .setDomisili(dtoObject.getDomisili())
                .setNoHP(dtoObject.getNoHP())
                .setNoKTP(dtoObject.getNoKTP())
                .setIpk(dtoObject.getIpk())
                .setJenisKelaminType(dtoObject.getJenisKelaminType())
                .setPendidikanType(dtoObject.getPendidikanType())
                .setNamaCivitas(dtoObject.getNamaCivitas())
                .setMinat(dtoObject.getMinat())
                .setKetrampilan1(dtoObject.getKetrampilan1())
                .setKetrampilan2(dtoObject.getKetrampilan2())
                .setKetrampilan3(dtoObject.getKetrampilan3())
                .setKetrampilan4(dtoObject.getKetrampilan4())
                .setKetrampilan5(dtoObject.getKetrampilan5())
                .setTingkatanType1(dtoObject.getTingkatanType1())
                .setTingkatanType2(dtoObject.getTingkatanType2())
                .setTingkatanType3(dtoObject.getTingkatanType3())
                .setTingkatanType4(dtoObject.getTingkatanType4())
                .setTingkatanType5(dtoObject.getTingkatanType5())
                .setUploadCV(dtoObject.getUploadCV())
                .setStatusApprove(dtoObject.getStatusApprove())
                .setJurusan(dtoObject.getJurusan())
                .setDisableButton(dtoObject.getDisableButton())
                .createUserSpecification();
    }

}
