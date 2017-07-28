package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.application.LowonganStatusService;
import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.application.RiwayatApplyMahasiswaService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.LowonganDTOBuilder;
import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTO;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.state.LowonganState;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.util.CommonUtil;
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
import org.zkoss.zk.ui.event.Event;
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
public class LowonganVM {

    /* Import Service */
    @WireVariable
    LowonganService lowonganService;

    @WireVariable
    MinatService minatService;

    @WireVariable
    UserService userService;

    @WireVariable
    RiwayatApplyMahasiswaService riwayatApplyMahasiswaService;

    @WireVariable
    LowonganStatusService lowonganStatusService;

    /* Object Binding for Form CRM */
    private UserDTO user;
    private UserSpecificationDTO userSpecificationDTO;

    private UserDTO userDTO = new UserDTO();
    private LowonganDTO lowonganDTO = new LowonganDTO();
    private RiwayatApplyMahasiswaDTO riwayatApplyMahasiswaDTO;
    private LowonganStatusDTO lowonganStatusDTO;

    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<String> listNamaMinat = new ArrayList<>();
    private List<LowonganDTO> lowonganDTOs = new ArrayList();
    private List<MinatDTO> minats = new ArrayList<MinatDTO>();
    private List<RiwayatApplyMahasiswaDTO> riwayatApplyMahasiswaDTOs = new ArrayList<>();
    private List<LowonganStatusDTO> lowonganStatusDTOs = new ArrayList<>();

    /* Function For Combobox  */
    private ListModelList<String> gaji = new ListModelList<>();

    /* Function For Seacrh  */
    private String userID;
    private Date tanggalBerakhir;
    private String namaLowongan;
    private String idLowonganParams;
    private String minatPekerjaan;
    private String namaLowonganApply;
    private String namaLengkap;
    private String namaApplyLowongan;
    private String idRiwayatApplyMahasiswa;
    private String idLowonganStatus;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 2;
    private int pageSizeCreateLowongan = 7;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    /* Paramater Objek Lowongan */
    private String idLowongan;

    /* Function For Objek Disable  */
    private boolean disableButtonSave;
    private boolean disableButtonApply;

    @Init
    public void init(
            @ExecutionArgParam("lowonganDTO") LowonganDTO lowongan,
            @ExecutionArgParam("userDTO") UserDTO user,
            @ExecutionArgParam("riwayatApplyMahasiswaDTO") RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(lowongan, user, riwayatApplyMahasiswa, previous);
    }

    private void initData() {

        lowonganDTOs = lowonganService.findAll();
        if (lowonganDTOs.isEmpty()) {
            lowonganDTOs = Collections.emptyList();
        }

        userDTO = userService.findByID(SecurityUtil.getUserName());
        Map<String, Object> map = new HashMap();
        map.put("idUserRiwayat", userDTO.getUserID());
        riwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaService.findByParams(map);
        if (riwayatApplyMahasiswaDTOs.isEmpty()) {
            riwayatApplyMahasiswaDTOs = Collections.emptyList();
        }

        lowonganStatusDTOs = lowonganStatusService.findAll();
        if (lowonganStatusDTOs.isEmpty()) {
            lowonganStatusDTOs = Collections.emptyList();
        }

        gaji.add(" < Rp 1.000.000");
        gaji.add("Rp 1.000.000 - Rp 3.000.000");
        gaji.add("Rp 3.000.000 - Rp 5.000.000");
        gaji.add("Rp 5.000.000 - Rp 7.000.000");
        gaji.add("Rp 7.000.000 - Rp 9.000.000");
        gaji.add("Rp 9.000.000 - Rp 11.000.000");
        gaji.add("Rp 11.000.000 - Rp 13.000.000");
        gaji.add("Rp 13.000.000 - Rp 15.000.000");
        gaji.add(" > Rp 15.000.000");

        minats = minatService.findAll();
        for (MinatDTO m : minats) {
            listNamaMinat.add(m.getNamaMinat());
        }

        user = userService.findByID(SecurityUtil.getUserName());

        user = userService.findByID(SecurityUtil.getUserName());
        if (user.getRoleDTO().getRoleID().contains("MAHASISWA")) {
            disableButtonSave = true;
        } else {
            disableButtonSave = false;
        }

    }

