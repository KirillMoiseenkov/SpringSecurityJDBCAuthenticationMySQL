package com.javasampleapproach.springsecurity.jdbcauthentication.dao;

public interface IProductDAO<T> extends IDAO<T> {

    T getByName(String name);
}
