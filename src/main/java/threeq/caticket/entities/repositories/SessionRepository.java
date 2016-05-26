package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
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
			session.setSeatId(rs.getInt("seatId"));
			session.setMovieId(rs.getInt("movieId"));
			session.setCinemaId(rs.getInt("cinemaId"));
			session.setPlayDate(rs.getDate("playDate"));
			session.setBeginTime(rs.getTime("beginTime"));
			session.setEndTime(rs.getTime("endTime"));
			session.setPrice(rs.getFloat("price"));
			session.setRoom(rs.getInt("room"));
			session.setLanguage(rs.getString("lang"));
			session.setIsThreeD(rs.getBoolean("isThreeD"));
		    return session;
		}
	}
	
	public List<Session> findAll() {
		return jdbcTemplate.query("select * from sessions", new SessionMapper());
	}
	
	public Session findByMandC(int movieId, int cinemaId) {
		return jdbcTemplate.queryForObject("select * from sessions where movieId = ? and cinemaId = ?",
				new Object[]{movieId, cinemaId},
				new SessionMapper());
	}
	
	public List<Session> findByDate(Date date) {
		return jdbcTemplate.query("select * from sessions where playDate = ?",
				new Object[]{date.toString()},
				new SessionMapper());
	}
	
	public Session findById(int id) {
		return jdbcTemplate.queryForObject("select * from sessions where id = ?",
				new Object[]{id},
				new SessionMapper());
	}
}
