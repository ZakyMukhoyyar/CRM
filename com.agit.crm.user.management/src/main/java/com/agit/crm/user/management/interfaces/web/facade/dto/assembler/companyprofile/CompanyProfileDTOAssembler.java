package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.companyprofile;

//package com.agit.crm.user.management.interfaces.web.facade.dto.assembler.companyprofile;
//
//import com.bitozen.skk.common.dto.usermanagement.CompanyProfileDTO;
//import com.bitozen.skk.common.dto.usermanagement.CompanyProfileDTOBuilder;
//import com.agit.crm.user.management.domain.company.profile.CompanyProfile;
//import com.agit.crm.user.management.domain.company.profile.CompanyProfileBuilder;
//import com.agit.crm.user.management.domain.company.profile.CompanyProfileRepository;
//import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.IObjectAssembler;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author RBS
// */
//public class CompanyProfileDTOAssembler implements IObjectAssembler<CompanyProfile, CompanyProfileDTO> {
//
//    private CompanyProfileRepository companyProfileRepository;
//
//    @Override
//    public CompanyProfileDTO toDTO(CompanyProfile domainObject) {
//        return new CompanyProfileDTOBuilder()
//                .setFullname(domainObject.getFullname())
//                .setShortname(domainObject.getShortname())
//                .setDisplayname(domainObject.getDisplayname())
//                .setBankcode(domainObject.getBankcode())
//                .setTaxID(domainObject.getTaxID())
//                .setAddress1(domainObject.getAddress1())
//                .setAddress2(domainObject.getAddress2())
//                .setAddress3(domainObject.getAddress3())
//                .setAddress4(domainObject.getAddress4())
//                .setCountry(domainObject.getCountry())
//                .setProvince(domainObject.getProvince())
//                .setCity(domainObject.getCity())
//                .setPostcode(domainObject.getPostcode())
//                .setTelepon(domainObject.getTelepon())
//                .setFax(domainObject.getFax())
//                .setPersonname1(domainObject.getPersonname1())
//                .setOfficephone1(domainObject.getOfficephone1())
//                .setMobilephone1(domainObject.getMobilephone1())
//                .setEmail1(domainObject.getEmail1())
//                .setPersonname2(domainObject.getPersonname2())
//                .setOfficephone2(domainObject.getOfficephone2())
//                .setMobilephone2(domainObject.getMobilephone2())
//                .setEmail2(domainObject.getEmail2())
//                .setCreationalDate(domainObject.getCreationalDate())
//                .setCreationalBy(domainObject.getCreationalBy())
//                .createCompanyProfileDTO();
//    }
//
//    @Override
//    public CompanyProfile toDomain(CompanyProfileDTO dtoObject) {
//        return new CompanyProfileBuilder()
//                .setFullname(dtoObject.getFullname())
//                .setShortname(dtoObject.getShortname())
//                .setDisplayname(dtoObject.getDisplayname())
//                .setBankcode(dtoObject.getBankcode())
//                .setTaxID(dtoObject.getTaxID())
//                .setAddress1(dtoObject.getAddress1())
//                .setAddress2(dtoObject.getAddress2())
//                .setAddress3(dtoObject.getAddress3())
//                .setAddress4(dtoObject.getAddress4())
//                .setCountry(dtoObject.getCountry())
//                .setProvince(dtoObject.getProvince())
//                .setCity(dtoObject.getCity())
//                .setPostcode(dtoObject.getPostcode())
//                .setTelepon(dtoObject.getTelepon())
//                .setFax(dtoObject.getFax())
//                .setPersonname1(dtoObject.getPersonname1())
//                .setOfficephone1(dtoObject.getOfficephone1())
//                .setMobilephone1(dtoObject.getMobilephone1())
//                .setEmail1(dtoObject.getEmail1())
//                .setPersonname2(dtoObject.getPersonname2())
//                .setOfficephone2(dtoObject.getOfficephone2())
//                .setMobilephone2(dtoObject.getMobilephone2())
//                .setEmail2(dtoObject.getEmail2())
//                .setCreationalDate(dtoObject.getCreationalDate())
//                .setCreationalBy(dtoObject.getCreationalBy())
//                .createCompanyProfile();
//    }
//
//    public List<CompanyProfile> toDomain(List<CompanyProfileDTO> arg0) {
//        List<CompanyProfile> res = new ArrayList<>();
//        for (CompanyProfileDTO c : arg0) {
//            res.add(new CompanyProfileDTOAssembler().toDomain(c));
//        }
//        return res;
//    }
//    
//    public List<CompanyProfileDTO> toDTO(List<CompanyProfile> arg0) {
//        List<CompanyProfileDTO> res = new ArrayList<>();
//        for (CompanyProfile c : arg0) {
//            res.add(this.toDTO(c));
//        }
//        return res;
//    }
//
//}
