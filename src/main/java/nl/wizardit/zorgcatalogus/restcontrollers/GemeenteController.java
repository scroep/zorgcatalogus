package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Gemeente;
import nl.wizardit.zorgcatalogus.repositories.GemeenteRepository;

@RestController
public class GemeenteController {

	@Autowired
	private GemeenteRepository gemeenteRepository;

	@RequestMapping("/zorgcatalogus/gemeente")
	public List<Gemeente> getAllgemeentes() {
		List<Gemeente> gemeenten = gemeenteRepository.findAll();
		System.out.println("gemeente controller" + gemeenteRepository);
		return gemeenten;
	}

}
