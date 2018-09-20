package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import com.javasampleapproach.springsecurity.jdbcauthentication.dao.ProductDaoImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements IProductDAOService<Product> {

    @Autowired
    ProductDaoImp productDaoImp;

    public ProductService() {
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productDaoImp.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productDaoImp.getById(id);
    }

    @Override
    @Transactional
    public Product saveOrUpdate(Product product) {
        return productDaoImp.saveOrUpdate(product);
    }

    @Override
    @Transactional
    public Product remove(Product product) {
        return null;
    }

    @Override
    public Product getByName(String name) {
        return productDaoImp.getByName(name);
    }
}
