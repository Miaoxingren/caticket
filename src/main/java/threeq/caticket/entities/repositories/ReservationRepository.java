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
			reservation.setSessionId(rs.getInt("sessionId"));
			reservation.setUserId(rs.getInt("userId"));
			reservation.setPrice(rs.getFloat("price"));
			reservation.setSeatCnt(rs.getInt("seatCnt"));
			reservation.setSeats(rs.getString("seats"));
			reservation.setPaied(rs.getBoolean("isPaied"));
		    return reservation;
		}
	}

	public List<Reservation> findByUserId(final int userId) {
		return jdbcTemplate.query("select * from reservations where userId = ?",
				new Object[]{userId},
				new ReservationMapper());
	}

	public Reservation findById(final int id) {
		return jdbcTemplate.queryForObject("select * from reservations where id = ?",
				new Object[]{id},
				new ReservationMapper());
	}

	public boolean addOne(final Reservation reservation) {
		int res = jdbcTemplate.update("insert into reservations " +
				"(userId, sessionId, seatCnt, seats, price, isPaied) values (?, ?, ?, ?, ?, ?)",
				reservation.getUserId(),
				reservation.getSessionId(),
				reservation.getSeatCnt(),
				reservation.getSeats(),
				reservation.getPrice(),
				reservation.getPaied());
		return res == 1;
	}
}
