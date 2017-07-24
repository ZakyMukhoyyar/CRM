package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.shared.type.StatusData;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class UserDTO implements Serializable {

    private String userID;
    private String nip;
    private String userName;
    private String password;
    private RoleDTO roleDTO;
    private StatusData userStatus;
    private UserSpecificationDTO userSpecificationDTO;
    private Date creationalDate;
    private String creationalBy;
    private List<LowonganDTO> lowongansDTO;

    public UserDTO() {
    }

    public UserDTO(String userID, String nip, String userName, String password, RoleDTO roleDTO, StatusData userStatus, UserSpecificationDTO userSpecificationDTO, Date creationalDate, String creationalBy, List<LowonganDTO> lowongansDTO) {
        this.userID = userID;
        this.nip = nip;
        this.userName = userName;
        this.password = password;
        this.roleDTO = roleDTO;
        this.userStatus = userStatus;
        this.userSpecificationDTO = userSpecificationDTO;
        this.creationalDate = creationalDate;
        this.creationalBy = creationalBy;
        this.lowongansDTO = lowongansDTO;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public StatusData getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(StatusData userStatus) {
        this.userStatus = userStatus;
    }

    public UserSpecificationDTO getUserSpecificationDTO() {
        return userSpecificationDTO;
    }

    public void setUserSpecificationDTO(UserSpecificationDTO userSpecificationDTO) {
        this.userSpecificationDTO = userSpecificationDTO;
    }

    public Date getCreationalDate() {
        return creationalDate;
    }

    public void setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
    }

    public String getCreationalBy() {
        return creationalBy;
    }

    public void setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
    }

    public List<LowonganDTO> getLowongansDTO() {
        return lowongansDTO;
    }

    public void setLowongansDTO(List<LowonganDTO> lowongansDTO) {
        this.lowongansDTO = lowongansDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", nip=" + nip + ", userName=" + userName + ", password=" + password + ", roleDTO=" + roleDTO + ", userStatus=" + userStatus + ", userSpecificationDTO=" + userSpecificationDTO + ", creationalDate=" + creationalDate + ", creationalBy=" + creationalBy + ", lowongansDTO=" + lowongansDTO + '}';
    }

    public static UserDTO getInstance() {

        UserDTO user = new UserDTOBuilder()
                .setUserID("User123")
                .setNip("12333")
                .setUserName("bayuhendra")
                .setPassword("PASS")
                .setRoleDTO(RoleDTO.getInstance())
                .setUserStatus(StatusData.DELETED)
                .setCreationalBy("creationalBy")
                .setCreationalDate(new Date())
                .setUserSpecificationDTO(UserSpecificationDTO.getInstance())
                .createUserDTO();
        return user;

    }

}
