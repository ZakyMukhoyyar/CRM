package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.KeterampilanService;
import com.agit.crm.common.dto.crm.KeterampilanDTO;
import com.agit.crm.common.dto.crm.KeterampilanDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import java.util.ArrayList;
import java.util.Collections;
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
public class KeterampilanVM {

    @WireVariable
    KeterampilanService keterampilanService;

    private KeterampilanDTO keterampilanDTO = new KeterampilanDTO();
    private List<KeterampilanDTO> keterampilanDTOs = new ArrayList<>();

    /* Parameter Filter */
    private String idKeterampilan;
    private String namaKeterampilan;
    private Boolean status;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 5;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    @Init
    public void init(
            @ExecutionArgParam("keterampilanDTO") KeterampilanDTO keterampilan,
            @ExecutionArgParam("previous") PageNavigation previous) {
        initData();
        checkValidity(keterampilan, previous);

    }

    private void initData() {
        keterampilanDTOs = keterampilanService.findAll();
        if (keterampilanDTOs.isEmpty()) {
            keterampilanDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(KeterampilanDTO keterampilan, PageNavigation previous) {
        if (keterampilan == null) {
            ListModelList<KeterampilanDTO> parameterList = new ListModelList<>(keterampilanService.findAll());
            String idKeterampilan = "";
            if (parameterList.isEmpty()) {
                idKeterampilan = "1";
            } else {
                idKeterampilan = getLatestObjectID(parameterList, "idKeterampilan");
            }
            keterampilanDTO = new KeterampilanDTOBuilder()
                    .setIdKeterampilan(idKeterampilan)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createKeterampilanDTO();
        } else {
            this.keterampilanDTO = keterampilan;
            idKeterampilan = keterampilanDTO.getIdKeterampilan();
            this.previous = previous;
        }
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

    @Command("buttonNewKeterampilan")
    @NotifyChange("keterampilanDTO")
    public void buttonNewKeterampilan(@BindingParam("object") KeterampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("keterampilanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/ketrampilan/add_ketrampilan.zul", window, params);
    }

    @Command("searchKeterampilan")
    @NotifyChange("keterampilanDTOs")
    public void searchKeterampilan(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idKeterampilan", idKeterampilan);
        params.put("namaKeterampilan", namaKeterampilan);
        params.put("status", status);

        keterampilanDTOs = keterampilanService.findByParams(params);
    }

    @Command("detailKeterampilan")
    @NotifyChange("keterampilan")
    public void detailKeterampilan(@BindingParam("object") KeterampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("keterampilanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/ketrampilan/add_ketrampilan.zul", window, params);
    }

    @Command("buttonKembaliKetrampilan")
    @NotifyChange("keterampilanDTO")
    public void buttonKembaliKetrampilan(@BindingParam("object") KeterampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveKeterampilan")
    @NotifyChange({"keterampilanDTO", "keterampilanDTOs"})
    public void buttonSaveKeterampilan(@BindingParam("object") KeterampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        keterampilanService.SaveOrUpdate(keterampilanDTO);
        showInformationMessagebox("Data Ketrampilan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshKeterampilan", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("keterampilanDTOs")
    public void refreshKeterampilan() {
        keterampilanDTOs = keterampilanService.findAll();
    }

    public List<KeterampilanDTO> getKeterampilanDTOs() {
        return keterampilanDTOs;
    }

    public void setKeterampilanDTOs(List<KeterampilanDTO> keterampilanDTOs) {
        this.keterampilanDTOs = keterampilanDTOs;
    }

    public String getIdKeterampilan() {
        return idKeterampilan;
    }

    public void setIdKeterampilan(String idKeterampilan) {
        this.idKeterampilan = idKeterampilan;
    }

    public String getNamaKeterampilan() {
        return namaKeterampilan;
    }

    public void setNamaKeterampilan(String namaKeterampilan) {
        this.namaKeterampilan = namaKeterampilan;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public KeterampilanDTO getKeterampilanDTO() {
        return keterampilanDTO;
    }

    public void setKeterampilanDTO(KeterampilanDTO keterampilanDTO) {
        this.keterampilanDTO = keterampilanDTO;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

}
