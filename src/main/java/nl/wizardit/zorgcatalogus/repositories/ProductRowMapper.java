package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.Product;


@SuppressWarnings("rawtypes")
public class ProductRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductCode(rs.getInt("product_code"));
		product.setCategorieCode(rs.getInt("categorie_code"));
		product.setProductNaam(rs.getString("product_naam"));
		product.setProductEenheid(rs.getString("product_eenheid"));
		return product;
	}

}
