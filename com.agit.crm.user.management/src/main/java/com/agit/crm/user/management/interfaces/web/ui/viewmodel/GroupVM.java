package com.agit.crm.user.management.interfaces.web.ui.viewmodel;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import com.agit.crm.common.dto.usermanagement.RoleDTO;
import com.agit.crm.common.dto.usermanagement.RoleDTOBuilder;
import com.agit.crm.common.dto.usermanagement.RolePrivilegeDTO;
import com.agit.crm.common.layout.PrivilegeTreeModel;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.type.AccessType;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.PrivilegeService;
import com.agit.crm.user.management.application.RoleService;
import com.agit.crm.user.management.application.security.SecurityCacheHelper;
import com.agit.crm.user.management.interfaces.web.ui.navigation.GroupNavigation;
import com.agit.crm.util.SqlFilterUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public final class GroupVM {

    @WireVariable
    PrivilegeService privilegeService;

    @WireVariable
    RoleService roleService;

    private RoleDTO roleDTO;
    private PageNavigation previous;
    private List<RoleDTO> roleDTOs;
    private PrivilegeTreeModel model;
    private String deleted;
    private int pageSize;
    private int activePage;
    private String searchRoleName;
    private final Map<String, RolePrivilegeDTO> mappedRolePrivilege = new HashMap<>();

    @Init
    public void init(@ExecutionArgParam("role") RoleDTO role,
            @ExecutionArgParam("previous") PageNavigation previous,
            @ExecutionArgParam("search") String searchRoleName,
            @ExecutionArgParam("deleted") String deleted) {
        if (role == null) {
            roleDTO = new RoleDTOBuilder()
                    .setRoleStatus(StatusData.ACTIVE)
                    .setCreationalBy(SecurityUtil.getUserName())
                    .setRolePrivilegeDTOs(new ArrayList<RolePrivilegeDTO>())
                    .createRoleDTO();
        } else {
            roleDTO = role;
            this.previous = previous;
            this.searchRoleName = searchRoleName;
            this.deleted = deleted;
//            roleDTO.setRoleStatus(StatusData.DELETED);
        }

        if (deleted != null) {
            if (deleted.equals("deleted")) {
                roleDTO.setRoleStatus(StatusData.DELETED);
            }
        }

        pageSize = CommonViewModel.PAGE_SIZE;
        activePage = 1;
        for (RolePrivilegeDTO rolePrivilege : roleDTO.getRolePrivilegeDTOs()) {
            mappedRolePrivilege.put(rolePrivilege.getPrivilegeDTO().getPrivilegeID(), rolePrivilege);
        }
        PrivilegeDTO root = (PrivilegeDTO) SecurityCacheHelper.getObjectInCache(SecurityCacheHelper.ROOT, SecurityCacheHelper.ROOT);
        if (root == null) {
            root = privilegeService.findByID("ROOT");
            SecurityCacheHelper.putObjectInCache(SecurityCacheHelper.ROOT, SecurityCacheHelper.ROOT, root);
        }
        List<PrivilegeDTO> privileges = new ArrayList<>();
        privileges.add(root);
        model = new PrivilegeTreeModel(privileges);
    }

    /* Command */
    @Command("buttonSubmit")
    public void buttonSubmit(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("role", roleDTO);
        params.put("privilegeTree", model);
        params.put("search", searchRoleName);
        if (previous == null) {
            //create
            params.put("previous", PageNavigation.CREATE);
        } else {
            if (previous.equals(PageNavigation.SEARCH) || previous.equals(PageNavigation.CONFIRM)) {
                params.put("previous", PageNavigation.UPDATE);
            } else if (previous.equals(PageNavigation.CREATE)) {
                params.put("previous", PageNavigation.CREATE);
            }
        }
        CommonViewModel.navigateTo(GroupNavigation.GROUP_READ, window, params);
    }

    @Command("buttonConfirm")
    public void buttonConfirm(@ContextParam(ContextType.VIEW) Window window) throws JsonProcessingException {
        if (previous == PageNavigation.CREATE) {
            /* Check exist code */
            RoleDTO group = roleService.findByID(roleDTO.getRoleID() == null ? "" : roleDTO.getRoleID());
            if (group == null) {
                roleDTO.setCreationalDate(new Date());
                roleDTO.setRoleID(roleDTO.getRoleID().toUpperCase());
                try {
                    roleService.saveOrUpdate(roleDTO);
                    showInformationMessagebox("Role ID " + roleDTO.getRoleID() + " has successfully created", GroupNavigation.GROUP_CREATE, null, window);
                } catch (Exception e) {
                    CommonViewModel.showErrorMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", roleDTO.getRoleID()}));
                }
            } else {
                CommonViewModel.showErrorMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"Group Code", roleDTO.getRoleID()}));
            }
        } else if (previous == PageNavigation.UPDATE) {
            roleService.saveOrUpdate(roleDTO);
            showInformationMessagebox("Role ID " + roleDTO.getRoleID() + " has successfully updated", GroupNavigation.GROUP_SEARCH, null, window);
        } else {
            roleService.saveOrUpdate(roleDTO);
            showInformationMessagebox("Role ID " + roleDTO.getRoleID() + " has successfully deleted", GroupNavigation.GROUP_SEARCH, null, window);
        }
    }

    @Command("buttonOk")
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.goToGlobalCommandCloseTab();
    }

    @Command("buttonBack")
    public void buttonBack(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("role", roleDTO);
        params.put("previous", previous);
        params.put("search", searchRoleName);
        if (previous == PageNavigation.CREATE) {
            CommonViewModel.navigateTo(GroupNavigation.GROUP_CREATE, window, params);
        } else if (previous == PageNavigation.UPDATE) {
            params.put("previous", PageNavigation.CONFIRM);
            CommonViewModel.navigateTo(GroupNavigation.GROUP_UPDATE, window, params);
        } else {
            CommonViewModel.navigateTo(GroupNavigation.GROUP_SEARCH, window, params);
        }
    }

    @Command("buttonSearch")
    @NotifyChange({"roleDTOs", "pageSize", "activePage"})
    public void buttonSearch() {
        roleDTOs = roleService.findByParameter(SqlFilterUtil.bothLike(this.searchRoleName));

        if (roleDTOs.isEmpty()) {
            Messagebox.show("Data Tidak Ditemukan", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        }
    }

    @Command("buttonView")
    public void buttonView(@BindingParam("object") RoleDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("role", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchRoleName);
        CommonViewModel.navigateTo(GroupNavigation.GROUP_READ, window, params);
    }

    @Command("buttonUpdate")
    public void buttonUpdate(@BindingParam("object") RoleDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("role", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchRoleName);
        CommonViewModel.navigateTo(GroupNavigation.GROUP_UPDATE, window, params);
    }

    @Command("buttonDelete")
    public void buttonDelete(@BindingParam("object") RoleDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("role", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("deleted", "deleted");
        params.put("search", searchRoleName);
        CommonViewModel.navigateTo(GroupNavigation.GROUP_READ, window, params);
    }

    @Command("buttonClose")
    public void buttonClose() {
        CommonViewModel.onCloseTab();
    }

    @Command("onDoubleClickTree")
    public void onClickTree(@BindingParam("obj") PrivilegeDTO privilege) {
        if (model.isObjectOpened(privilege)) {
            model.removeOpenObject(privilege);
        } else {
            model.addOpenObject(privilege);
        }
    }

    @Command("selectGroupStatus")
    public void selectPrivilegeStatus(@BindingParam("obj") StatusData statusData) {
        roleDTO.setRoleStatus(statusData);
    }

    @Command("onCheckRadioButton")
    public void onCheckRadioButton(@BindingParam("privilege") PrivilegeDTO privilege, @BindingParam("accessType") AccessType accessType) {
        String privilegeID = privilege.getPrivilegeID();
        if (accessType.equals(AccessType.NONE)) {
            roleDTO.getRolePrivilegeDTOs().remove(mappedRolePrivilege.get(privilegeID));
            mappedRolePrivilege.remove(privilegeID);
        } else {
            RolePrivilegeDTO rolePrivilegeDTO = mappedRolePrivilege.get(privilegeID);
            RolePrivilegeDTO rolePrivilege = new RolePrivilegeDTO(privilege, accessType);
            mappedRolePrivilege.put(privilegeID, rolePrivilege);
            if (rolePrivilegeDTO == null) {
                roleDTO.getRolePrivilegeDTOs().add(rolePrivilege);
            } else {
                int index = roleDTO.getRolePrivilegeDTOs().indexOf(rolePrivilegeDTO);
                roleDTO.getRolePrivilegeDTOs().set(index, rolePrivilege);
            }
        }
    }

    /* Listbox */
    public AccessType[] getAccessTypes() {
        return AccessType.values();
    }

    public StatusData[] getStatusList() {
        return new StatusData[]{StatusData.ACTIVE, StatusData.INACTIVE, StatusData.DELETED};
    }

    public PrivilegeTreeModel getModel() {
        return model;
    }

    public AccessType checkedRadio(String privilegeID) {
        if (mappedRolePrivilege.get(privilegeID) == null) {
            return AccessType.NONE;
        }
        return mappedRolePrivilege.get(privilegeID).getAccessType();
    }

    public String toSentenceCase(String word) {
        if (word == null || word.trim().isEmpty()) {
            return word;
        }
        return word.charAt(0) + word.substring(1).toLowerCase();
    }

    /* Getter & Setter */
    public String getSearchRoleName() {
        return searchRoleName;
    }

    public void setSearchRoleName(String searchRoleName) {
        this.searchRoleName = searchRoleName;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public List<RoleDTO> getRoleDTOs() {
        return roleDTOs;
    }

    public void setRoleDTOs(List<RoleDTO> roleDTOs) {
        this.roleDTOs = roleDTOs;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getActivePage() {
        return activePage;
    }

    public void setActivePage(int activePage) {
        this.activePage = activePage;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public void setModel(PrivilegeTreeModel model) {
        this.model = model;
    }

}
