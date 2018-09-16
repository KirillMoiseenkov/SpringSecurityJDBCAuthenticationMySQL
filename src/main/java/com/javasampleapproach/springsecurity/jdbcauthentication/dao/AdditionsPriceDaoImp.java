package com.javasampleapproach.springsecurity.jdbcauthentication.dao;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.AdditionsPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AdditionsPriceDaoImp implements IDAO<AdditionsPrice> {

    @PersistenceContext
    private EntityManager entityManager;

    public AdditionsPriceDaoImp() {
    }

    @Override
    public List<AdditionsPrice> getAll() {
        return (List<AdditionsPrice>) entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    @Override
    public AdditionsPrice getById(Long id) {
        return (AdditionsPrice) entityManager.find(AdditionsPrice.class, id);
    }

    @Override
    public AdditionsPrice saveOrUpdate(AdditionsPrice additionsPrice) {
        return null;
    }

    @Override
    public AdditionsPrice remove(AdditionsPrice additionsPrice) {
        return entityManager.merge(additionsPrice);
    }
}
