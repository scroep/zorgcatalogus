package nl.wizardit.zorgcatalogus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.Product;



@Repository
public class ProductRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked"})
	public Product getProduct(int productCode) {
		Product product = null;
		
		try {
			jdbcTemplate.execute("SET SCHEMA 'zorgcatalogus';");
			
			
			product = (Product) jdbcTemplate.queryForObject(
					"SELECT * FROM sp_zoek_product(?); ",
					new Object[] {productCode}, new ProductRowMapper());
					
			System.out.println(product);
			
		} catch (DataAccessException e) {}
		
		return product;
	}

	
}
