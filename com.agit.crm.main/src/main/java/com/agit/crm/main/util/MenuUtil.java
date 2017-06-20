package com.agit.crm.main.util;

import com.agit.crm.main.impl.MenuImpl;
import com.agit.crm.main.model.Menu;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;

public class MenuUtil {

    public static String PREFIX_MENU = "mnu_";
    public static String PREFIX_MENU_POPUP = "mnupop_";
    public static String PREFIX_MENU_ITEM = "mnuitem_";

    public static void renderMenuNav(Component paramCompTarget, Navbar paramMenuBar, String arg) {
        initMenuNav(paramCompTarget, paramMenuBar, arg);
    }

    private static void initMenuNav(Component paramCompTarget, Navbar paramMenuBar, String arg) {
        List<String> lsMenuIdId = new ArrayList<String>();
        MenuImpl menuService = new MenuImpl();
        try {
            List<Menu> lsMenu = menuService.getListMenu(arg);
            List<Nav> lsMenuArr = new ArrayList<Nav>();
            List<Nav> lsMenupopupArr = new ArrayList<Nav>();
            
            for (Menu mData : lsMenu) {
                if (!lsMenuIdId.contains(mData.getMenuIdId())) {
                    lsMenuIdId.add(mData.getMenuIdId());
                    if (mData.getParentId() == null || mData.getParentId().equalsIgnoreCase("0")) {
                        drawTreeMenuNav(paramCompTarget, paramMenuBar, lsMenuArr, lsMenupopupArr, mData);
                    } else {
                        drawTreeMenuNav(paramCompTarget, null, lsMenuArr, lsMenupopupArr, mData);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private static void drawTreeMenuNav(Component paramCompTarget, Navbar paramMenuBar, List<Nav> lsMenuArr, List<Nav> lsMenupopupArr, Menu mData) {
        String strMenupopupParent = PREFIX_MENU_POPUP + mData.getParentId();
        String strIconClassSubMenu = "z-icon-angle-double-right";

        if (mData.getMenuType().equalsIgnoreCase("0") && (mData.getPathContent() == null || mData.getPathContent().isEmpty())) {
            Nav m = new Nav();
            m.setId(PREFIX_MENU_POPUP + mData.getMenuIdId());
            m.setLabel(mData.getMenuName());
            m.setIconSclass(strIconClassSubMenu);
            m.setAttribute("data_value", mData);
            m.setParent(paramMenuBar);
            
            if (paramMenuBar == null) {
                for (Nav mpop : lsMenupopupArr) {
                    if (mpop.getId().equalsIgnoreCase(strMenupopupParent)) {
                        m.setParent(mpop);
                        break;
                    }
                }
            } else {
                m.setParent(paramMenuBar);
            }
            lsMenuArr.add(m);
            lsMenupopupArr.add(m);
        } else {
            Navitem mitem = new Navitem();
            mitem.setId(PREFIX_MENU_ITEM + mData.getMenuIdId());
            mitem.setLabel(mData.getMenuName());
            mitem.setIconSclass(strIconClassSubMenu);
            mitem.setAttribute("data_value", mData);
            mitem.addForward("onClick", paramCompTarget, "onOpenPage", mitem);
            
            if (paramMenuBar == null) {
                for (Nav mpop : lsMenupopupArr) {
                    if (mpop.getId().equalsIgnoreCase(strMenupopupParent)) {
                        mitem.setParent(mpop);
                        break;
                    }
                }
            } else {
                mitem.setParent(paramMenuBar);
            }
        }
    }
}
