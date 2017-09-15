package com.agit.crm.main.viewmodel.register;

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
import com.agit.crm.common.dto.usermanagement.AccessTimeDTO;
import com.agit.crm.common.dto.usermanagement.AccessTimeDTOBuilder;
import com.agit.crm.common.dto.usermanagement.RoleDTO;
import com.agit.crm.common.dto.usermanagement.RoleDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTO;
import com.agit.crm.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.status.StatusCode;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.ReleaseType;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.shared.type.TingkatanType;
import com.agit.crm.shared.zul.CommonViewModel;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.RoleService;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.user.management.application.security.SecurityCacheHelper;
import com.agit.crm.user.management.interfaces.web.ui.navigation.UserNavigation;
import com.agit.crm.util.CommonUtil;
import com.agit.crm.util.DateUtil;
import com.agit.crm.util.SqlFilterUtil;
import com.agit.crm.util.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.zkoss.bind.BindContext;
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
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class RegisterVM {

    @WireVariable
    UserService userService;

    @WireVariable
    RoleService roleService;

    @WireVariable
    MinatService minatService;

    @WireVariable
    KetrampilanService ketrampilanService;

    @WireVariable
    JurusanService jurusanService;

    @WireVariable
    CivitasService civitasService;

    @WireVariable
    DomisiliService domisiliService;


    /* search option*/
    private String searchUserName;
    private String searchFullName;
    private String searchRoleID;
    private String roleName;
    private StatusData searchUserStatus;

    /* Select ComboBox */
    private String domisiliSelect;
    private String minatSelect;
    private String jurusanSelect;
    private String ketrampilanSelect;
    private String civitasSelect;

    private List<UserDTO> userDTOs;
    private UserDTO userDTO;
    private String primaryBranchName;
    private String supervisorName;
    private String deleted;
    private PageNavigation previous;
    private String confirmPassword;
    private String password;
    private String message;
    private String release;
    private ReleaseType releaseType;
    private boolean checked;
    private int pageSize;
    private int activePage;
    private String lockUnlock;
    private String userID;
    private ListModelList<JobDivision> listJobDivision = new ListModelList<>();
    private ListModelList<JobLocation> listJobLocation = new ListModelList<>();
    private ListModelList<StatusData> listStatus = new ListModelList<>();
    private List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
    private RoleDTO roleDTO = new RoleDTO();

    /* Object List */
    private List<MinatDTO> minats = new ArrayList<MinatDTO>();
    private List<KetrampilanDTO> ketrampilans = new ArrayList<KetrampilanDTO>();
    private List<JurusanDTO> jurusans = new ArrayList<JurusanDTO>();
    private List<CivitasDTO> civitass = new ArrayList<CivitasDTO>();
    private List<DomisiliDTO> domisilis = new ArrayList<DomisiliDTO>();
    private ListModelList<PendidikanType> pendidikanTypes;
    private ListModelList<JenisKelaminType> jenisKelaminTypes;
    private ListModelList<TingkatanType> tingkatanTypes1;
    private ListModelList<TingkatanType> tingkatanTypes2;
    private ListModelList<TingkatanType> tingkatanTypes3;
    private ListModelList<TingkatanType> tingkatanTypes4;
    private ListModelList<TingkatanType> tingkatanTypes5;

    /* Bind List Value ComboBox */
    private List<String> listMinat = new ArrayList<>();
    private List<String> listKetrampilan = new ArrayList<>();
    private List<String> listDomisili = new ArrayList<>();
    private List<String> listCivitas = new ArrayList<>();
    private List<String> listJurusan = new ArrayList<>();

    /* attribut for upload file CV */
    Media mediaUploadCV;
    String mediaNameUploadCV;
    private String filepathUploadCV;
    private String pathLocationUploadCV;

    @Init
    public void init(@ContextParam(ContextType.COMPONENT) Window window,
            @ExecutionArgParam("user") UserDTO user,
            @ExecutionArgParam("previous") PageNavigation previous,
            @ExecutionArgParam("deleted") String deleted,
            @ExecutionArgParam("search") Map<String, Object> search,
            @ExecutionArgParam("propertyParam") Map<String, Object> prop) {
        searchUserStatus = StatusData.ACTIVE;

//        roleDTOs = roleService.findByParameter("Mahasiswa");
        roleDTO = roleService.findByID("MAHASISWA");

        initData();
        checkValidity(user, previous);

        if (window.getId().isEmpty()) {
            if (user == null) {
                UserSpecificationDTO userSpecificationDTO = new UserSpecificationDTOBuilder()
                        .setImmediateSupervisorUserName("admin")
                        .setPrimaryBranchID("123456789")
                        .setAccessTimeDTO(initAccessTime())
                        .setUserLoginInfoDTO(new UserLoginInfoDTO())
                        .createUserSpecificationDTO();
                RoleDTO roleDTO = new RoleDTOBuilder()
                        .setRoleName("Mahasiswa")
                        .createRoleDTO();
                userDTO = new UserDTOBuilder()
                        .setCreationalBy(SecurityUtil.getUserName())
                        .setUserSpecificationDTO(userSpecificationDTO)
                        .setRoleDTO(roleDTO)
                        .setUserStatus(StatusData.ACTIVE)
                        .createUserDTO();
            } else {
                this.userDTO = user;
                this.previous = previous;
                this.deleted = deleted;

                if (userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt() != 0) {
                    lockUnlock = "lock";
                } else {
                    lockUnlock = "Unlock";
                }
            }

            if (search != null) {
                this.searchFullName = (String) search.get("searchFullName");
                this.searchUserName = (String) search.get("searchUserName");
                this.searchRoleID = (String) search.get("searchRoleID");
                this.searchUserStatus = (StatusData) search.get("userStatus");
            }

            if (prop != null) {
                this.supervisorName = (String) prop.get("supervisorName");
                this.primaryBranchName = (String) prop.get("primaryBranchName");
                this.checked = (Boolean) prop.get("checked");
            }

            if (deleted != null) {
                if (deleted.equals("deleted")) {
                    userDTO.setUserStatus(StatusData.DELETED);
                }
            }

            checked = userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getCredentialsExpiredDate() == null;

        } else {
            pageSize = CommonViewModel.PAGE_SIZE;
            activePage = 1;
        }
    }

    private void initData() {


        /* Load Data */
        minats = minatService.findAllByStatus(Status.ACTIVE);
        for (MinatDTO m : minats) {
            listMinat.add(m.getNamaMinat());
        }
        ketrampilans = ketrampilanService.findAllByStatus(Status.ACTIVE);
        for (KetrampilanDTO k : ketrampilans) {
            listKetrampilan.add(k.getNamaKetrampilan());
        }
        civitass = civitasService.findAllByStatus(Status.ACTIVE);
        for (CivitasDTO c : civitass) {
            listCivitas.add(c.getNamaCivitas());
        }
        jurusans = jurusanService.findAllByStatus(Status.ACTIVE);
        for (JurusanDTO j : jurusans) {
            listJurusan.add(j.getNamaJurusan());
        }
        domisilis = domisiliService.findAllByStatus(Status.ACTIVE);
        for (DomisiliDTO d : domisilis) {
            listDomisili.add(d.getNamaKabupaten());
        }
    }

    private void checkValidity(UserDTO user, PageNavigation previous) {
        if (user != null) {
            this.userDTO = user;
            mediaNameUploadCV = user.getUserSpecificationDTO().getUploadCV();
            this.previous = previous;
        }
    }

    public AccessTimeDTO initAccessTime() {
        Date startTime = DateUtil.stringToDate("00:00", "HH:mm");
        Date endTime = DateUtil.stringToDate("23:59", "HH:mm");

        return new AccessTimeDTOBuilder()
                .setMondayStart(startTime).setMondayEnd(endTime)
                .setTuesdayStart(startTime).setTuesdayEnd(endTime)
                .setWednesdayStart(startTime).setWednesdayEnd(endTime)
                .setThursdayStart(startTime).setThursdayEnd(endTime)
                .setFridayStart(startTime).setFridayEnd(endTime)
                .setSaturdayStart(startTime).setSaturdayEnd(endTime)
                .setSundayStart(startTime).setSundayEnd(endTime)
                .createAccessTimeDTO();
    }

    @Command("buttonKembali")
    @NotifyChange("userDTO")
    public void buttonKembali(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    /* Command */
    @Command("verifyUserName")
    @NotifyChange("verifyUserName")
    public void verifyUserName(@BindingParam("obj") String userName) {
        if (userName != null && !userName.trim().equals("")) {
            UserDTO user = userService.findByID(userName);
            if (user == null) {
                CommonViewModel.showInformationMessagebox("User Name is not exist");
            } else {
                CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", userName}));
            }
        }
    }

    @Command("verifyKtp")
    @NotifyChange("verifyKtp")
    public void verifyKtp(@BindingParam("obj1") String ktp) {
        if (ktp != null && !ktp.trim().equals("")) {
            UserDTO user = userService.findByKtp(ktp);
            if (user == null) {
                CommonViewModel.showInformationMessagebox("KTP is not exist");
            } else {
                CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"ktp", ktp}));
            }
        }
    }

    @Command("verifyEmail")
    @NotifyChange("verifyEmail")
    public void verifyEmail(@BindingParam("obj2") String email) {
        if (email != null && !email.trim().equals("")) {
            UserDTO user = userService.findByEmail(email);
            if (user == null) {
                CommonViewModel.showInformationMessagebox("Email is not exist");
            } else {
                CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"email", email}));
            }
        }
    }

    @Command("onCheckPasswordExpired")
    @NotifyChange("checked")
    public void onCheckPasswordExpired(@BindingParam("obj") Boolean checked) {
        this.checked = checked;
        if (checked) {
            userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().setCredentialsExpiredDate(null);
        } else {
            userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().setCredentialsExpiredDate(DateUtil.addDays(new Date(), 30));
        }
    }

    @GlobalCommand("refreshvalues")
    @NotifyChange("primaryBranchName")
    public void refreshvalues(@BindingParam("returnBranchCode") String str1, @BindingParam("returnBranchName") String str2,
            @BindingParam("window") Window win, @ContextParam(ContextType.VIEW) Window window) {
        if (win.equals(window)) {
            this.primaryBranchName = str2;
            this.userDTO.getUserSpecificationDTO().setPrimaryBranchID(str1);
        }
    }

    @GlobalCommand("refreshUserSupervisor")
    @NotifyChange("supervisorName")
    public void refreshUserSupervisor(@BindingParam("returnUserName") String str1, @BindingParam("returnFullName") String str2,
            @BindingParam("window") Window win, @ContextParam(ContextType.VIEW) Window window) {
        if (win.equals(window)) {
            this.supervisorName = str2;
            this.userDTO.getUserSpecificationDTO().setImmediateSupervisorUserName(str1);
        }
    }

    @Command("buttonConfirm")
    public void buttonConfirm(@ContextParam(ContextType.VIEW) Window window) throws JsonProcessingException {
        if (previous == PageNavigation.CREATE) {
            /* Check exist code */

            if ((userDTO.getUserName() != null && !userDTO.getUserName().trim().equals("")) || (userDTO.getUserSpecificationDTO().getKtp() != null && !userDTO.getUserSpecificationDTO().getKtp().trim().equals("")) || (userDTO.getUserSpecificationDTO().getEmail() != null && !userDTO.getUserSpecificationDTO().getEmail().trim().equals(""))) {
                userDTO.setUserName(userDTO.getUserName().toUpperCase());
                UserDTO user = userService.findByID(userDTO.getUserName());
                if (user != null) {
                    if (user.getUserName().equals(userDTO.getUserName())) {
                        CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", userDTO.getUserName()}));
                    }
                } else if (user == null) {
                    user = userService.findByKtp(userDTO.getUserSpecificationDTO().getKtp());
                    if (user != null) {
                        if (user.getUserSpecificationDTO().getKtp().equals(userDTO.getUserSpecificationDTO().getKtp())) {
                            CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"ktp", userDTO.getUserSpecificationDTO().getKtp()}));
                        }
                    }
                    if (user == null) {
                        user = userService.findByEmail(userDTO.getUserSpecificationDTO().getEmail());
                        if (user != null) {
                            if (user.getUserSpecificationDTO().getEmail().equals(userDTO.getUserSpecificationDTO().getEmail())) {
                                CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"email", userDTO.getUserSpecificationDTO().getEmail()}));
                            }
                        } else {
                            ListModelList<UserDTO> userList = new ListModelList<>(userService.findAllUser());
                            String userID = "";
                            if (userList.isEmpty()) {
                                userID = "USER004";
                            } else {
                                userID = getLatestObjectID(userList, "userID");
                            }
                            userDTO.setUserID(userID);
                            userDTO.setCreationalDate(new Date());
                            userDTO.setUserName(userDTO.getUserName().toUpperCase());
                            userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
                            try {
                                userService.saveOrUpdate(userDTO);
                                CommonViewModel.showInformationMessagebox("User Name " + userDTO.getUserName() + " has successfully created", UserNavigation.DASHBOARD, null, window);
                            } catch (Exception e) {
                                CommonViewModel.showErrorMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", userDTO.getUserName()}));
                            }
                        }
                    }
                }
            }

