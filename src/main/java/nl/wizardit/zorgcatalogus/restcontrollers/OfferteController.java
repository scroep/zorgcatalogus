package nl.wizardit.zorgcatalogus.restcontrollers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(value ="/zorgcatalogus/offerte/slaop",method=RequestMethod.POST)
	public Offerte slaOfferteOp(@RequestBody Offerte offerte){
		 offerteRepository.offerteOpslaan(offerte);
		 System.out.println("test: s"+ offerte.getGemeenteCode());
		 return offerte;
	 }

}
