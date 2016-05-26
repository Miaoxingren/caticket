package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import threeq.caticket.entities.Seat;

@Repository
public class SeatRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	private class SeatMapper implements RowMapper<Seat> {
		public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
			Seat seat = new Seat();
			seat.setId(rs.getInt("id"));
			seat.setLineCnt(rs.getInt("lineCnt"));
			seat.setChairCnt(rs.getInt("chairCnt"));
			seat.setChairsByStr(rs.getString("chairs"));
		    return seat;
		}
	}
	
	public Seat findById(int id) {
		return jdbcTemplate.queryForObject("select * from seats where id = ?",
				new Object[]{id},
				new SeatMapper());
	}
	
	public boolean updateSeat(int seatId, String chairs) {
		int res = jdbcTemplate.update("update seats set chairs = '" + chairs + "' where id = ?",
				new Object[]{seatId});
		return res == 1;
	}
}
