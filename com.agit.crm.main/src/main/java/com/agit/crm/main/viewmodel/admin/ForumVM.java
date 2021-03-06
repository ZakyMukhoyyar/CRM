package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.ForumService;
import com.agit.crm.common.application.KomentarForumService;
import com.agit.crm.common.dto.crm.ForumDTOBuilder;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.common.dto.crm.KomentarForumDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
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
import org.zkoss.zk.ui.event.Event;
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

    @WireVariable
    KomentarForumService komentarForumService;

    private ForumDTO forumDTO = new ForumDTO();
    private List<ForumDTO> forumDTOs = new ArrayList<>();
    private List<ForumDTO> forumuserDTOs = new ArrayList<>();

    private KomentarForumDTO komentarForumDTO = new KomentarForumDTO();
    private List<KomentarForumDTO> komentarForumDTOs = new ArrayList<>();

    /* Parameter Filter */
    private String idForum;
    private String namaForum;
    private String deskripsiForum;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private Status status;
    private String komentarID;
    private String komentar;

    private PageNavigation previous;
    private int pageSize = 5;
    private ListModelList<Status> statuses;

    /* attribut for upload file forum*/
    Media mediaUploadFileForum;
    String mediaNameUploadFileForum;
    private String filePathUploadFileForum;
    private String pathLocationUploadFileForum;
    private String src;

    private boolean hide;

    @Init
    public void init(
            @ExecutionArgParam("forumDTO") ForumDTO forum,
            @ExecutionArgParam("komentarForumDTO") KomentarForumDTO komentarForum,
            @ExecutionArgParam("previous") PageNavigation previous) {
        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(forum, komentarForum, previous);
    }

    private void initData() {
        src = "/crm/mahasiswa/view_forums.zul";

        forumDTOs = forumService.findAll();
        if (forumDTOs.isEmpty()) {
            forumDTOs = Collections.emptyList();
        }
        /*to User*/
        forumuserDTOs = forumService.findAllByStatus(status.ACTIVE);
        komentarForumDTOs = komentarForumService.findAllByID(forumDTO.getIdForum());
        if (komentarForumDTOs.isEmpty()) {
            komentarForumDTOs = Collections.emptyList();
        }

    }

    private void checkValidity(ForumDTO forum, KomentarForumDTO komentarForum, PageNavigation previous) {
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
        if (komentarForum != null) {
            this.komentarForumDTO = komentarForum;
            komentarID = komentarForum.getIdForum();
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

    @NotifyChange("src")
    public void buttonKlikDashboardForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        src = "/crm/admin/forum/view_forums.zul";
    }

    @Command("refreshDataGrid")
    @NotifyChange("komentarForumDTOs")
    public void refreshDataGrid() {
        komentarForumDTOs = komentarForumService.findAllByID(forumDTO.getIdForum());

    }

    @Command("deleteForum")
    @NotifyChange("forumDTOs")
    public void deleteForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        forumDTO = (ForumDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Forum?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    forumService.deleteData(forumDTO);
                    showInformationMessagebox("Forum Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshForum", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    @Command("buttonNewForum")
    @NotifyChange("forumDTO")
    public void buttonNewForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("forumDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/forum/add_forum.zul", window, params);
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    @Command("buttonSearchForum")
    @NotifyChange("forumDTOs")
    public void buttonSearchForum(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;

        Map params = new HashMap();
        params.put("idForum", idForum);
        count = checkCountParameter(count, idForum);
        params.put("namaForum", namaForum);
        count = checkCountParameter(count, namaForum);
        params.put("status", status);
        count = checkCountParameter(count, status);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        forumDTOs = forumService.findByParams(params);
    }

    @Command("buttonSearchForum2")
    @NotifyChange("forumuserDTOs")
    public void buttonSearchForum2(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;

        Map params = new HashMap();
        params.put("idForum", idForum);
        count = checkCountParameter(count, idForum);
        params.put("namaForum", namaForum);
        count = checkCountParameter(count, namaForum);
        params.put("status", status.ACTIVE);
        count = checkCountParameter(count, status.ACTIVE);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        forumuserDTOs = forumService.findByParams(params);
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

    @Command("buttonSaveForum")
    @NotifyChange({"forumDTO", "forumDTOs"})
    public void buttonSaveForum(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        forumService.SaveOrUpdate(forumDTO);
        showInformationMessagebox("Data Forum Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshForum", null);
        window.detach();
    }

    @Command("komentariOnAdmin")
    @NotifyChange("forumDTO")
    public void komentariOnAdmin(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("forumDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/forum/dashboard_komentar.zul", window, params);
        BindUtils.postGlobalCommand(null, null, "refreshKomentarForum", null);
    }

    @Command("deleteKomentar")
    @NotifyChange({"komentarForumDTO", "komentarForumDTOs", "komentar", "forumuserDTOs"})
    public void deleteKomentar(@BindingParam("object") KomentarForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        komentarForumDTO = (KomentarForumDTO) obj;
        Messagebox.show("Apakah anda yakin ingin menghapus Lowongan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    komentarForumService.delete(komentarForumDTO);
                    showInformationMessagebox("Lowongan Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshKomentarForum", null);
                } else {
                    System.out.println("Operation Canceled !");
                }
            }
        }
        );
    }

    /*------------------------------------------------------------- functonality Comment ----------------------------------------------------*/
    @Command("komentari")
    @NotifyChange("forumDTO")
    public void komentari(@BindingParam("object") ForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("forumDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/dashboard_komentar.zul", window, params);
        BindUtils.postGlobalCommand(null, null, "refreshKomentarForum", null);
    }

    @Command("buttonComment")
    @NotifyChange({"forumDTO", "forumDTOs", "komentarForumDTO", "komentarForumDTOs", "komentar", "forumuserDTOs"})
    public void buttonComment(@BindingParam("object") KomentarForumDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        komentarForumDTO.setKomentarID(UUID.randomUUID().toString());
        komentarForumDTO.setUserName(SecurityUtil.getUserName());
        komentarForumDTO.setTglKomentar(new Date());
        komentarForumDTO.setKomentar(komentar);
        komentarForumDTO.setIdForum(forumDTO.getIdForum());

        if (pathLocationUploadFileForum != null) {
            komentarForumDTO.setPicture(pathLocationUploadFileForum);
        } else {
            komentarForumDTO.setPicture("No Pict");
        }

        komentarForumService.saveOrUpdate(komentarForumDTO);
        komentar = null;
        pathLocationUploadFileForum = null;
        BindUtils.postGlobalCommand(null, null, "refreshKomentarForum", null);
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

    @GlobalCommand
    @NotifyChange("komentarForumDTOs")
    public void refreshKomentarForum() {
        komentarForumDTOs = komentarForumService.findAllByID(forumDTO.getIdForum());
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

    public KomentarForumDTO getKomentarForumDTO() {
        return komentarForumDTO;
    }

    public void setKomentarForumDTO(KomentarForumDTO komentarForumDTO) {
        this.komentarForumDTO = komentarForumDTO;
    }

    public List<KomentarForumDTO> getKomentarForumDTOs() {
        return komentarForumDTOs;
    }

    public void setKomentarForumDTOs(List<KomentarForumDTO> komentarForumDTOs) {
        this.komentarForumDTOs = komentarForumDTOs;
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

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<ForumDTO> getForumuserDTOs() {
        return forumuserDTOs;
    }

    public void setForumuserDTOs(List<ForumDTO> forumuserDTOs) {
        this.forumuserDTOs = forumuserDTOs;
    }

}
