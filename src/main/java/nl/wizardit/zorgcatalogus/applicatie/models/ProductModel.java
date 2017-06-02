package nl.wizardit.zorgcatalogus.applicatie.models;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Product;

public class ProductModel {

	private RestTemplate restTemplate = new RestTemplate();

	public Product getProduct(int id) {
		Product product = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/product/{id}", Product.class, id);
		return product;

	}

}
