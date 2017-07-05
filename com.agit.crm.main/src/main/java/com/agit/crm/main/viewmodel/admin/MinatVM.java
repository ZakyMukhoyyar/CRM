package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.common.dto.crm.MinatDTOBuilder;
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
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author Zaky
 */
public class MinatVM {

    @WireVariable
    MinatService minatService;

    private MinatDTO minatDTO = new MinatDTO();
    private List<MinatDTO> minatDTOs = new ArrayList<>();

    /* Parameter Filter */
    private String idMinat;
    private String namaMinat;
    private Status status;

    private ListModelList<Status> listStatus;

    private PageNavigation previous;
    private int pageSize = 5;

    @Init
    public void init(
            @ExecutionArgParam("minatDTO") MinatDTO minat,
            @ExecutionArgParam("previous") PageNavigation previous) {
        initData();
        checkValidity(minat, previous);
    }

    private void initData() {
        minatDTOs = minatService.findAll();
        if (minatDTOs.isEmpty()) {
            minatDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(MinatDTO minat, PageNavigation previous) {
        if (minat == null) {
            ListModelList<MinatDTO> parameterList = new ListModelList<>(minatService.findAll());
            String idMinat = "";
            if (parameterList.isEmpty()) {
                idMinat = "1";
            } else {
                idMinat = getLatestObjectID(parameterList, "idMinat");
            }
            minatDTO = new MinatDTOBuilder()
                    .setIdMinat(idMinat)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createMinatDTO();
        } else {
            this.minatDTO = minat;
            idMinat = minatDTO.getIdMinat();
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

    @GlobalCommand
    @NotifyChange("minatDTOs")
    public void refreshMinat() {
        minatDTOs = minatService.findAll();
    }

    @Command("buttonNewMinat")
    @NotifyChange("minatDTO")
    public void buttonNewMinat(@BindingParam("object") MinatDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("minatDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/minat/add_minat.zul", window, params);
    }

    @Command("searchMinat")
    @NotifyChange("minatDTOs")
    public void searchMinat(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idMinat", idMinat);
        params.put("namaMinat", namaMinat);
        params.put("status", status);

        minatDTOs = minatService.findByParams(params);
    }

    @Command("detailMinat")
    @NotifyChange("minatDTO")
    public void detailMinat(@BindingParam("object") MinatDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("minatDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/minat/add_minat.zul", window, params);
    }

    @Command("buttonKembaliMinat")
    @NotifyChange("minatDTO")
    public void buttonKembaliMinat(@BindingParam("object") MinatDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveMinat")
    @NotifyChange({"minatDTO", "minatDTOs"})
    public void buttonSaveMinat(@BindingParam("object") MinatDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        minatService.SaveOrUpdate(minatDTO);
        showInformationMessagebox("Data Minat Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshMinat", null);
        window.detach();
    }

    /* getter setter */
    public MinatService getMinatService() {
        return minatService;
    }

    public void setMinatService(MinatService minatService) {
        this.minatService = minatService;
    }

    public MinatDTO getMinatDTO() {
        return minatDTO;
    }

    public void setMinatDTO(MinatDTO minatDTO) {
        this.minatDTO = minatDTO;
    }

    public List<MinatDTO> getMinatDTOs() {
        return minatDTOs;
    }

    public void setMinatDTOs(List<MinatDTO> minatDTOs) {
        this.minatDTOs = minatDTOs;
    }

    public String getIdMinat() {
        return idMinat;
    }

    public void setIdMinat(String idMinat) {
        this.idMinat = idMinat;
    }

    public String getNamaMinat() {
        return namaMinat;
    }

    public void setNamaMinat(String namaMinat) {
        this.namaMinat = namaMinat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ListModelList<Status> getListStatus() {
        return new ListModelList<>(Status.values());
    }

    public void setListStatus(ListModelList<Status> listStatus) {
        this.listStatus = listStatus;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
