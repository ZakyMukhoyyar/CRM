package com.agit.crm.main.viewmodel.recruiter;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.application.MinatService;
import com.agit.crm.common.application.RiwayatApplyMahasiswaService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.LowonganDTOBuilder;
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
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
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
public class RecruiterVM {
    /* Import Service */

    @WireVariable
    LowonganService lowonganService;

    @WireVariable
    MinatService minatService;

    @WireVariable
    UserService userService;

    @WireVariable
    RiwayatApplyMahasiswaService riwayatApplyMahasiswaService;


    /* Object Binding for Form CRM */
    private UserDTO user;
    private UserSpecificationDTO userSpecificationDTO;

    private UserDTO userDTO = new UserDTO();
    private LowonganDTO lowonganDTO = new LowonganDTO();
    private RiwayatApplyMahasiswaDTO riwayatApplyMahasiswaDTO;

    private List<UserDTO> userDTOs = new ArrayList<>();
    private List<String> listNamaMinat = new ArrayList<>();
    private List<LowonganDTO> lowonganDTOs = new ArrayList();
    private List<MinatDTO> minats = new ArrayList<MinatDTO>();
    private List<RiwayatApplyMahasiswaDTO> riwayatApplyMahasiswaDTOs = new ArrayList<>();
    private List<RiwayatApplyMahasiswaDTO> listRiwayatApplyMahasiswaDTOs = new ArrayList<>();
    private List<String> listLowonganID = new ArrayList<String>();
    private ListModelList<LowonganState> lowonganStates;

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

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 5;
    private int pageSizeCreateLowongan = 7;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    /* Paramater Objek Lowongan */
    private String idLowongan;

    @Init
    public void init(
            @ExecutionArgParam("lowonganDTO") LowonganDTO lowongan,
            @ExecutionArgParam("userDTO") UserDTO user,
            @ExecutionArgParam("riwayatApplyMahasiswaDTO") RiwayatApplyMahasiswaDTO riwayatApplyMahasiswa,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(lowongan, user, riwayatApplyMahasiswa ,previous);
    }

    private void initData() {

        lowonganDTOs = lowonganService.findAll();
        if (lowonganDTOs.isEmpty()) {
            lowonganDTOs = Collections.emptyList();
        }
        for (LowonganDTO m : lowonganDTOs) {
            listLowonganID.add(m.getNamaLowongan());
        }

        userDTO = userService.findByID(SecurityUtil.getUserName());
        Map<String, Object> map = new HashMap();
        map.put("idUserRiwayat", userDTO.getUserID());
        riwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaService.findByParams(map);
        if (riwayatApplyMahasiswaDTOs.isEmpty()) {
            riwayatApplyMahasiswaDTOs = Collections.emptyList();
        }

        minats = minatService.findAll();
        for (MinatDTO m : minats) {
            listNamaMinat.add(m.getNamaMinat());
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


    /* ==================== for Dashboard Recruiter Functional ==================== */
    @Command("KlikDetailDataPelamar")
    @NotifyChange({"userDTO", "userDTOs", "lowonganDTO", "lowonganDTOs", "riwayatApplyMahasiswaDTOs", "riwayatApplyMahasiswaDTO"})
    public void KlikDetailDataPelamar(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (obj.getIdUserRiwayat() != null) {
            userDTO = userService.findByUserID(obj.getIdUserRiwayat());
        }
    }

    @Command("searchPelamar")
    @NotifyChange("listRiwayatApplyMahasiswaDTOs")
    public void searchPelamar(@ContextParam(ContextType.VIEW) Window window) {
        int count1 = 0;
        int count2 = 0;
        Map params = new HashMap();
        params.put("namaApplyLowongan", namaApplyLowongan);
        params.put("namaLowonganApply", namaLowonganApply);
        count1 = checkCount(count1, namaLowonganApply);
        params.put("lowonganState", lowonganState);
        count2 = checkCount(count2, lowonganState);
        if (count1 < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        if (count2 < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }
        listRiwayatApplyMahasiswaDTOs = riwayatApplyMahasiswaService.findByParams(params);
    }
    
    public int checkCount(int count, Object object) {
        if (StringUtil.hasValue(object)){
            count += 1;
        }return count;
    }
    
    @Command("buttonKlikPreviewCV")
    @NotifyChange({"riwayatApplyLowonganDTO", "userDTOs", "user"})
    public void buttonKlikPreviewCV(@BindingParam("object") RiwayatApplyMahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        userDTO = userService.findByUserID(obj.getIdUserRiwayat());
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", userDTO);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/dataRegister/previewCV.zul", window, params);
    }

    /* ==================== Getter Setter ==================== */
    public MinatService getMinatService() {
        return minatService;
    }

    public void setMinatService(MinatService minatService) {
        this.minatService = minatService;
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

    public LowonganDTO getLowonganDTO() {
        return lowonganDTO;
    }

    public void setLowonganDTO(LowonganDTO lowonganDTO) {
        this.lowonganDTO = lowonganDTO;
    }

    public RiwayatApplyMahasiswaDTO getRiwayatApplyMahasiswaDTO() {
        return riwayatApplyMahasiswaDTO;
    }

    public void setRiwayatApplyMahasiswaDTO(RiwayatApplyMahasiswaDTO riwayatApplyMahasiswaDTO) {
        this.riwayatApplyMahasiswaDTO = riwayatApplyMahasiswaDTO;
    }


    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public List<String> getListNamaMinat() {
        return listNamaMinat;
    }

    public void setListNamaMinat(List<String> listNamaMinat) {
        this.listNamaMinat = listNamaMinat;
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

    public List<RiwayatApplyMahasiswaDTO> getListRiwayatApplyMahasiswaDTOs() {
        return listRiwayatApplyMahasiswaDTOs;
    }

    public void setListRiwayatApplyMahasiswaDTOs(List<RiwayatApplyMahasiswaDTO> listRiwayatApplyMahasiswaDTOs) {
        this.listRiwayatApplyMahasiswaDTOs = listRiwayatApplyMahasiswaDTOs;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getIdRiwayatLowongan() {
        return idRiwayatLowongan;
    }

    public void setIdRiwayatLowongan(String idRiwayatLowongan) {
        this.idRiwayatLowongan = idRiwayatLowongan;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
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

}
