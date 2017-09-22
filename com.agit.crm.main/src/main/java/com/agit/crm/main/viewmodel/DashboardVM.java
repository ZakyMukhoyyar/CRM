package com.agit.crm.main.viewmodel;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.application.EventStatusService;
import com.agit.crm.common.application.KomentarEventService;
import com.agit.crm.common.application.RiwayatApplyEventService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.common.dto.crm.EventStatusDTO;
import com.agit.crm.common.dto.crm.KomentarEventDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.DateUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class DashboardVM {

    @WireVariable
    EventAgitService eventAgitService;

    @WireVariable
    EventStatusService eventStatusService;

    @WireVariable
    RiwayatApplyEventService riwayatApplyEventService;

    @WireVariable
    KomentarEventService komentarEventService;

    /* data user */
    private UserDTO user;
    private String userNPWP;
    private String role;
    private String uriPhoto;
    private String idEvent;
    private String idRiwayatApplyEvent;
    private String idEventStatus;
    private String komentarID;
    private Status status;
    private String komentar;

    private String src;

//    private UserDTO userDTO;
    private EventAgitDTO eventAgitDTO = new EventAgitDTO();
    private EventStatusDTO eventStatusDTO = new EventStatusDTO();
    private RiwayatApplyEventDTO riwayatApplyEventDTO = new RiwayatApplyEventDTO();
    private KomentarEventDTO komentarEventDTO = new KomentarEventDTO();

//    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<EventAgitDTO> eventAgitDTOs = new ArrayList<>();
    private List<EventStatusDTO> eventStatusDTOs = new ArrayList<>();
    private List<RiwayatApplyEventDTO> riwayatApplyEventDTOs = new ArrayList<>();
    private List<KomentarEventDTO> komentarEventDTOs = new ArrayList<>();

    Media mediaUploadFileForum;
    String mediaNameUploadFileForum;
    private String filePathUploadFileForum;
    private String pathLocationUploadFileForum;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 3;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    @Init
    public void init(@ContextParam(ContextType.COMPONENT) Window window,
            @ExecutionArgParam("eventAgitDTO") EventAgitDTO eventAgit,
            @ExecutionArgParam("eventStatusDTO") EventStatusDTO eventStatus,
            @ExecutionArgParam("riwayatApplyEventDTO") RiwayatApplyEventDTO riwayatApplyEvent,
            @ExecutionArgParam("komentarEventDTO") KomentarEventDTO komentarEvent,
            @ExecutionArgParam("previous") PageNavigation previous) {

        userNPWP = SecurityUtil.getUserName();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();
        user = SecurityUtil.getUser();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();
        if (user.getUserSpecificationDTO().getFullName() != null) {
        } else if (user.getUserSpecificationDTO().getFullName() != null) {

        }
        switch (role) {
            default:
                uriPhoto = "/images/background.png";
                break;
        }
        initData();
        checkValidity(eventAgit, eventStatus, komentarEvent, riwayatApplyEvent, previous);

    }

    private void initData() {
        eventAgitDTOs = eventAgitService.findAllByStatus(status.ACTIVE);
        if (eventAgitDTO.getIdEvent() != null) {
            riwayatApplyEventDTOs = riwayatApplyEventService.findIdEvent(eventAgitDTO.getIdEvent());
            if (riwayatApplyEventDTOs.isEmpty()) {
                riwayatApplyEventDTOs = Collections.emptyList();
            }
        }
        komentarEventDTOs = komentarEventService.findAllByID(eventAgitDTO.getIdEvent());

    }

    private void checkValidity(EventAgitDTO eventAgit, EventStatusDTO eventStatus, KomentarEventDTO komentarEvent, RiwayatApplyEventDTO riwayatApplyEvent, PageNavigation previous) {
        if (eventAgit != null) {
            this.eventAgitDTO = eventAgit;
            idEvent = eventAgitDTO.getIdEvent();
            this.previous = previous;
        }
        if (riwayatApplyEvent != null) {
            this.riwayatApplyEventDTO = riwayatApplyEvent;
            idRiwayatApplyEvent = riwayatApplyEventDTO.getIdRiwayatApplyEvent();
            this.previous = previous;
        }
        if (eventStatus != null) {
            this.eventStatusDTO = eventStatus;
            idEventStatus = eventStatusDTO.getIdEventStatus();
            this.previous = previous;
        }
        if (komentarEvent != null) {
            this.komentarEventDTO = komentarEvent;
            komentarID = komentarEventDTO.getKomentarID();
            this.previous = previous;
        }
    }

    @Command("buttonKlikEvent")
    @NotifyChange({"src", "eventAgitDTOs", "eventAgitDTO"})
    public void buttonKlikPreview(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/previewEventAgit.zul", window, params);
    }

    @Command("buttonApplyAcara")
    @NotifyChange({"eventAgitDTO", "eventAgitDTOs"})
    public void buttonApplyAcara(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {

        Map map = new HashMap();
        map.put("idUser", user.getUserID());
        map.put("idEvent", obj.getIdEvent());
        eventStatusDTOs = eventStatusService.findByParams2(map);
        if (eventStatusDTOs.isEmpty()) {
            BindUtils.postGlobalCommand(null, null, "refreshAcara", null);
            Map<String, Object> params = new HashMap<>();
            params.put("eventAgitDTO", obj);
            CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/popup_apply_acara.zul", window, params);
        } else {
            showInformationMessagebox("Anda Sudah Pernah Menghadiri Acara Ini");
        }
    }

    @GlobalCommand
    @NotifyChange("eventAgitDTOs")
    public void refreshAcara() {
        eventAgitDTOs = eventAgitService.findAllByStatus(Status.ACTIVE);
    }

    @Command("buttonClosePreview")
    @NotifyChange("eventAgitDTO")
    public void buttonClosePreview(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("pengumuman")
    @NotifyChange("eventAgitDTO")
    public void pengumuman(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/dashboard_pengumuman.zul", window, params);
        BindUtils.postGlobalCommand(null, null, "refreshRiwayatApplyEvent", null);
    }

    @GlobalCommand
    @NotifyChange("riwayatApplyEventDTOs")
    public void refreshRiwayatApplyEvent() {
        riwayatApplyEventDTOs = riwayatApplyEventService.findAllByStatus(eventAgitDTO.getIdEvent(), LowonganState.ACCEPTED);
    }

    /*--------------------------------------------------------Komentari-------------------------------------------------------------------*/
    @Command("komentariEvent")
    @NotifyChange("eventAgitDTO")
    public void komentariEvent(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("eventAgitDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/event/dashboard_komentar.zul", window, params);
        BindUtils.postGlobalCommand(null, null, "refreshKomentarEvent", null);
    }

    @GlobalCommand
    @NotifyChange("komentarEventDTOs")
    public void refreshKomentarEvent() {
        komentarEventDTOs = komentarEventService.findAllByID(eventAgitDTO.getIdEvent());
    }

    @Command("buttonComment")
    @NotifyChange({"eventAgitDTO", "eventAgitDTOs", "komentarEventDTO", "komentarEventDTOs", "komentar"})
    public void buttonComment(@BindingParam("object") EventAgitDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        komentarEventDTO.setKomentarID(UUID.randomUUID().toString());
        komentarEventDTO.setUserName(SecurityUtil.getUserName());
        komentarEventDTO.setTglKomentar(new Date());
        komentarEventDTO.setKomentar(komentar);
        komentarEventDTO.setIdEvent(eventAgitDTO.getIdEvent());

        if (pathLocationUploadFileForum != null) {
            komentarEventDTO.setPicture(pathLocationUploadFileForum);
        } else {
            komentarEventDTO.setPicture("No Pict");
        }
        komentarEventService.saveOrUpdate(komentarEventDTO);
        komentar = null;
        pathLocationUploadFileForum = null;
        BindUtils.postGlobalCommand(null, null, "refreshKomentarEvent", null);
    }

    @Command("refreshDataGrid")
    @NotifyChange("komentarEventDTOs")
    public void refreshDataGrid() {
        komentarEventDTOs = komentarEventService.findAllByID(eventAgitDTO.getIdEvent());
    }

    @Command("buttonUploadFileKomentar")
    @NotifyChange({"mediaNameUploadFileForum", "pathLocationUploadFileForum"})
    public void buttonUploadFileForum(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaUploadFileForum = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePathUploadFileForum = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filePathUploadFileForum = filePathUploadFileForum + "\\" + "files" + "\\" + "filekomentar" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filePathUploadFileForum);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            Files.copy(new File(filePathUploadFileForum + mediaUploadFileForum.getName()), mediaUploadFileForum.getStreamData());
            setMediaNameUploadFileForum(filePathUploadFileForum + mediaUploadFileForum.getName());
            pathLocationUploadFileForum = "/" + "files" + "/" + "filekomentar" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadFileForum.getName();
        } else {
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            mediaNameUploadFileForum = "";
            pathLocationUploadFileForum = "/" + "files" + "/" + "filekomentar" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadFileForum.getName();
            Messagebox.show("File : " + mediaUploadFileForum + " Bukan File PDF", "Error", Messagebox.OK, Messagebox.ERROR);
        }
    }

    /* helper */
    public String concatUsername(String s1, String s2) {
        return s1.concat(s2);
    }

    public String concatDate(String s1, Date s2) {
        return s1.concat(DateUtil.dateToString(s2, "dd-MMM-yyy HH:mm:ss"));
    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    /* Getter&Setter */
    public RiwayatApplyEventDTO getRiwayatApplyEventDTO() {
        return riwayatApplyEventDTO;
    }

    public void setRiwayatApplyEventDTO(RiwayatApplyEventDTO riwayatApplyEventDTO) {
        this.riwayatApplyEventDTO = riwayatApplyEventDTO;
    }

    public List<RiwayatApplyEventDTO> getRiwayatApplyEventDTOs() {
        return riwayatApplyEventDTOs;
    }

    public void setRiwayatApplyEventDTOs(List<RiwayatApplyEventDTO> riwayatApplyEventDTOs) {
        this.riwayatApplyEventDTOs = riwayatApplyEventDTOs;
    }

    public String getUserNPWP() {
        return userNPWP;
    }

    public void setUserNPWP(String userNPWP) {
        this.userNPWP = userNPWP;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUriPhoto() {
        return uriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        this.uriPhoto = uriPhoto;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<EventAgitDTO> getEventAgitDTOs() {
        return eventAgitDTOs;
    }

    public void setEventAgitDTOs(List<EventAgitDTO> eventAgitDTOs) {
        this.eventAgitDTOs = eventAgitDTOs;
    }

    public EventAgitDTO getEventAgitDTO() {
        return eventAgitDTO;
    }

    public void setEventAgitDTO(EventAgitDTO eventAgitDTO) {
        this.eventAgitDTO = eventAgitDTO;
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

    public EventStatusDTO getEventStatusDTO() {
        return eventStatusDTO;
    }

    public void setEventStatusDTO(EventStatusDTO eventStatusDTO) {
        this.eventStatusDTO = eventStatusDTO;
    }

    public List<EventStatusDTO> getEventStatusDTOs() {
        return eventStatusDTOs;
    }

    public void setEventStatusDTOs(List<EventStatusDTO> eventStatusDTOs) {
        this.eventStatusDTOs = eventStatusDTOs;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getIdRiwayatApplyEvent() {
        return idRiwayatApplyEvent;
    }

    public void setIdRiwayatApplyEvent(String idRiwayatApplyEvent) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
    }

    public String getIdEventStatus() {
        return idEventStatus;
    }

    public void setIdEventStatus(String idEventStatus) {
        this.idEventStatus = idEventStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getKomentarID() {
        return komentarID;
    }

    public void setKomentarID(String komentarID) {
        this.komentarID = komentarID;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public KomentarEventDTO getKomentarEventDTO() {
        return komentarEventDTO;
    }

    public void setKomentarEventDTO(KomentarEventDTO komentarEventDTO) {
        this.komentarEventDTO = komentarEventDTO;
    }

    public List<KomentarEventDTO> getKomentarEventDTOs() {
        return komentarEventDTOs;
    }

    public void setKomentarEventDTOs(List<KomentarEventDTO> komentarEventDTOs) {
        this.komentarEventDTOs = komentarEventDTOs;
    }

    public Media getMediaUploadFileForum() {
        return mediaUploadFileForum;
    }

    public void setMediaUploadFileForum(Media mediaUploadFileForum) {
        this.mediaUploadFileForum = mediaUploadFileForum;
    }

    public String getMediaNameUploadFileForum() {
        return mediaNameUploadFileForum;
    }

    public void setMediaNameUploadFileForum(String mediaNameUploadFileForum) {
        this.mediaNameUploadFileForum = mediaNameUploadFileForum;
    }

    public String getFilePathUploadFileForum() {
        return filePathUploadFileForum;
    }

    public void setFilePathUploadFileForum(String filePathUploadFileForum) {
        this.filePathUploadFileForum = filePathUploadFileForum;
    }

    public String getPathLocationUploadFileForum() {
        return pathLocationUploadFileForum;
    }

    public void setPathLocationUploadFileForum(String pathLocationUploadFileForum) {
        this.pathLocationUploadFileForum = pathLocationUploadFileForum;
    }

}
