package nl.wizardit.zorgcatalogus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class GebruikerRepository {

	public static enum Gebruikersfunctie {
		ONBEKEND, FUNCTIONEEL_MEDEWERKER, ADMINISTRATIEF_MEDEWERKER,
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Gebruikersfunctie getGebruikerFunctie() {

		Gebruikersfunctie gebruikersfunctie = Gebruikersfunctie.ONBEKEND;

		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

			SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM zorgcatalogus.sp_gebruiker_functie();");

			if (!sqlRowSet.next()) {
				// Geen data teruggekregen.
				return Gebruikersfunctie.ONBEKEND;
			}

			switch (sqlRowSet.getString(1)) {
			case "functioneel_medewerker":
				gebruikersfunctie = Gebruikersfunctie.FUNCTIONEEL_MEDEWERKER;
				break;

			case "administratief_medewerker":
				gebruikersfunctie = Gebruikersfunctie.ADMINISTRATIEF_MEDEWERKER;
				break;
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return gebruikersfunctie;
	}

	public int getGebruikerGemeentecode() {

		int gemeentecode = -1;

		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

			SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM zorgcatalogus.sp_gebruiker_gemeentecode();");

			if (!sqlRowSet.next()) {
				// Geen data teruggekregen.
				return -1;
			}

			gemeentecode = sqlRowSet.getInt(1);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return gemeentecode;
	}

}
