package com.agit.crm.infrastructure.component.xls;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;

/**
 *
 * @author bayutridewanto
 */
public class Student {

    @ReadableColumn(column = "name",index=1)
    private String name;
    @ReadableColumn(column = "name",index=2)
    private String maths;
    @ReadableColumn(column = "name",index=3)
    private String science;
    @ReadableColumn(column = "name",index=4)
    private String english;

    public Student() {
    }

    public Student(String name, String maths, String science, String english) {
        this.name = name;
        this.maths = maths;
        this.science = science;
        this.english = english;
    }

    @ReadableValue(column = "name",index=1)
    public String getName() {
        return name;
    }

    @WritableValue(column = "name",index=1)
    public void setName(String name) {
        this.name = name;
    }

    @ReadableValue(column = "maths",index=2)
    public String getMaths() {
        return maths;
    }

    @WritableValue(column = "maths",index=2)
    public void setMaths(String maths) {
        this.maths = maths;
    }

    @ReadableValue(column = "science",index=3)
    public String getScience() {
        return science;
    }

    @WritableValue(column = "science",index=3)
    public void setScience(String science) {
        this.science = science;
    }

    @ReadableValue(column = "english",index=4)
    public String getEnglish() {
        return english;
    }

    @WritableValue(column = "english",index=4)
    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return name + ": Maths " + maths + " Science " + science + " English " + english;
    }
}
