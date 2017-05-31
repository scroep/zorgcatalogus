package nl.wizardit.zorgcatalogus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nl.wizardit.zorgcatalogus.domein.ProductDienst;


@SuppressWarnings("rawtypes")
public class ProductDienstRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDienst productDienst = new ProductDienst();
		productDienst.setProductDienstcode(rs.getInt("product_dienst_code"));
		productDienst.setCategorieCode(rs.getInt("categorie_code"));
		productDienst.setProductDienstNaam(rs.getString("product_dienst_naam"));
		productDienst.setProductDienstOmschrijving(rs.getString("product_dienst_omschrijving"));
		productDienst.setActief(rs.getBoolean("is_actief"));
		return productDienst;
	}

}
