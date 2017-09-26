package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.DomisiliService;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.common.dto.crm.DomisiliDTOBuilder;
import com.agit.crm.common.dto.crm.DomisiliSecondary;
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
 * @author Bayu Hendra Setiawan
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DomisiliVM {

    @WireVariable
    DomisiliService domisiliService;

    /* Object Binding UI CRM */
    private DomisiliDTO domisiliDTO = new DomisiliDTO();
    private List<DomisiliDTO> domisiliDTOs = new ArrayList<>();
    private ListModelList<Status> statuses = new ListModelList<>();

    private String idDomisili;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKota;

//    private static final String FILE_LOC = "D:\\Work\\AgitCRM\\CRM\\template-mapping\\insert-template-domisili.xlsx";

    /* attribut for CRM */
    private PageNavigation previous;
    private int pageSize = 9;

    /* attribut for upload file Event */
    Media mediaUploadDomisili;
    String mediaNameUploadDomisili;
    private String filepathUploadDomisili;
    private String pathLocationUploadDomisili;

    @Init
    public void init(
            @ExecutionArgParam("domisiliDTO") DomisiliDTO domisili,
            @ExecutionArgParam("previous") PageNavigation previous
    ) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(domisili, previous);
    }

    private void initData() {
        domisiliDTOs = domisiliService.findAll();
        if (domisiliDTOs.isEmpty()) {
            domisiliDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(DomisiliDTO domisili, PageNavigation previous) {
        if (domisili == null) {
            ListModelList<DomisiliDTO> parameterList = new ListModelList<>(domisiliService.findAll());
            String idDomisili = "";
            if (parameterList.isEmpty()) {
                idDomisili = "1";
            } else {
                idDomisili = getLatestObjectID(parameterList, "idDomisili");
            }
            domisiliDTO = new DomisiliDTOBuilder()
                    .setIdDomisili(idDomisili)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createDomisiliDTO();
        } else {
            this.domisiliDTO = domisili;
            idDomisili = domisiliDTO.getIdDomisili();
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

    @Command("deleteDomisili")
    @NotifyChange("domisiliDTOs")
    public void deleteDomisili(@BindingParam("object") DomisiliDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        domisiliDTO = (DomisiliDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Domisili?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    domisiliService.deleteData(domisiliDTO);
                    showInformationMessagebox("Domisili Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshDomisili", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    @Command("buttonTambahDomisili")
    @NotifyChange("domisiliDTO")
    public void buttonNewDomisili(@BindingParam("object") DomisiliDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("domisiliDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/domisili/add_domisili.zul", window, params);
    }

    @Command("buttonSaveDataDomisili")
    @NotifyChange({"domisiliDTOs", "domisiliDTO"})
    public void buttonSaveDataDomisili(@BindingParam("object") DomisiliDTO obj, @ContextParam(ContextType.VIEW) Window window) throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        if (mediaNameUploadDomisili == null) {
            Messagebox.show("Silakan Pilih File yang akan diupload!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        XlsReader<DomisiliSecondary> jxr = new XlsReader<>(DomisiliSecondary.class);
        List<DomisiliSecondary> ls = jxr.getJavaObjectFromThisFile(filepathUploadDomisili + mediaNameUploadDomisili);
        for (DomisiliSecondary s : ls) {

            Status status = null;

            if ("ACTIVE".equals(s.getStatus())) {
                status = Status.ACTIVE;
            } else {
                status = Status.INACTIVE;
            }
            DomisiliDTO m = new DomisiliDTOBuilder()
                    .setIdDomisili(s.getIdDomisili())
                    .setNamaProvinsi(s.getNamaProvinsi())
                    .setNamaKabupaten(s.getNamaKabupaten())
                    .setNamaKota(s.getNamaKota())
                    .setStatus(status)
                    .setCreatedBy("SYSTEM")
                    .setCreatedDate(new Date())
                    .setModifiedBy("SYSTEM")
                    .setModifiedDate(new Date())
                    .createDomisiliDTO();
            try {
                domisiliService.SaveOrUpdate(m);
                System.out.println("Row " + s.getIdDomisili() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getIdDomisili() + " FAILED");
            }
        }
        showInformationMessagebox("Data Domisili Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDomisili", null);
    }

    @Command("buttonSaveDomisili")
    @NotifyChange("domisiliDTO")
    public void buttonSaveDomisili(@BindingParam("object") DomisiliDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        domisiliService.SaveOrUpdate(domisiliDTO);
        showInformationMessagebox("Data Domisili Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDomisili", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("domisiliDTOs")
    public void refreshDomisili() {
        domisiliDTOs = domisiliService.findAll();
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    @Command("buttonSearchDomisili")
    @NotifyChange("domisiliDTOs")
    public void buttonSearchJurusan(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;

        Map params = new HashMap();
        params.put("idDomisili", idDomisili);
        count = checkCountParameter(count, idDomisili);
        params.put("namaKabupaten", namaKabupaten);
        count = checkCountParameter(count, namaKabupaten);
        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        domisiliDTOs = domisiliService.findByParams(params);
    }

    @Command("buttonUploadFile")
    @NotifyChange({"mediaNameUploadDomisili", "pathLocationUploadDomisili"})
    public void buttonUploadFile(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaUploadDomisili = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filepathUploadDomisili = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filepathUploadDomisili = filepathUploadDomisili + "\\" + "files" + "\\" + "crm-xls" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filepathUploadDomisili);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            if (mediaUploadDomisili.getFormat().matches("xlsx") || mediaUploadDomisili.getFormat().matches("xls")) {
                Files.copy(new File(filepathUploadDomisili + mediaUploadDomisili.getName()), mediaUploadDomisili.getStreamData());
                setMediaNameUploadDomisili(mediaUploadDomisili.getName());
                pathLocationUploadDomisili = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadDomisili.getName();
            } else {
                Messagebox.show("Format Harus Sesuai Template", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

    @Command("buttonKembaliDomisili")
    @NotifyChange({"domisiliDTO", "domisiliDTOs"})
    public void buttonKembaliDomisili(@BindingParam("object") DomisiliDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("detailDomisili")
    @NotifyChange("domisiliDTO")
    public void detailDomisili(@BindingParam("object") DomisiliDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("domisiliDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/domisili/add_domisili.zul", window, params);
    }

    public DomisiliService getDomisiliService() {
        return domisiliService;
    }

    public void setDomisiliService(DomisiliService domisiliService) {
        this.domisiliService = domisiliService;
    }

    public DomisiliDTO getDomisiliDTO() {
        return domisiliDTO;
    }

    public void setDomisiliDTO(DomisiliDTO domisiliDTO) {
        this.domisiliDTO = domisiliDTO;
    }

    public List<DomisiliDTO> getDomisiliDTOs() {
        return domisiliDTOs;
    }

    public void setDomisiliDTOs(List<DomisiliDTO> domisiliDTOs) {
        this.domisiliDTOs = domisiliDTOs;
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

    public Media getMediaUploadDomisili() {
        return mediaUploadDomisili;
    }

    public void setMediaUploadDomisili(Media mediaUploadDomisili) {
        this.mediaUploadDomisili = mediaUploadDomisili;
    }

    public String getMediaNameUploadDomisili() {
        return mediaNameUploadDomisili;
    }

    public void setMediaNameUploadDomisili(String mediaNameUploadDomisili) {
        this.mediaNameUploadDomisili = mediaNameUploadDomisili;
    }

    public String getFilepathUploadDomisili() {
        return filepathUploadDomisili;
    }

    public void setFilepathUploadDomisili(String filepathUploadDomisili) {
        this.filepathUploadDomisili = filepathUploadDomisili;
    }

    public String getPathLocationUploadDomisili() {
        return pathLocationUploadDomisili;
    }

    public void setPathLocationUploadDomisili(String pathLocationUploadDomisili) {
        this.pathLocationUploadDomisili = pathLocationUploadDomisili;
    }

    public String getIdDomisili() {
        return idDomisili;
    }

    public void setIdDomisili(String idDomisili) {
        this.idDomisili = idDomisili;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

}
