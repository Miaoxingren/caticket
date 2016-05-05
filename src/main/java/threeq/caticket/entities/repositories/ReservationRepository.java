package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import threeq.caticket.entities.Reservation;

@Repository
public class ReservationRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	private class ReservationMapper implements RowMapper<Reservation> {
		public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reservation reservation = new Reservation();
			reservation.setId(rs.getInt("id"));
			reservation.setCinemaName(rs.getString("cinemaName"));
			reservation.setMovieName(rs.getString("movieName"));
			reservation.setTicketCnt(rs.getInt("ticketCnt"));
			String position = rs.getString("position");
			reservation.setPosition(position.split(":"));
		    return reservation;
		}
	}
	
	public List<Reservation> findAll() {
		return jdbcTemplate.query("select * from reservations", new ReservationMapper());
	}
	
	public Reservation findByName(String movieName, String cinemaName) {
		return jdbcTemplate.queryForObject("select * from reservations where movieName = ? and cinemaName = ?",
				new Object[]{movieName, cinemaName},
				new ReservationMapper());
	}
	
	public Reservation findById(int id) {
		return jdbcTemplate.queryForObject("select * from reservations where id = ?",
				new Object[]{id},
				new ReservationMapper());
	}
}
