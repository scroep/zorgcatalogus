package nl.wizardit.zorgcatalogus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Gemeente;

@Component
public class GemeenteRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Gemeente> findAll(){
		
		List<Gemeente> gemeentes = jdbcTemplate.query("Select * from gemeente", (rs, rowNum) -> new Gemeente(rs.getInt("gemeente_code"),
				rs.getString("gemeente_naam"),rs.getBoolean("is_actief")
			));
		
		return gemeentes;	
	}
	
	
	

}
