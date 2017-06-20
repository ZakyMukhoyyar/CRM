package com.agit.crm.user.management.interfaces.web.ui.viewmodel;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import com.agit.crm.common.dto.usermanagement.PrivilegeDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.PrivilegeService;
import com.agit.crm.util.CommonUtil;
import com.agit.crm.util.DateUtil;
import com.agit.crm.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author 3AD
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MenuVM {

    @WireVariable
    PrivilegeService privilegeService;

    /* Object Related Ticket*/
    private List<PrivilegeDTO> privilegeDTOs = new ArrayList<>();
    private PrivilegeDTO privilegeDTO;

    /* search option*/
    private String privilegeID;
    private String privilegeName;
    private StatusData privilegeStatus;

    /* list for combobox */
    private ListModelList<StatusData> listStatusPrivilege = new ListModelList<>();
    private ListModelList<String> listCodeParent = new ListModelList<>();

    /* list for combobox */
    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 5;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    @Init
    public void init(
            @ExecutionArgParam("privilegeDTO") PrivilegeDTO privilege,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(privilege, previous);
    }

    private void initData() {
        /* get all pelayanan */
        privilegeDTOs = privilegeService.findAll();
        for (PrivilegeDTO p : privilegeDTOs) {
            listCodeParent.add(p.getPrivilegeID());
        }

    }

    private void checkValidity(PrivilegeDTO privilege, PageNavigation previous) {
        if (privilege == null) {
            privilegeDTO = new PrivilegeDTOBuilder()
                    .setCreationalBy(SecurityUtil.getUserName())
                    .setCreationalDate(new Date())
                    .setMenu(Boolean.TRUE)
                    .setPrivilegeStatus(StatusData.ACTIVE)
                    .createPrivilegeDTO();
        } else {
            this.privilegeDTO = privilege;
            privilegeID = privilegeDTO.getPrivilegeID();
            privilegeName = privilegeDTO.getPrivilegeName();
            privilegeStatus = privilegeDTO.getPrivilegeStatus();
            this.previous = previous;
        }

    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    @Command("buttonSearch")
    @NotifyChange("privilegeDTOs")
    public void buttonSearch(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("privilegeID", privilegeID);
        params.put("privilegeName", privilegeName);
        params.put("privilegeStatus", privilegeStatus);

        privilegeDTOs = privilegeService.findByParam(params);
    }

    @Command("buttonNewPrivilege")
    @NotifyChange("privilegeDTO")
    public void buttonNewPrivilege(@BindingParam("object") PrivilegeDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("privilegeDTO", obj);
        CommonViewModel.navigateToWithoutDetach("~./ui/fnd/menu/create.privilege.zul", window, params);
    }

    @Command("buttonSavePrivilege")
    @NotifyChange({"privilegeDTO", "privilegeDTOs"})
    public void buttonSavePrivilege(@BindingParam("object") PrivilegeDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        privilegeService.saveOrUpdate(privilegeDTO);
        showInformationMessagebox("Menu Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();

    }

    @GlobalCommand
    @NotifyChange("privilegeDTOs")
    public void refreshData() {
        privilegeDTOs = privilegeService.findAll();
    }

    @Command("detailPrivilege")
    @NotifyChange("privilegeDTO")
    public void detailPrivilege(@BindingParam("object") PrivilegeDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("privilegeDTO", obj);
        CommonViewModel.navigateToWithoutDetach("~./ui/fnd/menu/create.privilege.zul", window, params);
    }

    @Command("buttonCancel")
    @NotifyChange("privilegeDTO")
    public void buttonCancel(@BindingParam("object") PrivilegeDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("onPagingLayanan")
    @NotifyChange({"privilegeDTOs", "activePage"})
    private void onPagingLayanan() {
        totalSize = privilegeDTOs.size();
        if (activePage * pageSize >= totalSize) {//the data size was change since last paging, reysnc it.
            activePage = 0;//simply to first page
        }
        ListModelList<PrivilegeDTO> listPrivilegeTemp = (ListModelList<PrivilegeDTO>) privilegeDTOs;
        for (int i = activePage * pageSize; i < (activePage + 1) * pageSize; i++) {
            listPrivilegeTemp.add(privilegeDTOs.get(i));
        }
        privilegeDTOs = listPrivilegeTemp;
    }

    /*Helper*/
    public String timeToString(Date date) {
        return DateUtil.dateToString(date, "HH:mm");
    }

    public String toSentenceCase(String word) {
        if (word == null || word.trim().isEmpty()) {
            return word;
        }
        return word.charAt(0) + word.substring(1).toLowerCase();
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    protected String getLatestObjectID(ListModelList list, String attribute) {
        int count = 0;
        int pointer = 0;
        int max = 0;
        String s = "";
        for (Object obj : list) {
            Map<String, Object> map = CommonUtil.convertObject2Map(obj);
            String att = attribute;
            String[] arr = new String[attribute.length()];
            String key = "";

            if (att.contains(".")) {
                arr = att.split("\\.");
                int f = 1;
                for (Object x : arr) {
                    if (f != arr.length) {
                        map = CommonUtil.convertObject2Map(map.get(x.toString()));
                    } else {
                        key = x.toString();
                    }
                    f += 1;
                }
            } else {
                key = att;
            }

            att = map.get(key).toString();

            String temp = "";
            int countTemp = 0;
            for (int i = att.length(); i > 0; i--) {
                if (Character.isLetter(att.charAt(i - 1))) {
                    pointer = i;
                    s = att.substring(0, pointer);
                    break;
                }
                countTemp += 1;
                temp = att.charAt(i - 1) + temp;
            }
            if (Integer.parseInt(temp) > max) {
                max = Integer.parseInt(temp);
            }
            count = countTemp;
        }

        return s + String.format("%0" + count + "d", max + 1);
    }

    public List<PrivilegeDTO> getPrivilegeDTOs() {
        return privilegeDTOs;
    }

    public void setPrivilegeDTOs(List<PrivilegeDTO> privilegeDTOs) {
        this.privilegeDTOs = privilegeDTOs;
    }

    public PrivilegeDTO getPrivilegeDTO() {
        return privilegeDTO;
    }

    public void setPrivilegeDTO(PrivilegeDTO privilegeDTO) {
        this.privilegeDTO = privilegeDTO;
    }

    public String getPrivilegeID() {
        return privilegeID;
    }

    public void setPrivilegeID(String privilegeID) {
        this.privilegeID = privilegeID;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public StatusData getPrivilegeStatus() {
        return privilegeStatus;
    }

    public void setPrivilegeStatus(StatusData privilegeStatus) {
        this.privilegeStatus = privilegeStatus;
    }

    public ListModelList<StatusData> getListStatusPrivilege() {
        return new ListModelList<>(StatusData.values());
    }

    public void setListStatusPrivilege(ListModelList<StatusData> listStatusPrivilege) {
        this.listStatusPrivilege = listStatusPrivilege;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public ListModelList<String> getListCodeParent() {
        return listCodeParent;
    }

    public void setListCodeParent(ListModelList<String> listCodeParent) {
        this.listCodeParent = listCodeParent;
    }

}
