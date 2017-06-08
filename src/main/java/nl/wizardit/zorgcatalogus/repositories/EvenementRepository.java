package nl.wizardit.zorgcatalogus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Evenement;
import nl.wizardit.zorgcatalogus.domein.Offerte;

@Repository
public class EvenementRepository {
	 @Autowired
     private JdbcTemplate jdbcTemplate;
	  
	  @SuppressWarnings({ "unchecked"})
	  public List<Evenement> getEvenementen(int gemeenteCode){
		  
		  List<Evenement> evenementen = null;
		  
		 try {
				jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
				
				evenementen = (List<Evenement>) jdbcTemplate.query(
						"select * from sp_zoek_evenementen(?)",
						new Object[] {gemeenteCode},new EvenementRowMapper());
				
		   } catch (DataAccessException e) {}
		  
		  return evenementen;
		  
	  }
	

}
