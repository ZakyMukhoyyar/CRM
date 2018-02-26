/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.viewmodel.storing.fi.card;

import com.agit.crm.common.application.StoringFICardService;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTOBuilder;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardSecondary;
import com.agit.crm.infrastructure.component.csv.CsvReader;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class StoringFICardVM {

    @WireVariable
    StoringFICardService storingFICardService;

    private StoringFICardDTO storingFICardDTO = new StoringFICardDTO();
    private List<StoringFICardDTO> storingFICardDTOs = new ArrayList<>();

    Media mediaUploadStoringFICard;
    String mediaNameUploadStoringFICard;
    private String filepathUploadStoringFICard;
    private String pathLocationUploadStoringFICard;
    private String storingFICardID;

    private String noRepair;
    private String repairInline;
    private String repairOutline;

    private PageNavigation previous;

    @Init
    public void init(
            @ExecutionArgParam("storingFICardDTO") StoringFICardDTO storingFICard,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();
        checkValidity(storingFICard, previous);

    }

    private void initData() {
        storingFICardDTOs = storingFICardService.findAll();
        if (storingFICardDTOs.isEmpty()) {
            storingFICardDTOs = Collections.emptyList();
        }
    }

    private void checkValidity(StoringFICardDTO storingFICard, PageNavigation previous) {
        if (storingFICard == null) {
            ListModelList<StoringFICardDTO> parameterList = new ListModelList<>(storingFICardService.findAll());
            String storingFICardID = "";
            if (parameterList.isEmpty()) {
                storingFICardID = "C1";
            } else {
                storingFICardID = getLatestObjectID(parameterList, "storingFICardID");
            }
            storingFICardDTO = new StoringFICardDTOBuilder()
                    .setStoringFICardID(storingFICardID)
                    .createStoringFICardDTO();
        } else {
            this.storingFICardDTO = storingFICard;
            storingFICardID = storingFICardDTO.getStoringFICardID();
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
    @NotifyChange({"mediaNameUploadStoringFICard", "pathLocationUploadStoringFICard"})
    public void buttonUploadFile(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();

        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }

        if (upEvent != null) {
            mediaUploadStoringFICard = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH);
            int day = now.get(Calendar.DAY_OF_MONTH);
            filepathUploadStoringFICard = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
            filepathUploadStoringFICard = filepathUploadStoringFICard + "\\" + "files" + "\\" + "crm-xls" + "\\" + year + "\\" + month + "\\" + day + "\\";

            File baseDir = new File(filepathUploadStoringFICard);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            if (mediaUploadStoringFICard.getFormat().matches("xlsx") || mediaUploadStoringFICard.getFormat().matches("xls")) {
                Files.copy(new File(filepathUploadStoringFICard + mediaUploadStoringFICard.getName()), mediaUploadStoringFICard.getStreamData());
                setMediaNameUploadStoringFICard(mediaUploadStoringFICard.getName());
                pathLocationUploadStoringFICard = "/" + "files" + "/" + "rkap" + "/" + year + "/" + month + "/" + day + "/" + mediaUploadStoringFICard.getName();
            } else {
                Messagebox.show("Format Harus Sesuai Template", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

    @Command("buttonSaveStoringFICard")
    @NotifyChange("storingFICardDTO")
    public void buttonSaveStoringFICard(@BindingParam("object") StoringFICardDTO obj, @ContextParam(ContextType.VIEW) Window window) throws IOException, FileNotFoundException, IllegalAccessException, InstantiationException, IllegalArgumentException,
            InvocationTargetException, IntrospectionException {
        if (mediaNameUploadStoringFICard == null) {
            Messagebox.show("Silakan Pilih File yang akan diupload!", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        CsvReader<StoringFICardSecondary> jxr = new CsvReader<>(StoringFICardSecondary.class);
        List<StoringFICardSecondary> ls = jxr.getJavaObjectFromThisFile(filepathUploadStoringFICard + mediaNameUploadStoringFICard);
        for (StoringFICardSecondary s : ls) {
            StoringFICardDTO m = new StoringFICardDTOBuilder()
                    .setStoringFICardID(s.getStoringFICardID())
                    .setPointCheck1(s.getPointCheck1())
                    .setPointCheck2(s.getPointCheck2())
                    .setPointCheck3(s.getPointCheck3())
                    .setPointCheck4(s.getPointCheck4())
                    .setPointCheck5(s.getPointCheck5())
                    .setCreatedDate(new Date())
                    .createStoringFICardDTO();
            try {
                storingFICardService.SaveOrUpdate(m);
                System.out.println("Row " + s.getStoringFICardID() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getStoringFICardID() + " FAILED");
            }
        }
        String jdbcUrl = "jdbc:postgresql://localhost:5432/crm-engine";
        String username = "postgres";
        String password = "root";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1 - Load driver
            // Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

            // Step 2 - Open connection
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Step 3 - Execute statement
            stmt = conn.createStatement();
            rs = stmt.executeQuery("UPDATE agit_storing_fi_card AS v\n"
                    + "SET statusresult = CASE\n"
                    + "WHEN s.pointcheck1 = '|'\n"
                    + "AND s.pointcheck2 = '|'\n"
                    + "AND s.pointcheck3 = '|'\n"
                    + "AND s.pointcheck4 = '|'\n"
                    + "AND s.pointcheck5 = '|' THEN\n"
                    + "	'G'\n"
                    + "ELSE\n"
                    + "	'NG'\n"
                    + "END\n"
                    + "FROM\n"
                    + "	agit_storing_fi_card AS s\n"
                    + "WHERE\n"
                    + "	v.storingficardid = s.storingficardid");

            // Step 4 - Get result
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                // Step 5 Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        showInformationMessagebox("Data Storing FI Card Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
    }
    
    @Command("refreshData")
    @GlobalCommand
    @NotifyChange("storingFICardDTOs")
    public void refreshData() {
        storingFICardDTOs = storingFICardService.findAll();
    }

    @Command("detailStoringFICard")
    @NotifyChange({"storingFICard", "storingFICardDTO", "storingFICardDTOs"})
    public void detailStoringFICard(@BindingParam("object") StoringFICardDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("storingFICardDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/storing-fi-card/view-data-storing.zul", window, params);
    }

    @Command("previewImagaeStoringFICardImage")
    @NotifyChange({"src", "storingFICardDTO", "storingFICardDTOs"})
    public void previewImagaeStoringFICardImage(@BindingParam("object") StoringFICardDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("storingFICardDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/storing-fi-card/preview-image-storing-FICard-image.zul", window, params);
    }

    @Command("previewImagaeStoringFICardPDF")
    @NotifyChange({"src", "storingFICardDTO", "storingFICardDTOs"})
    public void previewImagaeStoringFICardPDF(@BindingParam("object") StoringFICardDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("storingFICardDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/storing-fi-card/preview-image-storing-FICard-pdf.zul", window, params);
    }

    public StoringFICardService getStoringFICardService() {
        return storingFICardService;
    }

    public void setStoringFICardService(StoringFICardService storingFICardService) {
        this.storingFICardService = storingFICardService;
    }

    public StoringFICardDTO getStoringFICardDTO() {
        return storingFICardDTO;
    }

    public void setStoringFICardDTO(StoringFICardDTO storingFICardDTO) {
        this.storingFICardDTO = storingFICardDTO;
    }

    public List<StoringFICardDTO> getStoringFICardDTOs() {
        return storingFICardDTOs;
    }

    public void setStoringFICardDTOs(List<StoringFICardDTO> storingFICardDTOs) {
        this.storingFICardDTOs = storingFICardDTOs;
    }

    public Media getMediaUploadStoringFICard() {
        return mediaUploadStoringFICard;
    }

    public void setMediaUploadStoringFICard(Media mediaUploadStoringFICard) {
        this.mediaUploadStoringFICard = mediaUploadStoringFICard;
    }

    public String getMediaNameUploadStoringFICard() {
        return mediaNameUploadStoringFICard;
    }

    public void setMediaNameUploadStoringFICard(String mediaNameUploadStoringFICard) {
        this.mediaNameUploadStoringFICard = mediaNameUploadStoringFICard;
    }

    public String getFilepathUploadStoringFICard() {
        return filepathUploadStoringFICard;
    }

    public void setFilepathUploadStoringFICard(String filepathUploadStoringFICard) {
        this.filepathUploadStoringFICard = filepathUploadStoringFICard;
    }

    public String getPathLocationUploadStoringFICard() {
        return pathLocationUploadStoringFICard;
    }

    public void setPathLocationUploadStoringFICard(String pathLocationUploadStoringFICard) {
        this.pathLocationUploadStoringFICard = pathLocationUploadStoringFICard;
    }

    public String getStoringFICardID() {
        return storingFICardID;
    }

    public void setStoringFICardID(String storingFICardID) {
        this.storingFICardID = storingFICardID;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

}
