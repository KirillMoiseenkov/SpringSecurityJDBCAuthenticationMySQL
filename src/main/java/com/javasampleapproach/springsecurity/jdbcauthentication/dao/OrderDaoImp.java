package com.javasampleapproach.springsecurity.jdbcauthentication.dao;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderDaoImp implements IDAO<Order> {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = Logger.getLogger(OrderDaoImp.class);

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
        log.debug("add/merge new order: " + order.toString());
        return entityManager.merge(order); //предполагается, что его не существует,поэтому megre
    }

    @Override
    public Order remove(Order order) {
        log.debug("remove order: " + order.toString());
        entityManager.merge(order);
        return order;
    }
}
