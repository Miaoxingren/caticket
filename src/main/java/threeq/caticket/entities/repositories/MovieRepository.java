package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import threeq.caticket.entities.Movie;


@Repository
public class MovieRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	private class MovieMapper implements RowMapper<Movie> {
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setId(rs.getInt("id"));
			movie.setName(rs.getString("name"));
			movie.setScore(rs.getFloat("score"));
			movie.setDetail(rs.getString("detail"));
			movie.setLowCost(rs.getFloat("lowCost"));
			movie.setReleaseTime(rs.getDate("releaseTime"));
			movie.setTimeLength(rs.getInt("timeLength"));
			String actors = rs.getString("actors");
			movie.setActors(actors.split(","));
			String doctors = rs.getString("doctors");
			movie.setDoctors(doctors.split(","));
			String movieTypes = rs.getString("movieTypes");
			movie.setMovieTypes(movieTypes.split(","));
			String[] cinemas = rs.getString("cinemaList").split(",");
			int[] cinemaList = new int[cinemas.length];
			for (int i = 0; i < cinemaList.length; i++) {
				cinemaList[i] = Integer.parseInt(cinemas[i]);
			}
			movie.setCinemaList(cinemaList);
		    return movie;
		}
	}
	
	public List<Movie> findAll() {
		return jdbcTemplate.query("select * from movies", new MovieMapper());
	}
	
	public Movie findByName(String name) {
		return jdbcTemplate.queryForObject("select * from movies where name = ?",
				new Object[]{name},
				new MovieMapper());
	}
	
	public Movie findById(int id) {
		return jdbcTemplate.queryForObject("select * from movies where id = ?",
				new Object[]{id},
				new MovieMapper());
	}
	

}
