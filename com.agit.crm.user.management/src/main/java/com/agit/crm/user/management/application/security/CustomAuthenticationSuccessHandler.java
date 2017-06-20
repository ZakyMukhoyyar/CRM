package com.agit.crm.user.management.application.security;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.user.management.application.UserService;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author bayutridewanto
 */
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDTO user = SecurityUtil.getUser();
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", user);
        user.getUserSpecificationDTO().getUserLoginInfoDTO().setLoginDate(new Date());
        user.getUserSpecificationDTO().getUserLoginInfoDTO().setRemoteAddress(request.getRemoteAddr());
        user.getUserSpecificationDTO().getUserLoginInfoDTO().setRemoteHost(request.getRemoteHost());
        user.getUserSpecificationDTO().getUserLoginInfoDTO().setSessionID(request.getSession().getId());
        updateLoginInfo(user);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    public void updateLoginInfo(UserDTO user) {
            userService.updateLoginInfo(user.getUserName(), user.getUserSpecificationDTO().getUserLoginInfoDTO()); 
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
