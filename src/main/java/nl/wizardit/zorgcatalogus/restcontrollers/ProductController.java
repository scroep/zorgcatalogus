package nl.wizardit.zorgcatalogus.restcontrollers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nl.wizardit.zorgcatalogus.domein.Product;
import nl.wizardit.zorgcatalogus.repositories.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;


	@RequestMapping("/zorgcatalogus/product/{id}")
	public Product getProductDienst(@PathVariable("id") int id) {
	   Product product = productRepository.getProduct(id);
		return product;
		
	}
}
