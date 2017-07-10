package com.agit.crm.infrastructure.component.mdb;

import com.agit.crm.infrastructure.component.annotation.ReadableColumn;
import com.agit.crm.infrastructure.component.annotation.ReadableValue;
import com.agit.crm.infrastructure.component.annotation.WritableValue;

/**
 *
 * @author bayutridewanto
 */
public class MyMDBRecord {

    @ReadableColumn(column = "name", index = 1)
    private String name;

    @ReadableColumn(column = "address", index = 2)
    private String address;

    @ReadableValue(column = "name", index = 1)
    public String getName() {
        return name;
    }

    @WritableValue(column = "name", index = 1)
    public void setName(String name) {
        this.name = name;
    }

    @ReadableValue(column = "address", index = 2)
    public String getAddress() {
        return address;
    }

    @WritableValue(column = "address", index = 2)
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MyMDBRecord{" + "name=" + name + ", address=" + address + '}';
    }

}
