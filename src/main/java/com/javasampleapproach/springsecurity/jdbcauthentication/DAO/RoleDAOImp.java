package com.javasampleapproach.springsecurity.jdbcauthentication.DAO;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDAOImp implements IRoleDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public Role getByUserName(String userName) {

        Role role = new Role();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select username, role from user_roles where username=?";

        List<Role> roles = jdbcTemplate.query(sql, new Object[]{userName}, new RowMapper<Role>() {
            public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                role.setUserName(userName);
                role.setRole(rs.getString("role"));
                return role;
            }
        });

        return role;
    }
}