    private void checkValidity(LowonganDTO lowongan, UserDTO user, RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa, PageNavigation previous) {
        if (lowongan == null) {
            ListModelList<LowonganDTO> parameterList = new ListModelList<>(lowonganService.findAll());
            String idLowongan = "";
            if (parameterList.isEmpty()) {
                idLowongan = "L001";
            } else {
                idLowongan = getLatestObjectID(parameterList, "idLowongan");
            }
            lowonganDTO = new LowonganDTOBuilder()
                    .setIdLowongan(idLowongan)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createLowonganDTO();
        } else {
            this.lowonganDTO = lowongan;
            idLowongan = lowonganDTO.getIdLowongan();
            this.previous = previous;
        }

        if (user == null) {
//            ListModelList<UserDTO> parameterList = new ListModelList<>(userService.findAllUser());
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
        if (riwayatApplyMahasiswa == null) {
            ListModelList<RiwayatApplyMahasiswaDTO> parameterRAM = new ListModelList<>(riwayatApplyMahasiswaService.findAll());
            String idRiwayatApplyMahasiswa = "";
            if (parameterRAM.isEmpty()) {
                idRiwayatApplyMahasiswa = "RAM0001";
            } else {
                idRiwayatApplyMahasiswa = getLatestObjectID(parameterRAM, "idRiwayatApplyMahasiswa");
            }
            riwayatApplyMahasiswaDTO = new RiwayatApplyMahasiswaDTOBuilder()
                    .setIdRiwayatApplyMahasiswa(idRiwayatApplyMahasiswa)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createRiwayatApplyMahasiswaDTO();
        } else {
            this.riwayatApplyMahasiswaDTO = riwayatApplyMahasiswa;
            idRiwayatApplyMahasiswa = riwayatApplyMahasiswaDTO.getIdRiwayatApplyMahasiswa();
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

    /*---------------------------------------------------------------Lowongan Fungstionality-------------------------------------------------*/
    @Command("buttonRiwayatLowongan")
    @NotifyChange("riwayatApplyMahasiswaDTO")
    public void buttonRiwayatLowongan(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params1 = new HashMap();
        params1.put("riwayatApplyMahasiswaDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/riwayat_apply_lowongan.zul", window, params1);
    }

    @Command("buttonViewDataPribadi")
    @NotifyChange("mahasiswaDTO")
    public void buttonViewDataPribadi(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("lowonganDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/riwayat_apply_lowongan.zul", window, params);
    }

    @Command("buttonCancelRiwayatLowongan")
    @NotifyChange("lowonganDTO")
    public void buttonCancelRiwayatLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    /* Function button klik create lowongan */
    @Command("buttonKlikCreateLowongan")
    @NotifyChange("lowonganDTO")
    public void buttonKlikCreateLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("lowonganDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/lowongan/create_lowongan.zul", window, params);
    }

    @Command("buttonKembaliLowongan")
    @NotifyChange("lowonganDTO")
    public void buttonKembaliLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("searchLowongan")
    @NotifyChange("lowonganDTOs")
    public void searchKetrampilan(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idLowongan", idLowongan);
        params.put("namaLowongan", namaLowongan);
        params.put("tanggalBerakhir", tanggalBerakhir);
        params.put("minatPekerjaan", minatPekerjaan);

        lowonganDTOs = lowonganService.findByParams(params);
    }

    @Command("buttonSaveLowongan")
    @NotifyChange({"lowonganDTO", "lowonganDTOs"})
    public void buttonSaveKetrampilan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        lowonganService.SaveOrUpdate(lowonganDTO);
        showInformationMessagebox("Data Lowongan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
        window.detach();
    }

    @Command("buttonDetailLowongan")
    @NotifyChange("lowonganDTO")
    public void buttonDetailLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("lowonganDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/lowongan/create_lowongan.zul", window, params);
    }

    @Command("buttonKonfirmasiApplyLowongan")
    @NotifyChange({"lowonganDTO", "lowonganDTOs"})
    public void buttonKonfirmasiApplyLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        String message = "";
        riwayatApplyMahasiswaDTO.setIdRiwayatLowongan(idLowongan);
        riwayatApplyMahasiswaDTO.setNamaLowonganApply(lowonganDTO.getNamaLowongan());
        riwayatApplyMahasiswaDTO.setNamaApplyLowongan(user.getUserSpecificationDTO().getFullName());
        riwayatApplyMahasiswaDTO.setIdUserRiwayat(user.getUserID());
        riwayatApplyMahasiswaDTO.setLowonganState(LowonganState.APPLY);
        riwayatApplyMahasiswaService.SaveOrUpdate(riwayatApplyMahasiswaDTO);
        message = "Konfirmasi Lowongan Berhasil Di Apply";

        showInformationMessagebox(message);
        BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
        window.detach();
    }

