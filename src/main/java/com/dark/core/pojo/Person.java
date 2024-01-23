package com.dark.core.pojo;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvRecurse;

public class Person {
    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String position;

    @CsvRecurse
    private AddressInfo info;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public AddressInfo getInfo() {
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setInfo(AddressInfo info) {
        this.info = info;
    }
}
