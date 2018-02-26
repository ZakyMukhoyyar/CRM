/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.scheduler;

import com.agit.crm.common.application.StoringFICardService;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTO;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardDTOBuilder;
import com.agit.crm.common.dto.storing.fi.card.StoringFICardSecondary;
import com.agit.crm.infrastructure.component.csv.CsvReader;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.util.media.Media;

/**
 *
 * @author BayuHS
 */
public class SchedulerMonitoringFolder {

    @Autowired
    StoringFICardService storingFICardService;
    Media mediaUploadStoringFICard;
    String mediaNameUploadStoringFICard;
    private String filepathUploadStoringFICard = "D:\\AGIT\\Training-Material\\Project\\Project Storing FI Card Online\\POC\\point-check.csv";
    private String pathLocationUploadStoringFICard;

    public void execute() throws FileNotFoundException {
        CsvReader<StoringFICardSecondary> jxr = new CsvReader<>(StoringFICardSecondary.class);
        List<StoringFICardSecondary> ls = jxr.getJavaObjectFromThisFile(filepathUploadStoringFICard + mediaNameUploadStoringFICard);
        for (StoringFICardSecondary s : ls) {
            StoringFICardDTO m = new StoringFICardDTOBuilder()
                    .setStoringFICardID(s.getStoringFICardID())
                    .setPointCheck1(s.getPointCheck1())
                    .setPointCheck2(s.getPointCheck2())
                    .setPointCheck3(s.getPointCheck3())
                    .setPointCheck4(s.getPointCheck4())
                    .setPointCheck5(s.getPointCheck5())
                    .setCreatedDate(new Date())
                    .createStoringFICardDTO();
            try {
                storingFICardService.SaveOrUpdate(m);
                System.out.println("Row " + s.getStoringFICardID() + " SUCCESS");
            } catch (Exception e) {
                System.out.println("Row " + s.getStoringFICardID() + " FAILED");
            }
        }
    }

    public StoringFICardService getStoringFICardService() {
        return storingFICardService;
    }

    public void setStoringFICardService(StoringFICardService storingFICardService) {
        this.storingFICardService = storingFICardService;
    }

    public Media getMediaUploadStoringFICard() {
        return mediaUploadStoringFICard;
    }

    public void setMediaUploadStoringFICard(Media mediaUploadStoringFICard) {
        this.mediaUploadStoringFICard = mediaUploadStoringFICard;
    }

    public String getMediaNameUploadStoringFICard() {
        return mediaNameUploadStoringFICard;
    }

    public void setMediaNameUploadStoringFICard(String mediaNameUploadStoringFICard) {
        this.mediaNameUploadStoringFICard = mediaNameUploadStoringFICard;
    }

    public String getFilepathUploadStoringFICard() {
        return filepathUploadStoringFICard;
    }

    public void setFilepathUploadStoringFICard(String filepathUploadStoringFICard) {
        this.filepathUploadStoringFICard = filepathUploadStoringFICard;
    }

    public String getPathLocationUploadStoringFICard() {
        return pathLocationUploadStoringFICard;
    }

    public void setPathLocationUploadStoringFICard(String pathLocationUploadStoringFICard) {
        this.pathLocationUploadStoringFICard = pathLocationUploadStoringFICard;
    }

}
