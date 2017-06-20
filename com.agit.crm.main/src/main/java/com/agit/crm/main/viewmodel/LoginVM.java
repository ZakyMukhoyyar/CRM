package com.agit.crm.main.viewmodel;

import com.agit.crm.common.security.SecurityUtil;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author bayutridewanto
 */
public class LoginVM {

    @Init
    public void init(@ContextParam(ContextType.VIEW) Component view) {
        if (SecurityUtil.getUser() != null) {
            Executions.getCurrent().sendRedirect("/");
        }
    }

    public Map<String, String> getDomains() {
        Map<String, String> ldapDomains = new HashMap<>();
        ResourceBundle labels = ResourceBundle.getBundle("ldapDomain");
        Enumeration z = labels.getKeys();
        while (z.hasMoreElements()) {
            String key = (String) z.nextElement();
            ldapDomains.put(key, labels.getString(key));
        }
        return ldapDomains;
    }
}
