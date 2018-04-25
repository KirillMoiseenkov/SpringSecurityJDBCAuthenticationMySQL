package com.javasampleapproach.springsecurity.jdbcauthentication;

import java.sql.SQLException;

public class TestMain {
    public static void main(String[] args) {

        JDBCTest jdbcTest = new JDBCTest();

        try {
            jdbcTest.getUser("kirill");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
