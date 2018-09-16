package com.javasampleapproach.springsecurity.jdbcauthentication.models;

public class Some {

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Some{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
