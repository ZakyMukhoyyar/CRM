package com.agit.crm.user.management.interfaces.web.ui.viewmodel;

//package com.agit.crm.user.management.interfaces.web.ui.viewmodel;
//
//import com.agit.crm.common.dto.usermanagement.CompanyProfileDTO;
//import com.agit.crm.common.dto.usermanagement.CompanyProfileDTOBuilder;
//import com.agit.crm.shared.type.BankCode;
//import com.agit.crm.shared.type.City;
//import com.agit.crm.shared.type.Country;
//import com.agit.crm.shared.type.Province;
//import com.agit.crm.shared.zul.CommonViewModel;
//import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
//import com.agit.crm.shared.zul.PageNavigation;
//import com.agit.crm.user.management.application.CompanyProfileService;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.zkoss.bind.BindUtils;
//import org.zkoss.bind.annotation.BindingParam;
//import org.zkoss.bind.annotation.Command;
//import org.zkoss.bind.annotation.ContextParam;
//import org.zkoss.bind.annotation.ContextType;
//import org.zkoss.bind.annotation.ExecutionArgParam;
//import org.zkoss.bind.annotation.GlobalCommand;
//import org.zkoss.bind.annotation.Init;
//import org.zkoss.bind.annotation.NotifyChange;
//import org.zkoss.zk.ui.event.Event;
//import org.zkoss.zk.ui.select.annotation.WireVariable;
//import org.zkoss.zul.ListModelList;
//import org.zkoss.zul.Messagebox;
//import org.zkoss.zul.Window;
//
///**
// *
// * @author RBS
// */
//public class CompanyVM {
//
//    @WireVariable
//    CompanyProfileService companyProfileService;
//
//    private CompanyProfileDTO companyProfileDTO = new CompanyProfileDTO();
//    private List<CompanyProfileDTO> companyProfileDTOs = new ArrayList<>();//mengambil DTO menghasilkan DTO Array
//
//    /* search option*/
//    private String fullname;
//    
//    //List For Combo Box
//    private ListModelList<BankCode> listBankCode = new ListModelList<>();
//    private ListModelList<Country> listCountry = new ListModelList<>();
//    private ListModelList<Province> listProvince = new ListModelList<>();
//    private ListModelList<City> listCity= new ListModelList<>();
//    
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
//     //    Setting List
//    private PageNavigation previous;
//    private boolean checked;
//    private int pageSize = 5;
//    private int activePage = 0;
//    private int selectedIndex;
//    private int totalSize = 0;
//    
//    @Init
//    public void init(
//            @ExecutionArgParam("companyProfileDTO") CompanyProfileDTO companyProfile,
//            @ExecutionArgParam("previous") PageNavigation previous) {
//
//        initData();
//        checkValidity(companyProfile, previous);
//    }
//
//    private void initData() {
//        companyProfileDTOs = companyProfileService.findAllCompany();
//        if (companyProfileDTOs == null && companyProfileDTOs.size() == 0) {
//            companyProfileDTOs = Collections.EMPTY_LIST;
//        } else {
//        }
//    }
//
//    private void checkValidity(CompanyProfileDTO companyProfile, PageNavigation previous) {
//        if (companyProfile == null) {
//            ListModelList<CompanyProfileDTO> companyProfileList = new ListModelList<>(companyProfileService.findAllCompany());
//            String fullname = "";
//            companyProfileDTO = new CompanyProfileDTOBuilder()
//                    .setFullname(fullname)
//                    .setCreationalBy("Rachmad")
//                    .setCreationalDate(new Date())
//                    .createCompanyProfileDTO();
//        } else {
//            this.companyProfileDTO = companyProfile;
//            fullname = companyProfileDTO.getFullname();
//            this.previous = previous;
//        }
//    }
//    
//     @Command("buttonSave")
//     @NotifyChange("companyProfileDTO")
//    public void buttonSave(@ContextParam(ContextType.VIEW) Window window) {
//        if (companyProfileDTO != null) {
//            companyProfileDTO.setCreationalBy("Rachmad");
//            companyProfileDTO.setCreationalDate(new Date());
//            companyProfileService.saveOrUpdate(companyProfileDTO);
//            showInformationMessagebox("Data Berhasil Disimpan");
//            BindUtils.postGlobalCommand(null, null, "refreshData", null);
//            window.detach();
//        }
//
//    }
//
//    @Command("buttonNewCompany")
//    @NotifyChange("companyProfileDTO")
//    public void buttonNewCompany(@BindingParam("object") CompanyProfileDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("companyProfileDTO", obj);
//        CommonViewModel.navigateToWithoutDetach("~./ui/fnd/company/creat.company.zul", window, params);
//    }
//
//    @Command("buttonCancel")
//    @NotifyChange("companyProfileDTO")
//    public void buttonCancel(@BindingParam("object") CompanyProfileDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        window.detach();
//    }
//
//    @Command("buttonSearch")
//    @NotifyChange("companyProfileDTOs")
//    public void buttonSearch(@ContextParam(ContextType.VIEW) Window window) {
//        Map params = new HashMap();
//        params.put("fullname", fullname);
//
//        companyProfileDTOs = companyProfileService.findByParams(params);
//    }
//
//    @Command("detailCompanyProfile")
//    @NotifyChange("companyProfile")
//    public void detailEmployee(@BindingParam("object") CompanyProfileDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("companyProfileDTO", obj);
//        CommonViewModel.navigateToWithoutDetach("~./ui/fnd/company/creat.company.zul", window, params);
//    }
//
//    @Command("deleteCompany")
//    @NotifyChange("companyProfileDTOs")
//    public void deleteEmployee(@BindingParam("object") CompanyProfileDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        companyProfileDTO = (CompanyProfileDTO) obj;
//        Messagebox.show("Apakah anda yakin ingin menghapus Data?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
//                new org.zkoss.zk.ui.event.EventListener() {
//            @Override
//            public void onEvent(Event evt) throws InterruptedException {
//                if (evt.getName().equals("onOK")) {
//                    companyProfileService.deleteData(companyProfileDTO);
//                    showInformationMessagebox("Data Berhasil Dihapus");
//                    BindUtils.postGlobalCommand(null, null, "refreshData", null);
//                } else {
//                    System.out.println("Operation Canceled !");
//                }
//            }
//        }
//        );
//    }
//
//    @GlobalCommand
//    @NotifyChange("companyProfileDTOs")
//    public void refreshData() {
//        companyProfileDTOs = companyProfileService.findAllCompany();
//    }
//
//    public CompanyProfileService getCompanyProfileService() {
//        return companyProfileService;
//    }
//
//    public void setCompanyProfileService(CompanyProfileService companyProfileService) {
//        this.companyProfileService = companyProfileService;
//    }
//
//    public CompanyProfileDTO getCompanyProfileDTO() {
//        return companyProfileDTO;
//    }
//
//    public void setCompanyProfileDTO(CompanyProfileDTO companyProfileDTO) {
//        this.companyProfileDTO = companyProfileDTO;
//    }
//
//    public List<CompanyProfileDTO> getCompanyProfileDTOs() {
//        return companyProfileDTOs;
//    }
//
//    public void setCompanyProfileDTOs(List<CompanyProfileDTO> companyProfileDTOs) {
//        this.companyProfileDTOs = companyProfileDTOs;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public ListModelList<BankCode> getListBankCode() {
//        return new ListModelList<>(BankCode.values());
//    }
//
//    public void setListBankCode(ListModelList<BankCode> listBankCode) {
//        this.listBankCode = listBankCode;
//    }
//
//    public ListModelList<Country> getListCountry() {
//        return new ListModelList<>(Country.values());
//    }
//
//    public void setListCountry(ListModelList<Country> listCountry) {
//        this.listCountry = listCountry;
//    }
//
//    public ListModelList<Province> getListProvince() {
//        return new ListModelList<>(Province.values());
//    }
//
//    public void setListProvince(ListModelList<Province> listProvince) {
//        this.listProvince = listProvince;
//    }
//
//    public ListModelList<City> getListCity() {
//        return new ListModelList<>(City.values());
//    }
//
//    public void setListCity(ListModelList<City> listCity) {
//        this.listCity = listCity;
//    }
//
//    public String getShortname() {
//        return shortname;
//    }
//
//    public void setShortname(String shortname) {
//        this.shortname = shortname;
//    }
//
//    public String getDisplayname() {
//        return displayname;
//    }
//
//    public void setDisplayname(String displayname) {
//        this.displayname = displayname;
//    }
//
//    public BankCode getBankcode() {
//        return bankcode;
//    }
//
//    public void setBankcode(BankCode bankcode) {
//        this.bankcode = bankcode;
//    }
//
//    public String getTaxID() {
//        return taxID;
//    }
//
//    public void setTaxID(String taxID) {
//        this.taxID = taxID;
//    }
//
//    public String getAddress1() {
//        return address1;
//    }
//
//    public void setAddress1(String address1) {
//        this.address1 = address1;
//    }
//
//    public String getAddress2() {
//        return address2;
//    }
//
//    public void setAddress2(String address2) {
//        this.address2 = address2;
//    }
//
//    public String getAddress3() {
//        return address3;
//    }
//
//    public void setAddress3(String address3) {
//        this.address3 = address3;
//    }
//
//    public String getAddress4() {
//        return address4;
//    }
//
//    public void setAddress4(String address4) {
//        this.address4 = address4;
//    }
//
//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//
//    public Province getProvince() {
//        return province;
//    }
//
//    public void setProvince(Province province) {
//        this.province = province;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
//
//    public int getPostcode() {
//        return postcode;
//    }
//
//    public void setPostcode(int postcode) {
//        this.postcode = postcode;
//    }
//
//    public int getTelepon() {
//        return telepon;
//    }
//
//    public void setTelepon(int telepon) {
//        this.telepon = telepon;
//    }
//
//    public int getFax() {
//        return fax;
//    }
//
//    public void setFax(int fax) {
//        this.fax = fax;
//    }
//
//    public String getPersonname1() {
//        return personname1;
//    }
//
//    public void setPersonname1(String personname1) {
//        this.personname1 = personname1;
//    }
//
//    public String getOfficephone1() {
//        return officephone1;
//    }
//
//    public void setOfficephone1(String officephone1) {
//        this.officephone1 = officephone1;
//    }
//
//    public String getMobilephone1() {
//        return mobilephone1;
//    }
//
//    public void setMobilephone1(String mobilephone1) {
//        this.mobilephone1 = mobilephone1;
//    }
//
//    public String getEmail1() {
//        return email1;
//    }
//
//    public void setEmail1(String email1) {
//        this.email1 = email1;
//    }
//
//    public String getPersonname2() {
//        return personname2;
//    }
//
//    public void setPersonname2(String personname2) {
//        this.personname2 = personname2;
//    }
//
//    public String getOfficephone2() {
//        return officephone2;
//    }
//
//    public void setOfficephone2(String officephone2) {
//        this.officephone2 = officephone2;
//    }
//
//    public String getMobilephone2() {
//        return mobilephone2;
//    }
//
//    public void setMobilephone2(String mobilephone2) {
//        this.mobilephone2 = mobilephone2;
//    }
//
//    public String getEmail2() {
//        return email2;
//    }
//
//    public void setEmail2(String email2) {
//        this.email2 = email2;
//    }
//
//    public Date getCreationalDate() {
//        return creationalDate;
//    }
//
//    public void setCreationalDate(Date creationalDate) {
//        this.creationalDate = creationalDate;
//    }
//
//    public String getCreationalBy() {
//        return creationalBy;
//    }
//
//    public void setCreationalBy(String creationalBy) {
//        this.creationalBy = creationalBy;
//    }
//
//    public PageNavigation getPrevious() {
//        return previous;
//    }
//
//    public void setPrevious(PageNavigation previous) {
//        this.previous = previous;
//    }
//
//    public boolean isChecked() {
//        return checked;
//    }
//
//    public void setChecked(boolean checked) {
//        this.checked = checked;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getActivePage() {
//        return activePage;
//    }
//
//    public void setActivePage(int activePage) {
//        this.activePage = activePage;
//    }
//
//    public int getSelectedIndex() {
//        return selectedIndex;
//    }
//
//    public void setSelectedIndex(int selectedIndex) {
//        this.selectedIndex = selectedIndex;
//    }
//
//    public int getTotalSize() {
//        return totalSize;
//    }
//
//    public void setTotalSize(int totalSize) {
//        this.totalSize = totalSize;
//    }
//    
//    
//}
