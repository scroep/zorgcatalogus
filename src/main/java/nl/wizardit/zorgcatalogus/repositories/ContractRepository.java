package nl.wizardit.zorgcatalogus.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Contract;

@Repository
public class ContractRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@SuppressWarnings({ "unchecked"})
	public List<Contract> getContracten(int productCode, int gemeenteCode){
		
		List<Contract> contracten = null;
		
		try {
		jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

		contracten = (List<Contract>)jdbcTemplate.query(
				"select * from sp_zoek_contract(?,?)"
				,new Object[] {productCode,gemeenteCode},new ContractRowMapper());
	
	     } catch (DataAccessException e) {}
		
		    return contracten;
		
	  }
	
	@SuppressWarnings("unchecked")
	public List<Contract> getAlleContracten(int gemeenteCode){
		List<Contract> contracten = null;
		
		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");

			contracten = (List<Contract>)jdbcTemplate.query(
					"select * from sp_zoek_contracten(?)"
					,new Object[]{gemeenteCode},new ContractRowMapper());
		
			
		     } catch (DataAccessException e) {}
			
			    return contracten;
		  }
		
		

	
}
