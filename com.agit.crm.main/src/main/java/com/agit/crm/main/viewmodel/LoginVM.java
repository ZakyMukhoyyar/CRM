package com.agit.crm.main.viewmodel;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.CommonViewModel;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

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

    @Command("buttonKembali")
    @NotifyChange("userDTO")
    public void buttonKembali(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/crm/register/register.zul", window, params);
    }

}
