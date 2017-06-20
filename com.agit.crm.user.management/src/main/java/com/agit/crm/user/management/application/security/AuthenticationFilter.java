package com.agit.crm.user.management.application.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 *
 * @author bayutridewanto
 */
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String usernameParameter;
    private String passwordParameter;
    private String ldapDomainParameter;
    private boolean postOnly = true;

    public AuthenticationFilter(String loginProcessingUrl) {
        super(loginProcessingUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String ldapDomain = request.getParameter(ldapDomainParameter);
        String username = request.getParameter(usernameParameter)==null?"":request.getParameter(usernameParameter);
        String password = request.getParameter(passwordParameter)==null?"":request.getParameter(passwordParameter);
        username = username.concat("@").concat(ldapDomain);
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    public void setUsernameParameter(String usernameParameter) {
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        this.passwordParameter = passwordParameter;
    }

    public void setLdapDomainParameter(String ldapDomainParameter) {
        this.ldapDomainParameter = ldapDomainParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getUsernameParameter() {
        return usernameParameter;
    }

    public final String getPasswordParameter() {
        return passwordParameter;
    }

    public final String getLdapDomainParameter() {
        return ldapDomainParameter;
    }

}
