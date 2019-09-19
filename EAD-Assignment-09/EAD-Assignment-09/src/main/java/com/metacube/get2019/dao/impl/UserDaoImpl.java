/*package com.metacube.get2019.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import com.metacube.get2019.dao.UserDao;
import com.metacube.get2019.model.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private final String SQL_INSERT_USER = "insert into employee(full_name, gender,email_id,contact,password,organization) values(?,?,?,?,?,?)";

	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean add(User user) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER); 
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getGender());
                ps.setString(3, user.getEmail());
                ps.setLong(4, user.getContact());
                ps.setString(5, user.getPassword());
                ps.setString(6,user.getOrganization());
                return ps;
            }
        });
		return row > 0 ?true : false;
		
		
	}
	

}
*/