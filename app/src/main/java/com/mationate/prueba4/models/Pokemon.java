package com.mationate.prueba4.models;

import com.orm.SugarRecord;

public class Pokemon extends SugarRecord {

    private int number;
    private String name, url;

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }


    public int getNumber() {
        String[] split = url.split("/");
        return Integer.parseInt(split[split.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


