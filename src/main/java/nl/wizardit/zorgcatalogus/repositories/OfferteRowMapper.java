package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Offerte;

@SuppressWarnings("rawtypes")
public class OfferteRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int numRow) throws SQLException {
		Offerte offerte = new Offerte();
		offerte.setOfferteCode(rs.getInt("offerte_code"));
		offerte.setGemeenteCode(rs.getInt("gemeente_code"));
		offerte.setAannemerKvkNummer(rs.getString("aannemer_kvk_nummer"));
		offerte.setOfferteTitel(rs.getString("offerte_titel"));
		offerte.setOfferteSamenvating(rs.getString("offerte_samenvating"));
		offerte.setOfferteUitleg(rs.getString("offerte_uitleg"));
		offerte.setOfferteGeldigTot(rs.getDate("offerte_geldig_tot"));
		offerte.setOfferteDocument(rs.getBytes("offerte_document"));
		return offerte;
	}
	
	

}
