package com.agit.crm.main.viewmodel;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.application.DomisiliService;
import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.crm.common.layout.PrivilegeTreeModel;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showQuestionMessagebox;
import com.agit.crm.user.management.application.PrivilegeService;
import com.agit.crm.user.management.application.RoleService;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.user.management.application.security.SecurityCacheHelper;
import com.agit.crm.util.DateUtil;
import com.agit.crm.util.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class WorkspaceVM {

    @WireVariable
    PrivilegeService privilegeService;

    @WireVariable
    RoleService roleService;

    @WireVariable
    UserService userService;

    @WireVariable
    DomisiliService domisiliService;

    @WireVariable
    MinatService minatService;

    @WireVariable
    KetrampilanService ketrampilanService;

    @WireVariable
    JurusanService jurusanService;

    @WireVariable
    CivitasService civitasService;

    private UserDTO user;
    private PrivilegeTreeModel model;
    private String rightSelectedTab;
    private String selectedTab;
    private String role;
    private String uriPhoto;
    private String sourceDashboard;

    private UserDTO userDTO = new UserDTO();
    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<UserDTO> userDTO2s = new ArrayList<>();
    private List<DomisiliDTO> domisilis = new ArrayList<DomisiliDTO>();
    private List<MinatDTO> minats = new ArrayList<MinatDTO>();
    private List<String> listMinat = new ArrayList<>();
    private List<String> listKetrampilan = new ArrayList<>();
    private List<String> listDomisili = new ArrayList<>();
    private List<String> listCivitas = new ArrayList<>();
    private List<String> listJurusan = new ArrayList<>();
    private ListModelList<JenisKelaminType> jenisKelaminTypes;
    private ListModelList<PendidikanType> pendidikanTypes;
    private ListModelList<TingkatanType> tingkatanTypes1;
    private ListModelList<TingkatanType> tingkatanTypes2;
    private ListModelList<TingkatanType> tingkatanTypes3;
    private ListModelList<TingkatanType> tingkatanTypes4;
    private ListModelList<TingkatanType> tingkatanTypes5;
    private List<KetrampilanDTO> ketrampilans = new ArrayList<KetrampilanDTO>();
    private List<JurusanDTO> jurusans = new ArrayList<JurusanDTO>();
    private List<CivitasDTO> civitass = new ArrayList<CivitasDTO>();

    private String fullName;
    private String ktp;
    private String domisiliSelect;
    private String minatSelect;
    private String jurusanSelect;
    private String ketrampilanSelect;
    private String civitasSelect;
    private String userID;

    @Wire
    private Tabs tabs;
    @Wire
    private Tabpanels tabPanels;
    @Wire
    private Tabbox tabbox;

    private final Map<String, Tab> tabMap = new HashMap<>();
    private final Map<String, Tabpanel> tabPanelMap = new HashMap<>();

    public static String URI_MENUS = "fnd.service.privilege.get.menu";

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        tabs.getChildren().get(0).addEventListener(Events.ON_SELECT, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                Component comp = Executions.createComponents("/WEB-INF/dashboard.zul", null, null);
//                Component comp = Executions.createComponents("/acction/monitoring/Order_Monitoring.zul", null, null);
                tabPanels.getChildren().get(0).getChildren().clear();
                tabPanels.getChildren().get(0).appendChild(comp);
            }
        });
    }

    @Init
    public void init() {
        user = SecurityUtil.getUser();
        List<PrivilegeDTO> menu = (List<PrivilegeDTO>) SecurityCacheHelper.getObjectInCache(SecurityCacheHelper.MENU, user.getUserName());
        if (menu == null) {
            menu = new ArrayList();
            PrivilegeDTO p = getPrivilege();

            menu.add(p);

            SecurityCacheHelper.putObjectInCache(SecurityCacheHelper.MENU, user.getUserName(), menu);
        }

        model = new PrivilegeTreeModel(menu);

        sourceDashboard = "/WEB-INF/dashboard.zul";
//        sourceDashboard = "/acction/monitoring/Order_Monitoring.zul";
//        uriPhoto = "/images/logoagit-new.png";

    }

    private PrivilegeDTO getPrivilege() {
        PrivilegeDTO p = privilegeService.findByID("ROOT");

        if (!user.getUserName().equalsIgnoreCase("superadmin")) {
            List<String> s = roleService.grantedAuthoritys(user.getRoleDTO().getRoleID());
            List<PrivilegeDTO> privilegeDTOs = privilegeService.findByListID(s);
            List<PrivilegeDTO> privilegeDTOs1 = new ArrayList();

            for (PrivilegeDTO privilegeDTO : privilegeDTOs) {
                if (privilegeDTO.getParentID().equalsIgnoreCase("administrator")) {
                    privilegeDTOs1.add(privilegeDTO);
                }
            }
            p.setChildren(privilegeDTOs1);
        }

        return p;
    }

    @Command("menuClick")
    public void menu(@BindingParam("obj") PrivilegeDTO selected) {
        if (model.isLeaf(selected)) {
            final String tabName = selected.getTabName();
            Tab tab = tabMap.get(tabName);
            if (tab == null) {
                tab = newTab(tabName, selected.getIcon(), true);
                tabMap.put(tabName, tab);
                tabs.appendChild(tab);
            }
            selectedTab = tabName;
            tabbox.setSelectedTab(tab);

            Tabpanel tabPanel = tabPanelMap.get(tabName);
            if (tabPanel == null) {
                tabPanel = new Tabpanel();
                tabPanel.setStyle("overflow:auto;");
                tabPanelMap.put(tabName, tabPanel);
                tabPanels.appendChild(tabPanel);
                Component comp = Executions.createComponents(selected.getUrl(), null, null);
                tabPanel.appendChild(comp);
            } else {
                tabPanel.getChildren().clear();
                Component comp = Executions.createComponents(selected.getUrl(), null, null);
                tabPanel.appendChild(comp);
            }
        } else if (model.isObjectOpened(selected)) {
            model.removeOpenObject(selected);
        } else {
            model.clearOpen();
            model.addOpenPath(model.getPath(selected));
            int[] path = model.getPath(selected);
            int[] openPath = new int[]{};
            for (int i = 0; i < path.length; i++) {
                openPath = Arrays.copyOf(openPath, openPath.length + 1);
                openPath[openPath.length - 1] = path[i];
                model.addOpenPath(openPath);
            }
        }
    }

    public Tab newTab(final String tabName, String icon, boolean closable) {
        Tab tab = new Tab(tabName);
        tab.setClosable(closable);
        tab.setIconSclass(icon);
        tab.setContext("popupClose");
        tab.setSelected(true);

        tab.addEventListener(Events.ON_CLOSE, new SerializableEventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                String eventName = event.getName();
                if (eventName.equals(Events.ON_CLOSE)) {
                    event.stopPropagation();
                    showQuestionMessagebox(Labels.getLabel("common.question.close"), new EventListener<Event>() {
                        @Override
                        public void onEvent(Event e) throws Exception {
                            if (e.getData().equals(Messagebox.OK)) {
                                closeTab();
                            }
                        }
                    });
                }
            }
        });
        tab.addEventListener(Events.ON_RIGHT_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                rightSelectedTab = ((Tab) event.getTarget()).getLabel();
            }
        });
        tab.addEventListener(Events.ON_SELECT, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                selectedTab = ((Tab) event.getTarget()).getLabel();
            }
        });
        return tab;
    }

    @Command("menuRightTab")

    public void menuRightTab(@BindingParam("popupRight") Integer popupRight) {
        if (popupRight == 1) {
            showQuestionMessagebox(Labels.getLabel("common.question.close.tab"), new EventListener<Event>() {
                @Override
                public void onEvent(Event event) throws Exception {
                    if (event.getData().equals(Messagebox.OK)) {
                        tabMap.get(rightSelectedTab).close();
                        tabMap.remove(rightSelectedTab);
                        tabPanelMap.remove(rightSelectedTab);
                    }
                }
            });
        } else if (popupRight == 2) {
            showQuestionMessagebox(Labels.getLabel("common.question.close.all"), new EventListener<Event>() {
                @Override
                public void onEvent(Event event) throws Exception {
                    if (event.getData().equals(Messagebox.OK)) {
                        for (Map.Entry<String, Tab> entry : tabMap.entrySet()) {
                            entry.getValue().close();
                        }
                        tabMap.clear();
                        tabPanelMap.clear();
                    }
                }
            });
        } else {
            showQuestionMessagebox(Labels.getLabel("common.question.close.other"), new EventListener<Event>() {
                @Override
                public void onEvent(Event event) throws Exception {
                    if (event.getData().equals(Messagebox.OK)) {
                        Map<String, Tab> temp = new HashMap<>();
                        temp.putAll(tabMap);
                        temp.remove(rightSelectedTab);
                        for (Map.Entry<String, Tab> entry : temp.entrySet()) {
                            entry.getValue().close();
                            tabMap.remove(entry.getKey());
                            tabPanelMap.remove(entry.getKey());
                        }
                    }
                }
            });
        }
    }

    @Command("buttonKlikProfile")
    @NotifyChange("userDTO")
    public void buttonDetailProfil(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/beranda_profile_mahasiswa.zul", window, params);
    }

    @Command("buttonLogout")
    public void buttonLogout(@ContextParam(ContextType.VIEW) Window window) {
        Date now = new Date();
        UserDTO userInfo = userService.findByID(SecurityUtil.getUserName());
        if (StringUtil.hasValue(userInfo)) {
            UserLoginInfoDTO loginInfoDTO = userInfo.getUserSpecificationDTO().getUserLoginInfoDTO();
            loginInfoDTO.setLastLogin(now);
            loginInfoDTO.setLogoutDate(now);
            loginInfoDTO.setRemoteHost(null);
            loginInfoDTO.setRemoteAddress(null);
            loginInfoDTO.setSessionID(null);
            userService.updateLoginInfo(userInfo.getUserName(), loginInfoDTO);
        }
        CommonViewModel.navigateToWithoutDetach("/crm/logout.zul", window, null);
    }

    @GlobalCommand("closeTab")
    public void closeTab() {
        tabMap.get(selectedTab).close();
        tabMap.remove(selectedTab);
        tabPanelMap.remove(selectedTab);
    }

    @GlobalCommand
    public void openFromDetach(@BindingParam("zulName") String zulName, @BindingParam("tabName") String tabName, @ContextParam(ContextType.VIEW) Window window) {
        Tabpanel tabPanel = tabPanelMap.get(tabName);
        tabPanel.getChildren().clear();
        Component comp = Executions.createComponents(zulName, null, null);
        tabPanel.appendChild(comp);
    }

    /* Helper */
    public String concat(String s1, String s2) {
        return s1.concat(s2);
    }

    public String concatDate(String s1, Date s2) {
        return s1.concat(DateUtil.dateToString(s2, "dd-MMM-yyy HH:mm:ss"));
    }

    /* Getter & Setter */
    public UserDTO getUser() {
        return user;
    }

    public PrivilegeTreeModel getModel() {
        return model;
    }

    public String getRightSelectedTab() {
        return rightSelectedTab;
    }

    public String getSelectedTab() {
        return selectedTab;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUriPhoto() {
        return uriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        this.uriPhoto = uriPhoto;
    }

    public String getSourceDashboard() {
        return sourceDashboard;
    }

    public void setSourceDashboard(String sourceDashboard) {
        this.sourceDashboard = sourceDashboard;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public List<UserDTO> getUserDTO2s() {
        return userDTO2s;
    }

    public void setUserDTO2s(List<UserDTO> userDTO2s) {
        this.userDTO2s = userDTO2s;
    }

    public List<DomisiliDTO> getDomisilis() {
        return domisilis;
    }

    public void setDomisilis(List<DomisiliDTO> domisilis) {
        this.domisilis = domisilis;
    }

    public List<MinatDTO> getMinats() {
        return minats;
    }

    public void setMinats(List<MinatDTO> minats) {
        this.minats = minats;
    }

    public List<String> getListMinat() {
        return listMinat;
    }

    public void setListMinat(List<String> listMinat) {
        this.listMinat = listMinat;
    }

    public List<String> getListKetrampilan() {
        return listKetrampilan;
    }

    public void setListKetrampilan(List<String> listKetrampilan) {
        this.listKetrampilan = listKetrampilan;
    }

    public List<String> getListDomisili() {
        return listDomisili;
    }

    public void setListDomisili(List<String> listDomisili) {
        this.listDomisili = listDomisili;
    }

    public List<String> getListCivitas() {
        return listCivitas;
    }

    public void setListCivitas(List<String> listCivitas) {
        this.listCivitas = listCivitas;
    }

    public List<String> getListJurusan() {
        return listJurusan;
    }

    public void setListJurusan(List<String> listJurusan) {
        this.listJurusan = listJurusan;
    }

    public ListModelList<JenisKelaminType> getJenisKelaminTypes() {
        return new ListModelList<>(JenisKelaminType.values());
    }

    public void setJenisKelaminTypes(ListModelList<JenisKelaminType> jenisKelaminTypes) {
        this.jenisKelaminTypes = jenisKelaminTypes;
    }

    public ListModelList<PendidikanType> getPendidikanTypes() {
        return new ListModelList<>(PendidikanType.values());
    }

    public void setPendidikanTypes(ListModelList<PendidikanType> pendidikanTypes) {
        this.pendidikanTypes = pendidikanTypes;
    }

    public ListModelList<TingkatanType> getTingkatanTypes1() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes1(ListModelList<TingkatanType> tingkatanTypes1) {
        this.tingkatanTypes1 = tingkatanTypes1;
    }

    public ListModelList<TingkatanType> getTingkatanTypes2() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes2(ListModelList<TingkatanType> tingkatanTypes2) {
        this.tingkatanTypes2 = tingkatanTypes2;
    }

    public ListModelList<TingkatanType> getTingkatanTypes3() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes3(ListModelList<TingkatanType> tingkatanTypes3) {
        this.tingkatanTypes3 = tingkatanTypes3;
    }

    public ListModelList<TingkatanType> getTingkatanTypes4() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes4(ListModelList<TingkatanType> tingkatanTypes4) {
        this.tingkatanTypes4 = tingkatanTypes4;
    }

    public ListModelList<TingkatanType> getTingkatanTypes5() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes5(ListModelList<TingkatanType> tingkatanTypes5) {
        this.tingkatanTypes5 = tingkatanTypes5;
    }

    public List<KetrampilanDTO> getKetrampilans() {
        return ketrampilans;
    }

    public void setKetrampilans(List<KetrampilanDTO> ketrampilans) {
        this.ketrampilans = ketrampilans;
    }

    public List<JurusanDTO> getJurusans() {
        return jurusans;
    }

    public void setJurusans(List<JurusanDTO> jurusans) {
        this.jurusans = jurusans;
    }

    public List<CivitasDTO> getCivitass() {
        return civitass;
    }

    public void setCivitass(List<CivitasDTO> civitass) {
        this.civitass = civitass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getDomisiliSelect() {
        return domisiliSelect;
    }

    public void setDomisiliSelect(String domisiliSelect) {
        this.domisiliSelect = domisiliSelect;
    }

    public String getMinatSelect() {
        return minatSelect;
    }

    public void setMinatSelect(String minatSelect) {
        this.minatSelect = minatSelect;
    }

    public String getJurusanSelect() {
        return jurusanSelect;
    }

    public void setJurusanSelect(String jurusanSelect) {
        this.jurusanSelect = jurusanSelect;
    }

    public String getKetrampilanSelect() {
        return ketrampilanSelect;
    }

    public void setKetrampilanSelect(String ketrampilanSelect) {
        this.ketrampilanSelect = ketrampilanSelect;
    }

    public String getCivitasSelect() {
        return civitasSelect;
    }

    public void setCivitasSelect(String civitasSelect) {
        this.civitasSelect = civitasSelect;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Tabs getTabs() {
        return tabs;
    }

    public void setTabs(Tabs tabs) {
        this.tabs = tabs;
    }

    public Tabpanels getTabPanels() {
        return tabPanels;
    }

    public void setTabPanels(Tabpanels tabPanels) {
        this.tabPanels = tabPanels;
    }

    public Tabbox getTabbox() {
        return tabbox;
    }

    public void setTabbox(Tabbox tabbox) {
        this.tabbox = tabbox;
    }

}
