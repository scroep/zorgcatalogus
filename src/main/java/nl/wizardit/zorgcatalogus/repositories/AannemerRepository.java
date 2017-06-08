package nl.wizardit.zorgcatalogus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Aannemer;
import nl.wizardit.zorgcatalogus.domein.Specialiteit;



@Repository
public class AannemerRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked"})
	public List<Aannemer> getAannemers(int specialiteitCode, int gemeenteCode){
		
		List<Aannemer> aannemers = null;
		
		try {
		jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

		aannemers = (List<Aannemer>)jdbcTemplate.query(
				"select * from sp_zoek_aannemers(?,?)"
				,new Object[] {specialiteitCode,gemeenteCode},new AannemerRowMapper());
	
	     } catch (DataAccessException e) {}
		
		    return aannemers;
		
	  }
	
	public List<Specialiteit> getAlleSpecialiteiten(){
		jdbcTemplate.execute("set schema 'zorgcatalogus';");

		List<Specialiteit> specialiteiten = jdbcTemplate.query(
				"SELECT * FROM specialiteit",
				(rs, rowNum) -> new Specialiteit(rs.getInt("specialiteit_code"),rs.getString("specialiteit_string")));
		
		return specialiteiten;	
		
	}

}
