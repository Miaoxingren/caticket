package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import threeq.caticket.entities.Cinema;

@Repository
public class CinemaRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	private class CinemaMapper implements RowMapper<Cinema> {
		public Cinema mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cinema cinema = new Cinema();
			cinema.setId(rs.getInt("id"));
			cinema.setName(rs.getString("name"));
			cinema.setScore(rs.getFloat("score"));
			cinema.setLocation(rs.getString("location"));
			cinema.setArea(rs.getString("area"));
			cinema.setPhone(rs.getString("phone"));
			
			String[] movies = rs.getString("movieList").split(",");
			int[] movieList = new int[movies.length];
			for (int i = 0; i < movies.length; i++) {
				movieList[i] = Integer.parseInt(movies[i]);
			}
			
			cinema.setMovieList(movieList);
		    return cinema;
		}
	}
	
	public List<Cinema> findAll() {
		return jdbcTemplate.query("select * from cinemas", new CinemaMapper());
	}
	
	public Cinema findByName(String name) {
		return jdbcTemplate.queryForObject("select * from cinemas where name = ?",
				new Object[]{name},
				new CinemaMapper());
	}
	
	public Cinema findById(int id) {
		return jdbcTemplate.queryForObject("select * from cinemas where id = ?",
				new Object[]{id},
				new CinemaMapper());
	}
	
}
