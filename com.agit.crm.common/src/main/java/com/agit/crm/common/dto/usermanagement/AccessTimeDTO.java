package com.agit.crm.common.dto.usermanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bayutridewanto
 */
public class AccessTimeDTO implements Serializable {

    private Date mondayStart;
    private Date mondayEnd;
    private Date tuesdayStart;
    private Date tuesdayEnd;
    private Date wednesdayStart;
    private Date wednesdayEnd;
    private Date thursdayStart;
    private Date thursdayEnd;
    private Date fridayStart;
    private Date fridayEnd;
    private Date saturdayStart;
    private Date saturdayEnd;
    private Date sundayStart;
    private Date sundayEnd;

    public AccessTimeDTO() {
    }

    public AccessTimeDTO(Date mondayStart, Date mondayEnd, Date tuesdayStart, Date tuesdayEnd, Date wednesdayStart, Date wednesdayEnd, Date thursdayStart, Date thursdayEnd, Date fridayStart, Date fridayEnd, Date saturdayStart, Date saturdayEnd, Date sundayStart, Date sundayEnd) {
        this.mondayStart = mondayStart;
        this.mondayEnd = mondayEnd;
        this.tuesdayStart = tuesdayStart;
        this.tuesdayEnd = tuesdayEnd;
        this.wednesdayStart = wednesdayStart;
        this.wednesdayEnd = wednesdayEnd;
        this.thursdayStart = thursdayStart;
        this.thursdayEnd = thursdayEnd;
        this.fridayStart = fridayStart;
        this.fridayEnd = fridayEnd;
        this.saturdayStart = saturdayStart;
        this.saturdayEnd = saturdayEnd;
        this.sundayStart = sundayStart;
        this.sundayEnd = sundayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getMondayStart() {
        return mondayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getMondayEnd() {
        return mondayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getTuesdayStart() {
        return tuesdayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getTuesdayEnd() {
        return tuesdayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getWednesdayStart() {
        return wednesdayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getWednesdayEnd() {
        return wednesdayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getThursdayStart() {
        return thursdayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getThursdayEnd() {
        return thursdayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getFridayStart() {
        return fridayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getFridayEnd() {
        return fridayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getSaturdayStart() {
        return saturdayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getSaturdayEnd() {
        return saturdayEnd;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getSundayStart() {
        return sundayStart;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT+7")
    public Date getSundayEnd() {
        return sundayEnd;
    }

    public void setMondayStart(Date mondayStart) {
        this.mondayStart = mondayStart;
    }

    public void setMondayEnd(Date mondayEnd) {
        this.mondayEnd = mondayEnd;
    }

    public void setTuesdayStart(Date tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public void setTuesdayEnd(Date tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
    }

    public void setWednesdayStart(Date wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
    }

    public void setWednesdayEnd(Date wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
    }

    public void setThursdayStart(Date thursdayStart) {
        this.thursdayStart = thursdayStart;
    }

    public void setThursdayEnd(Date thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
    }

    public void setFridayStart(Date fridayStart) {
        this.fridayStart = fridayStart;
    }

    public void setFridayEnd(Date fridayEnd) {
        this.fridayEnd = fridayEnd;
    }

    public void setSaturdayStart(Date saturdayStart) {
        this.saturdayStart = saturdayStart;
    }

    public void setSaturdayEnd(Date saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
    }

    public void setSundayStart(Date sundayStart) {
        this.sundayStart = sundayStart;
    }

    public void setSundayEnd(Date sundayEnd) {
        this.sundayEnd = sundayEnd;
    }

    @Override
    public String toString() {
        return "AccessTimeDTO{" + "mondayStart=" + mondayStart + ", mondayEnd=" + mondayEnd + ", tuesdayStart=" + tuesdayStart + ", tuesdayEnd=" + tuesdayEnd + ", wednesdayStart=" + wednesdayStart + ", wednesdayEnd=" + wednesdayEnd + ", thursdayStart=" + thursdayStart + ", thursdayEnd=" + thursdayEnd + ", fridayStart=" + fridayStart + ", fridayEnd=" + fridayEnd + ", saturdayStart=" + saturdayStart + ", saturdayEnd=" + saturdayEnd + ", sundayStart=" + sundayStart + ", sundayEnd=" + sundayEnd + '}';
    }

    public static AccessTimeDTO getInstance() {
        AccessTimeDTO accessTime = new AccessTimeDTOBuilder()
                .setFridayEnd(new Date())
                .setFridayStart(new Date())
                .setMondayEnd(new Date())
                .setMondayStart(new Date())
                .setSaturdayEnd(new Date())
                .setSaturdayStart(new Date())
                .setSundayEnd(new Date())
                .setSundayStart(new Date())
                .setThursdayEnd(new Date())
                .setThursdayStart(new Date())
                .setTuesdayEnd(new Date())
                .setTuesdayStart(new Date())
                .setWednesdayEnd(new Date())
                .setWednesdayStart(new Date())
                .createAccessTimeDTO();
        return accessTime;
    }
}
