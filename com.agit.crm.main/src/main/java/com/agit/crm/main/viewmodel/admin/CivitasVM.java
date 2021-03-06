package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.crm.CivitasDTOBuilder;
import com.agit.crm.common.dto.crm.CivitasSecondary;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.infrastructure.component.xls.XlsReader;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import com.agit.crm.util.StringUtil;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author 3AD
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CivitasVM {

    @WireVariable
    CivitasService civitasService;

//    private static final String FILE_LOC = "E:\\PEKERJAAN\\Agit\\Project\\Project2\\CRM\\template-mapping\\insert-template-civitas.xlsx";
    private FileItem file;

    private CivitasDTO civitasDTO = new CivitasDTO();
    private List<CivitasDTO> civitasDTOs = new ArrayList<>();

    private ListModelList<Status> statuses = new ListModelList<>();

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 9;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    Media mediaCivitas;
    String mediaNameCivitas;
    private String filepathCivitas;
    private String pathLocationCivitas;

    private String civitasID;
    private String namaCivitas;
    private Status status;

    @Init
    public void init(
            @ExecutionArgParam("civitasDTO") CivitasDTO civitas,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();
        checkValidity(civitas, previous);

    }

    private void initData() {
        civitasDTOs = civitasService.findAll();
        if (civitasDTOs.isEmpty()) {
            civitasDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(CivitasDTO civitas, PageNavigation previous) {
        if (civitas == null) {
            ListModelList<CivitasDTO> parameterList = new ListModelList<>(civitasService.findAll());
            String civitasID = "";
            if (parameterList.isEmpty()) {
                civitasID = "C1";
            } else {
                civitasID = getLatestObjectID(parameterList, "civitasID");
            }
            civitasDTO = new CivitasDTOBuilder()
                    .setCivitasID(civitasID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createCivitasDTO();
        } else {
            this.civitasDTO = civitas;
            civitasID = civitasDTO.getCivitasID();
            this.previous = previous;
        }
    }

    @GlobalCommand
    @NotifyChange("civitasDTOs")
    public void refreshData() {
        civitasDTOs = civitasService.findAll();
    }

    @Command("buttonUploadFile")
    @NotifyChange({"mediaNameCivitas", "pathLocationCivitas"})
    public void buttonUploadFile(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaCivitas = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filepathCivitas = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filepathCivitas = filepathCivitas + "\\" + "files" + "\\" + "crm-xls" + "\\" + year + "\\" + month + "\\" + day + "\\";

//            filepathCivitas = FILE_LOC;
            File baseDir = new File(filepathCivitas);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            if (mediaCivitas.getFormat().matches("xlsx")) {
                Files.copy(new File(filepathCivitas + mediaCivitas.getName()), mediaCivitas.getStreamData());
                setMediaNameCivitas(mediaCivitas.getName());
                pathLocationCivitas = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaCivitas.getName();
            } else if (mediaCivitas.getFormat().matches("xls")) {
                Files.copy(new File(filepathCivitas + mediaCivitas.getName()), mediaCivitas.getStreamData());
                setMediaNameCivitas(mediaCivitas.getName());
                pathLocationCivitas = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaCivitas.getName();
            } else {
                Messagebox.show("Format Harus Sesuai Template", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    @Command("deleteCivitas")
    @NotifyChange("civitasDTOs")
    public void deleteCivitas(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        civitasDTO = (CivitasDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Civitas?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    civitasService.deleteData(civitasDTO);
                    showInformationMessagebox("Civitas Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshData", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    @Command("buttonSearchCivitas")
    @NotifyChange("civitasDTOs")
    public void buttonSearchCivitas(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;

        Map params = new HashMap();
        params.put("namaCivitas", namaCivitas);
        count = checkCountParameter(count, namaCivitas);
        params.put("status", status);
        count = checkCountParameter(count, status);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        civitasDTOs = civitasService.findByParams(params);
    }

    @Command("buttonNewCivitas")
    @NotifyChange("civitasDTO")
    public void buttonNewCivitas(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("civitasDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/civitas/add_civitas.zul", window, params);
    }

    @Command("buttonKembaliCivitas")
    @NotifyChange({"civitasDTO", "civitasDTOs"})
    public void buttonKembaliCivitas(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
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

    @Command("buttonSaveCivitas")
    @NotifyChange("civitasDTO")
    public void buttonSaveCivitas(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        civitasService.SaveOrUpdate(civitasDTO);
        showInformationMessagebox("Data Civitas Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @Command("buttonSaveDataCivitas")
    @NotifyChange({"civitasDTO", "civitasDTOs"})
    public void buttonSaveDataCivitas(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {

        if (mediaNameCivitas == null) {
            Messagebox.show("Silakan Pilih File yang akan diupload!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        XlsReader<CivitasSecondary> jxr = new XlsReader<>(CivitasSecondary.class);
        List<CivitasSecondary> ls = jxr.getJavaObjectFromThisFile(filepathCivitas + mediaNameCivitas);
        for (CivitasSecondary s : ls) {
            Status status = null;

            if ("ACTIVE".equals(s.getStatus())) {
                status = Status.ACTIVE;
            } else {
                status = Status.INACTIVE;
            }
            CivitasDTO m = new CivitasDTOBuilder()
                    .setCivitasID(s.getNo())
                    .setNamaCivitas(s.getNamaCivitas())
                    .setStatus(status)
                    .setCreatedBy("SYSTEM")
                    .setCreatedDate(new Date())
                    .setModifiedBy("SYSTEM")
                    .setModifiedDate(new Date())
                    .createCivitasDTO();
            try {
                civitasService.SaveOrUpdate(m);
                System.out.println("Row " + s.getNo() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getNo() + " FAILED");
            }
        }
        showInformationMessagebox("Data History Berhasil Diupload");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
    }

    @Command("detailCivitas")
    @NotifyChange("civitas")
    public void detailEventAgit(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("civitasDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/civitas/add_civitas.zul", window, params);
    }


    /* getter setter */
    public CivitasDTO getCivitasDTO() {
        return civitasDTO;
    }

    public void setCivitasDTO(CivitasDTO civitasDTO) {
        this.civitasDTO = civitasDTO;
    }

    public List<CivitasDTO> getCivitasDTOs() {
        return civitasDTOs;
    }

    public void setCivitasDTOs(List<CivitasDTO> civitasDTOs) {
        this.civitasDTOs = civitasDTOs;
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

    public Media getMediaCivitas() {
        return mediaCivitas;
    }

    public void setMediaCivitas(Media mediaCivitas) {
        this.mediaCivitas = mediaCivitas;
    }

    public String getMediaNameCivitas() {
        return mediaNameCivitas;
    }

    public void setMediaNameCivitas(String mediaNameCivitas) {
        this.mediaNameCivitas = mediaNameCivitas;
    }

    public String getFilepathCivitas() {
        return filepathCivitas;
    }

    public void setFilepathCivitas(String filepathCivitas) {
        this.filepathCivitas = filepathCivitas;
    }

    public String getPathLocationCivitas() {
        return pathLocationCivitas;
    }

    public void setPathLocationCivitas(String pathLocationCivitas) {
        this.pathLocationCivitas = pathLocationCivitas;
    }

    public String getNamaCivitas() {
        return namaCivitas;
    }

    public void setNamaCivitas(String namaCivitas) {
        this.namaCivitas = namaCivitas;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCivitasID() {
        return civitasID;
    }

    public void setCivitasID(String civitasID) {
        this.civitasID = civitasID;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

}
