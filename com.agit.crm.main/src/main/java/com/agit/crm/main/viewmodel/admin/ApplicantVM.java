package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.LowonganService;
import com.agit.crm.common.application.MahasiswaService;
import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.common.dto.crm.MahasiswaDTO;
import com.agit.crm.shared.zul.CommonViewModel;
import com.agit.crm.shared.zul.PageNavigation;
import java.util.ArrayList;
import java.util.Collections;
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
import org.zkoss.zul.Window;

/**
 *
 * @author Zaky
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ApplicantVM {

    /* Import Service */
    @WireVariable
    MahasiswaService mahasiswaService;

    @WireVariable
    LowonganService lowonganService;

    /* Object Binding */
    private LowonganDTO lowonganDTO = new LowonganDTO();
    private List<LowonganDTO> lowonganDTOs = new ArrayList();
    private MahasiswaDTO mahasiswaDTO = new MahasiswaDTO();
    private List<MahasiswaDTO> mahasiswaDTOs = new ArrayList();

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 5;
    private int pageSizeCreateApplicant = 7;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    @Init
    public void init(
            @ExecutionArgParam("LowonganDTO") LowonganDTO lowongan,
            @ExecutionArgParam("MahasiswaDTO") MahasiswaDTO mahasiswa,
            @ExecutionArgParam("previous") PageNavigation previous
    ) {
        /* Load Data */
        initData();

    }

    private void initData() {
        lowonganDTOs = lowonganService.findAll();
        if (lowonganDTOs.isEmpty()) {
            lowonganDTOs = Collections.emptyList();
        }
        mahasiswaDTOs = mahasiswaService.findAll();
        if (mahasiswaDTOs.isEmpty()) {
            mahasiswaDTOs = Collections.emptyList();
        }
    }
    
    @Command("detailLowongan")
    @NotifyChange({"lowongan", "mahasiswa"})
    public void detailLowongan(@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window){
        Map<String, Object> params = new HashMap<>();
        params.put("lowonganDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/admin/applicant/applicant_contain.zul", window, params);
    }
    
    @Command("detailApplicant")
    @NotifyChange({"lowongan", "mahasiswa"})
    public void detailApplicant(@BindingParam("object") MahasiswaDTO obj, @ContextParam(ContextType.VIEW) Window window){
        Map<String, Object> params = new HashMap<>();
        params.put("mahasiswaDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/mahasiswa/registrasi_mahasiswa.zul", window, params);
    }
    
    @Command("buttonKembaliApplicantContain")
    @NotifyChange({"lowongan", "mahasiswa"})
    public void buttonKembaliApplicantContain (@BindingParam("object") LowonganDTO obj, @ContextParam(ContextType.VIEW) Window window){
        window.detach();
    }
    

    /* getter setter */
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

    public int getPageSizeCreateApplicant() {
        return pageSizeCreateApplicant;
    }

    public void setPageSizeCreateApplicant(int pageSizeCreateApplicant) {
        this.pageSizeCreateApplicant = pageSizeCreateApplicant;
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

}
