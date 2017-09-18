package com.agit.crm.main.viewmodel;

import com.agit.crm.common.application.EventAgitService;
import com.agit.crm.common.application.EventStatusService;
import com.agit.crm.common.application.RiwayatApplyEventService;
import com.agit.crm.common.dto.crm.EventAgitDTO;
import com.agit.crm.common.dto.crm.EventStatusDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyEventDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.DateUtil;
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

    /* data user */
    private UserDTO user;
    private String userNPWP;
    private String role;
    private String uriPhoto;
    private String idEvent;
    private String idRiwayatApplyEvent;
    private String idEventStatus;
    private Status status;

    private String src;

//    private UserDTO userDTO;
    private EventAgitDTO eventAgitDTO = new EventAgitDTO();
    private EventStatusDTO eventStatusDTO = new EventStatusDTO();
    private RiwayatApplyEventDTO riwayatApplyEventDTO = new RiwayatApplyEventDTO();

//    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<EventAgitDTO> eventAgitDTOs = new ArrayList<>();
    private List<EventStatusDTO> eventStatusDTOs = new ArrayList<>();
    private List<RiwayatApplyEventDTO> riwayatApplyEventDTOs = new ArrayList<>();

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
        checkValidity(eventAgit, eventStatus, riwayatApplyEvent, previous);

    }

    private void initData() {
        eventAgitDTOs = eventAgitService.findAllByStatus(status.ACTIVE);
        if (eventAgitDTO.getIdEvent() != null) {
            riwayatApplyEventDTOs = riwayatApplyEventService.findIdEvent(eventAgitDTO.getIdEvent());
            if (riwayatApplyEventDTOs.isEmpty()) {
                riwayatApplyEventDTOs = Collections.emptyList();
            }
        }

    }

    private void checkValidity(EventAgitDTO eventAgit, EventStatusDTO eventStatus, RiwayatApplyEventDTO riwayatApplyEvent, PageNavigation previous) {
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

//        user = userService.findByID(SecurityUtil.getUserName());
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

}
