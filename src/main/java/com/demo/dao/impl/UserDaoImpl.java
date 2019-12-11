package com.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.dao.UserDao;
import com.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		String sql = "INSERT INTO USER(UID,USERNAME, PASSWORD,GENDER) VALUE(?,?,?,?)";
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String uid = String.valueOf(timestamp.getTime());
		
		jdbcTemplate.update(sql, uid, user.getName(), user.getPassword(),user.getGender());

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(String uid) {
		String sql = "DELETE FROM USER WHERE UID = ?";
		jdbcTemplate.update(sql, uid);
	}

	public User getUserById(String id) {
		String sql = "SELECT * FROM USER WHERE UID LIKE ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getString("uid"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
	}

	public List<User> getUserList() {
		String sql = "SELECT * FROM USER";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getString("uid"));
				user.setName(rs.getString("username").toLowerCase());
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				return user;
			}
		});
	}

}
