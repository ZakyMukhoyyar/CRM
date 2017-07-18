package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.common.dto.crm.KetrampilanDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
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
public class KetrampilanVM {

    @WireVariable
    KetrampilanService ketrampilanService;

    private KetrampilanDTO ketrampilanDTO = new KetrampilanDTO();
    private List<KetrampilanDTO> ketrampilanDTOs = new ArrayList<>();

    /* Parameter Filter */
    private String idKetrampilan;
    private String namaKetrampilan;
    private Status status;
    
    private ListModelList<Status> statuses;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 15;

    @Init
    public void init(
            @ExecutionArgParam("ketrampilanDTO") KetrampilanDTO ketrampilan,
            @ExecutionArgParam("previous") PageNavigation previous) {
        
        /* Load Data */
        initData();
        
        /* Check Validity */
        checkValidity(ketrampilan, previous);
        
    }

    private void initData() {
        ketrampilanDTOs = ketrampilanService.findAll();
        if (ketrampilanDTOs.isEmpty()) {
            ketrampilanDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(KetrampilanDTO ketrampilan, PageNavigation previous) {
        if (ketrampilan == null) {
            ListModelList<KetrampilanDTO> parameterList = new ListModelList<>(ketrampilanService.findAll());
            String idKetrampilan = "";
            if (parameterList.isEmpty()) {
                idKetrampilan = "1";
            } else {
                idKetrampilan = getLatestObjectID(parameterList, "idKetrampilan");
            }
            ketrampilanDTO = new KetrampilanDTOBuilder()
                    .setIdKetrampilan(idKetrampilan)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createKetrampilanDTO();
        } else {
            this.ketrampilanDTO = ketrampilan;
            idKetrampilan = ketrampilanDTO.getIdKetrampilan();
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

    @Command("buttonNewKetrampilan")
    @NotifyChange("ketrampilanDTO")
    public void buttonNewKetrampilan(@BindingParam("object") KetrampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("ketrampilanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/ketrampilan/add_ketrampilan.zul", window, params);
    }

    @Command("buttonSearchKetrampilan")
    @NotifyChange("ketrampilanDTOs")
    public void buttonSearchKetrampilan(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idKetrampilan", idKetrampilan);
        params.put("namaKetrampilan", namaKetrampilan);
        params.put("status", status);

        ketrampilanDTOs = ketrampilanService.findByParams(params);
    }

    @Command("detailKetrampilan")
    @NotifyChange("ketrampilan")
    public void detailKetrampilan(@BindingParam("object") KetrampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("ketrampilanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/ketrampilan/add_ketrampilan.zul", window, params);
    }

    @Command("buttonKembaliKetrampilan")
    @NotifyChange("ketrampilanDTO")
    public void buttonKembaliKetrampilan(@BindingParam("object") KetrampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveKetrampilan")
    @NotifyChange({"ketrampilanDTO", "ketrampilanDTOs"})
    public void buttonSaveKetrampilan(@BindingParam("object") KetrampilanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        ketrampilanService.SaveOrUpdate(ketrampilanDTO);
        showInformationMessagebox("Data Ketrampilan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshKetrampilan", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("ketrampilanDTOs")
    public void refreshKetrampilan() {
        ketrampilanDTOs = ketrampilanService.findAll();
    }

    public List<KetrampilanDTO> getKetrampilanDTOs() {
        return ketrampilanDTOs;
    }

    public void setKetrampilanDTOs(List<KetrampilanDTO> ketrampilanDTOs) {
        this.ketrampilanDTOs = ketrampilanDTOs;
    }

    public String getIdKetrampilan() {
        return idKetrampilan;
    }

    public void setIdKetrampilan(String idKetrampilan) {
        this.idKetrampilan = idKetrampilan;
    }

    public String getNamaKetrampilan() {
        return namaKetrampilan;
    }

    public void setNamaKetrampilan(String namaKetrampilan) {
        this.namaKetrampilan = namaKetrampilan;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public KetrampilanDTO getKetrampilanDTO() {
        return ketrampilanDTO;
    }

    public void setKetrampilanDTO(KetrampilanDTO ketrampilanDTO) {
        this.ketrampilanDTO = ketrampilanDTO;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }
}
