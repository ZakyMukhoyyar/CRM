package com.agit.crm.user.management.domain.user;

import java.util.Date;

public class AccessTimeBuilder {
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

    public AccessTimeBuilder() {
    }

    public AccessTimeBuilder setMondayStart(Date mondayStart) {
        this.mondayStart = mondayStart;
        return this;
    }

    public AccessTimeBuilder setMondayEnd(Date mondayEnd) {
        this.mondayEnd = mondayEnd;
        return this;
    }

    public AccessTimeBuilder setTuesdayStart(Date tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
        return this;
    }

    public AccessTimeBuilder setTuesdayEnd(Date tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
        return this;
    }

    public AccessTimeBuilder setWednesdayStart(Date wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
        return this;
    }

    public AccessTimeBuilder setWednesdayEnd(Date wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
        return this;
    }

    public AccessTimeBuilder setThursdayStart(Date thursdayStart) {
        this.thursdayStart = thursdayStart;
        return this;
    }

    public AccessTimeBuilder setThursdayEnd(Date thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
        return this;
    }

    public AccessTimeBuilder setFridayStart(Date fridayStart) {
        this.fridayStart = fridayStart;
        return this;
    }

    public AccessTimeBuilder setFridayEnd(Date fridayEnd) {
        this.fridayEnd = fridayEnd;
        return this;
    }

    public AccessTimeBuilder setSaturdayStart(Date saturdayStart) {
        this.saturdayStart = saturdayStart;
        return this;
    }

    public AccessTimeBuilder setSaturdayEnd(Date saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
        return this;
    }

    public AccessTimeBuilder setSundayStart(Date sundayStart) {
        this.sundayStart = sundayStart;
        return this;
    }

    public AccessTimeBuilder setSundayEnd(Date sundayEnd) {
        this.sundayEnd = sundayEnd;
        return this;
    }

    public AccessTime createAccessTime() {
        return new AccessTime(mondayStart, mondayEnd, tuesdayStart, tuesdayEnd, wednesdayStart, wednesdayEnd, thursdayStart, thursdayEnd, fridayStart, fridayEnd, saturdayStart, saturdayEnd, sundayStart, sundayEnd);
    }

}
