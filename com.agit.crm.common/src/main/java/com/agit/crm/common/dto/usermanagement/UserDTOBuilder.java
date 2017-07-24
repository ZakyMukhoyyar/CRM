/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.usermanagement;

import com.agit.crm.common.dto.crm.LowonganDTO;
import com.agit.crm.shared.type.StatusData;
import java.util.Date;
import java.util.List;

public class UserDTOBuilder {

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

    public UserDTOBuilder() {
    }

    public UserDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public UserDTOBuilder setNip(String nip) {
        this.nip = nip;
        return this;
    }

    public UserDTOBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserDTOBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTOBuilder setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
        return this;
    }

    public UserDTOBuilder setUserStatus(StatusData userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public UserDTOBuilder setUserSpecificationDTO(UserSpecificationDTO userSpecificationDTO) {
        this.userSpecificationDTO = userSpecificationDTO;
        return this;
    }

    public UserDTOBuilder setCreationalDate(Date creationalDate) {
        this.creationalDate = creationalDate;
        return this;
    }

    public UserDTOBuilder setCreationalBy(String creationalBy) {
        this.creationalBy = creationalBy;
        return this;
    }

    public UserDTOBuilder setLowongansDTO(List<LowonganDTO> lowongansDTO) {
        this.lowongansDTO = lowongansDTO;
        return this;
    }

    public UserDTO createUserDTO() {
        return new UserDTO(userID, nip, userName, password, roleDTO, userStatus, userSpecificationDTO, creationalDate, creationalBy, lowongansDTO);
    }

}
