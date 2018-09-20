package com.javasampleapproach.springsecurity.jdbcauthentication.dao;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderDaoImp implements IDAO<Order> {

    @PersistenceContext
    private EntityManager entityManager;

    public OrderDaoImp() {

    }


    @Override
    public List<Order> getAll() {
        return (List<Order>) entityManager.createQuery("SELECT p FROM Order p").getResultList();
    }

    @Override
    public Order getById(Long id) {
        return (Order) entityManager.find(Order.class, id);
    }


    @Override
    public Order saveOrUpdate(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public Order remove(Order order) {
        return entityManager.merge(order);
    }
}
