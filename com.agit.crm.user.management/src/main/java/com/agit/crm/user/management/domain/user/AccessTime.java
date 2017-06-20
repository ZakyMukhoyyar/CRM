package com.agit.crm.user.management.domain.user;

import com.agit.crm.shared.object.ValueObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author bayutridewanto
 */
public class AccessTime implements ValueObject<AccessTime>{
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

    public AccessTime() {
    }

    public AccessTime(Date mondayStart, Date mondayEnd, Date tuesdayStart, Date tuesdayEnd, Date wednesdayStart, Date wednesdayEnd, Date thursdayStart, Date thursdayEnd, Date fridayStart, Date fridayEnd, Date saturdayStart, Date saturdayEnd, Date sundayStart, Date sundayEnd) {
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

    public Date getMondayStart() {
        return mondayStart;
    }

    public Date getMondayEnd() {
        return mondayEnd;
    }

    public Date getTuesdayStart() {
        return tuesdayStart;
    }

    public Date getTuesdayEnd() {
        return tuesdayEnd;
    }

    public Date getWednesdayStart() {
        return wednesdayStart;
    }

    public Date getWednesdayEnd() {
        return wednesdayEnd;
    }

    public Date getThursdayStart() {
        return thursdayStart;
    }

    public Date getThursdayEnd() {
        return thursdayEnd;
    }

    public Date getFridayStart() {
        return fridayStart;
    }

    public Date getFridayEnd() {
        return fridayEnd;
    }

    public Date getSaturdayStart() {
        return saturdayStart;
    }

    public Date getSaturdayEnd() {
        return saturdayEnd;
    }

    public Date getSundayStart() {
        return sundayStart;
    }

    public Date getSundayEnd() {
        return sundayEnd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.mondayStart);
        hash = 67 * hash + Objects.hashCode(this.mondayEnd);
        hash = 67 * hash + Objects.hashCode(this.tuesdayStart);
        hash = 67 * hash + Objects.hashCode(this.tuesdayEnd);
        hash = 67 * hash + Objects.hashCode(this.wednesdayStart);
        hash = 67 * hash + Objects.hashCode(this.wednesdayEnd);
        hash = 67 * hash + Objects.hashCode(this.thursdayStart);
        hash = 67 * hash + Objects.hashCode(this.thursdayEnd);
        hash = 67 * hash + Objects.hashCode(this.fridayStart);
        hash = 67 * hash + Objects.hashCode(this.fridayEnd);
        hash = 67 * hash + Objects.hashCode(this.saturdayStart);
        hash = 67 * hash + Objects.hashCode(this.saturdayEnd);
        hash = 67 * hash + Objects.hashCode(this.sundayStart);
        hash = 67 * hash + Objects.hashCode(this.sundayEnd);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccessTime other = (AccessTime) obj;
        if (!Objects.equals(this.mondayStart, other.mondayStart)) {
            return false;
        }
        if (!Objects.equals(this.mondayEnd, other.mondayEnd)) {
            return false;
        }
        if (!Objects.equals(this.tuesdayStart, other.tuesdayStart)) {
            return false;
        }
        if (!Objects.equals(this.tuesdayEnd, other.tuesdayEnd)) {
            return false;
        }
        if (!Objects.equals(this.wednesdayStart, other.wednesdayStart)) {
            return false;
        }
        if (!Objects.equals(this.wednesdayEnd, other.wednesdayEnd)) {
            return false;
        }
        if (!Objects.equals(this.thursdayStart, other.thursdayStart)) {
            return false;
        }
        if (!Objects.equals(this.thursdayEnd, other.thursdayEnd)) {
            return false;
        }
        if (!Objects.equals(this.fridayStart, other.fridayStart)) {
            return false;
        }
        if (!Objects.equals(this.fridayEnd, other.fridayEnd)) {
            return false;
        }
        if (!Objects.equals(this.saturdayStart, other.saturdayStart)) {
            return false;
        }
        if (!Objects.equals(this.saturdayEnd, other.saturdayEnd)) {
            return false;
        }
        if (!Objects.equals(this.sundayStart, other.sundayStart)) {
            return false;
        }
        if (!Objects.equals(this.sundayEnd, other.sundayEnd)) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean sameValueAs(AccessTime other) {
        return this.equals(other);
    }

}