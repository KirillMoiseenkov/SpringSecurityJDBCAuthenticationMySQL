package com.javasampleapproach.springsecurity.jdbcauthentication.dao;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Product;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDaoImp implements IProductDAO<Product> {

    private static final Logger log = Logger.getLogger(ProductDaoImp.class);

    @PersistenceContext
    private EntityManager entityManager;

    public ProductDaoImp() {
    }


    @Override
    public List<Product> getAll() {

        return (List<Product>) entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    @Override
    public Product getById(Long id) {
        return (Product) entityManager.find(Product.class, id);
    }


    @Override
    public Product saveOrUpdate(Product product) {

        log.debug("add/merge new product: " + product.toString());
        return entityManager.merge(product); //предполагается, что его не существует,поэтому megre
    }

    @Override
    public Product remove(Product product) {

        log.debug("remove product: " + product.toString());
        entityManager.remove(product);
        return product;

    }

    @Override
    public Product getByName(String name) {
        return (Product) entityManager.createQuery("SELECT p FROM Product p WHERE p.name = :name")
                .setParameter("name", name).getSingleResult();

    }

}
