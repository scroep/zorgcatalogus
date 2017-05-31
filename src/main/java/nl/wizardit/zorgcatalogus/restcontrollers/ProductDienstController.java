package nl.wizardit.zorgcatalogus.restcontrollers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nl.wizardit.zorgcatalogus.domein.Gemeente;
import nl.wizardit.zorgcatalogus.repositories.GemeenteRepository;

@RestController
public class ProductDienstController {

	@Autowired
	private GemeenteRepository gemeenteRepository;


	@RequestMapping("/tests")
	public List<Gemeente> getAllgemeentes() {
		List<Gemeente> gemeenten = gemeenteRepository.findAll();		
		return gemeenten;
		
	}
}