//            UserDTO user = userService.findByID(userDTO.getUserName() == null ? "" : userDTO.getUserName());
//            if (user == null) {
//
//            } else if (user.getUserName().equals(userDTO.getUserName())) {
//                CommonViewModel.showErrorMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", userDTO.getUserName()}));
//            }
        } else if (previous == PageNavigation.UPDATE) {
            userService.saveOrUpdate(userDTO);
            CommonViewModel.showInformationMessagebox("User Name " + userDTO.getUserName() + " has successfully updated", UserNavigation.USER_SEARCH, null, window);
        } else {
            userService.delete(userDTO.getUserName());
            CommonViewModel.showInformationMessagebox("User Name " + userDTO.getUserName() + " has successfully deleted", UserNavigation.USER_SEARCH, null, window);
        }

        final String username = "bajm.recruitment.agit@gmail.com";
        final String passwordEmail = "bayuhendra1993";
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwordEmail);
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bayuhendra1078@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userDTO.getUserSpecificationDTO().getEmail()));

            message.setSubject("Registrasi CRM");
            message.setText("Dear  " + userDTO.getUserName()
                    + "\n\n Selamat, Anda sudah berhasil mendaftar App Candidate Recruitment di PT. Astra Graphia Information Technology"
                    + "\n "
                    + "\n Nama Lengkap      :" + userDTO.getUserSpecificationDTO().getFullName()
                    + "\n Email             :" + userDTO.getUserSpecificationDTO().getEmail()
                    + "\n No KTP            :" + userDTO.getUserSpecificationDTO().getKtp()
                    + "\n\n Mohon simpan email ini sebagai referensi atas registrasi CRM anda. "
                    + "\n\n Terimakasih. "
                    + "\n\n PT. Astra Graphia Information Technology. "
            );
            message.setSentDate(new Date());

            Transport.send(message);

            System.out.println("Sending Email Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
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

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    @Command("buttonBack")
    public void buttonBack(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", userDTO);
        params.put("previous", previous);
        params.put("search", searchParam());
        params.put("propertyParam", propertyParam());
        if (previous == PageNavigation.CREATE) {
            CommonViewModel.navigateTo(UserNavigation.USER_CREATE, window, params);
        } else if (previous == PageNavigation.UPDATE) {
            params.put("previous", PageNavigation.CONFIRM);
            CommonViewModel.navigateTo(UserNavigation.USER_UPDATE, window, params);
        } else if (previous == PageNavigation.CONFIRM || previous == PageNavigation.SEARCH) {
            CommonViewModel.navigateTo(UserNavigation.USER_SEARCH, window, params);
        }
    }

    @Command("buttonSearch")
    @NotifyChange("userDTOs")
    public void buttonSearch() {

        int count = 0;

        Map params = new HashMap();
        params.put("namaUser", searchUserName);
        count = checkCountParameter(count, searchUserName);
        params.put("roleID", searchRoleID);
        count = checkCountParameter(count, searchRoleID);
        params.put("userStatus", searchUserStatus);
        count = checkCountParameter(count, searchUserStatus);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        userDTOs = userService.findByParameter(
                SqlFilterUtil.bothLike(searchFullName),
                SqlFilterUtil.bothLike(searchUserName),
                searchRoleID == null ? "%%" : searchRoleID,
                searchUserStatus);

        if (userDTOs.isEmpty()) {
            Messagebox.show("Data Tidak Ditemukan", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        }
    }

    @Command("selectRole")
    public void selectRole(@BindingParam("obj") RoleDTO selectedRole) {
        userDTO.setRoleDTO(selectedRole);
    }

    @Command("selectRoleSearch")
    public void selectRoleSearch(@BindingParam("obj") RoleDTO selectedRole) {
        searchRoleID = selectedRole.getRoleID();
    }

    @Command("selectReleaseType")
    @NotifyChange("releaseType")
    public void selectReleaseType(@BindingParam("obj") ReleaseType releaseType) {
        this.releaseType = releaseType;
    }

    @Command("checkedLock")
    public void checkedLock(@BindingParam("obj") Boolean locked) {
        if (locked) {
            userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().setLoginAttempt(3);
        } else {
            userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().setLoginAttempt(0);
        }
    }

    @Command("buttonLupaPassword")
    public void buttonLupaPassword(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateToWithoutDetach(UserNavigation.GANTI_PASSWORD, window, params);
    }

    @Command("buttonSubmit")
    @NotifyChange({"verifyEmail", "verifyKtp", "verifyUserName", "buttonSubmit"})
    public void buttonSubmit(@BindingParam("obj") String userName, @BindingParam("obj1") String ktp, @BindingParam("obj2") String email, @ContextParam(ContextType.VIEW) Window window) {
        userDTO.setRoleDTO(roleDTO);
        Map<String, Object> params = new HashMap<>();
        params.put("user", userDTO);
        params.put("propertyParam", propertyParam());
        if (pathLocationUploadCV == null) {
            pathLocationUploadCV = userDTO.getUserSpecificationDTO().getUploadCV();
        }
        userDTO.getUserSpecificationDTO().setUploadCV(pathLocationUploadCV);
        if (previous == null) {
            params.put("previous", PageNavigation.CREATE);
        } else if (previous.equals(PageNavigation.SEARCH) || previous.equals(PageNavigation.CONFIRM)) {
            params.put("previous", PageNavigation.UPDATE);
        } else if (previous.equals(PageNavigation.CREATE)) {
            params.put("previous", PageNavigation.CREATE);
        }
        CommonViewModel.navigateToWithoutDetach(UserNavigation.APPROVE, window, params);
    }

    @Command("buttonUpdate")
    public void buttonUpdate(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_UPDATE, window, params);
    }

    @Command("buttonDelete")
    public void buttonDelete(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("deleted", "deleted");
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_READ, window, params);
    }

    @Command("buttonView")
    public void buttonView(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_READ, window, params);
    }

    @Command("buttonLockUnlock")
    public void buttonLockUnlock(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_LOCK_UNLOCK, window, params);
    }

    @Command("buttonResetPassword")
    public void buttonResetPassword(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_RESET_PASSWORD, window, params);
    }

    @Command("buttonRelease")
    @NotifyChange("message")
    public void buttonRelease() {
        message = null;
        if (releaseType == ReleaseType.ALL || releaseType == null) {
            StatusCode statusCode = userService.releaseAll();
            if (statusCode == StatusCode.CREATED) {
                CommonViewModel.showInformationMessagebox("All User has been successfully released");
                CommonViewModel.goToGlobalCommandCloseTab();
            }
        } else if (releaseType != null && release != null && !release.trim().isEmpty()) {
            StatusCode statusCode = userService.release(releaseType.toString(), release);
            if (statusCode == StatusCode.CREATED) {
                CommonViewModel.showInformationMessagebox(releaseType.toString() + " : " + release + " has been successfully released");
                CommonViewModel.goToGlobalCommandCloseTab();
            } else {
                CommonViewModel.showErrorMessagebox(releaseType.toString() + " : " + release + " cannot find in the system. Please check again.");
            }
        } else {
            message = "This field may not be empty or contain only spaces.";
        }
    }

    @Command("buttonSavePassword")
    @NotifyChange("message")
    public void buttonSavePassword(@ContextParam(ContextType.VIEW) Window window) {
        if (password != null && confirmPassword != null && password.equals(confirmPassword)) {
            //update password
            try {
                userService.updatePassword(userDTO.getUserName(), password);
                SecurityCacheHelper.invalidate(SecurityCacheHelper.USER_DETAIL, userDTO.getUserName());
                CommonViewModel.showInformationMessagebox("Password UserName " + userDTO.getUserName() + " has successfully updated", UserNavigation.USER_SEARCH, null, window);
            } catch (Exception ex) {
                CommonViewModel.showErrorMessagebox(ex.getMessage());
            }
        } else {
            message = Labels.getLabel("user.label.verifyPassword");
        }
    }

    @Command("buttonSaveLockUnlock")
    public void buttonSaveLockUnlock(@ContextParam(ContextType.VIEW) Window window) {
        try {
            userService.updateLockUnlock(userDTO.getUserName(), userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt());
            /* Clear cache */

            SecurityCacheHelper.invalidate(SecurityCacheHelper.USER_DETAIL, userDTO.getUserName());
            if (userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt() == 3) {
                CommonViewModel.showInformationMessagebox("UserName " + userDTO.getUserName() + " has been locked", UserNavigation.USER_SEARCH, null, window);
            } else {
                CommonViewModel.showInformationMessagebox("UserName " + userDTO.getUserName() + " has been unlocked", UserNavigation.USER_SEARCH, null, window);
            }
        } catch (Exception ex) {
            CommonViewModel.showErrorMessagebox(ex.getMessage());
        }
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

    /*Listbox*/
    public ReleaseType[] getListRelease() {
        return ReleaseType.values();
    }

    public List<RoleDTO> getRoleList() {
        RoleDTO roleNull = new RoleDTOBuilder().setRoleName("-- Please Select --").createRoleDTO();
        List<RoleDTO> roles = new ArrayList<>();
        roles.add(roleNull);
        roles = roleService.findAllByStatus(StatusData.ACTIVE);
        return roles;
    }

    public String getPrimaryBranchName() {
        this.primaryBranchName = "DJP Pusat";
        return primaryBranchName;
    }

    public String getSupervisorName() {
//        if (userDTO.getUserSpecificationDTO().getImmediateSupervisorUserName() != null && supervisorName == null) {
//            UserDTO supervisor = userService.findByID(userDTO.getUserSpecificationDTO().getImmediateSupervisorUserName());
//            supervisorName = supervisor.getUserSpecificationDTO().getFullName();
//        }
        return supervisorName;
    }

    /*Helper*/
    public String timeToString(Date date) {
        return DateUtil.dateToString(date, "HH:mm");
    }

    public String toSentenceCase(String word) {
        if (word == null || word.trim().isEmpty()) {
            return word;
        }
        return word.charAt(0) + word.substring(1).toLowerCase();
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    public Map<String, Object> searchParam() {
        Map<String, Object> params = new HashMap<>();
        params.put("searchFullName", searchFullName);
        params.put("searchUserName", searchUserName);
        params.put("searchRoleID", searchRoleID);
        params.put("searchUserStatus", searchUserStatus);
        return params;
    }

    public Map<String, Object> propertyParam() {
        Map<String, Object> params = new HashMap<>();
        params.put("primaryBranchName", primaryBranchName);
        params.put("supervisorName", supervisorName);
        params.put("checked", checked);
        return params;
    }

    /* Getter&Setter */
    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getSearchUserName() {
        return searchUserName;
    }

    public void setSearchUserName(String searchUserName) {
        this.searchUserName = searchUserName;
    }

    public String getSearchFullName() {
        return searchFullName;
    }

    public void setSearchFullName(String searchFullName) {
        this.searchFullName = searchFullName;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public void setPrimaryBranchName(String primaryBranchName) {
        this.primaryBranchName = primaryBranchName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSearchRoleName() {
        return searchRoleID;
    }

    public void setSearchRoleName(String searchRoleID) {
        this.searchRoleID = searchRoleID;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public ReleaseType getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(ReleaseType releaseType) {
        this.releaseType = releaseType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchRoleID() {
        return searchRoleID;
    }

    public void setSearchRoleID(String searchRoleID) {
        this.searchRoleID = searchRoleID;
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

    public ListModelList<JobDivision> getListJobDivision() {
        return new ListModelList<>(JobDivision.values());
    }

    public void setListJobDivision(ListModelList<JobDivision> listJobDivision) {
        this.listJobDivision = listJobDivision;
    }

    public ListModelList<JobLocation> getListJobLocation() {
        return new ListModelList<>(JobLocation.values());
    }

    public void setListJobLocation(ListModelList<JobLocation> listJobLocation) {
        this.listJobLocation = listJobLocation;
    }

    public String getLockUnlock() {
        return lockUnlock;
    }

    public void setLockUnlock(String lockUnlock) {
        this.lockUnlock = lockUnlock;
    }

    public StatusData getSearchUserStatus() {
        return searchUserStatus;
    }

    public void setSearchUserStatus(StatusData searchUserStatus) {
        this.searchUserStatus = searchUserStatus;
    }

    public ListModelList<StatusData> getListStatus() {
        return new ListModelList<>(StatusData.values());
    }

    public void setListStatus(ListModelList<StatusData> listStatus) {
        this.listStatus = listStatus;
    }

    public List<RoleDTO> getRoleDTOs() {
        return roleDTOs;
    }

    public void setRoleDTOs(List<RoleDTO> roleDTOs) {
        this.roleDTOs = roleDTOs;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public List<MinatDTO> getMinats() {
        return minats;
    }

    public void setMinats(List<MinatDTO> minats) {
        this.minats = minats;
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

    public List<String> getListMinat() {
        return listMinat;
    }

    public void setListMinat(List<String> listMinat) {
        this.listMinat = listMinat;
    }

    public List<String> getListKetrampilan() {
        return listKetrampilan;
    }

    public void setListKetrampilan(List<String> listKetrampilan) {
        this.listKetrampilan = listKetrampilan;
    }

    public List<String> getListDomisili() {
        return listDomisili;
    }

    public void setListDomisili(List<String> listDomisili) {
        this.listDomisili = listDomisili;
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

    public ListModelList<PendidikanType> getPendidikanTypes() {
        return new ListModelList<>(PendidikanType.values());
    }

    public void setPendidikanTypes(ListModelList<PendidikanType> pendidikanTypes) {
        this.pendidikanTypes = pendidikanTypes;
    }

    public ListModelList<JenisKelaminType> getJenisKelaminTypes() {
        return new ListModelList<>(JenisKelaminType.values());
    }

    public void setJenisKelaminTypes(ListModelList<JenisKelaminType> jenisKelaminTypes) {
        this.jenisKelaminTypes = jenisKelaminTypes;
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

    public List<DomisiliDTO> getDomisilis() {
        return domisilis;
    }

    public void setDomisilis(List<DomisiliDTO> domisilis) {
        this.domisilis = domisilis;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

}
