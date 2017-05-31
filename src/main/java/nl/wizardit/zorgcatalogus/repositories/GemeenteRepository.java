package nl.wizardit.zorgcatalogus.repositories;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Gemeente;

@Repository
public class GemeenteRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Gemeente> findAll(){
		jdbcTemplate.execute("set schema 'zorgcatalogus';");

		List<Gemeente> gemeentes = jdbcTemplate.query(
				"SELECT * FROM gemeente",
				(rs, rowNum) -> new Gemeente(rs.getInt("gemeente_code"), rs.getString("gemeente_naam"), rs.getBoolean("is_actief")
			));
		
		return gemeentes;	
	}

}
