package nl.wizardit.zorgcatalogus.restcontrollers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nl.wizardit.zorgcatalogus.domein.ProductDienst;
import nl.wizardit.zorgcatalogus.repositories.ProductDienstRepository;

@RestController
public class ProductDienstController {

	@Autowired
	private ProductDienstRepository productDienstRepository;


	@RequestMapping("/zorgcatalogus/productdienst/{id}")
	public ProductDienst getProductDienst(@PathVariable("id") int id) {
	   ProductDienst productdienst = productDienstRepository.getProductDienst(id);
		return productdienst;
		
	}
}
