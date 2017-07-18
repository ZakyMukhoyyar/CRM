package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.ForumService;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.common.dto.crm.ForumDTOBuilder;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
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
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author Zaky
 */
public class ForumVM {

    @WireVariable
    ForumService forumService;

    private ForumDTO forumDTO = new ForumDTO();
    private List<ForumDTO> forumDTOs = new ArrayList<>();

    /* Parameter Filter */
    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private Status status;

    private PageNavigation previous;
    private int pageSize = 10;
    private ListModelList<Status> statuses;

    /* attribut for upload file forum*/
    Media mediaUploadFileForum;
    String mediaNameUploadFileForum;
    private String filePathUploadFileForum;
    private String pathLocationUploadFileForum;

    @Init
    public void init(
            @ExecutionArgParam("forumDTO") ForumDTO forum,
            @ExecutionArgParam("previous") PageNavigation previous) {
        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(forum, previous);
    }

    private void initData() {
        forumDTOs = forumService.findAll();
        if (forumDTOs.isEmpty()) {
            forumDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(ForumDTO forum, PageNavigation previous) {
        if (forum == null) {
            ListModelList<ForumDTO> parameterList = new ListModelList<>(forumService.findAll());
            String idForum = "";
            if (parameterList.isEmpty()) {
                idForum = "1";
            } else {
                idForum = getLatestObjectID(parameterList, "idForum");
            }
            forumDTO = new ForumDTOBuilder()
                    .setIdForum(idForum)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createForumDTO();
        } else {
            this.forumDTO = forum;
            idForum = forumDTO.getIdForum();
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
    @NotifyChange("forumDTOs")
    public void refreshForum() {
        forumDTOs = forumService.findAll();
    }

    @Command("buttonNewForum")
    @NotifyChange("forumDTO")
    public void buttonNewForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("forumDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/forum/add_forum.zul", window, params);
    }

    @Command("buttonSearchForum")
    @NotifyChange("forumDTOs")
    public void buttonSearchForum(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idForum", idForum);
        params.put("namaForum", namaForum);
        params.put("status", status);

        forumDTOs = forumService.findByParams(params);
    }

    @Command("detailForum")
    @NotifyChange("forumDTO")
    public void detailForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("forumDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/forum/add_forum.zul", window, params);
    }

    @Command("buttonKembaliForum")
    @NotifyChange("forumDTO")
    public void buttonKembaliForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    /* Function upload File Forum */
//    @Command("buttonUploadFileForum")
//    @NotifyChange({"mediaNameUploadFileForum", "pathLocationUploadFileForum"})
//    public void buttonUploadFileForum(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
//        UploadEvent upEvent = null;
//        Object objUploadEvent = ctx.getTriggerEvent();
//
//        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
//            upEvent = (UploadEvent) objUploadEvent;
//        }
//
//        if (upEvent != null) {
//            mediaUploadFileForum = upEvent.getMedia();
//            Calendar now = Calendar.getInstance();
//            int year = now.get(Calendar.YEAR);
//            int month = now.get(Calendar.MONTH);
//            int day = now.get(Calendar.DAY_OF_MONTH);
//            filePathUploadFileForum = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
//            filePathUploadFileForum = filePathUploadFileForum + "\\" + "files" + "\\" + "crm-cv" + "\\" + year + "\\" + month + "\\" + day + "\\";
//
//            File baseDir = new File(filePathUploadFileForum);
//            if (!baseDir.exists()) {
//                baseDir.mkdirs();
//            }
//
//            Files.copy(new File(filePathUploadFileForum + mediaUploadFileForum.getName()), mediaUploadFileForum.getStreamData());
//            setMediaNameUploadFileForum(filePathUploadFileForum + mediaUploadFileForum.getName());
//            pathLocationUploadFileForum = "/" + "files" + "/" + "crm-cv" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadFileForum.getName();
//        } else {
//            Calendar now = Calendar.getInstance();
//            int year = now.get(Calendar.YEAR);
//            int month = now.get(Calendar.MONTH);
//            int day = now.get(Calendar.DAY_OF_MONTH);
//            mediaNameUploadFileForum = "";
//            pathLocationUploadFileForum = "/" + "files" + "/" + "crm-cv" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadFileForum.getName();
//            Messagebox.show("File : " + mediaUploadFileForum + " Bukan File PDF", "Error", Messagebox.OK, Messagebox.ERROR);
//        }
//    }
    @Command("buttonSaveForum")
    @NotifyChange({"forumDTO", "forumDTOs"})
    public void buttonSaveForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        forumService.SaveOrUpdate(forumDTO);
        showInformationMessagebox("Data Forum Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshForum", null);
        window.detach();
    }

    /* getter setter */
    public ForumDTO getForumDTO() {
        return forumDTO;
    }

    public void setForumDTO(ForumDTO forumDTO) {
        this.forumDTO = forumDTO;
    }

    public List<ForumDTO> getForumDTOs() {
        return forumDTOs;
    }

    public void setForumDTOs(List<ForumDTO> forumDTOs) {
        this.forumDTOs = forumDTOs;
    }

    public String getIdForum() {
        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }

    public String getNamaForum() {
        return namaForum;
    }

    public void setNamaForum(String namaForum) {
        this.namaForum = namaForum;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public void setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

    public String getDeskripsiForum() {
        return deskripsiForum;
    }

    public void setDeskripsiForum(String deskripsiForum) {
        this.deskripsiForum = deskripsiForum;
    }

}
