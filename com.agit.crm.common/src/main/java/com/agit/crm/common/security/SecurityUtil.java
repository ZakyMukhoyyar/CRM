package com.agit.crm.common.security;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Use this helper to get user login info, granted authority, and user
 * visibility
 *
 * @author bayutridewanto
 *
 */
public class SecurityUtil {

    public static UserDTO getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null||auth.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return ((UserDetailsImpl) auth.getPrincipal()).getUserDTO();
    }

    /* for creational By */
    public static String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null||auth.getPrincipal().equals("anonymousUser")) {
            return "system";
        }
        UserDTO user = ((UserDetailsImpl) auth.getPrincipal()).getUserDTO();
        if (user == null) {
            return "system";
        }
        return user.getUserName();
    }

    /*
        if authorities is more than one authority, separate with comma
        example : isAllGranted("USER_CREATE,USER_DELETE")
    */
    public static boolean isAllGranted(String authorities) {
        if (null == authorities || "".equals(authorities)) {
            return false;
        }

        return getPrincipalAuthorities().containsAll(parseAuthorities(authorities));
    }

    public static Collection<? extends GrantedAuthority> getPrincipalAuthorities() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        if (currentUser == null) {
            return Collections.emptyList();
        }
        if (currentUser.getAuthorities() == null || currentUser.getAuthorities().isEmpty()) {
            return Collections.emptyList();
        }

        return currentUser.getAuthorities();
    }

    private static Collection<GrantedAuthority> parseAuthorities(String authorizationsString) {
        ArrayList<GrantedAuthority> required = new ArrayList<>();
        String[] roles = authorizationsString.split(",");
        for (String role : roles) {
            required.add(new SimpleGrantedAuthority(role.trim()));
        }
        return required;
    }

}
