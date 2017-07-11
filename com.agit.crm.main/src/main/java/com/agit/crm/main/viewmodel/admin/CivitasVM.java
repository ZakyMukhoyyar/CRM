package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.crm.CivitasDTOBuilder;
import com.agit.crm.common.dto.crm.CivitasSecondary;
import com.agit.crm.infrastructure.component.xls.XlsReader;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
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

    private static final String ABS_FILE_LOC = "E:\\PEKERJAAN\\Agit\\Project\\Project2\\CRM\\template-mapping\\insert-template-civitas.xlsx";

    private CivitasDTO civitasDTO = new CivitasDTO();
    private List<CivitasDTO> civitasDTOs = new ArrayList<>();

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 15;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    Media mediaCivitas;
    String mediaNameCivitas;
    private String filepathCivitas;
    private String pathLocationCivitas;

    private String namaCivitas;
    private String status;
    private String civitasID;

    @Init
    public void init(
            @ExecutionArgParam("civitasDTO") CivitasDTO civitas,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();
        checkValidity(civitas, previous);

    }

    private void initData() {
        civitasDTOs = civitasService.findAll();
    }

    private void checkValidity(CivitasDTO civitas, PageNavigation previous) {
        if (civitas == null) {
            civitasDTO = new CivitasDTOBuilder()
                    .setCreatedBy("System")
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

    @Command("buttonSaveDataCivitas")
    @NotifyChange({"civitasDTO", "civitasDTOs"})
    public void buttonSaveDataCivitas(@BindingParam("object") CivitasDTO obj, @ContextParam(ContextType.VIEW) Window window) throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {

        if (mediaNameCivitas == null) {
            Messagebox.show("Silakan Pilih File yang akan diupload!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        XlsReader<CivitasSecondary> jxr = new XlsReader<>(CivitasSecondary.class);
        List<CivitasSecondary> ls = jxr.getJavaObjectFromThisFile(filepathCivitas);
        for (CivitasSecondary s : ls) {
            CivitasDTO m = new CivitasDTOBuilder()
                    .setCivitasID(s.getNo())
                    .setNamaCivitas(s.getNamaCivitas())
                    .setStatus(s.getStatus())
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

    @Command("uploadFile")
    @NotifyChange({"mediaNameCivitas", "pathLocationCivitas"})
    public void uploadFile(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
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
//            filepath = filepath + "\\" + "files" + "\\" + "rkap" + "\\" + year + "\\" + month + "\\" + day + "\\" + media.getName();

            filepathCivitas = "E:\\PEKERJAAN\\Agit\\Project\\Project2\\CRM\\template-mapping\\insert-template-civitas.xlsx";
            File baseDir = new File(filepathCivitas);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            Files.copy(new File(filepathCivitas + mediaCivitas.getName()), mediaCivitas.getStreamData());
            setMediaNameCivitas(mediaCivitas.getName());
            pathLocationCivitas = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaCivitas.getName();
        }
    }

    @Command("buttonPencarian")
    @NotifyChange("civitasDTOs")
    public void buttonPencarian(@ContextParam(ContextType.VIEW) Window window) {

        Map params = new HashMap();
        params.put("namaCivitas", namaCivitas);
        params.put("status", status);

        civitasDTOs = civitasService.findByParams(params);
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCivitasID() {
        return civitasID;
    }

    public void setCivitasID(String civitasID) {
        this.civitasID = civitasID;
    }

}
