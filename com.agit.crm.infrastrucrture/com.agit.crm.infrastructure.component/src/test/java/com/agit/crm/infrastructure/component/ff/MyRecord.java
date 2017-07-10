package com.agit.crm.infrastructure.component.ff;

import com.ancientprogramming.fixedformat4j.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bayutridewanto
 */
@Record
//@Readable(value = "true")
public class MyRecord {

    private String stringData;
    private Integer integerData;
    private Date dateData;
    private Character charData;
    private Boolean booleanData;
    private Long longData;
    private Double doubleData;
    private Float floatData;
    private BigDecimal bigDecimalData;
    private float simpleFloatData;

    @Field(offset = 1, length = 10, align = Align.RIGHT, paddingChar = ' ')
    //@ReadableValue(column = "stringData", index = 1)
    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    public void setIntegerData(Integer integerData) {
        this.integerData = integerData;
    }

    @Field(offset = 11, length = 5, align = Align.RIGHT, paddingChar = '0')
    //@ReadableValue(column = "integerData", index = 2)
    public Integer getIntegerData() {
        return integerData;
    }

    @Field(offset = 16, length = 8)
    //@ReadableValue(column = "dateData", index = 3)
    public Date getDateData() {
        return dateData;
    }

    public void setDateData(Date dateData) {
        this.dateData = dateData;
    }

    @Field(offset = 24, length = 1)
    public Character getCharData() {
        return charData;
    }

    public void setCharData(Character charData) {
        this.charData = charData;
    }

    @Field(offset = 25, length = 1)
    public Boolean isBooleanData() {
        return booleanData;
    }

    public void setBooleanData(Boolean booleanData) {
        this.booleanData = booleanData;
    }

    @Field(offset = 26, length = 4, align = Align.RIGHT, paddingChar = '0')
    public Long getLongData() {
        return longData;
    }

    public void setLongData(Long longData) {
        this.longData = longData;
    }

    @Field(offset = 30, length = 10, align = Align.RIGHT, paddingChar = '0')
    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

    @Field(offset = 40, length = 10, align = Align.RIGHT, paddingChar = '0')
    public Float getFloatData() {
        return floatData;
    }

    public void setFloatData(Float floatData) {
        this.floatData = floatData;
    }

    @Field(offset = 50, length = 10, align = Align.RIGHT, paddingChar = '0')
    @FixedFormatDecimal(decimals = 4, decimalDelimiter = ' ', useDecimalDelimiter = true)
    @FixedFormatNumber(sign = Sign.PREPEND)
    public BigDecimal getBigDecimalData() {
        return bigDecimalData;
    }

    public void setBigDecimalData(BigDecimal bigDecimalData) {
        this.bigDecimalData = bigDecimalData;
    }

    @Field(offset = 60, length = 10, align = Align.RIGHT, paddingChar = '0')
    public float getSimpleFloatData() {
        return simpleFloatData;
    }

    public void setSimpleFloatData(float simpleFloatData) {
        this.simpleFloatData = simpleFloatData;
    }

//    @Record
//    static class MyStaticNestedClass {
//
//        private String stringData;
//
//        @Field(offset = 1, length = 10)
//        public String getStringData() {
//            return stringData;
//        }
//
//        public void setStringData(String stringData) {
//            this.stringData = stringData;
//        }
//    }
//
//    @Record
//    class MyInnerClass {
//
//        private String stringData;
//
//        @Field(offset = 1, length = 10)
//        public String getStringData() {
//            return stringData;
//        }
//
//        public void setStringData(String stringData) {
//            this.stringData = stringData;
//        }
//    }
}
