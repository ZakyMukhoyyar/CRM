package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.application.EventStatusService;
import com.agit.crm.common.application.RiwayatApplyEventService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.common.dto.crm.EventAgitDTOBuilder;
import com.agit.crm.common.dto.crm.EventStatusDTO;
import com.agit.crm.common.dto.crm.EventStatusDTOBuilder;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTO;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.util.CommonUtil;
import com.agit.crm.util.StringUtil;
import java.io.File;
import java.io.IOException;
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
 * @author 3AD
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class EventAgitVM {

    @WireVariable
    EventAgitService eventAgitService;

    @WireVariable
    EventStatusService eventStatusService;

    @WireVariable
    RiwayatApplyEventService riwayatApplyEventService;

    @WireVariable
    UserService userService;

    /* Object Binding UI CRM */
    private UserDTO user;
    private UserSpecificationDTO userSpecificationDTO;

    private UserDTO userDTO = new UserDTO();
    private EventAgitDTO eventAgitDTO = new EventAgitDTO();
    private EventStatusDTO eventStatusDTO = new EventStatusDTO();
    private RiwayatApplyEventDTO riwayatApplyEventDTO = new RiwayatApplyEventDTO();

    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<EventAgitDTO> eventAgitDTOs = new ArrayList<>();
    private List<EventStatusDTO> eventStatusDTOs = new ArrayList<>();
    private List<RiwayatApplyEventDTO> riwayatApplyEventDTOs = new ArrayList<>();
    private List<RiwayatApplyEventDTO> listRiwayatApplyEventDTOs = new ArrayList<>();


    /* for drop down */
    private ListModelList<Status> statuses;
    private ListModelList<LowonganState> lowonganStates;
    private List<EventAgitDTO> eventUserDTOs;

    /* for string list container */
    private List<String> listNamaEvent = new ArrayList<>();

    /* for variable container */
    private String idEvent;
    private String idEventStatus;
    private String idRiwayatApplyEvent;
    private String namaLengkap;
    private String userID;
    private LowonganState lowonganState;
    private String namaEvent;
    private Date endDate;
    private Status status;

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
            @ExecutionArgParam("userDTO") UserDTO user,
            @ExecutionArgParam("eventAgitDTO") EventAgitDTO eventAgit,
            @ExecutionArgParam("eventStatusDTO") EventStatusDTO eventStatus,
            @ExecutionArgParam("riwayatApplyEventDTO") RiwayatApplyEventDTO riwayatApplyEvent,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(user, eventAgit, eventStatus, riwayatApplyEvent, previous);
    }

    private void initData() {
        /* for init event */
        eventAgitDTOs = eventAgitService.findAll();
        if (eventAgitDTOs.isEmpty()) {
            eventAgitDTOs = Collections.emptyList();
        }
        for (EventAgitDTO listEvent : eventAgitDTOs) {
            listNamaEvent.add(listEvent.getNamaEvent());
        }

        /* for init event status */
        eventStatusDTOs = eventStatusService.findAll();
        if (eventStatusDTOs.isEmpty()) {
            eventAgitDTOs = Collections.emptyList();
        }

        /* for init user */
        user = userService.findByID(SecurityUtil.getUserName());
        eventUserDTOs = eventAgitService.findAllByStatus(status.ACTIVE);
    }

    private void checkValidity(
            UserDTO user,
            EventAgitDTO eventAgit,
            EventStatusDTO eventStatus,
            RiwayatApplyEventDTO riwayatApplyEvent,
            PageNavigation previous
    ) {
        if (user == null) {
            userSpecificationDTO = new UserSpecificationDTOBuilder()
                    .setFullName(namaLengkap)
                    .createUserSpecificationDTO();
            userDTO = new UserDTOBuilder()
                    .setUserID(userID)
                    .setUserSpecificationDTO(userSpecificationDTO)
                    .setCreationalBy(SecurityUtil.getUserName())
                    .setCreationalDate(new Date())
                    .createUserDTO();
        } else {
            this.userDTO = user;
            userID = userDTO.getUserID();
            this.previous = previous;
        }
        /* for validity event */
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

        /* for validity event status */
        if (eventStatus == null) {
            ListModelList<EventStatusDTO> parameterList = new ListModelList<>(eventStatusService.findAll());
            String idEventStatus = "";
            if (parameterList.isEmpty()) {
                idEventStatus = "EVTSTS0001";
            } else {
                idEventStatus = getLatestObjectID(parameterList, "idEventStatus");
            }
            eventStatusDTO = new EventStatusDTOBuilder()
                    .setIdEventStatus(idEventStatus)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createEventStatusDTO();
        } else {
            this.eventStatusDTO = eventStatus;
            idEventStatus = eventStatusDTO.getIdEventStatus();
            this.previous = previous;
        }

        /* for validity riwayat apply event */
        if (riwayatApplyEvent == null) {
            ListModelList<RiwayatApplyEventDTO> parameterList = new ListModelList<>(riwayatApplyEventService.findAll());
            String idRiwayatApplyEvent = "";
            if (parameterList.isEmpty()) {
                idRiwayatApplyEvent = "RAE0001";
            } else {
                idRiwayatApplyEvent = getLatestObjectID(parameterList, "idRiwayatApplyEvent");
            }
            riwayatApplyEventDTO = new RiwayatApplyEventDTOBuilder()
                    .setIdRiwayatApplyEvent(idRiwayatApplyEvent)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createRiwayatApplyEventDTO();
        } else {
            this.riwayatApplyEventDTO = riwayatApplyEvent;
            idRiwayatApplyEvent = riwayatApplyEventDTO.getIdRiwayatApplyEvent();
            this.previous = previous;
        }
    }

    /* =========== for data apply use =========== */
    @Command("buttonBackPopupAcara")
    @NotifyChange({"riwayatApplyEventDTOs", "eventStatusDTOs", "eventAgitDTOs"})
    public void buttonBackPopupAcara(@ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("searchAttendance")
    @NotifyChange("listRiwayatApplyEventDTOs")
    public void searchAttendance(@ContextParam(ContextType.VIEW) Window window) {

        int count = 0;
        Map params = new HashMap();
        params.put("namaEvent", namaEvent);
        count = checkCount(count, namaEvent);
        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        listRiwayatApplyEventDTOs = riwayatApplyEventService.findByParams(params);
    }

    @Command("KlikStatusPeserta")
    @NotifyChange({"userDTO", "userDTOs",
        "riwayatApplyEventDTO", "riwayatApplyEventDTOs", "listRiwayatApplyEventDTOs"})
    public void KlikStatusPeserta(@BindingParam("object") RiwayatApplyEventDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> map = new HashMap<>();
        map.put("riwayatApplyEventDTO", obj);
        riwayatApplyEventDTOs = riwayatApplyEventService.findByParams(map);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/dataApplyAcara/popup_status_acara.zul", window, map);
    }

    @Command("buttonSimpanStatusPeserta")
    @NotifyChange({"listRiwayatApplyEventDTOs", "riwayatApplyEventDTO", "riwayatApplyEventDTOs"})
    public void buttonSimpanStatusPeserta(@BindingParam("object") RiwayatApplyEventDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        riwayatApplyEventDTO.setLowonganState(lowonganState);
        riwayatApplyEventService.saveOrUpdate(riwayatApplyEventDTO);
        showInformationMessagebox("Data Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshEventAgit", null);
        window.detach();
    }

    @Command("KlikDetailDataPeserta")
    @NotifyChange({"userDTO", "userDTOs",
        "eventAgitDTO", "eventAgitDTOs",
        "riwayatApplyEventDTO", "riwayatApplyEventDTOs"})
    public void KlikDetailDataPeserta(@BindingParam("object") RiwayatApplyEventDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (obj.getIdUserRiwayat() != null) {
            userDTO = userService.findByUserID(obj.getIdUserRiwayat());
        }
    }

    /* =========== for data event admin use =========== */
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

    @Command("deleteEvent")
    @NotifyChange("eventAgitDTOs")
    public void deleteEvent(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        eventAgitDTO = (EventAgitDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Event?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    eventAgitService.deleteData(eventAgitDTO);
                    showInformationMessagebox("Event Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshEventAgit", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

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

    /* =============== dashboard_pengumuman =============== */
    @Command("LihatPengumuman")
    @NotifyChange({"eventAgitDTO,riwayatApplyEventDTOs,eventAgitDTOs,riwayatApplyEventDTO"})
    public void LihatPengumuman(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/dashboard_pengumuman.zul", window, params);
        riwayatApplyEventDTOs = riwayatApplyEventService.findIdEvent(eventAgitDTO.getIdEvent());
    }

    @Command("buttonClosePreview")
    @NotifyChange("eventAgitDTO")
    public void buttonClosePreview(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
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

    @Command("buttonSearchEvent")
    @NotifyChange("eventAgitDTOs")
    public void buttonSearchEvent(@ContextParam(ContextType.VIEW) Window window) {

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


    /* =========== for popup apply acara =========== */
    @Command("buttonKonfirmasiApplyAcara")
    @NotifyChange({"eventAgitDTO", "eventAgitDTOs",
        "riwayatApplyEventDTO", "riwayatApplyEventDTOs",
        "eventStatusDTO", "eventStatusDTOs"
    })
    public void buttonKonfirmasiApplyAcara(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        String message = "";
        riwayatApplyEventDTO.setIdRiwayatEvent(eventAgitDTO.getIdEvent());
        riwayatApplyEventDTO.setIdUserRiwayat(user.getUserID());
        riwayatApplyEventDTO.setNamaEvent(eventAgitDTO.getNamaEvent());
        riwayatApplyEventDTO.setNamaPelamar(user.getUserSpecificationDTO().getFullName());
        riwayatApplyEventDTO.setLowonganState(LowonganState.APPLY);
        riwayatApplyEventDTO.setCreatedBy(user.getUserSpecificationDTO().getFullName());
        riwayatApplyEventDTO.setCreatedDate(new Date());
        riwayatApplyEventService.saveOrUpdate(riwayatApplyEventDTO);

        eventStatusDTO.setIdEvent(eventAgitDTO.getIdEvent());
        eventStatusDTO.setIdUser(user.getUserID());
        eventStatusDTO.setLowonganState(LowonganState.APPLY);
        eventStatusDTO.setCreatedBy(user.getUserSpecificationDTO().getFullName());
        eventStatusDTO.setCreatedDate(new Date());
        eventStatusService.saveOrUpdate(eventStatusDTO);

        BindUtils.postGlobalCommand(null, null, "refreshEventAgit", null);
        window.detach();
    }

    /* =========== for Pengumuman Peserta use =========== */
    @Command("buttonSearchEvent2")
    @NotifyChange("eventAgitDTOs")
    public void buttonSearchEvent2(@ContextParam(ContextType.VIEW) Window window) {

        Map params = new HashMap();
        params.put("status", status.ACTIVE);
        eventUserDTOs = eventAgitService.findByParams(params);
    }

    /* =========== Configuration =========== */
    @GlobalCommand
    @NotifyChange({"eventAgitDTOs", "eventStatusDTOs"})
    public void refreshEventAgit() {
        eventAgitDTOs = eventAgitService.findAll();
        eventStatusDTOs = eventStatusService.findAll();
    }

    @GlobalCommand
    @NotifyChange({"riwayatApplyEventDTOs,eventAgitDTOs"})
    public void refreshRiwayatApplyEvent() {
        riwayatApplyEventDTOs = riwayatApplyEventService.findIdEvent(eventAgitDTO.getIdEvent());
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
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

    public int checkCount(int count, Object object) {
        if (StringUtil.hasValue(object)) {
            count += 1;
        }
        return count;
    }

    /* =========== getter setter =========== */
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

    public EventStatusDTO getEventStatusDTO() {
        return eventStatusDTO;
    }

    public void setEventStatusDTO(EventStatusDTO eventStatusDTO) {
        this.eventStatusDTO = eventStatusDTO;
    }

    public RiwayatApplyEventDTO getRiwayatApplyEventDTO() {
        return riwayatApplyEventDTO;
    }

    public void setRiwayatApplyEventDTO(RiwayatApplyEventDTO riwayatApplyEventDTO) {
        this.riwayatApplyEventDTO = riwayatApplyEventDTO;
    }

    public List<EventStatusDTO> getEventStatusDTOs() {
        return eventStatusDTOs;
    }

    public void setEventStatusDTOs(List<EventStatusDTO> eventStatusDTOs) {
        this.eventStatusDTOs = eventStatusDTOs;
    }

    public List<RiwayatApplyEventDTO> getRiwayatApplyEventDTOs() {
        return riwayatApplyEventDTOs;
    }

    public void setRiwayatApplyEventDTOs(List<RiwayatApplyEventDTO> riwayatApplyEventDTOs) {
        this.riwayatApplyEventDTOs = riwayatApplyEventDTOs;
    }

    public ListModelList<LowonganState> getLowonganStates() {
        return new ListModelList<>(LowonganState.values());
    }

    public void setLowonganStates(ListModelList<LowonganState> lowonganStates) {
        this.lowonganStates = lowonganStates;
    }

    public List<String> getListNamaEvent() {
        return listNamaEvent;
    }

    public void setListNamaEvent(List<String> listNamaEvent) {
        this.listNamaEvent = listNamaEvent;
    }

    public String getIdEventStatus() {
        return idEventStatus;
    }

    public void setIdEventStatus(String idEventStatus) {
        this.idEventStatus = idEventStatus;
    }

    public String getIdRiwayatApplyEvent() {
        return idRiwayatApplyEvent;
    }

    public void setIdRiwayatApplyEvent(String idRiwayatApplyEvent) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
    }

    public List<RiwayatApplyEventDTO> getListRiwayatApplyEventDTOs() {
        return listRiwayatApplyEventDTOs;
    }

    public void setListRiwayatApplyEventDTOs(List<RiwayatApplyEventDTO> listRiwayatApplyEventDTOs) {
        this.listRiwayatApplyEventDTOs = listRiwayatApplyEventDTOs;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserSpecificationDTO getUserSpecificationDTO() {
        return userSpecificationDTO;
    }

    public void setUserSpecificationDTO(UserSpecificationDTO userSpecificationDTO) {
        this.userSpecificationDTO = userSpecificationDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<EventAgitDTO> getEventUserDTOs() {
        return eventUserDTOs;
    }

    public void setEventUserDTOs(List<EventAgitDTO> eventUserDTOs) {
        this.eventUserDTOs = eventUserDTOs;
    }

}
