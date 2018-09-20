/*
package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import com.javasampleapproach.springsecurity.jdbcauthentication.dao.AdditionsPriceDaoImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.AdditionsPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalPriceService implements IDAOService<AdditionsPrice> {

    @Autowired
    AdditionsPriceDaoImp additionsPriceDaoImp;

    @Override
    public List<AdditionsPrice> getAll() {
        return additionsPriceDaoImp.getAll();
    }

    @Override
    public AdditionsPrice getById(Long id) {
        return additionsPriceDaoImp.getById(id);
    }

    @Override
    public AdditionsPrice saveOrUpdate(AdditionsPrice additionsPrice) {
        return additionsPriceDaoImp.saveOrUpdate(additionsPrice);
    }

    @Override
    public AdditionsPrice remove(AdditionsPrice additionsPrice) {
        return additionsPriceDaoImp.remove(additionsPrice);
    }

    public AdditionsPrice getByTypeProduct(String typeProduct) {
        return additionsPriceDaoImp.getByTypeProduct(typeProduct);
    }
}
*/
