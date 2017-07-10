package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.common.dto.crm.JurusanDTOBuilder;
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
 * @author Zaky
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class JurusanVM {

    @WireVariable
    JurusanService jurusanService;

    /* Object Binding UI*/
    private JurusanDTO jurusanDTO = new JurusanDTO();
    private List<JurusanDTO> jurusanDTOs = new ArrayList<>();

    /* parameter variable */
    private String idJurusan;
    private String namaJurusan;

    /* attribut for UI */
    private PageNavigation previous;

    @Init
    public void init(
            @ExecutionArgParam("jurusanDTO") JurusanDTO jurusan,
            @ExecutionArgParam("previous") PageNavigation previous
    ) {

        /* Load Data */
        initData();
        
        /* Check Validity */
        checkValidity(jurusan, previous);
    }

    private void initData() {
        jurusanDTOs = jurusanService.findAll();
        if (jurusanDTOs.isEmpty()) {
            jurusanDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(JurusanDTO jurusan, PageNavigation previous) {
        if (jurusan == null) {
            ListModelList<JurusanDTO> parameterList = new ListModelList<>(jurusanService.findAll());
            String idJurusan = "";
            if (parameterList.isEmpty()) {
                idJurusan = "Jur01";
            } else {
                idJurusan = getLatestObjectID(parameterList, "idJurusan");
            }
            jurusanDTO = new JurusanDTOBuilder()
                    .setIdJurusan(idJurusan)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createJurusanDTO();
        } else {
            this.jurusanDTO = jurusan;
            idJurusan = jurusanDTO.getIdJurusan();
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
    @NotifyChange("jurusanDTOs")
    public void refreshJurusan() {
        jurusanDTOs = jurusanService.findAll();
    }
    
    @Command("buttonSearchJurusan")
    @NotifyChange("jurusanDTOs")
    public void buttonSearchJurusan(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idJurusan", idJurusan);
        params.put("namaJurusan", namaJurusan);

        jurusanDTOs = jurusanService.findByParams(params);
    }
    
    @Command("buttonNewJurusan")
    @NotifyChange("jurusanDTO")
    public void buttonNewJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("jurusanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/jurusan/add_jurusan.zul", window, params);
    }
    
    @Command("detailJurusan")
    @NotifyChange("jurusanDTO")
    public void detailJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("jurusanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/jurusan/add_jurusan.zul", window, params);
    }

    @Command("buttonKembaliJurusan")
    @NotifyChange({"jurusanDTO", "jurusanDTOs"})
    public void buttonKembaliJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveJurusan")
    @NotifyChange("jurusanDTO")
    public void buttonSaveJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        jurusanService.SaveOrUpdate(jurusanDTO);
        showInformationMessagebox("Data Jurusan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshJurusan", null);
        window.detach();
    }

    /* getter setter */
    public JurusanDTO getJurusanDTO() {
        return jurusanDTO;
    }

    public void setJurusanDTO(JurusanDTO jurusanDTO) {
        this.jurusanDTO = jurusanDTO;
    }

    public List<JurusanDTO> getJurusanDTOs() {
        return jurusanDTOs;
    }

    public void setJurusanDTOs(List<JurusanDTO> jurusanDTOs) {
        this.jurusanDTOs = jurusanDTOs;
    }

    public String getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }
    
    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

}
