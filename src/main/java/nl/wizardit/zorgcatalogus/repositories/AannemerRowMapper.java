package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Aannemer;

@SuppressWarnings("rawtypes")
public class AannemerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Aannemer aannemer = new Aannemer();
		 aannemer.setAannemerKvkNummer(rs.getString("aannemer_kvk_nummer"));
		 aannemer.setSpecialiteitCode(rs.getInt("specialiteit_code"));
		 aannemer.setAannemerNaam(rs.getString("aannemer_naam"));
		 aannemer.setAannemerTelefoonnummer(rs.getString("aannemer_telefoonnummer"));
		 aannemer.setAannemerPostcode(rs.getString("aannemer_postcode"));
		 aannemer.setAannemerHuisnummer(rs.getString("aannemer_huisnr"));
		 aannemer.setEerderIngehuurd(rs.getInt("eerder_ingehuurd"));
		return aannemer;
	}

}
