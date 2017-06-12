package nl.wizardit.zorgcatalogus.repositories;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Voorraad;

@Repository
public class VoorraadRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public Voorraad getVoorraad(int gemeenteCode, int productCode) {

		Voorraad voorraad = null;

		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

			voorraad = (Voorraad) jdbcTemplate.queryForObject("SELECT * FROM sp_zoek_voorraad(?,?); ",
					new Object[] {gemeenteCode, productCode}, new VoorraadRowMapper());
			
		} catch (DataAccessException e) {}

		return voorraad;

	}

	public void updateVoorraadAantal(int gemeenteCode, int productCode, double aantal) {
		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
			
			BigDecimal bdAantal = new BigDecimal(aantal);

			jdbcTemplate.update("SELECT sp_update_voorraad(?,?,?);",
					new Object[] {gemeenteCode, productCode, bdAantal});
			
		} catch (DataAccessException e) {}
	}

}
