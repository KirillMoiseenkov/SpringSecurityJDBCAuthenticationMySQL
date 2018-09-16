package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import java.util.List;

public interface IDAOService<T> {

    List<T> getAll();

    T getById(Long id);

    T saveOrUpdate(T t);

    T remove(T t);
}
