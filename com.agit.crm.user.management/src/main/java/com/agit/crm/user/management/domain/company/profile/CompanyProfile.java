package com.agit.crm.user.management.domain.company.profile;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.agit.crm.user.management.domain.company.profile;
//
//import com.bitozen.skk.shared.type.BankCode;
//import com.bitozen.skk.shared.type.City;
//import com.bitozen.skk.shared.type.Country;
//import com.bitozen.skk.shared.type.Province;
//import java.util.Date;
//import java.util.Objects;
//
///**
// *
// * @author RBS
// */
//public class CompanyProfile {
//    long id;
//    //company info
//    private String fullname;
//    private String shortname;
//    private String displayname;
//    private BankCode bankcode;
//    private String taxID;
//
//    //addrress
//    private String address1;
//    private String address2;
//    private String address3;
//    private String address4;
//    private Country country;
//    private Province province;
//    private City city;
//    private int postcode;
//    private int telepon;
//    private int fax;
//
//    //Primary Contact
//    private String personname1;
//    private String officephone1;
//    private String mobilephone1;
//    private String email1;
//
//    //Primary Contact
//    private String personname2;
//    private String officephone2;
//    private String mobilephone2;
//    private String email2;
//
//    private Date creationalDate;
//    private String creationalBy;
//
//    public CompanyProfile() {
//    }
//
//    public CompanyProfile(String fullname, String shortname, String displayname, BankCode bankcode, String taxID, String address1, String address2, String address3, String address4, Country country, Province province, City city, int postcode, int telepon, int fax, String personname1, String officephone1, String mobilephone1, String email1, String personname2, String officephone2, String mobilephone2, String email2, Date creationalDate, String creationalBy) {
//        this.fullname = fullname;
//        this.shortname = shortname;
//        this.displayname = displayname;
//        this.bankcode = bankcode;
//        this.taxID = taxID;
//        this.address1 = address1;
//        this.address2 = address2;
//        this.address3 = address3;
//        this.address4 = address4;
//        this.country = country;
//        this.province = province;
//        this.city = city;
//        this.postcode = postcode;
//        this.telepon = telepon;
//        this.fax = fax;
//        this.personname1 = personname1;
//        this.officephone1 = officephone1;
//        this.mobilephone1 = mobilephone1;
//        this.email1 = email1;
//        this.personname2 = personname2;
//        this.officephone2 = officephone2;
//        this.mobilephone2 = mobilephone2;
//        this.email2 = email2;
//        this.creationalDate = creationalDate;
//        this.creationalBy = creationalBy;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public String getShortname() {
//        return shortname;
//    }
//
//    public String getDisplayname() {
//        return displayname;
//    }
//
//    public BankCode getBankcode() {
//        return bankcode;
//    }
//
//    public String getTaxID() {
//        return taxID;
//    }
//
//    public String getAddress1() {
//        return address1;
//    }
//
//    public String getAddress2() {
//        return address2;
//    }
//
//    public String getAddress3() {
//        return address3;
//    }
//
//    public String getAddress4() {
//        return address4;
//    }
//
//    public Country getCountry() {
//        return country;
//    }
//
//    public Province getProvince() {
//        return province;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public int getPostcode() {
//        return postcode;
//    }
//
//    public int getTelepon() {
//        return telepon;
//    }
//
//    public int getFax() {
//        return fax;
//    }
//
//    public String getPersonname1() {
//        return personname1;
//    }
//
//    public String getOfficephone1() {
//        return officephone1;
//    }
//
//    public String getMobilephone1() {
//        return mobilephone1;
//    }
//
//    public String getEmail1() {
//        return email1;
//    }
//
//    public String getPersonname2() {
//        return personname2;
//    }
//
//    public String getOfficephone2() {
//        return officephone2;
//    }
//
//    public String getMobilephone2() {
//        return mobilephone2;
//    }
//
//    public String getEmail2() {
//        return email2;
//    }
//
//    public Date getCreationalDate() {
//        return creationalDate;
//    }
//
//    public String getCreationalBy() {
//        return creationalBy;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 79 * hash + Objects.hashCode(this.fullname);
//        hash = 79 * hash + Objects.hashCode(this.shortname);
//        hash = 79 * hash + Objects.hashCode(this.displayname);
//        hash = 79 * hash + Objects.hashCode(this.bankcode);
//        hash = 79 * hash + Objects.hashCode(this.taxID);
//        hash = 79 * hash + Objects.hashCode(this.address1);
//        hash = 79 * hash + Objects.hashCode(this.address2);
//        hash = 79 * hash + Objects.hashCode(this.address3);
//        hash = 79 * hash + Objects.hashCode(this.address4);
//        hash = 79 * hash + Objects.hashCode(this.country);
//        hash = 79 * hash + Objects.hashCode(this.province);
//        hash = 79 * hash + Objects.hashCode(this.city);
//        hash = 79 * hash + this.postcode;
//        hash = 79 * hash + this.telepon;
//        hash = 79 * hash + this.fax;
//        hash = 79 * hash + Objects.hashCode(this.personname1);
//        hash = 79 * hash + Objects.hashCode(this.officephone1);
//        hash = 79 * hash + Objects.hashCode(this.mobilephone1);
//        hash = 79 * hash + Objects.hashCode(this.email1);
//        hash = 79 * hash + Objects.hashCode(this.personname2);
//        hash = 79 * hash + Objects.hashCode(this.officephone2);
//        hash = 79 * hash + Objects.hashCode(this.mobilephone2);
//        hash = 79 * hash + Objects.hashCode(this.email2);
//        hash = 79 * hash + Objects.hashCode(this.creationalDate);
//        hash = 79 * hash + Objects.hashCode(this.creationalBy);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final CompanyProfile other = (CompanyProfile) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        return true;
//    }
//    
//    public void assignNewCompanyProfile(CompanyProfile companyProfile) {
//        this.fullname = companyProfile.getFullname();
//        this.shortname = companyProfile.getShortname();
//        this.displayname = companyProfile.getDisplayname();
//        this.bankcode = companyProfile.getBankcode();
//        this.taxID = companyProfile.getTaxID();
//        this.address1 = companyProfile.getAddress1();
//        this.address2 = companyProfile.getAddress2();
//        this.address3 = companyProfile.getAddress3();
//        this.address4 = companyProfile.getAddress4();
//        this.country = companyProfile.getCountry();
//        this.province = companyProfile.getProvince();
//        this.city = companyProfile.getCity();
//        this.postcode = companyProfile.getPostcode();
//        this.telepon = companyProfile.getTelepon();
//        this.fax = companyProfile.getFax();
//        this.personname1 = companyProfile.getPersonname1();
//        this.officephone1 = companyProfile.getOfficephone1();
//        this.mobilephone1 = companyProfile.getMobilephone1();
//        this.email1 = companyProfile.getEmail1();
//        this.personname2 = companyProfile.getPersonname2();
//        this.officephone2 = companyProfile.getOfficephone2();
//        this.mobilephone2 = companyProfile.getMobilephone2();
//        this.email2 = companyProfile.getEmail2();
//        this.creationalDate = companyProfile.getCreationalDate();
//        this.creationalBy = companyProfile.getCreationalBy();
//    }
//
//    
//    
//}
