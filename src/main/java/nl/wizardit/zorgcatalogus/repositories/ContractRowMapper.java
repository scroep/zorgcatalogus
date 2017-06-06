package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Contract;


@SuppressWarnings("rawtypes")
public class ContractRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	 Contract contract = new Contract();
	 contract.setProductCode(rs.getInt("product_code"));
	 contract.setGroepCode(rs.getInt("groep_code"));
	 contract.setLeverancierAgbCode(rs.getString("leverancier_agb_code"));
	 contract.setContractStartdatum(rs.getDate("contract_start_datum"));
	 contract.setContractBeschrijving(rs.getString("contract_beschrijving"));
	 contract.setContractEinddatum(rs.getDate("contract_eind_datum"));
	 contract.setContractPrijs(rs.getBigDecimal("contract_prijs"));
	 contract.setContractAantal(rs.getBigDecimal("contract_aantal"));
      return contract;
	}

}
