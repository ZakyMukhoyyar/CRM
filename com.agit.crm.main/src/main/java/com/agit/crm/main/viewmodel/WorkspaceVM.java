package com.agit.crm.main.viewmodel;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.layout.PrivilegeTreeModel;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showQuestionMessagebox;
import com.agit.crm.user.management.application.PrivilegeService;
import com.agit.crm.user.management.application.RoleService;
import com.agit.crm.user.management.application.security.SecurityCacheHelper;
import com.agit.crm.util.DateUtil;
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

    private UserDTO user;
    private PrivilegeTreeModel model;
    private String rightSelectedTab;
    private String selectedTab;
    private String role;
    private String uriPhoto;
    private String sourceDashboard;

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
        } else {
            if (model.isObjectOpened(selected)) {
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

    @Command("buttonLogout")
    public void buttonLogout(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.navigateTo("login.zul", window, null);
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

}