    @Command("buttonApplyLowongan")
    @NotifyChange({"lowonganDTO", "lowonganDTOs"})
    public void buttonApplyLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
        Map<String, Object> params = new HashMap<>();
        params.put("lowonganDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/popup_apply_lowongan.zul", window, params);
    }

    @GlobalCommand
    @NotifyChange("lowonganDTOs")
    public void refreshLowongan() {
        lowonganDTOs = lowonganService.findAll();
    }

    @Command("deleteLowongan")
    @NotifyChange("lowonganDTOs")
    public void deletePetunjuk(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        lowonganDTO = (LowonganDTO) obj;
        Messagebox.show("Apakah anda yakin ingin menghapus Lowongan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    lowonganService.deleteData(lowonganDTO);
                    showInformationMessagebox("Lowongan Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
                } else {
                    System.out.println("Operation Canceled !");
                }
            }
        }
        );
    }

    /* --------------------------------------------- for data apply functionality ---------------------------------------------------*/
    @Command("detailMahasiswa")
    @NotifyChange("userDTOs")
    public void detailMahasiswa(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/dataApplyLowongan/dashboard_applicant.zul", window, params);
    }

    @Command("KlikDataPelamar")
    @NotifyChange({"userDTO", "userDTOs", "lowonganDTO", "lowonganDTOs", "riwayatApplyMahasiswaDTOs", "riwayatApplyMahasiswaDTO"})
    public void KlikDataPelamar(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("lowonganDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/dataApplyLowongan/dashboard_pelamar.zul", window, params);
    }

    @Command("KlikDetailDataPelamar")
    @NotifyChange({"userDTO", "userDTOs", "lowonganDTO", "lowonganDTOs", "riwayatApplyMahasiswaDTOs", "riwayatApplyMahasiswaDTO"})
    public void KlikDetailDataPelamar(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (obj.getNamaApplyLowongan() != null) {
            userDTO = userService.findByFullName(obj.getNamaApplyLowongan());
        }

    }

