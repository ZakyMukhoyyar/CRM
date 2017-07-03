package com.agit.crm.main.viewmodel.admin;

import com.agit.crm.common.application.ForumService;
import com.agit.crm.common.dto.crm.ForumDTO;
import com.agit.crm.common.dto.crm.ForumDTOBuilder;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.util.CommonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author Zaky
 */
public class ForumVM {

    @WireVariable
    ForumService forumService;

    private ForumDTO forumDTO = new ForumDTO();
    private List<ForumDTO> forumDTOs = new ArrayList<>();

    /* Parameter Filter */
    private String idForum;
    private String namaForum;
    private Date tanggalBerakhir;
    private Boolean status;

    private PageNavigation previous;
    private int pageSize = 5;

    @Init
    public void init(
            @ExecutionArgParam("forumDTO") ForumDTO forum,
            @ExecutionArgParam("previous") PageNavigation previous){
        
    }
    
    private void initData(){
        forumDTOs = forumService.findAll();
        if(forumDTOs.isEmpty()){
            forumDTOs = Collections.emptyList();
        }
    }
    
    private void checkValidity(ForumDTO forum, PageNavigation previous) {
        if (forum == null) {
            ListModelList<ForumDTO> parameterList = new ListModelList<>(forumService.findAll());
            String idForum = "";
            if (parameterList.isEmpty()) {
                idForum = "1";
            } else {
                idForum = getLatestObjectID(parameterList, "idForum");
            }
            forumDTO = new ForumDTOBuilder()
                    .setIdForum(idForum)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createForumDTO();
        } else {
            this.forumDTO = forum;
            idForum = forumDTO.getIdForum();
            this.previous = previous;
        }
    }
    
    protected String getLatestObjectID(ListModelList list, String attribute) {
        int count = 0;
        int pointer = 0;
        int max = 0;
        String s = "";
        for (Object obj : list) {
            Map<String, Object> map = CommonUtil.convertObject2Map(obj);
            String att = attribute;
            String[] arr = new String[attribute.length()];
            String key = "";
            if (att.contains(".")) {
                arr = att.split("\\.");
                int f = 1;
                for (Object x : arr) {
                    if (f != arr.length) {
                        map = CommonUtil.convertObject2Map(map.get(x.toString()));
                    } else {
                        key = x.toString();
                    }
                    f += 1;
                }
            } else {
                key = att;
            }
            att = map.get(key).toString();
            String temp = "";
            int countTemp = 0;
            for (int i = att.length(); i > 0; i--) {
                if (Character.isLetter(att.charAt(i - 1))) {
                    pointer = i;
                    s = att.substring(0, pointer);
                    break;
                }
                countTemp += 1;
                temp = att.charAt(i - 1) + temp;
            }
            if (Integer.parseInt(temp) > max) {
                max = Integer.parseInt(temp);
            }
            count = countTemp;
        }
        return s + String.format("%0" + count + "d", max + 1);
    }
    
    @GlobalCommand
    @NotifyChange("forumDTOs")
    public void refreshForum(){
        forumDTOs = forumService.findAll();
    }
    
    
    /* getter setter */

    public ForumService getForumService() {
        return forumService;
    }

    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }

    public ForumDTO getForumDTO() {
        return forumDTO;
    }

    public void setForumDTO(ForumDTO forumDTO) {
        this.forumDTO = forumDTO;
    }

    public List<ForumDTO> getForumDTOs() {
        return forumDTOs;
    }

    public void setForumDTOs(List<ForumDTO> forumDTOs) {
        this.forumDTOs = forumDTOs;
    }

    public String getIdForum() {
        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }

    public String getNamaForum() {
        return namaForum;
    }

    public void setNamaForum(String namaForum) {
        this.namaForum = namaForum;
    }

    public Date getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public void setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
}
