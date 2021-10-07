package com.example.restapi.model;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/7/2021.
 */
public class DemoBaseModel {
    private List<DemoSubModel> data;

    public DemoBaseModel(List<DemoSubModel> data) {
        this.data = data;
    }

    public List<DemoSubModel> getData() {
        return data;
    }

    public void setData(List<DemoSubModel> data) {
        this.data = data;
    }
}
