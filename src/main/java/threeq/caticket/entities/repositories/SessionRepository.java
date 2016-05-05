package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import threeq.caticket.entities.Session;

@Repository
public class SessionRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	private class SessionMapper implements RowMapper<Session> {
		public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
			Session session = new Session();
			session.setId(rs.getInt("id"));
			session.setPlayDate(rs.getDate("playDate"));
			session.setBeginTime(rs.getTime("beginTime"));
			session.setEndTime(rs.getTime("endTime"));
			session.setCinemaName(rs.getString("cinemaName"));
			session.setLanguage(rs.getString("lang"));
			session.setMovieName(rs.getString("movieName"));
			session.setPrice(rs.getFloat("price"));
			session.setRoom(rs.getInt("room"));
		    return session;
		}
	}
	
	public List<Session> findAll() {
		return jdbcTemplate.query("select * from sessions", new SessionMapper());
	}
	
	public Session findByName(String movieName, String cinemaName) {
		return jdbcTemplate.queryForObject("select * from sessions where movieName = ? and cinemaName = ?",
				new Object[]{movieName, cinemaName},
				new SessionMapper());
	}
	
	public Session findById(int id) {
		return jdbcTemplate.queryForObject("select * from sessions where id = ?",
				new Object[]{id},
				new SessionMapper());
	}
}
