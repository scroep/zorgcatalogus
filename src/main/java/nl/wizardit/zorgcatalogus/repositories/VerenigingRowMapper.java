package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Vereniging;

public class VerenigingRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vereniging vereniging = new Vereniging();
		vereniging.setVereningingCode(rs.getInt("vereniging_code"));
		vereniging.setGemeenteCode(rs.getInt("gemeente_code"));
		vereniging.setVerenigingNaam(rs.getString("vereniging_naam"));
		vereniging.setVerenigingOmschrijving(rs.getString("vereniging_omschrijving"));
		return vereniging;
	}

}
