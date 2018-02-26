/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.viewmodel.storing.fi.card;

import au.com.bytecode.opencsv.CSVReader;
import com.agit.crm.common.application.StoringFICardPOCService;
import com.agit.crm.common.dto.storing.fi.card.poc.StoringFICardPOCDTO;
import com.agit.crm.common.dto.storing.fi.card.poc.StoringFICardPOCDTOBuilder;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOC;
import com.agit.crm.domain.storing.fi.card.poc.StoringFICardPOCRepository;
import com.agit.crm.shared.status.StatusResult;

import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
 * @author BayuHS
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class StoringFICardPOCVM {

    @WireVariable
    StoringFICardPOCService storingFICardPOCService;

    @WireVariable
    StoringFICardPOCRepository storingFICardPOCRepository;

    private StoringFICardPOCDTO storingFICardPOCDTO = new StoringFICardPOCDTO();
    private List<StoringFICardPOCDTO> storingFICardPOCDTOs = new ArrayList<>();

    Media mediaUploadStoringFICardPOC;
    String mediaNameUploadStoringFICardPOC;
    private String filepathUploadStoringFICardPOC;
    private String pathLocationUploadStoringFICardPOC;
    private String storingFICardPOCID;

    private String noRepair;
    private String repairInline;
    private String repairOutline;

    private PageNavigation previous;

    @Init
    public void init(
            @ExecutionArgParam("storingFICardPOCDTO") StoringFICardPOCDTO storingFICardPOC,
            @ExecutionArgParam("previous") PageNavigation previous) {
        initData();
        checkValidity(storingFICardPOC, previous);

    }

    private void initData() {
        storingFICardPOCDTOs = storingFICardPOCService.findAll();
        if (storingFICardPOCDTOs.isEmpty()) {
            storingFICardPOCDTOs = storingFICardPOCService.findAll();
        }
    }

    private void checkValidity(StoringFICardPOCDTO storingFICardPOC, PageNavigation previous) {
        if (storingFICardPOC == null) {
            ListModelList<StoringFICardPOCDTO> parameterList = new ListModelList<>(storingFICardPOCService.findAll());
            String storingFICardPocID = "";
            if (parameterList.isEmpty()) {
                storingFICardPocID = "C1";
            } else {
                storingFICardPocID = getLatestObjectID(parameterList, "storingFICardPocID");
            }
            storingFICardPOCDTO = new StoringFICardPOCDTOBuilder()
                    .setStoringFICardPocID(storingFICardPOCID)
                    .createStoringFICardPOCDTO();
        } else {
            this.storingFICardPOCDTO = storingFICardPOC;
            storingFICardPOCID = storingFICardPOCDTO.getStoringFICardPocID();
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

    @Command("buttonUploadFile")
    @NotifyChange({"mediaNameUploadStoringFICardPOC", "pathLocationUploadStoringFICardPOC"})
    public void buttonUploadFile(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaUploadStoringFICardPOC = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filepathUploadStoringFICardPOC = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filepathUploadStoringFICardPOC = filepathUploadStoringFICardPOC + "\\" + "files" + "\\" + "crm-xls" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filepathUploadStoringFICardPOC);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            if (mediaUploadStoringFICardPOC.getFormat().matches("xlsx") || mediaUploadStoringFICardPOC.getFormat().matches("xls")) {
                Files.copy(new File(filepathUploadStoringFICardPOC + mediaUploadStoringFICardPOC.getName()), mediaUploadStoringFICardPOC.getStreamData());
                setMediaNameUploadStoringFICardPOC(mediaUploadStoringFICardPOC.getName());
                pathLocationUploadStoringFICardPOC = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadStoringFICardPOC.getName();
            } else {
                Messagebox.show("Format Harus Sesuai Template", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

    @Command("buttonSaveStoringFICardPOC")
    @NotifyChange("storingFICardPOCDTO")
    public void buttonSaveStoringFICardPOC(@BindingParam("object") StoringFICardPOCDTO obj, @ContextParam(ContextType.VIEW) Window window) throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        if (mediaNameUploadStoringFICardPOC == null) {
            Messagebox.show("Silakan Pilih File yang akan diupload!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        List<StoringFICardPOC> storingFICardPOCs = new ArrayList<>();
        CSVReader csvr = readCsv(filepathUploadStoringFICardPOC + mediaNameUploadStoringFICardPOC);
        List<String[]> records = null;
        records = csvr.readAll();
        int count = 1;
        try {
            for (String[] record : records) {
                StoringFICardPOC storingFICardPOC = new StoringFICardPOC();
                storingFICardPOC.setStoringFICardPocID(record[3]);
                storingFICardPOC.setFiCard(record[1]);
                storingFICardPOC.setFrameNumber(record[3]);
                storingFICardPOC.setFileName(record[5]);
                storingFICardPOC.setStage1(record[7]);
                storingFICardPOC.setStage2(record[9]);
                storingFICardPOC.setStage3(record[11]);
                storingFICardPOC.setStage4(record[13]);
                storingFICardPOC.setStage4PoinCheck5(record[15]);
                storingFICardPOC.setStage1PoinCheck1(record[17]);
                storingFICardPOC.setStage1PoinCheck2(record[19]);
                storingFICardPOC.setStage1PoinCheck3(record[21]);
                storingFICardPOC.setStage1PoinCheck4(record[23]);
                storingFICardPOC.setStage1PoinCheck5(record[25]);
                storingFICardPOC.setStage1PoinCheck6(record[27]);
                storingFICardPOC.setStage2PoinCheck1(record[29]);
                storingFICardPOC.setStage2PoinCheck2(record[31]);
                storingFICardPOC.setStage2PoinCheck3(record[33]);
                storingFICardPOC.setStage2PoinCheck4(record[35]);
                storingFICardPOC.setStage2PoinCheck5(record[37]);
                storingFICardPOC.setStage3PoinCheck1(record[39]);
                storingFICardPOC.setStage3PoinCheck2(record[41]);
                storingFICardPOC.setStage4PoinCheck1(record[43]);
                storingFICardPOC.setStage4PoinCheck2(record[45]);
//                storingFICardPOC.setStage4PoinCheck3(record[47]);
                storingFICardPOC.setStage4PoinCheck4(record[47]);
                storingFICardPOC.setPathFile(record[48]);
                storingFICardPOC.setCreatedBy("SYSTEM");
                storingFICardPOC.setCreatedDate(new Date());

                System.out.println("Read Row " + count++);
                storingFICardPOCRepository.saveOrUpdate(storingFICardPOC);

                if (storingFICardPOC.getStage4PoinCheck5().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage1PoinCheck1().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage1PoinCheck2().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage1PoinCheck3().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage1PoinCheck4().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage1PoinCheck5().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage1PoinCheck6().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage2PoinCheck1().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage2PoinCheck2().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage2PoinCheck3().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage2PoinCheck4().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage2PoinCheck5().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage3PoinCheck1().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage3PoinCheck2().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage4PoinCheck1().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage4PoinCheck2().equalsIgnoreCase("1")
                        //                    && storingFICardPOC.getStage4PoinCheck3().equalsIgnoreCase("1")
                        && storingFICardPOC.getStage4PoinCheck4().equalsIgnoreCase("1")) {
                    storingFICardPOC.setStatusResult(StatusResult.G);
                } else {
                    storingFICardPOC.setStatusResult(StatusResult.NG);
                }
                storingFICardPOCRepository.saveOrUpdate(storingFICardPOC);
            }
        } catch (Exception e) {
            String error = "Error at row " + count + " from total " + records.size();
        } finally {
            csvr.close();
        }

        showInformationMessagebox("Data Storing FI Card Berhasil Disimpan");
        BindUtils.postGlobalCommand(
                null, null, "refreshData", null);
    }

    private CSVReader readCsv(String pathFile) throws IOException {
        CSVReader csvr = null;
        csvr = new CSVReader(new FileReader(pathFile), ',');
        return csvr;
    }

    @Command("refreshData")
    @GlobalCommand
    @NotifyChange("storingFICardPOCDTOs")
    public void refreshData() {
        storingFICardPOCDTOs = storingFICardPOCService.findAll();
    }

    @Command("detailStoringFICardPOC")
    @NotifyChange({"storingFICard", "storingFICardPOCDTO", "storingFICardPOCDTOs"})
    public void detailStoringFICardPOC(@BindingParam("object") StoringFICardPOCDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("storingFICardPOCDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/storing-fi-card-poc/view-data-storing-poc.zul", window, params);
    }

    @Command("previewImagaeStoringFICardPOCImage")
    @NotifyChange({"src", "storingFICardPOCDTO", "storingFICardPOCDTOs"})
    public void previewImagaeStoringFICardPOCImage(@BindingParam("object") StoringFICardPOCDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("storingFICardPOCDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/storing-fi-card-poc/preview-image-storing-ficard-poc-image.zul", window, params);
    }

    @Command("previewImagaeStoringFICardPOCPDF")
    @NotifyChange({"src", "storingFICardPOCDTO", "storingFICardPOCDTOs"})
    public void previewImagaeStoringFICardPOCPDF(@BindingParam("object") StoringFICardPOCDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("storingFICardPOCDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/storing-fi-card-poc/preview-image-storing-ficard-poc-pdf.zul", window, params);
    }

    public StoringFICardPOCService getStoringFICardPOCService() {
        return storingFICardPOCService;
    }

    public void setStoringFICardPOCService(StoringFICardPOCService storingFICardPOCService) {
        this.storingFICardPOCService = storingFICardPOCService;
    }

    public StoringFICardPOCDTO getStoringFICardPOCDTO() {
        return storingFICardPOCDTO;
    }

    public void setStoringFICardPOCDTO(StoringFICardPOCDTO storingFICardPOCDTO) {
        this.storingFICardPOCDTO = storingFICardPOCDTO;
    }

    public List<StoringFICardPOCDTO> getStoringFICardPOCDTOs() {
        return storingFICardPOCDTOs;
    }

    public void setStoringFICardPOCDTOs(List<StoringFICardPOCDTO> storingFICardPOCDTOs) {
        this.storingFICardPOCDTOs = storingFICardPOCDTOs;
    }

    public Media getMediaUploadStoringFICardPOC() {
        return mediaUploadStoringFICardPOC;
    }

    public void setMediaUploadStoringFICardPOC(Media mediaUploadStoringFICardPOC) {
        this.mediaUploadStoringFICardPOC = mediaUploadStoringFICardPOC;
    }

    public String getMediaNameUploadStoringFICardPOC() {
        return mediaNameUploadStoringFICardPOC;
    }

    public void setMediaNameUploadStoringFICardPOC(String mediaNameUploadStoringFICardPOC) {
        this.mediaNameUploadStoringFICardPOC = mediaNameUploadStoringFICardPOC;
    }

    public String getFilepathUploadStoringFICardPOC() {
        return filepathUploadStoringFICardPOC;
    }

    public void setFilepathUploadStoringFICardPOC(String filepathUploadStoringFICardPOC) {
        this.filepathUploadStoringFICardPOC = filepathUploadStoringFICardPOC;
    }

    public String getPathLocationUploadStoringFICardPOC() {
        return pathLocationUploadStoringFICardPOC;
    }

    public void setPathLocationUploadStoringFICardPOC(String pathLocationUploadStoringFICardPOC) {
        this.pathLocationUploadStoringFICardPOC = pathLocationUploadStoringFICardPOC;
    }

    public String getStoringFICardPOCID() {
        return storingFICardPOCID;
    }

    public void setStoringFICardPOCID(String storingFICardPOCID) {
        this.storingFICardPOCID = storingFICardPOCID;
    }

    public String getNoRepair() {
        return noRepair;
    }

    public void setNoRepair(String noRepair) {
        this.noRepair = noRepair;
    }

    public String getRepairInline() {
        return repairInline;
    }

    public void setRepairInline(String repairInline) {
        this.repairInline = repairInline;
    }

    public String getRepairOutline() {
        return repairOutline;
    }

    public void setRepairOutline(String repairOutline) {
        this.repairOutline = repairOutline;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

}
