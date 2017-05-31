package nl.wizardit.zorgcatalogus.applicatie.models;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.ProductDienst;

public class ProductDienstModel {
	
private RestTemplate restTemplate = new RestTemplate();

    public ProductDienst getProductDienst(int id){
    	ProductDienst productDienst = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/productdienst/{id}",ProductDienst.class, id);
    	return productDienst;
    	
    }

}
