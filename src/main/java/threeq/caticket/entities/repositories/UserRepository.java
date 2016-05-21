package threeq.caticket.entities.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import threeq.caticket.entities.User;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		    return user;
		}
	}

	public List<User> findAll() {
		return jdbcTemplate.query("select * from users",
				new UserMapper());
	}
	
	public User findByName(String name) {
		//使用queryforlist查询，结果为空会抛出错误
		try {
			return jdbcTemplate.queryForObject("select * from users where name = ?",
					new Object[]{name},
					new UserMapper());
		} catch(Exception e) {
			return null;
		}
	}
	
	public User findById(int id) {
		try {
			return jdbcTemplate.queryForObject("select * from users where id = ?",
					new Object[]{id},
					new UserMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public int insert(String name, String password) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into users (name, password) values (?, ?)";
		int updateCount = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, name);
				ps.setString(2, password);
				return ps;
			}
		}, keyHolder);
		int id = keyHolder.getKey().intValue();
		return ((updateCount > 0) ? id : -1);
	}
	
	public boolean updateName(int id, String name) {
		boolean temp = false;
		if (name != "") {
			String sql = "update users set name=? where id=?";
			int updateCount = jdbcTemplate.update(sql, new Object[]{name, id});
			temp = (updateCount > 0) ? true:false;
		}
		return temp;
	}
	
	public boolean updatePassword(int id, String password) {
		boolean temp = false;
		if (password != "") {
			String sql = "update users set password=? where id=?";
			int updateCount = jdbcTemplate.update(sql, new Object[]{password, id});
			temp = (updateCount > 0) ? true:false;
		}
		return temp;
	}

}
