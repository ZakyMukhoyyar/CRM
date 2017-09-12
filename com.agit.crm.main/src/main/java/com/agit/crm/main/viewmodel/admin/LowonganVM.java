package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.application.LowonganStatusService;
import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.application.RiwayatApplyMahasiswaService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.LowonganDTOBuilder;
import com.agit.crm.common.dto.crm.LowonganStatusDTO;
import com.agit.crm.common.dto.crm.LowonganStatusDTOBuilder;
import com.agit.crm.common.dto.crm.MinatDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTO;
import com.agit.crm.common.dto.crm.RiwayatApplyMahasiswaDTOBuilder;
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
    private List<LowonganDTO> lowonganDTOs2 = new ArrayList();
    private List<MinatDTO> minats = new ArrayList<MinatDTO>();
    private List<RiwayatApplyMahasiswaDTO> riwayatApplyMahasiswaDTOs = new ArrayList<>();
    private List<RiwayatApplyMahasiswaDTO> listRiwayatApplyMahasiswaDTOs = new ArrayList<>();
    private List<LowonganStatusDTO> lowonganStatusDTOs = new ArrayList<>();
    private List<String> listLowonganID = new ArrayList<String>();
    private ListModelList<LowonganState> lowonganStates;
    private ListModelList<Status> statuses;

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
    private String idRiwayatLowongan;
    private LowonganState lowonganState;
    private Status status;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 5;
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
            @ExecutionArgParam("lowonganStatusDTO") LowonganStatusDTO LowonganStatus,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(lowongan, user, riwayatApplyMahasiswa, LowonganStatus, previous);
    }

    private void initData() {

        lowonganDTOs = lowonganService.findAll();
        if (lowonganDTOs.isEmpty()) {
            lowonganDTOs = Collections.emptyList();
        }

        lowonganDTOs2 = lowonganService.findAllByStatus(status.ACTIVE);

        for (LowonganDTO m : lowonganDTOs) {
            listLowonganID.add(m.getIdLowongan());
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
        minats = minatService.findAll();
        for (MinatDTO m : minats) {
            listNamaMinat.add(m.getNamaMinat());
        }

        user = userService.findByID(SecurityUtil.getUserName());
        if (user.getRoleDTO().getRoleID().contains("MAHASISWA")) {
            disableButtonSave = true;
        } else {
            disableButtonSave = false;
        }
    }

    private void checkValidity(LowonganDTO lowongan, UserDTO user, RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa, LowonganStatusDTO lowonganStatus, PageNavigation previous) {
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
        /* Validity Lowongan Status */
        if (lowonganStatus == null) {
            ListModelList<LowonganStatusDTO> parameterLS = new ListModelList<>(lowonganStatusService.findAll());
            String idLowonganStatus = "";
            if (parameterLS.isEmpty()) {
                idLowonganStatus = "LS001";
            } else {
                idLowonganStatus = getLatestObjectID(parameterLS, "idLowonganStatus");
            }
            lowonganStatusDTO = new LowonganStatusDTOBuilder()
                    .setIdLowonganStatus(idLowonganStatus)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createLowonganStatusDTO();
        } else {
            this.lowonganStatusDTO = lowonganStatus;
            idLowonganStatus = lowonganStatusDTO.getIdLowonganStatus();
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
        params.put("status", status);
        lowonganDTOs = lowonganService.findByParams(params);
    }

    @Command("buttonSaveLowongan")
    @NotifyChange({"lowonganDTO", "lowonganDTOs"})
    public void buttonSaveKetrampilan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Date tanggalMulai = lowonganDTO.getTanggalMulai();
        Date tanggalBerakhir = lowonganDTO.getTanggalBerakhir();

        if (tanggalMulai != null && tanggalBerakhir != null && tanggalBerakhir.compareTo(tanggalMulai) < 0) {
            Messagebox.show("Format tanggal mulai dan tanggal berakhir salah");
        } else {
            lowonganDTO.setStatus(Status.ACTIVE);
            lowonganService.SaveOrUpdate(lowonganDTO);
            showInformationMessagebox("Data Lowongan Berhasil Disimpan");
            BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
            window.detach();
        }
    }

    @Command("buttonSearchLowonganMahasiswa")
    @NotifyChange("lowonganDTOs")
    public void buttonSearchLowonganMahasiswa(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idLowongan", idLowongan);
        params.put("namaLowongan", namaLowongan);
        params.put("minatPekerjaan", minatPekerjaan);
        params.put("status", status);
        lowonganDTOs = lowonganService.findByParams(params);
    }

    @Command("buttonSearchLowonganMahasiswa2")
    @NotifyChange("lowonganDTOs2")
    public void buttonSearchLowonganMahasiswa2(@ContextParam(ContextType.VIEW) Window window) {
        Map params = new HashMap();
        params.put("idLowongan", idLowongan);
        params.put("namaLowongan", namaLowongan);
        params.put("minatPekerjaan", minatPekerjaan);
        params.put("status", status.ACTIVE);
        lowonganDTOs2 = lowonganService.findByParams(params);
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
        riwayatApplyMahasiswaDTO.setLowonganState(LowonganState.APPLY);
        riwayatApplyMahasiswaDTO.setIdUserRiwayat(user.getUserID());
        riwayatApplyMahasiswaService.SaveOrUpdate(riwayatApplyMahasiswaDTO);

        lowonganStatusDTO.setIdLowongan(idLowongan);
        lowonganStatusDTO.setIdUser(user.getUserID());
        lowonganStatusDTO.setLowonganState(LowonganState.APPLY);
        lowonganStatusService.saveOrUpdate(lowonganStatusDTO);

        BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
        window.detach();
    }

    @Command("buttonApplyLowongan")
    @NotifyChange({"lowonganDTO", "lowonganDTOs"})
    public void buttonApplyLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        userDTO = userService.findByID(SecurityUtil.getUserName());
        Map map = new HashMap();
        map.put("idUser", userDTO.getUserID());
        map.put("idLowongan", obj.getIdLowongan());
        lowonganStatusDTOs = lowonganStatusService.findByParams2(map);
        if (lowonganStatusDTOs.isEmpty()) {
            BindUtils.postGlobalCommand(null, null, "refreshLowongan", null);
            Map<String, Object> params = new HashMap<>();
            params.put("lowonganDTO", obj);
            CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/popup_apply_lowongan.zul", window, params);
        } else {
            showInformationMessagebox("Anda Sudah Pernah Apply Lowongan Ini");
        }
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

    public int checkCount(int count, Object object) {
        if (StringUtil.hasValue(object)) {
            count += 1;
        }
        return count;
    }
    /* --------------------------------------------- for data pelamar functionality ---------------------------------------------------*/

    @Command("searchPelamar")
    @NotifyChange("listRiwayatApplyMahasiswaDTOs")
    public void searchPelamar(@ContextParam(ContextType.VIEW) Window window) {
        int count = 0;
        Map params = new HashMap();
        params.put("idRiwayatLowongan", idRiwayatLowongan);
        count = checkCount(count, idRiwayatLowongan);
        params.put("namaLowonganApply", namaLowonganApply);
        count = checkCount(count, namaLowonganApply);
        params.put("namaApplyLowongan", namaApplyLowongan);
        count = checkCount(count, namaApplyLowongan);
        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        listRiwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaService.findByParams(params);
    }

    @Command("KlikDetailDataPelamar")
    @NotifyChange({"userDTO", "userDTOs", "lowonganDTO", "lowonganDTOs", "riwayatApplyMahasiswaDTOs", "riwayatApplyMahasiswaDTO"})
    public void KlikDetailDataPelamar(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (obj.getIdUserRiwayat() != null) {
            userDTO = userService.findByUserID(obj.getIdUserRiwayat());
        }
    }

    @Command("KlikStatusPelamar")
    @NotifyChange({"userDTO", "userDTOs", "lowonganDTO", "lowonganDTOs", "riwayatApplyMahasiswaDTOs", "riwayatApplyMahasiswaDTO"})
    public void KlikStatusPelamar(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> map = new HashMap<>();
        map.put("riwayatApplyMahasiswaDTO", obj);
        riwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaService.findByParams(map);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/dataApplyLowongan/popup_status_pelamar.zul", window, map);
    }

    @Command("buttonKembaliStatusPelamar")
    @NotifyChange("RiwayatApplyMahasiswaDTO")
    public void buttonKembaliStatusPelamar(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

//    @NotifyChange({"riwayatApplyMahasiswaDTO","riwayatApplyMahasiswaDTOs"})
    @Command("buttonSimpanStatusPelamar")
    @NotifyChange({"listRiwayatApplyMahasiswaDTOs", "riwayatApplyMahasiswaDTO", "riwayatApplyMahasiswaDTOs"})
    public void buttonSimpanStatusPelamar(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        riwayatApplyMahasiswaDTO.setLowonganState(lowonganState);
        riwayatApplyMahasiswaService.SaveOrUpdate(riwayatApplyMahasiswaDTO);
        showInformationMessagebox("Data Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshRAM", null);
        window.detach();
    }

    /*-------------------------------------------------------------------- Data Profile Mahasiswa-------------------------------------------------------*/
    @Command("detailProfileMahasiswa")
    @NotifyChange("user")
    public void detailProfileMahasiswa(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/registrasi_mahasiswa.zul", window, params);
    }

    @Command("detail")
    @NotifyChange("user")
    public void detail(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/grid_profile.zul", window, params);
    }

    public String concatStateLowongan(String s1, String s2) {
        return s1.concat(s2);
    }

    @GlobalCommand
    @NotifyChange("lowonganDTOs")
    public void refreshLowongan() {
        lowonganDTOs = lowonganService.findAll();
    }

    @GlobalCommand
    @NotifyChange({"riwayatApplyMahasiswaDTOs", "listRiwayatApplyMahasiswaDTOs"})
    public void refreshRAM() {
        riwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaService.findAll();
    }


    /*-------------------------------------------------------------------- getter setter --------------------------------------------------------------------*/
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

    public List<RiwayatApplyMahasiswaDTO> getListRiwayatApplyMahasiswaDTOs() {
        return listRiwayatApplyMahasiswaDTOs;
    }

    public void setListRiwayatApplyMahasiswaDTOs(List<RiwayatApplyMahasiswaDTO> listRiwayatApplyMahasiswaDTOs) {
        this.listRiwayatApplyMahasiswaDTOs = listRiwayatApplyMahasiswaDTOs;
    }

    public String getIdRiwayatLowongan() {
        return idRiwayatLowongan;
    }

    public void setIdRiwayatLowongan(String idRiwayatLowongan) {
        this.idRiwayatLowongan = idRiwayatLowongan;
    }

    public List<String> getListLowonganID() {
        return listLowonganID;
    }

    public void setListLowonganID(List<String> listLowonganID) {
        this.listLowonganID = listLowonganID;
    }

    public ListModelList<LowonganState> getLowonganStates() {
        return new ListModelList<>(LowonganState.values());
    }

    public void setLowonganStates(ListModelList<LowonganState> lowonganStates) {
        this.lowonganStates = lowonganStates;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<LowonganDTO> getLowonganDTOs2() {
        return lowonganDTOs2;
    }

    public void setLowonganDTOs2(List<LowonganDTO> lowonganDTOs2) {
        this.lowonganDTOs2 = lowonganDTOs2;
    }

}
