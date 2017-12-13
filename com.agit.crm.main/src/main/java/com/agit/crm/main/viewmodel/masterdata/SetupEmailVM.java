package com.agit.crm.main.viewmodel.masterdata;

import com.agit.crm.common.application.masterdata.SetupEmailService;
import com.agit.crm.common.dto.masterdata.SetupEmailDTO;
import com.agit.crm.common.dto.masterdata.SetupEmailDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
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
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author TriAA
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SetupEmailVM {

    @WireVariable
    SetupEmailService setupEmailService;

    private SetupEmailDTO setupEmailDTO = new SetupEmailDTO();
    private List<SetupEmailDTO> setupEmailDTOs = new ArrayList<>();

    private String idEmail;
    private String subject;
    private String templateTitle;

    private PageNavigation previous;
    private int pageSize = 9;

    @Init
    public void init(
            @ExecutionArgParam("setupEmailDTO") SetupEmailDTO setupEmail,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(setupEmail, previous);

    }

    private void initData() {
        setupEmailDTOs = setupEmailService.findAll();
    }

    private void checkValidity(SetupEmailDTO setupEmail, PageNavigation previous) {
        if (setupEmail == null) {
            ListModelList<SetupEmailDTO> parameterList = new ListModelList<>(setupEmailService.findAll());
            String idEmail = "";
            if (parameterList.isEmpty()) {
                idEmail = "E001";
            } else {
                idEmail = getLatestObjectID(parameterList, "idEmail");
            }
            setupEmailDTO = new SetupEmailDTOBuilder()
                    .setIdEmail(idEmail)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createSetupEmailDTO();
        } else {
            this.setupEmailDTO = setupEmail;
            idEmail = setupEmailDTO.getIdEmail();
            subject = setupEmailDTO.getSubject();
            templateTitle = setupEmailDTO.getTemplateTitle();
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

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    @GlobalCommand
    @NotifyChange("setupEmailDTOs")
    public void refreshEmail() {
        setupEmailDTOs = setupEmailService.findAll();
    }

    @Command("buttonNewEmail")
    @NotifyChange("setupEmailDTO")
    public void buttonNewEmail(@BindingParam("object") SetupEmailDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("setupEmailDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/setupEmail/add_email.zul", window, params);
    }

    @Command("deleteEmail")
    @NotifyChange("setupEmailDTOs")
    public void deleteEmail(@BindingParam("object") SetupEmailDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        setupEmailDTO = (SetupEmailDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Ketrampilan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    setupEmailService.delete(setupEmailDTO);
                    CommonViewModel.showInformationMessagebox("Email Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshEmail", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    @Command("buttonSearchEmail")
    @NotifyChange("setupEmailDTOs")
    public void buttonSearchEmail(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idEmail", idEmail);
        params.put("subject", subject);
        params.put("templateTitle", templateTitle);

        setupEmailDTOs = setupEmailService.findByParams(params);
    }

    @Command("detailEmail")
    @NotifyChange("setupEmail")
    public void detailEmail(@BindingParam("object") SetupEmailDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("setupEmailDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/setupEmail/add_email.zul", window, params);
    }

    @Command("buttonKembaliEmail")
    @NotifyChange("setupEmailDTO")
    public void buttonKembaliEmail(@BindingParam("object") SetupEmailDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveEmail")
    @NotifyChange({"setupEmailDTO", "setupEmailDTOs"})
    public void buttonSaveEmail(@BindingParam("object") SetupEmailDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        setupEmailService.saveOrUpdate(setupEmailDTO);
        showInformationMessagebox("Data Ketrampilan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshEmail", null);
        window.detach();
    }

    public SetupEmailDTO getSetupEmailDTO() {
        return setupEmailDTO;
    }

    public void setSetupEmailDTO(SetupEmailDTO setupEmailDTO) {
        this.setupEmailDTO = setupEmailDTO;
    }

    public List<SetupEmailDTO> getSetupEmailDTOs() {
        return setupEmailDTOs;
    }

    public void setSetupEmailDTOs(List<SetupEmailDTO> setupEmailDTOs) {
        this.setupEmailDTOs = setupEmailDTOs;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }

}
