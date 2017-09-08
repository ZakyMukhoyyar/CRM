package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.common.dto.crm.EventAgitDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import com.agit.crm.util.StringUtil;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalDate;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author 3AD
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class EventAgitVM {

    @WireVariable
    EventAgitService eventAgitService;

    /* Object Binding UI CRM */
    private EventAgitDTO eventAgitDTO = new EventAgitDTO();
    private List<EventAgitDTO> eventAgitDTOs = new ArrayList<>();

    private String idEvent;
    private String namaEvent;
    private Date endDate;
    private Status status;

    private ListModelList<Status> statuses;

    /* attribut for CRM */
    private PageNavigation previous;
    private int pageSize = 8;

    /* attribut for upload file Event */
    Media mediaUploadEventAgit;
    String mediaNameUploadEventAgit;
    private String filepathUploadEventAgit;
    private String pathLocationUploadEventAgit;

    @Init
    public void init(
            @ExecutionArgParam("eventAgitDTO") EventAgitDTO eventAgit,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(eventAgit, previous);
    }

    private void initData() {

        eventAgitDTOs = eventAgitService.findAll();
        if (eventAgitDTOs.isEmpty()) {
            eventAgitDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(EventAgitDTO eventAgit, PageNavigation previous) {
        if (eventAgit == null) {
            ListModelList<EventAgitDTO> parameterList = new ListModelList<>(eventAgitService.findAll());
            String idEvent = "";
            if (parameterList.isEmpty()) {
                idEvent = "EVT01";
            } else {
                idEvent = getLatestObjectID(parameterList, "idEvent");
            }
            eventAgitDTO = new EventAgitDTOBuilder()
                    .setIdEvent(idEvent)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createEventAgitDTO();
        } else {
            this.eventAgitDTO = eventAgit;
            idEvent = eventAgitDTO.getIdEvent();
            mediaNameUploadEventAgit = eventAgitDTO.getAttachment();
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

    @Command("buttonUploadEventAgit")
    @NotifyChange({"mediaNameUploadEventAgit", "pathLocationUploadEventAgit"})
    public void buttonUploadEventAgit(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaUploadEventAgit = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filepathUploadEventAgit = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filepathUploadEventAgit = filepathUploadEventAgit + "\\" + "files" + "\\" + "crm-event" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filepathUploadEventAgit);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            Files.copy(new File(filepathUploadEventAgit + mediaUploadEventAgit.getName()), mediaUploadEventAgit.getStreamData());
            setMediaNameUploadEventAgit(filepathUploadEventAgit + mediaUploadEventAgit.getName());
            pathLocationUploadEventAgit = "/" + "files" + "/" + "crm-event" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadEventAgit.getName();
        } else {
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            mediaNameUploadEventAgit = "";
            pathLocationUploadEventAgit = "/" + "files" + "/" + "crm-event" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadEventAgit.getName();
            Messagebox.show("File : " + mediaUploadEventAgit + " Bukan File PDF", "Error", Messagebox.OK, Messagebox.ERROR);

        }
    }

    /* Function button save Event */
    @Command("buttonSaveEventAgit")
    @NotifyChange({"eventAgitDTO"})
    public void buttonSaveEventAgit(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (pathLocationUploadEventAgit == null) {
            pathLocationUploadEventAgit = eventAgitDTO.getAttachment();
        }

        Date tanggalMulai = eventAgitDTO.getStartDate();
        Date tanggalBerakhir = eventAgitDTO.getEndDate();

        if (tanggalMulai != null && tanggalBerakhir != null && tanggalBerakhir.compareTo(tanggalMulai) < 0) {
            Messagebox.show("Format tanggal mulai dan tanggal berakhir salah");
        } else {
            eventAgitDTO.setStatus(Status.ACTIVE);
            eventAgitDTO.setAttachment(pathLocationUploadEventAgit);
            eventAgitService.SaveOrUpdate(eventAgitDTO);
            showInformationMessagebox("Data EventAgit Berhasil Disimpan");
            BindUtils.postGlobalCommand(null, null, "refreshEventAgit", null);
            window.detach();
        }
    }

    /* Function refresh data Event */
    @GlobalCommand
    @NotifyChange("eventAgitDTOs")
    public void refreshEventAgit() {
        eventAgitDTOs = eventAgitService.findAll();
    }

    @Command("buttonKembaliEvent")
    @NotifyChange("eventAgitDTO")
    public void buttonKembaliEvent(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonNewEvent")
    @NotifyChange("eventAgitDTO")
    public void buttonNewEvent(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/add_event.zul", window, params);
    }

//    public int validasiForm(int jawab, String afterChck) {
//        for (int i = 0; i < afterChck.length(); i++) {
//            if (afterChck.charAt(i) != 'a' ) {
//                jawab += 1;
//            }            
//        }
//        return jawab;
//    }
    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    @Command("buttonSearchEvent")
    @NotifyChange("eventAgitDTOs")
    public void buttonSearchEvent(@ContextParam(ContextType.VIEW) Window window) {

//        int jawab = 0;
//        Map param1 = new HashMap();
//        param1.put("namaEvent", namaEvent);
//        jawab = validasiForm(jawab, namaEvent);
        int count = 0;
        Map params = new HashMap();
        params.put("idEvent", idEvent);
        count = checkCountParameter(count, idEvent);
        params.put("namaEvent", namaEvent);
        count = checkCountParameter(count, namaEvent);
        params.put("status", status);
        count = checkCountParameter(count, status);
        params.put("endDate", endDate);
        count = checkCountParameter(count, endDate);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        eventAgitDTOs = eventAgitService.findByParams(params);
    }

    @Command("detailEventAgit")
    @NotifyChange("eventAgit")
    public void detailEventAgit(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/add_event.zul", window, params);
    }

    @Command("buttonKlikEvent")
    @NotifyChange({"src", "eventAgitDTOs", "eventAgitDTO"})
    public void buttonKlikPreview(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/previewEventAgit.zul", window, params);
    }

    @Command("buttonClosePreview")
    @NotifyChange("eventAgitDTO")
    public void buttonClosePreview(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    /*-------------------------------------------------------------------- for data apply use  --------------------------------------------------------------------*/
    @Command("buttonBackPopupAcara")
    @NotifyChange("EventAgitDTO")
    public void buttonBackPopupAcara(@ContextParam(ContextType.VIEW) Window window){
        window.detach();
    }
    
    /*-------------------------------------------------------------------- getter setter --------------------------------------------------------------------*/
    public EventAgitDTO getEventAgitDTO() {
        return eventAgitDTO;
    }

    public void setEventAgitDTO(EventAgitDTO eventAgitDTO) {
        this.eventAgitDTO = eventAgitDTO;
    }

    public List<EventAgitDTO> getEventAgitDTOs() {
        return eventAgitDTOs;
    }

    public void setEventAgitDTOs(List<EventAgitDTO> eventAgitDTOs) {
        this.eventAgitDTOs = eventAgitDTOs;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

    public Media getMediaUploadEventAgit() {
        return mediaUploadEventAgit;
    }

    public void setMediaUploadEventAgit(Media mediaUploadEventAgit) {
        this.mediaUploadEventAgit = mediaUploadEventAgit;
    }

    public String getMediaNameUploadEventAgit() {
        return mediaNameUploadEventAgit;
    }

    public void setMediaNameUploadEventAgit(String mediaNameUploadEventAgit) {
        this.mediaNameUploadEventAgit = mediaNameUploadEventAgit;
    }

    public String getFilepathUploadEventAgit() {
        return filepathUploadEventAgit;
    }

    public void setFilepathUploadEventAgit(String filepathUploadEventAgit) {
        this.filepathUploadEventAgit = filepathUploadEventAgit;
    }

    public String getPathLocationUploadEventAgit() {
        return pathLocationUploadEventAgit;
    }

    public void setPathLocationUploadEventAgit(String pathLocationUploadEventAgit) {
        this.pathLocationUploadEventAgit = pathLocationUploadEventAgit;
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
