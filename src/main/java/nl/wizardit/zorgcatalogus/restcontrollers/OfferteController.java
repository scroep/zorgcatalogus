package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Offerte;
import nl.wizardit.zorgcatalogus.repositories.OfferteRepository;

@RestController
public class OfferteController {
	
	@Autowired
	private OfferteRepository offerteRepository;
	
	
	@RequestMapping("/zorgcatalogus/offerte/{gemeentecode}")
	public List<Offerte> getOffertes(@PathVariable("gemeentecode")int gemeenteCode){
		List<Offerte> offertes = offerteRepository.getOffertes(gemeenteCode);
		return offertes;
		
	}

}
