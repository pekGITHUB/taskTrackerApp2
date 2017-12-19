package com.oosdclass.taskTrackerApp2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oosdclass.taskTrackerApp2.dao.UserDAO;
import com.oosdclass.taskTrackerApp2.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	//userDAOImpl is dependent on jdbc template 
	//so we need to inject the dependency

	//jdbc template is a class provided by spring jdbc 
	//to perform CRUD and map data in rows to objects
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User retrieveByUserName(String username) {
		//this is the sql query that we want to run on the db
		String sql = "select * from user where username=?";
		User user = (User) jdbcTemplate.queryForObject(sql, new Object[] { username }, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				return user;
			}
		});
		return user;
	}

}
