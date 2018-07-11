package com.agit.crm.main.viewmodel;

import com.agit.crm.common.application.QuestionService;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import com.agit.crm.util.DateUtil;
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
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class DashboardVM {

    @WireVariable
    QuestionService questionService;

    /* data user */
    private UserDTO user;
    private String userNPWP;
    private String role;
    private String uriPhoto;

    private String src;

    private PageNavigation previous;
    private boolean checked;
    private int pageSize = 3;
    private int activePage = 0;
    private int selectedIndex;
    private int totalSize = 0;

    private QuestionDTO questionDTO = new QuestionDTO();
    private List<QuestionDTO> questionDTOs = new ArrayList<>();
    private List<QuestionDTO> questionDTOsType = new ArrayList<>();

    private List<String> listQuestion = new ArrayList<String>();
    private ListModelList<Status> statuses = new ListModelList<>();
    private ListModelList<TypeTouchpoints> touchpointses = new ListModelList<>();
    private ListModelList<String> choiceAnswer = new ListModelList<>();

    private String questionID;
    private Status status;
    private TypeTouchpoints touchpoints;

    @Init
    public void init(
            @ExecutionArgParam("questionDTO") QuestionDTO question,
            @ExecutionArgParam("previous") PageNavigation previous) {
        Map params = new HashMap();
        Status status = Status.ACTIVE;
        params.put("status", status);

        userNPWP = SecurityUtil.getUserName();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();
        user = SecurityUtil.getUser();
        role = SecurityUtil.getUser().getRoleDTO().getRoleID();

        initData();

        checkValidity(question, previous);

    }

    private void initData() {
        questionDTOs = questionService.findAll();
        if (questionDTOs.isEmpty()) {
            questionDTOs = Collections.emptyList();
        }

        questionDTOs = questionService.findAllByTypeTouchpoints(TypeTouchpoints.TouchPoint_1);
        for (QuestionDTO m : questionDTOs) {
            listQuestion.add(m.getQuestion());
        }

        questionDTOsType = questionService.findAllByTypeTouchpoints(TypeTouchpoints.TouchPoint_2);
        for (QuestionDTO m : questionDTOs) {
            listQuestion.add(m.getQuestion());
        }

        choiceAnswer.add("Sangat Baik Sekali");
        choiceAnswer.add("Sangat Baik");
        choiceAnswer.add("Cukup Baik");
        choiceAnswer.add("Tidak Terlalu Baik");
        choiceAnswer.add("Sangat Buruk");
    }

    private void checkValidity(QuestionDTO question, PageNavigation previous) {
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

    @Command("buttonAddQuestion")
    @NotifyChange("questionDTO")
    public void buttonAddQuestion(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-question.zul", window, params);
    }

    @Command("detail")
    @NotifyChange("question")
    public void detail(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-question.zul", window, params);
    }

    @Command("buttonView1")
    @NotifyChange("question")
    public void buttonView1(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-1.zul", window, params);
    }

    @Command("buttonView2")
    @NotifyChange("question")
    public void buttonView2(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
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
    @NotifyChange("questionDTO")
    public void buttonSaveQuestion(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        questionService.SaveOrUpdate(questionDTO);
        showInformationMessagebox("Pertanyaan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @GlobalCommand
    @NotifyChange("questionDTOs")
    public void refreshData() {
        questionDTOs = questionService.findAll();
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


    /* helper */
    public String concatUsername(String s1, String s2) {
        return s1.concat(s2);
    }

    public String concatDate(String s1, Date s2) {
        return s1.concat(DateUtil.dateToString(s2, "dd-MMM-yyy HH:mm:ss"));
    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    /* Getter&Setter */
    public String getUserNPWP() {
        return userNPWP;
    }

    public void setUserNPWP(String userNPWP) {
        this.userNPWP = userNPWP;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUriPhoto() {
        return uriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        this.uriPhoto = uriPhoto;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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

    public List<QuestionDTO> getQuestionDTOsType() {
        return questionDTOsType;
    }

    public void setQuestionDTOsType(List<QuestionDTO> questionDTOsType) {
        this.questionDTOsType = questionDTOsType;
    }

}
