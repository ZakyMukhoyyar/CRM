package com.agit.crm.main.util;

import org.zkoss.zk.ui.Path;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class PathUtil {

    public static String getPathBaseAction() {
        return "~./ui/layout";
    }

    public static Include getPathIncludeMain() {
        return (Include) Path.getComponent("//main/winMain/incMain");
    }

    public static Tabbox getPathTabboxMain() {
        return (Tabbox) Path.getComponent("//mainPage/winMainPage/tabBoxContent");
    }

    public static void closePage() {
        getPathTabboxMain().getSelectedTab().close();
    }

    public static Include getIncludeTab() {
        Tab tab = getPathTabboxMain().getSelectedTab();
        Include incl = (Include) tab.getAttribute("inclTab");
        return incl;
    }

    public static void closeTabPopUp() {
        Include incl = getIncludeTab();
        incl.invalidate();
    }

    public static Tabs getPathTabsMain() {
        return (Tabs) Path.getComponent("//mainPage/winMainPage/tabBoxContent/tabsContent");
    }

    public static Tabpanels getPathTabPanelsMain() {
        return (Tabpanels) Path.getComponent("//mainPage/winMainPage/tabBoxContent/tabsContent/tabPanelsContent");
    }
}
