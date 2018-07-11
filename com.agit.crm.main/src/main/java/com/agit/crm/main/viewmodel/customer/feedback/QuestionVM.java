/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.viewmodel.customer.feedback;

import com.agit.crm.common.application.AnswerService;
import com.agit.crm.common.application.QuestionService;
import com.agit.crm.common.dto.customer.feedback.AnswerDTO;
import com.agit.crm.common.dto.customer.feedback.AnswerDTOBuilder;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author BayuHS
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class QuestionVM {

    @WireVariable
    QuestionService questionService;

    @WireVariable
    AnswerService answerService;

    private QuestionDTO questionDTO = new QuestionDTO();
    private List<QuestionDTO> questionDTOs = new ArrayList<>();
    private List<QuestionDTO> questionDTOsType1 = new ArrayList<>();
    private List<QuestionDTO> questionDTOsType2 = new ArrayList<>();

    private AnswerDTO answerDTO = new AnswerDTO();
    private List<AnswerDTO> answerDTOs = new ArrayList<>();

    private List<String> listQuestion = new ArrayList<String>();
    private ListModelList<Status> statuses = new ListModelList<>();
    private ListModelList<TypeTouchpoints> touchpointses = new ListModelList<>();
    private ListModelList<String> choiceAnswer = new ListModelList<>();

    private String questionID;
    private String answerID;
    private Status status;
    private TypeTouchpoints touchpoints;

    private PageNavigation previous;

    @Init
    public void init(
            @ExecutionArgParam("questionDTO") QuestionDTO question,
            @ExecutionArgParam("answerDTO") AnswerDTO answer,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(question, answer, previous);

    }

    private void initData() {
        questionDTOs = questionService.findAll();
        if (questionDTOs.isEmpty()) {
            questionDTOs = Collections.emptyList();
        }

        answerDTOs = answerService.findAll();
        if (answerDTOs.isEmpty()) {
            answerDTOs = Collections.emptyList();
        }

        questionDTOsType1 = questionService.findAllByTypeTouchpoints(TypeTouchpoints.TouchPoint_1);
        for (QuestionDTO m : questionDTOs) {
            listQuestion.add(m.getQuestion());
        }

        questionDTOsType2 = questionService.findAllByTypeTouchpoints(TypeTouchpoints.TouchPoint_2);
        for (QuestionDTO m : questionDTOs) {
            listQuestion.add(m.getQuestion());
        }

        choiceAnswer.add(" Sangat Baik Sekali ");
        choiceAnswer.add(" Sangat Baik ");
        choiceAnswer.add(" Cukup Baik ");
        choiceAnswer.add(" Tidak Terlalu Baik ");
        choiceAnswer.add(" Sangat Buruk ");
    }

    private void checkValidity(QuestionDTO question, AnswerDTO answer, PageNavigation previous) {
        if (question == null) {
            ListModelList<QuestionDTO> parameterList = new ListModelList<>(questionService.findAll());
            String questionID = "";
            if (parameterList.isEmpty()) {
                questionID = "Question1";
            } else {
                questionID = getLatestObjectID(parameterList, "questionID");
            }
            questionDTO = new QuestionDTOBuilder()
                    .setQuestionID(questionID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createQuestionDTO();
        } else {
            this.questionDTO = question;
            questionID = questionDTO.getQuestionID();
            this.previous = previous;
        }

        if (answer == null) {
            ListModelList<AnswerDTO> parameterList = new ListModelList<>(answerService.findAll());
            String answerID = "";
            if (parameterList.isEmpty()) {
                answerID = "1";
            } else {
                answerID = getLatestObjectID(parameterList, "answerID");
            }
            answerDTO = new AnswerDTOBuilder()
                    .setAnswerID(answerID)
                    .createAnswerDTO();
        } else {
            this.answerDTO = answer;
            answerID = answerDTO.getAnswerID();
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
    @NotifyChange("questionDTOs")
    public void refreshData() {
        questionDTOs = questionService.findAll();
    }

    @GlobalCommand
    @NotifyChange("answerDTOs")
    public void refreshDataAnswer() {
        answerDTOs = answerService.findAll();
    }

    @Command("buttonAddQuestion")
    @NotifyChange("questionDTO")
    public void buttonAddQuestion(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-question.zul", window, params);
    }

    @Command("buttonAddAnswer")
    @NotifyChange("questionDTO")
    public void buttonAddAnswer(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("answerDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-answer.zul", window, params);
    }

    @Command("detail")
    @NotifyChange("question")
    public void detail(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-question.zul", window, params);
    }

    @Command("buttonTp1")
    @NotifyChange("question")
    public void buttonTp1(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-1.zul", window, params);
    }

    @Command("buttonTp2")
    @NotifyChange("question")
    public void buttonTp2(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-2.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"questionDTO", "questionDTOs"})
    public void buttonKembali(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveQuestion")
    @NotifyChange({"questionDTO", "answerDTO", "answerDTOs"})
    public void buttonSaveQuestion(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        questionDTO.setAnswerDTOs(answerDTOs);
        questionService.SaveOrUpdate(questionDTO);
        String jdbcUrl = "jdbc:postgresql://localhost:5432/cfe-engine";
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
            rs = stmt.executeQuery("delete from\n"
                    + "      MST_ANSWER \n"
                    + "	WHERE (questionid) ISNULL");

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
        showInformationMessagebox("Pertanyaan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @Command("buttonSaveAnswer")
    @NotifyChange({"answerDTO", "questionDTO"})
    public void buttonSaveAnswer(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        answerService.SaveOrUpdate(answerDTO);
        showInformationMessagebox("Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataAnswer", null);
        window.detach();
    }

    @Command("delete")
    @NotifyChange("questionDTO")
    public void delete(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        questionDTO = (QuestionDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Pertanyaan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    questionService.deleteData(questionDTO);
                    showInformationMessagebox("Pertanyaan Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshData", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionDTO getQuestionDTO() {
        return questionDTO;
    }

    public void setQuestionDTO(QuestionDTO questionDTO) {
        this.questionDTO = questionDTO;
    }

    public List<QuestionDTO> getQuestionDTOs() {
        return questionDTOs;
    }

    public void setQuestionDTOs(List<QuestionDTO> questionDTOs) {
        this.questionDTOs = questionDTOs;
    }

    public ListModelList<Status> getStatuses() {
        return new ListModelList<>(Status.values());
    }

    public void setStatuses(ListModelList<Status> statuses) {
        this.statuses = statuses;
    }

    public ListModelList<TypeTouchpoints> getTouchpointses() {
        return new ListModelList<>(TypeTouchpoints.values());
    }

    public void setTouchpointses(ListModelList<TypeTouchpoints> touchpointses) {
        this.touchpointses = touchpointses;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TypeTouchpoints getTouchpoints() {
        return touchpoints;
    }

    public void setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public List<String> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<String> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public ListModelList<String> getChoiceAnswer() {
        return choiceAnswer;
    }

    public void setChoiceAnswer(ListModelList<String> choiceAnswer) {
        this.choiceAnswer = choiceAnswer;
    }

    public List<QuestionDTO> getQuestionDTOsType1() {
        return questionDTOsType1;
    }

    public void setQuestionDTOsType1(List<QuestionDTO> questionDTOsType1) {
        this.questionDTOsType1 = questionDTOsType1;
    }

    public List<QuestionDTO> getQuestionDTOsType2() {
        return questionDTOsType2;
    }

    public void setQuestionDTOsType2(List<QuestionDTO> questionDTOsType2) {
        this.questionDTOsType2 = questionDTOsType2;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    public AnswerDTO getAnswerDTO() {
        return answerDTO;
    }

    public void setAnswerDTO(AnswerDTO answerDTO) {
        this.answerDTO = answerDTO;
    }

    public List<AnswerDTO> getAnswerDTOs() {
        return answerDTOs;
    }

    public void setAnswerDTOs(List<AnswerDTO> answerDTOs) {
        this.answerDTOs = answerDTOs;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

}
