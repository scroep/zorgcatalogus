package nl.wizardit.zorgcatalogus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nl.wizardit.zorgcatalogus.domein.ProductDienst;



@Repository
public class ProductDienstRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked"})
	public ProductDienst getProductDienst(int productDienstCode){
		jdbcTemplate.execute("set schema 'zorgcatalogus';");
		ProductDienst productDienst = (ProductDienst) jdbcTemplate.queryForObject("SELECT * FROM product_dienst WHERE product_dienst_code = ?",new Object[]{ productDienstCode},new ProductDienstRowMapper());
		return productDienst;
	}

	
}
