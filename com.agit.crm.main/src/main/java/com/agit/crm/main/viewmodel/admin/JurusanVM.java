package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.common.dto.crm.JurusanDTOBuilder;
import com.agit.crm.common.dto.crm.JurusanSecondary;
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
 * @author Zaky
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class JurusanVM {

    @WireVariable
    JurusanService jurusanService;

    /* Object Binding UI*/
    private JurusanDTO jurusanDTO = new JurusanDTO();
    private List<JurusanDTO> jurusanDTOs = new ArrayList<>();
    private ListModelList<Status> statuses = new ListModelList<>();

    /* parameter variable */
    private String idJurusan;
    private String namaJurusan;

    /* attribut for UI */
    private PageNavigation previous;
    private int pageSize = 9;

    /* attribut for File Upload */
    Media mediaJurusan;
    String mediaNameJurusan;
    private String filePathJurusan;
    private String pathLocationJurusan;

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

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    @Command("buttonSearchJurusan")
    @NotifyChange("jurusanDTOs")
    public void buttonSearchJurusan(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;

        Map params = new HashMap();
        params.put("idJurusan", idJurusan);
        count = checkCountParameter(count, idJurusan);
        params.put("namaJurusan", namaJurusan);
        count = checkCountParameter(count, namaJurusan);
        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
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

    @Command("deleteJurusan")
    @NotifyChange("jurusanDTOs")
    public void deleteJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        jurusanDTO = (JurusanDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Jurusan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    jurusanService.deleteData(jurusanDTO);
                    showInformationMessagebox("Jurusan Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshJurusan", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    @Command("buttonKembaliJurusan")
    @NotifyChange({"jurusanDTO", "jurusanDTOs"})
    public void buttonKembaliJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveDataJurusan")
    @NotifyChange({"jurusanDTO", "jurusanDTOs"})
    public void buttonSaveDataJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {

        if (mediaNameJurusan == null) {
            Messagebox.show("Silakan Pilih File yang akan diupload!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        XlsReader<JurusanSecondary> jxr = new XlsReader<>(JurusanSecondary.class);
        List<JurusanSecondary> ls = jxr.getJavaObjectFromThisFile(filePathJurusan + mediaNameJurusan);
        for (JurusanSecondary s : ls) {
            Status status = null;

            if ("ACTIVE".equals(s.getStatus())) {
                status = Status.ACTIVE;
            } else {
                status = Status.INACTIVE;
            }
            JurusanDTO m = new JurusanDTOBuilder()
                    .setIdJurusan(s.getIdJurusan())
                    .setNamaJurusan(s.getNamaJurusan())
                    .setStatus(status)
                    .setCreatedBy("SYSTEM")
                    .setCreatedDate(new Date())
                    .setModifiedBy("SYSTEM")
                    .setModifiedDate(new Date())
                    .createJurusanDTO();
            try {
                jurusanService.SaveOrUpdate(m);
                System.out.println("Row " + s.getIdJurusan() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getIdJurusan() + " FAILED");
            }
        }
        showInformationMessagebox("Data History Berhasil Diupload");
        BindUtils.postGlobalCommand(null, null, "refreshJurusan", null);

    }

    @Command("buttonUploadFile")
    @NotifyChange({"mediaNameJurusan", "pathLocationJurusan"})
    public void buttonUploadFile(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaJurusan = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePathJurusan = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filePathJurusan = filePathJurusan + "\\" + "files" + "\\" + "crm-xls" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filePathJurusan);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            if (mediaJurusan.getFormat().matches("xlsx") || mediaJurusan.getFormat().matches("xls")) {
                Files.copy(new File(filePathJurusan + mediaJurusan.getName()), mediaJurusan.getStreamData());
                setMediaNameJurusan(mediaJurusan.getName());
                pathLocationJurusan = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaJurusan.getName();
            } else {
                Messagebox.show("Format Harus Sesuai Template", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

    @Command("buttonSaveJurusan")
    @NotifyChange("jurusanDTO")
    public void buttonSaveJurusan(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        jurusanService.SaveOrUpdate(jurusanDTO);
        showInformationMessagebox("Data Jurusan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshJurusan", null);
        window.detach();
    }

    @Command("detailEventAgit")
    @NotifyChange("jurusan")
    public void detailEventAgit(@BindingParam("object") JurusanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("jurusanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/jurusan/add_jurusan.zul", window, params);
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

    public Media getMediaJurusan() {
        return mediaJurusan;
    }

    public void setMediaJurusan(Media mediaJurusan) {
        this.mediaJurusan = mediaJurusan;
    }

    public String getMediaNameJurusan() {
        return mediaNameJurusan;
    }

    public void setMediaNameJurusan(String mediaNameJurusan) {
        this.mediaNameJurusan = mediaNameJurusan;
    }

    public String getFilePathJurusan() {
        return filePathJurusan;
    }

    public void setFilePathJurusan(String filePathJurusan) {
        this.filePathJurusan = filePathJurusan;
    }

    public String getPathLocationJurusan() {
        return pathLocationJurusan;
    }

    public void setPathLocationJurusan(String pathLocationJurusan) {
        this.pathLocationJurusan = pathLocationJurusan;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

}
