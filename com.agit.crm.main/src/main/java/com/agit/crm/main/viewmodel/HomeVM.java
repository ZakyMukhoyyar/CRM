package com.agit.crm.main.viewmodel;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.Window;

/**
 *
 * @author Bayu Hendra Setiawan
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class HomeVM {

    private String src;

    @Command("buttonKlikInputDataBuku")
    @NotifyChange({"src"})
    public void buttonKlikInputDataBuku(@BindingParam("object") @ContextParam(ContextType.VIEW) Window window) {
        src = "library/home/dashboard_buku.zul";

    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
