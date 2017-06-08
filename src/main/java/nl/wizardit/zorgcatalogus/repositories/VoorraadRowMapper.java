package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Voorraad;

@SuppressWarnings("rawtypes")
public class VoorraadRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voorraad voorraad = new Voorraad();
		voorraad.setGemeenteCode(rs.getInt("gemeente_code"));
		voorraad.setProductCode(rs.getInt("product_code"));
		voorraad.setVoorraadAantal(rs.getBigDecimal("voorraad_aantal"));
		voorraad.setVoorraadOmschrijving(rs.getString("vooraad_omschrijving"));
		return voorraad;
	}

}
