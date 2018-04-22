package com.javasampleapproach.springsecurity.jdbcauthentication.DAO.interfaces;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Role;

public interface IRoleDAO {

    public Role getByUserName(String userName);

}
