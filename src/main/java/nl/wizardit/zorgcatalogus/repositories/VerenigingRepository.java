package nl.wizardit.zorgcatalogus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import nl.wizardit.zorgcatalogus.domein.Vereniging;

@Repository
public class VerenigingRepository {
	 
	 @Autowired
     private JdbcTemplate jdbcTemplate;
	 
	 @SuppressWarnings("unchecked")
	public List<Vereniging> getVerenigingen(int gemeenteCode){
		 
		 List<Vereniging> verenigingen = null;
			try {
				jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

				verenigingen = (List<Vereniging>)jdbcTemplate.query(
						"select * from sp_zoek_verenigingen(?)"
						,new Object[] {gemeenteCode},new VerenigingRowMapper());
			
			     } catch (DataAccessException e) {}
		 
		 return verenigingen;
		 
	 }
	 
	 @SuppressWarnings("unchecked")
	public Vereniging getVereniging(int verenigingCode){
		 Vereniging vereniging = null;
			try {
				jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

				vereniging = (Vereniging)jdbcTemplate.queryForObject(
						"select * from sp_zoek_vereniging(?)"
						,new Object[] {verenigingCode},new VerenigingRowMapper());
			
			     } catch (DataAccessException e) {}
		 return vereniging;
	 }
	  
	 
	 public void verenigingUpdaten(Vereniging vereniging){
		 try{
				jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
				jdbcTemplate.update("SELECT sp_update_vereniging(?,?,?,?);", new Object[]{ vereniging.getVereningingCode(), vereniging.getGemeenteCode(), vereniging.getVerenigingNaam(),
						vereniging.getVerenigingOmschrijving() });

			 }catch (DataAccessException e) {}
	 }
	 
	 public void verenigingToevoegen(Vereniging vereniging){
		 try{
				jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
				jdbcTemplate.update("SELECT sp_vereniging_toevoegen(?,?,?,?);", new Object[]{ vereniging.getVereningingCode(), vereniging.getGemeenteCode(), vereniging.getVerenigingNaam(),
						vereniging.getVerenigingOmschrijving() });
			 }catch (DataAccessException e) {}
	 }
}
