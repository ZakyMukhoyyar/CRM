package com.agit.crm.main.viewmodel.mahasiswa;

import com.agit.crm.common.application.KetrampilanService;
import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.application.MahasiswaService;
import com.agit.crm.common.dto.crm.KetrampilanDTO;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.LowonganDTOBuilder;
import com.agit.crm.common.dto.crm.MahasiswaDTO;
import com.agit.crm.common.dto.crm.MahasiswaDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.TingkatanType;
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
import org.zkoss.zk.ui.select.SelectorComposer;
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
public class MahasiswaVM extends SelectorComposer<Window> {

    /* Import Service */
    @WireVariable
    MahasiswaService mahasiswaService;

    @WireVariable
    LowonganService lowonganService;

    @WireVariable
    KetrampilanService ketrampilanService;

    /* Object Binding for Form CRM */
    private MahasiswaDTO mahasiswaDTO = new MahasiswaDTO();
    private List<MahasiswaDTO> mahasiswaDTOs = new ArrayList();
    private LowonganDTO lowonganDTO = new LowonganDTO();
    private List<LowonganDTO> lowonganDTOs = new ArrayList();

    /* attribut for CRM */
    private PageNavigation previous;

    /* Paramater Objek Mahasiswa */
    private String idMahasiswa;
    private String idLowongan;

    /* Function For Combobox  */
    private ListModelList<PendidikanType> pendidikanTypes;
    private ListModelList<JenisKelaminType> jenisKelaminTypes;
    private ListModelList<TingkatanType> tingkatanTypes1;
    private ListModelList<TingkatanType> tingkatanTypes2;
    private ListModelList<TingkatanType> tingkatanTypes3;
    private ListModelList<TingkatanType> tingkatanTypes4;
    private ListModelList<TingkatanType> tingkatanTypes5;
    private List<KetrampilanDTO> ketrampilans = new ArrayList<KetrampilanDTO>();


    /* attribut for upload file CV */
    Media mediaUploadCV;
    String mediaNameUploadCV;
    private String filepathUploadCV;
    private String pathLocationUploadCV;

    @Init
    public void init(
            @ExecutionArgParam("mahasiswaDTO") MahasiswaDTO mahasiswa,
            @ExecutionArgParam("lowonganDTO") LowonganDTO lowongan,
            @ExecutionArgParam("previous") PageNavigation previous) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(mahasiswa, lowongan, previous);
    }

    private void initData() {
        mahasiswaDTOs = mahasiswaService.findAll();
        if (mahasiswaDTOs.isEmpty()) {
            mahasiswaDTOs = Collections.emptyList();
        }
        lowonganDTOs = lowonganService.findAll();
        if (lowonganDTOs.isEmpty()) {
            lowonganDTOs = Collections.emptyList();
        }

        ketrampilans = ketrampilanService.findAll();

    }

    private void checkValidity(MahasiswaDTO mahasiswa, LowonganDTO lowongan, PageNavigation previous) {
        if (mahasiswa == null) {
            ListModelList<MahasiswaDTO> parameterList = new ListModelList<>(mahasiswaService.findAll());
            String id = "";
            if (parameterList.isEmpty()) {
                idMahasiswa = "MHS01";
            } else {
                idMahasiswa = getLatestObjectID(parameterList, "idMahasiswa");
            }
            mahasiswaDTO = new MahasiswaDTOBuilder()
                    .setIdMahasiswa(idMahasiswa)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createMahasiswaDTO();
        } else {
            this.mahasiswaDTO = mahasiswa;
            idMahasiswa = mahasiswaDTO.getIdMahasiswa();
            mediaNameUploadCV = mahasiswaDTO.getUploadCV();
            this.previous = previous;
        }
        if (lowongan == null) {
            ListModelList<LowonganDTO> parameterList = new ListModelList<>(lowonganService.findAll());
            String id = "";
            if (parameterList.isEmpty()) {
                idLowongan = "LOWONGAN01";
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

    /* Function upload CV */
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

    /* Function button save register mahasiswa */
    @Command("buttonSaveMahasiswa")
    @NotifyChange({"mahasiswaDTO"})
    public void buttonSaveMahasiswa(@BindingParam("object") MahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        if (pathLocationUploadCV == null) {
            pathLocationUploadCV = mahasiswaDTO.getUploadCV();
        }
        mahasiswaService.SaveOrUpdate(mahasiswaDTO);
        showInformationMessagebox("Data Mahasiswa Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshMahasiswa", null);
        Map<String, Object> params = new HashMap<>();
        params.put("mahasiswaDTO", obj);
        CommonViewModel.navigateTo("/crm/mahasiswa/registrasi_pekerja.zul", window, params);
    }

    /* Function refresh data mahasiswa */
    @GlobalCommand
    @NotifyChange("mahasiswaDTOs")
    public void refreshMahasiswa() {
        mahasiswaDTOs = mahasiswaService.findAll();
    }

    public MahasiswaDTO getMahasiswaDTO() {
        return mahasiswaDTO;
    }

    public void setMahasiswaDTO(MahasiswaDTO mahasiswaDTO) {
        this.mahasiswaDTO = mahasiswaDTO;
    }

    public List<MahasiswaDTO> getMahasiswaDTOs() {
        return mahasiswaDTOs;
    }

    public void setMahasiswaDTOs(List<MahasiswaDTO> mahasiswaDTOs) {
        this.mahasiswaDTOs = mahasiswaDTOs;
    }

    public LowonganDTO getLowonganDTO() {
        return lowonganDTO;
    }

    public void setLowonganDTO(LowonganDTO lowonganDTO) {
        this.lowonganDTO = lowonganDTO;
    }

    public List<LowonganDTO> getLowonganDTOs() {
        return lowonganDTOs;
    }

    public void setLowonganDTOs(List<LowonganDTO> lowonganDTOs) {
        this.lowonganDTOs = lowonganDTOs;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public ListModelList<PendidikanType> getPendidikanTypes() {
        return new ListModelList<>(PendidikanType.values());
    }

    public void setPendidikanTypes(ListModelList<PendidikanType> pendidikanTypes) {
        this.pendidikanTypes = pendidikanTypes;
    }

    public String getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
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

    public ListModelList<JenisKelaminType> getJenisKelaminTypes() {
        return new ListModelList<>(JenisKelaminType.values());
    }

    public void setJenisKelaminTypes(ListModelList<JenisKelaminType> jenisKelaminTypes) {
        this.jenisKelaminTypes = jenisKelaminTypes;
    }

    public List<KetrampilanDTO> getKetrampilans() {
        return ketrampilans;
    }

    public void setKetrampilans(List<KetrampilanDTO> ketrampilans) {
        this.ketrampilans = ketrampilans;
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

}
