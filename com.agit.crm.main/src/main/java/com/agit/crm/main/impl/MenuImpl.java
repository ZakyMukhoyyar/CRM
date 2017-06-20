package com.agit.crm.main.impl;

import com.agit.crm.main.model.Menu;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.agit.crm.util.StringUtil;

import java.util.HashMap;

import java.net.URL;

public class MenuImpl {

    public List<Menu> getListMenu(String arg) {
        List<Menu> lsRes = new ArrayList<Menu>();
        Map<String, Object> outParam = new LinkedHashMap<String, Object>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            outParam = mapper.readValue(new URL("http://localhost:9091/adira-acction/init/menus.json"),
                    new TypeReference<HashMap<String, Object>>() {
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Map<String, Object>> lsData = (List<Map<String, Object>>) outParam.get("P_RC1");
        for (Map<String, Object> mapData : lsData) {
            Menu m = new Menu();
            m.setFlagDelete((String) StringUtil.nvl(mapData.get("FDELETE"), null));
            m.setIsActive((String) StringUtil.nvl(mapData.get("IS_ACTIVE"), null));
            m.setKeterangan((String) StringUtil.nvl(mapData.get("KETERANGAN"), null));
            m.setLogId((String) StringUtil.nvl(mapData.get("LOG_ID"), null));
            m.setMenuId((String) StringUtil.nvl(mapData.get("ID"), null));
            m.setMenuIdId((String) StringUtil.nvl(mapData.get("MENU_ID"), null));
            m.setMenuLevel((String) StringUtil.nvl(mapData.get("MENU_LEVEL"), null));
            m.setMenuName((String) StringUtil.nvl(mapData.get("MENU_NAME"), null));
            m.setMenuType((String) StringUtil.nvl(mapData.get("MENU_TYPE"), null));
            m.setParentId((String) StringUtil.nvl(mapData.get("PARENT_ID"), null));
            m.setPathContent((String) StringUtil.nvl(mapData.get("PATH_CONTENT"), null));
            m.setSortChild(Integer.parseInt(StringUtil.nvl(mapData.get("SORT_CHILD"), null).toString()));
            lsRes.add(m);
        }
        return lsRes;
    }
}
