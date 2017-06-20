package com.agit.crm.common.dto.usermanagement;

import java.util.Date;

public class AccessTimeDTOBuilder {
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

    public AccessTimeDTOBuilder() {
    }

    public AccessTimeDTOBuilder setMondayStart(Date mondayStart) {
        this.mondayStart = mondayStart;
        return this;
    }

    public AccessTimeDTOBuilder setMondayEnd(Date mondayEnd) {
        this.mondayEnd = mondayEnd;
        return this;
    }

    public AccessTimeDTOBuilder setTuesdayStart(Date tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
        return this;
    }

    public AccessTimeDTOBuilder setTuesdayEnd(Date tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
        return this;
    }

    public AccessTimeDTOBuilder setWednesdayStart(Date wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
        return this;
    }

    public AccessTimeDTOBuilder setWednesdayEnd(Date wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
        return this;
    }

    public AccessTimeDTOBuilder setThursdayStart(Date thursdayStart) {
        this.thursdayStart = thursdayStart;
        return this;
    }

    public AccessTimeDTOBuilder setThursdayEnd(Date thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
        return this;
    }

    public AccessTimeDTOBuilder setFridayStart(Date fridayStart) {
        this.fridayStart = fridayStart;
        return this;
    }

    public AccessTimeDTOBuilder setFridayEnd(Date fridayEnd) {
        this.fridayEnd = fridayEnd;
        return this;
    }

    public AccessTimeDTOBuilder setSaturdayStart(Date saturdayStart) {
        this.saturdayStart = saturdayStart;
        return this;
    }

    public AccessTimeDTOBuilder setSaturdayEnd(Date saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
        return this;
    }

    public AccessTimeDTOBuilder setSundayStart(Date sundayStart) {
        this.sundayStart = sundayStart;
        return this;
    }

    public AccessTimeDTOBuilder setSundayEnd(Date sundayEnd) {
        this.sundayEnd = sundayEnd;
        return this;
    }

    public AccessTimeDTO createAccessTimeDTO() {
        return new AccessTimeDTO(mondayStart, mondayEnd, tuesdayStart, tuesdayEnd, wednesdayStart, wednesdayEnd, thursdayStart, thursdayEnd, fridayStart, fridayEnd, saturdayStart, saturdayEnd, sundayStart, sundayEnd);
    }

}
