package threeq.caticket.entities.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import threeq.caticket.entities.CImage;

@Repository
public class CImageRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	}
	
	private class CImageMapper implements RowMapper<CImage> {
		public CImage mapRow(ResultSet rs, int rowNum) throws SQLException {
			CImage cImage = new CImage();
			cImage.setId(rs.getInt("id"));
			cImage.setName(rs.getString("name"));
			cImage.setSource(rs.getBlob("source"));
		    return cImage;
		}
	}
	
	public CImage findByName(String name) {
		return jdbcTemplate.queryForObject("select * from images where name = ?",
				new Object[]{name},
				new CImageMapper());
	}
	
	public CImage findById(int id) {
		return jdbcTemplate.queryForObject("select * from images where id = ?",
				new Object[]{id},
				new CImageMapper());
	}
}
