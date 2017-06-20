package com.agit.crm.main.util;

import java.util.List;

import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class TabboxUtil {

    public static String PREFIX_TAB = "tab_";
    public static String PREFIX_TAB_PANEL = "tpanel_";
    public static String PREFIX_INCLUDE = "inc_";
    public static String URL_VARIABLE_INCLUDE = "inc";

    public static void openNewTab(Tabs tabs, Tabpanels tabPanels, String tabID, String strLabel, String strPathPage) {
        int childPanel = tabPanels.getChildren().size();
        if (childPanel > 0) {
            tabPanels.getChildren().get(0).detach();
            tabs.getChildren().get(0).detach();
        }
        onAddTabContent(tabs, tabPanels, tabID, strLabel, strPathPage);
    }

    @SuppressWarnings("unused")
    private static Boolean isExistsTab(Tabs tabs, String strIdTab) {
        Boolean res = false;
        List<Tab> lsTab = tabs.getChildren();
        for (Tab t : lsTab) {
            if (strIdTab.equalsIgnoreCase(t.getId())) {
                res = true;
                t.setSelected(true);
                break;
            }
        }
        return res;
    }

    @SuppressWarnings("unused")
    private static void selectedTab(Tabs tabs, String strIdTab) {
        List<Tab> lsTab = tabs.getChildren();
        for (Tab t : lsTab) {
            if (strIdTab.equalsIgnoreCase(t.getId())) {
                t.setSelected(true);
                break;
            }
        }
    }

    private static void onAddTabContent(Tabs tabs, Tabpanels tabPanels, String strId, String strLabelTab, String strPathPage) {
        Tab tab = new Tab(strLabelTab);
        tab.setId(PREFIX_TAB + strId);
        tab.setClosable(true);
        tab.setParent(tabs);

        Tabpanel tpanel = new Tabpanel();
        tpanel.setId(PREFIX_TAB_PANEL + strId);

        Include incl = new Include();
        incl.setId(PREFIX_INCLUDE + strId);
        incl.setMode("defer");
        if (!strPathPage.contains("zul?")) {
            strPathPage += "?" + URL_VARIABLE_INCLUDE + "=" + incl.getId();
        } else {
            strPathPage += "&" + URL_VARIABLE_INCLUDE + "=" + incl.getId();
        }
        incl.setSrc(PathUtil.getPathBaseAction() + strPathPage);
        incl.setParent(tpanel);

        tpanel.setParent(tabPanels);
        tab.setSelected(true);
        tab.setAttribute("inclTab", incl);
    }
}
