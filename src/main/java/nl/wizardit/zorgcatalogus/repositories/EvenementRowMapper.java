package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Evenement;

public class EvenementRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int numRow) throws SQLException {
		Evenement evenement = new Evenement();
		evenement.setEvenementNaam(rs.getString("evenement_naam"));
		evenement.setVerenigingCode(rs.getInt("vereniging_code"));
		evenement.setEvenementOmschrijving(rs.getString("evenement_omschrijving"));
		evenement.setEvenementDatum(rs.getTimestamp("evenement_datum"));
		return evenement;
	}

}
