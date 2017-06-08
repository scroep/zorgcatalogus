package nl.wizardit.zorgcatalogus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Offerte;

@Repository
public class OfferteRepository {
	
	  @Autowired
      private JdbcTemplate jdbcTemplate;
	  
	  @SuppressWarnings({ "unchecked"})
	  public List<Offerte> getOffertes(int gemeenteCode){
		  
		  List<Offerte> offertes = null;
		  
		 try {
				jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
				
				offertes = (List<Offerte>) jdbcTemplate.query(
						"select * from sp_zoek_offerte(?)",
						new Object[] {gemeenteCode},new OfferteRowMapper());
				
		   } catch (DataAccessException e) {}
		  
		  return offertes;
		  
	  }
	  
}
