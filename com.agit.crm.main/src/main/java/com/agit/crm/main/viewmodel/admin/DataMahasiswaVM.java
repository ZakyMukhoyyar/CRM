package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.CivitasService;
import com.agit.crm.common.application.DomisiliService;
import com.agit.crm.common.application.JurusanService;
import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.dto.crm.CivitasDTO;
import com.agit.crm.common.dto.crm.DomisiliDTO;
import com.agit.crm.common.dto.crm.JurusanDTO;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.util.StringUtil;
import java.io.File;
import java.io.IOException;
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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author 3AD
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DataMahasiswaVM {

    /*------------------------------------- import Service -----------------------------------*/
    @WireVariable
    UserService userService;

    @WireVariable
    DomisiliService domisiliService;

    @WireVariable
    MinatService minatService;

    @WireVariable
    KetrampilanService ketrampilanService;

    @WireVariable
    JurusanService jurusanService;

    @WireVariable
    CivitasService civitasService;


    /*------------------------------------- object binding -----------------------------------*/
    private UserDTO userDTO = new UserDTO();
    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<UserDTO> userDTO2s = new ArrayList<>();
    private List<DomisiliDTO> domisilis = new ArrayList<DomisiliDTO>();
    private List<MinatDTO> minats = new ArrayList<MinatDTO>();
    private List<String> listMinat = new ArrayList<>();
    private List<String> listKetrampilan = new ArrayList<>();
    private List<String> listDomisili = new ArrayList<>();
    private List<String> listCivitas = new ArrayList<>();
    private List<String> listJurusan = new ArrayList<>();
    private ListModelList<JenisKelaminType> jenisKelaminTypes;
    private ListModelList<PendidikanType> pendidikanTypes;
    private ListModelList<TingkatanType> tingkatanTypes1;
    private ListModelList<TingkatanType> tingkatanTypes2;
    private ListModelList<TingkatanType> tingkatanTypes3;
    private ListModelList<TingkatanType> tingkatanTypes4;
    private ListModelList<TingkatanType> tingkatanTypes5;
    private List<KetrampilanDTO> ketrampilans = new ArrayList<KetrampilanDTO>();
    private List<JurusanDTO> jurusans = new ArrayList<JurusanDTO>();
    private List<CivitasDTO> civitass = new ArrayList<CivitasDTO>();

    /*------------------------------------- Parameter Pencarian-------------------------------*/
    private String fullName;
    private String ktp;
    private String domisiliSelect;
    private String minatSelect;
    private String jurusanSelect;
    private String ketrampilanSelect;
    private String civitasSelect;
    private String userID;

    /*------------------------------------- Paging--------------------------------------------*/
    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 2;
    private int pageSizeCreateLowongan = 7;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    /*------------------------------ attribut for upload file CV ----------------------------*/
    Media mediaUploadCV;
    String mediaNameUploadCV;
    private String filepathUploadCV;
    private String pathLocationUploadCV;


    /*------------------------------------- Init--------------------------------------------*/
    @Init
    public void init(
            @ExecutionArgParam("userDTO") UserDTO user,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(user, previous);

    }

    private void initData() {
        userDTOs = userService.findAllMahasiswa(3);

        userDTO2s = userService.findByUsername(SecurityUtil.getUserName());

        minats = minatService.findAll();
        for (MinatDTO m : minats) {
            listMinat.add(m.getNamaMinat());
        }
        ketrampilans = ketrampilanService.findAll();
        for (KetrampilanDTO k : ketrampilans) {
            listKetrampilan.add(k.getNamaKetrampilan());
        }
        civitass = civitasService.findAll();
        for (CivitasDTO c : civitass) {
            listCivitas.add(c.getNamaCivitas());
        }
        jurusans = jurusanService.findAll();
        for (JurusanDTO j : jurusans) {
            listJurusan.add(j.getNamaJurusan());
        }
        domisilis = domisiliService.findAll();
        for (DomisiliDTO d : domisilis) {
            listDomisili.add(d.getNamaKabupaten());
        }
    }

    private void checkValidity(UserDTO user, PageNavigation previous) {
        if (user == null) {
            ListModelList<UserDTO> parameterList = new ListModelList<>(userService.findAllMahasiswa(3));
            userDTO = new UserDTOBuilder()
                    .setCreationalBy(SecurityUtil.getUserName())
                    .setCreationalDate(new Date())
                    .createUserDTO();
        } else {
            this.userDTO = user;
            userID = user.getUserID();
            mediaNameUploadCV = user.getUserSpecificationDTO().getUploadCV();
            this.previous = previous;
        }
    }
    /*------------------------------------- Button-------------------------------------------*/

    @Command("searchRegMahasiswa")
    @NotifyChange("userDTOs")
    public void searchRegMahasiswa(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;
        Map params = new HashMap();
        params.put("ktp", ktp);
        count = checkCountParameter(count, ktp);
        params.put("fullName", fullName);
        count = checkCountParameter(count, fullName);
        params.put("domisiliSelect", domisiliSelect);
        count = checkCountParameter(count, domisiliSelect);
        params.put("minatSelect", minatSelect);
        count = checkCountParameter(count, minatSelect);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        userDTOs = userService.findByParamsMap(params);
    }

    @Command("detailRegMahasiswa")
    @NotifyChange("userDTO")
    public void detailRegMahasiswa(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/register/detail_akun.zul", window, params);
    }

    @Command("buttonKlikPreviewCV")
    @NotifyChange({"src", "userDTOs", "user"})
    public void buttonKlikPreviewCV(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/dataRegister/previewCV.zul", window, params);
    }

    @Command("buttonClosePreview")
    @NotifyChange("userDTOs")
    public void buttonClosePreview(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("userDTOs")
    public void refreshLowongan() {
        userDTOs = userService.findAllMahasiswa(3);
    }

    @Command("buttonKembali")
    @NotifyChange("userDTO")
    public void buttonKembali(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    /*--------------------------------------------------------- Aksi Update Profile ---------------------------------------------------------*/
    @Command("buttonDetailProfil")
    @NotifyChange("userDTO")
    public void buttonDetailProfil(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/register/update_profile.zul", window, params);
    }

    @Command("buttonUpdateProfile")
    @NotifyChange({"userDTO", "userDTO2s"})
    public void buttonUpdateProfile(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (pathLocationUploadCV == null) {
            pathLocationUploadCV = userDTO.getUserSpecificationDTO().getUploadCV();
        }
        userDTO.getUserSpecificationDTO().setUploadCV(pathLocationUploadCV);
        userService.saveOrUpdate(userDTO);
        showInformationMessagebox("Update Profile Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshUsers", null);
        window.detach();
    }

    @Command("uploadFileCV")
    @NotifyChange({"mediaNameUploadCV", "pathLocationUploadCV"})
    public void uploadFileCV(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaUploadCV = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filepathUploadCV = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filepathUploadCV = filepathUploadCV + "\\" + "files" + "\\" + "crm-cv" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filepathUploadCV);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            Files.copy(new File(filepathUploadCV + mediaUploadCV.getName()), mediaUploadCV.getStreamData());
            setMediaNameUploadCV(filepathUploadCV + mediaUploadCV.getName());
            pathLocationUploadCV = "/" + "files" + "/" + "crm-cv" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadCV.getName();
        } else {
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            mediaNameUploadCV = "";
            pathLocationUploadCV = "/" + "files" + "/" + "crm-cv" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadCV.getName();
            Messagebox.show("File : " + mediaUploadCV + " Bukan File PDF", "Error", Messagebox.OK, Messagebox.ERROR);
        }

    }

    @GlobalCommand
    @NotifyChange("userDTO2s")
    public void refreshUsers() {
        userDTO2s = userService.findByUsername(SecurityUtil.getUserName());
    }

    /*------------------------------------- Getter&Set---------------------------------------*/
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

    public List<DomisiliDTO> getDomisilis() {
        return domisilis;
    }

    public void setDomisilis(List<DomisiliDTO> domisilis) {
        this.domisilis = domisilis;
    }

    public List<MinatDTO> getMinats() {
        return minats;
    }

    public void setMinats(List<MinatDTO> minats) {
        this.minats = minats;
    }

    public List<String> getListMinat() {
        return listMinat;
    }

    public void setListMinat(List<String> listMinat) {
        this.listMinat = listMinat;
    }

    public List<String> getListDomisili() {
        return listDomisili;
    }

    public void setListDomisili(List<String> listDomisili) {
        this.listDomisili = listDomisili;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getDomisiliSelect() {
        return domisiliSelect;
    }

    public void setDomisiliSelect(String domisiliSelect) {
        this.domisiliSelect = domisiliSelect;
    }

    public String getMinatSelect() {
        return minatSelect;
    }

    public void setMinatSelect(String minatSelect) {
        this.minatSelect = minatSelect;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public int getPageSizeCreateLowongan() {
        return pageSizeCreateLowongan;
    }

    public void setPageSizeCreateLowongan(int pageSizeCreateLowongan) {
        this.pageSizeCreateLowongan = pageSizeCreateLowongan;
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

    public String getFilepathUploadCV() {
        return filepathUploadCV;
    }

    public void setFilepathUploadCV(String filepathUploadCV) {
        this.filepathUploadCV = filepathUploadCV;
    }

    public String getPathLocationUploadCV() {
        return pathLocationUploadCV;
    }

    public void setPathLocationUploadCV(String pathLocationUploadCV) {
        this.pathLocationUploadCV = pathLocationUploadCV;
    }

    public Media getMediaUploadCV() {
        return mediaUploadCV;
    }

    public void setMediaUploadCV(Media mediaUploadCV) {
        this.mediaUploadCV = mediaUploadCV;
    }

    public String getMediaNameUploadCV() {
        return mediaNameUploadCV;
    }

    public void setMediaNameUploadCV(String mediaNameUploadCV) {
        this.mediaNameUploadCV = mediaNameUploadCV;
    }

    public ListModelList<JenisKelaminType> getJenisKelaminTypes() {
        return new ListModelList<>(JenisKelaminType.values());
    }

    public void setJenisKelaminTypes(ListModelList<JenisKelaminType> jenisKelaminTypes) {
        this.jenisKelaminTypes = jenisKelaminTypes;
    }

    public ListModelList<PendidikanType> getPendidikanTypes() {
        return new ListModelList<>(PendidikanType.values());
    }

    public void setPendidikanTypes(ListModelList<PendidikanType> pendidikanTypes) {
        this.pendidikanTypes = pendidikanTypes;
    }

    public List<String> getListKetrampilan() {
        return listKetrampilan;
    }

    public void setListKetrampilan(List<String> listKetrampilan) {
        this.listKetrampilan = listKetrampilan;
    }

    public List<String> getListCivitas() {
        return listCivitas;
    }

    public void setListCivitas(List<String> listCivitas) {
        this.listCivitas = listCivitas;
    }

    public List<String> getListJurusan() {
        return listJurusan;
    }

    public void setListJurusan(List<String> listJurusan) {
        this.listJurusan = listJurusan;
    }

    public ListModelList<TingkatanType> getTingkatanTypes1() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes1(ListModelList<TingkatanType> tingkatanTypes1) {
        this.tingkatanTypes1 = tingkatanTypes1;
    }

    public ListModelList<TingkatanType> getTingkatanTypes2() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes2(ListModelList<TingkatanType> tingkatanTypes2) {
        this.tingkatanTypes2 = tingkatanTypes2;
    }

    public ListModelList<TingkatanType> getTingkatanTypes3() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes3(ListModelList<TingkatanType> tingkatanTypes3) {
        this.tingkatanTypes3 = tingkatanTypes3;
    }

    public ListModelList<TingkatanType> getTingkatanTypes4() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes4(ListModelList<TingkatanType> tingkatanTypes4) {
        this.tingkatanTypes4 = tingkatanTypes4;
    }

    public ListModelList<TingkatanType> getTingkatanTypes5() {
        return new ListModelList<>(TingkatanType.values());
    }

    public void setTingkatanTypes5(ListModelList<TingkatanType> tingkatanTypes5) {
        this.tingkatanTypes5 = tingkatanTypes5;
    }

    public List<KetrampilanDTO> getKetrampilans() {
        return ketrampilans;
    }

    public void setKetrampilans(List<KetrampilanDTO> ketrampilans) {
        this.ketrampilans = ketrampilans;
    }

    public List<JurusanDTO> getJurusans() {
        return jurusans;
    }

    public void setJurusans(List<JurusanDTO> jurusans) {
        this.jurusans = jurusans;
    }

    public List<CivitasDTO> getCivitass() {
        return civitass;
    }

    public void setCivitass(List<CivitasDTO> civitass) {
        this.civitass = civitass;
    }

    public String getJurusanSelect() {
        return jurusanSelect;
    }

    public void setJurusanSelect(String jurusanSelect) {
        this.jurusanSelect = jurusanSelect;
    }

    public String getKetrampilanSelect() {
        return ketrampilanSelect;
    }

    public void setKetrampilanSelect(String ketrampilanSelect) {
        this.ketrampilanSelect = ketrampilanSelect;
    }

    public String getCivitasSelect() {
        return civitasSelect;
    }

    public void setCivitasSelect(String civitasSelect) {
        this.civitasSelect = civitasSelect;
    }

    public List<UserDTO> getUserDTO2s() {
        return userDTO2s;
    }

    public void setUserDTO2s(List<UserDTO> userDTO2s) {
        this.userDTO2s = userDTO2s;
    }

}
