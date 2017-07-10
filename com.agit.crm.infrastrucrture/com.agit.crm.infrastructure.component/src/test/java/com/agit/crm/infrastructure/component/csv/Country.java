package com.agit.crm.infrastructure.component.csv;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.Readable;
import java.io.Serializable;

/**
 *
 * @author bayutridewanto
 */


@Readable(value = "true")
public class Country implements Serializable {
    
    @ReadableColumn(column="countryName",index=1)
    private String countryName;
    
    @ReadableColumn(column="capital",index=2)
    private String capital;

    @ReadableValue(column="countryName",index=1)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @ReadableValue(column="capital",index=2)
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
