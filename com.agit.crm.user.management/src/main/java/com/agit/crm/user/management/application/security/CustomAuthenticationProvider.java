package com.agit.crm.user.management.application.security;

import com.agit.crm.common.dto.usermanagement.AccessTimeDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.UserDetailsImpl;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.util.DateUtil;
import com.agit.crm.user.management.application.UserService;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author bayutridewanto
 *
 */
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private UserDetailsService userDetailsService;
    UserService userService;

    private final String ldapDefault = "local.default.com";

    @Override
    public Authentication authenticate(Authentication authentication) {
        UsernamePasswordAuthenticationToken userToken = (UsernamePasswordAuthenticationToken) authentication;
        String[] principal = userToken.getPrincipal().toString().split("@");
        String username = principal[0].trim();
        String ldapDomain = principal[1];

        /* Pre checking*/
        /*check username & password is empty*/
        if (username.isEmpty() && userToken.getCredentials().toString().trim().isEmpty()) {
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.usernamePasswordEmpty", "username and password is empty"));
        }

        /*check username is empty*/
        if (username.isEmpty()) {
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.usernameEmpty", "username is empty"));
        }

        /*check password is empty*/
        if (userToken.getCredentials().toString().trim().isEmpty()) {
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.passwordEmpty", "password is empty"));
        }

        /* for LDAP*/
//        if (!ldapDomain.equalsIgnoreCase(ldapDefault)) {
//            try {
//                Security sec = new Security(ResourceBundle.getBundle("config").getString("SCORPION_URL"));
//                String lg = sec.getSecuritySoap().login(ResourceBundle.getBundle("config").getString("SCORPION_APP"), ldapDomain, username, userToken.getCredentials().toString());
//                if (!lg.equalsIgnoreCase("true")) {
//                    /* if username not found in ldap*/
//                    throw new UsernameNotFoundException(messages.getMessage("LDAPSecurity.usernameNotFound", "ldap : username not found"));
//                }
//            } catch (MalformedURLException e) {
//                /* if configuration URL is wrong */
//                throw new UsernameNotFoundException(messages.getMessage("LDAPSecurity.configurationURLError", "ldap : Error configuration URL"));
//            } catch (WebServiceException e) {
//                /* if connection is refused */
//                throw new AuthenticationServiceException(messages.getMessage("LDAPSecurity.connectionRefuse", "ldap : Connection is refused"));
//            }
//        }
        UserDetailsImpl user = (UserDetailsImpl) SecurityCacheHelper.getObjectInCache(SecurityCacheHelper.USER_DETAIL, username);
        if (user == null) {
            try {
                user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
                SecurityCacheHelper.putObjectInCache(SecurityCacheHelper.USER_DETAIL, username, user);
            } catch (UsernameNotFoundException notFound) {
                throw new BadCredentialsException(messages.getMessage(notFound.getMessage()));
//                throw new BadCredentialsException(notFound.getMessage());
//                throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.userEmpty", "user is not found"));
            }
        }

        /* check user is found */
//        if (user.getUserDTO() == null) {
//            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.userEmpty", "user is not found"));
//        }

        /*check username is conflict*/
        if (isNotConflictUsername(username)) {
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.sameUser", "this username is currently being used by another user"));
        }

        /*check ipaddress is conflict*/
//        if (isNotConflictIP(user.getUserDTO().getUserSpecificationDTO().getUserLoginInfoDTO().getRemoteAddress()) == Boolean.FALSE) {
//            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.sameWorkstation", new String[]{user.getUserDTO().getUserSpecificationDTO().getUserLoginInfoDTO().getRemoteAddress()}, "this workstation is currently being used by another user"));
//        }
        
        if (ldapDomain.equalsIgnoreCase(ldapDefault)) {
            /*check user status*/

            if (user.getUserDTO() == null) {
                throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.userEmpty", "user is not found"));
            }

            if (!user.isEnabled()) {
                throw new DisabledException(messages.getMessage("AvantradeSecurity.disabled", "User is disabled"));
            }

            /*check password matches*/
            if (!new BCryptPasswordEncoder().matches(authentication.getCredentials().toString(), user.getPassword())) {
                int loginAttempt = user.getUserDTO().getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt();
                user.getUserDTO().getUserSpecificationDTO().getUserLoginInfoDTO().setLoginAttempt(loginAttempt);
                user.getUserDTO().getUserSpecificationDTO().getUserLoginInfoDTO().setLastLoginFailed(new Date());
                updateLoginInfo(user.getUserDTO());
                throw new BadCredentialsException(messages.getMessage("AvantradeSecurity.badCredentials", "Bad credentials"));
            }

            /*check password expired*/
            if (!user.isCredentialsNonExpired()) {
                throw new CredentialsExpiredException(messages.getMessage("AvantradeSecurity.credentialsExpired", "User account has expired"));
            }

            /*check account locked*/
            if (!user.isAccountNonLocked()) {
                throw new LockedException(messages.getMessage("AvantradeSecurity.locked", "User account is locked"));
            }
        }

        /*check role status*/
        if (!user.getUserDTO().getRoleDTO().getRoleStatus().equals(StatusData.ACTIVE)) {
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.role.disable", "avantrade : user group is disabled"));
        }

        /*check is this day accessible*/
        if (!isThisDayAccessibleForThisUser(user.getUserDTO().getUserSpecificationDTO().getAccessTimeDTO())) {
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity.noAccess", "No Access"));
        }

        return createSuccessAuthentication(user, authentication);
    }

    protected Authentication createSuccessAuthentication(UserDetailsImpl principal, Authentication authentication) {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, authentication.getCredentials(), principal.getAuthorities());
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public UserDetailsImpl retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetailsImpl loadedUser;
        try {
            loadedUser = userDetailsService.loadUserByUsername(username.split("@")[0]);
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
//            throw new AuthenticationServiceException(messages.getMessage(e.getMessage()));
        }
        return loadedUser;
    }

    @Override
    protected void doAfterPropertiesSet() throws Exception {
        Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    /* Helper */
    public boolean isNotConflictIP(String ip) {
        try {
            return userService.isNotExistIPAddress(ip);
        } catch (ResourceAccessException e) {
            /* if connection is refused */
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity", "avantrade : Connection is refused"));
        }
    }

    public boolean isNotConflictUsername(String username) {
        try {
            return userService.isNotExistUserName(username);
        } catch (ResourceAccessException e) {
            /* if connection is refused */
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity", "avantrade : Connection is refused"));
        }
    }

    public void updateLoginInfo(UserDTO user) {
        try {
            userService.updateLoginInfo(user.getUserName(), user.getUserSpecificationDTO().getUserLoginInfoDTO());
        } catch (ResourceAccessException e) {
            /* if connection is refused */
            throw new AuthenticationServiceException(messages.getMessage("AvantradeSecurity", "avantrade : Connection is refused"));
        }
    }

    private boolean isThisDayAccessibleForThisUser(AccessTimeDTO accessTimeDTO) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(new Date());
        c.setTimeZone(TimeZone.getTimeZone(DateUtil.TIMEZONE));
        Date now = c.getTime();
        int i = c.get(Calendar.DAY_OF_WEEK);
        if (i == Calendar.MONDAY) {
            return isATime(now, accessTimeDTO.getMondayStart(), accessTimeDTO.getMondayEnd());
        } else if (i == Calendar.TUESDAY) {
            return isATime(now, accessTimeDTO.getTuesdayStart(), accessTimeDTO.getTuesdayEnd());
        } else if (i == Calendar.WEDNESDAY) {
            return isATime(now, accessTimeDTO.getWednesdayStart(), accessTimeDTO.getWednesdayEnd());
        } else if (i == Calendar.THURSDAY) {
            return isATime(now, accessTimeDTO.getThursdayStart(), accessTimeDTO.getThursdayEnd());
        } else if (i == Calendar.FRIDAY) {
            return isATime(now, accessTimeDTO.getFridayStart(), accessTimeDTO.getFridayEnd());
        } else if (i == Calendar.SATURDAY) {
            return isATime(now, accessTimeDTO.getSaturdayStart(), accessTimeDTO.getSaturdayEnd());
        } else {
            return isATime(now, accessTimeDTO.getSundayStart(), accessTimeDTO.getSundayEnd());
        }
    }

    private boolean isATime(Date now, Date startTime, Date endTime) {
        return timeSeconds(now) < timeSeconds(endTime) && timeSeconds(now) >= timeSeconds(startTime);
    }

    private int timeSeconds(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.setTimeZone(TimeZone.getTimeZone(DateUtil.TIMEZONE));
        return cal.get(Calendar.HOUR_OF_DAY) * 3600 + cal.get(Calendar.MINUTE) * 60 + cal.get(Calendar.SECOND);
    }

    /* Setter */
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
