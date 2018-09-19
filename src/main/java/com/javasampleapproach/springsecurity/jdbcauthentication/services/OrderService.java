package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import com.javasampleapproach.springsecurity.jdbcauthentication.dao.OrderDaoImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService implements IDAOService<Order> {

    @Autowired
    OrderDaoImp orderDaoImp;

    public OrderService() {
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orderDaoImp.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(Long id) {
        return orderDaoImp.getById(id);
    }

    @Override
    @Transactional
    public Order saveOrUpdate(Order product) {
        return orderDaoImp.saveOrUpdate(product);
    }

    @Override
    @Transactional
    public Order remove(Order product) {
        return null;
    }

}
