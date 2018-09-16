package com.javasampleapproach.springsecurity.jdbcauthentication.services;

public interface IProductDAOService<T> extends IDAOService<T> {

    T getByName(String name);
}
