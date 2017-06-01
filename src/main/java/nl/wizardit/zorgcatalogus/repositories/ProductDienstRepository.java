package nl.wizardit.zorgcatalogus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.ProductDienst;



@Repository
public class ProductDienstRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked"})
	public ProductDienst getProductDienst(int productDienstCode) {
		ProductDienst productDienst = null;
		
		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
			
			
			productDienst = (ProductDienst) jdbcTemplate.queryForObject(
					"SELECT * FROM sp_zoek_product_met_product_code(?); ",
					new Object[] {productDienstCode}, new ProductDienstRowMapper());
					
			
		} catch (DataAccessException e) {}
		
		return productDienst ;
	}

	
}
