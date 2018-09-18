package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;

import java.util.ArrayList;
import java.util.List;

public class SomesFormService {

    public List<Some> arrayList;

    public SomesFormService() {
        arrayList = new ArrayList<>();
    }

    public List<Some> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<Some> arrayList) {
        this.arrayList = arrayList;
    }

    public void addSome(Some some) {
        arrayList.add(some);
    }

}
