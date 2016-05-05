package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		return jdbcTemplate.queryForObject("select * from users where name = ?",
				new Object[]{name},
				new UserMapper());
	}

	public int insert(String name, String password) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		/*
		int updatecount = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, keyHolder);
		*/
		int updateCount = jdbcTemplate.update("insert into users (name, password) values (?, ?)", name, password, keyHolder);
		int id = keyHolder.getKey().intValue();
		return ((updateCount > 0) ? id : -1);
	}

}
