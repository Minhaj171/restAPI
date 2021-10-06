package com.example.restapi.model;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class Position {
    private String name;
    int countryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Position(String name, int countryId) {
        this.name = name;
        this.countryId = countryId;
    }
}