//    @Command("AddDetailApplicant")
//    @NotifyChange({"userDTO", "userDTOs", "lowonganDTO", "lowonganDTOs"})
//    public void AddDetailApplicant(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("userDTO", obj);
////        CommonViewModel.navigateToWithoutDetach("/crm/admin/applicant/dummy.zul", window, params);
//    }
    @Command("buttonBackApplicant")
    @NotifyChange({"lowonganDTO", "userDTOs"})
    public void buttonBackApplicant(@BindingParam("object") LowonganDTO obj, UserDTO obj2, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    /*-------------------------------------------------------------------- Data Profile Mahasiswa-------------------------------------------------------*/
    @Command("detailProfileMahasiswa")
    @NotifyChange("user")
    public void detailProfileMahasiswa(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        mahasiswaDTO.setIdMahasiswa(idMahasiswa);
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/registrasi_mahasiswa.zul", window, params);
    }

    @Command("detail")
    @NotifyChange("user")
    public void detail(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
//        mahasiswaDTO.setIdMahasiswa(idMahasiswa);
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/grid_profile.zul", window, params);
    }


    /* getter setter */
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LowonganDTO getLowonganDTO() {
        return lowonganDTO;
    }

    public void setLowonganDTO(LowonganDTO lowonganDTO) {
        this.lowonganDTO = lowonganDTO;
    }

    public List<String> getListNamaMinat() {
        return listNamaMinat;
    }

    public void setListNamaMinat(List<String> listNamaMinat) {
        this.listNamaMinat = listNamaMinat;
    }

    public RiwayatApplyMahasiswaDTO getRiwayatApplyMahasiswaDTO() {
        return riwayatApplyMahasiswaDTO;
    }

    public void setRiwayatApplyMahasiswaDTO(RiwayatApplyMahasiswaDTO riwayatApplyMahasiswaDTO) {
        this.riwayatApplyMahasiswaDTO = riwayatApplyMahasiswaDTO;
    }

    public LowonganStatusDTO getLowonganStatusDTO() {
        return lowonganStatusDTO;
    }

    public void setLowonganStatusDTO(LowonganStatusDTO lowonganStatusDTO) {
        this.lowonganStatusDTO = lowonganStatusDTO;
    }

    public List<LowonganDTO> getLowonganDTOs() {
        return lowonganDTOs;
    }

    public void setLowonganDTOs(List<LowonganDTO> lowonganDTOs) {
        this.lowonganDTOs = lowonganDTOs;
    }

    public List<MinatDTO> getMinats() {
        return minats;
    }

    public void setMinats(List<MinatDTO> minats) {
        this.minats = minats;
    }

    public List<RiwayatApplyMahasiswaDTO> getRiwayatApplyMahasiswaDTOs() {
        return riwayatApplyMahasiswaDTOs;
    }

    public void setRiwayatApplyMahasiswaDTOs(List<RiwayatApplyMahasiswaDTO> riwayatApplyMahasiswaDTOs) {
        this.riwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaDTOs;
    }

    public List<LowonganStatusDTO> getLowonganStatusDTOs() {
        return lowonganStatusDTOs;
    }

    public void setLowonganStatusDTOs(List<LowonganStatusDTO> lowonganStatusDTOs) {
        this.lowonganStatusDTOs = lowonganStatusDTOs;
    }

    public ListModelList<String> getGaji() {
        return gaji;
    }

    public void setGaji(ListModelList<String> gaji) {
        this.gaji = gaji;
    }

    public Date getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public void setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    public String getNamaLowongan() {
        return namaLowongan;
    }

    public void setNamaLowongan(String namaLowongan) {
        this.namaLowongan = namaLowongan;
    }

    public String getIdLowonganParams() {
        return idLowonganParams;
    }

    public void setIdLowonganParams(String idLowonganParams) {
        this.idLowonganParams = idLowonganParams;
    }

    public String getMinatPekerjaan() {
        return minatPekerjaan;
    }

    public void setMinatPekerjaan(String minatPekerjaan) {
        this.minatPekerjaan = minatPekerjaan;
    }

    public String getNamaLowonganApply() {
        return namaLowonganApply;
    }

    public void setNamaLowonganApply(String namaLowonganApply) {
        this.namaLowonganApply = namaLowonganApply;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaApplyLowongan() {
        return namaApplyLowongan;
    }

    public void setNamaApplyLowongan(String namaApplyLowongan) {
        this.namaApplyLowongan = namaApplyLowongan;
    }

    public String getIdRiwayatApplyMahasiswa() {
        return idRiwayatApplyMahasiswa;
    }

    public void setIdRiwayatApplyMahasiswa(String idRiwayatApplyMahasiswa) {
        this.idRiwayatApplyMahasiswa = idRiwayatApplyMahasiswa;
    }

    public String getIdLowonganStatus() {
        return idLowonganStatus;
    }

    public void setIdLowonganStatus(String idLowonganStatus) {
        this.idLowonganStatus = idLowonganStatus;
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

    public String getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
    }

    public boolean isDisableButtonSave() {
        return disableButtonSave;
    }

    public void setDisableButtonSave(boolean disableButtonSave) {
        this.disableButtonSave = disableButtonSave;
    }

    public boolean isDisableButtonApply() {
        return disableButtonApply;
    }

    public void setDisableButtonApply(boolean disableButtonApply) {
        this.disableButtonApply = disableButtonApply;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
