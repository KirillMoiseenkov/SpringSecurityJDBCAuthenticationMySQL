package com.javasampleapproach.springsecurity.jdbcauthentication.models;

public class Role {

    private String userName;
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
