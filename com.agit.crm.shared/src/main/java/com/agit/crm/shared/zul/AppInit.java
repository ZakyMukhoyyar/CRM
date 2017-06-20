package com.agit.crm.shared.zul;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppInit;

/**
 *
 * @author bayutridewanto
 */
public class AppInit implements WebAppInit{

    @Override
    public void init(WebApp webapp) throws Exception {
        Labels.register(new LabelLocator("application"));
        Labels.register(new LabelLocator("common"));
        Labels.register(new LabelLocator("foundation"));
//        Labels.register(new LabelLocator("order"));
    }

}
