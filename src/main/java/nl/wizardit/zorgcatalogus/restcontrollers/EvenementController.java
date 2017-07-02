package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Evenement;
import nl.wizardit.zorgcatalogus.repositories.EvenementRepository;

@RestController
public class EvenementController {
	
	@Autowired
	private EvenementRepository evenementRepository;
	
	
	
	@RequestMapping("/zorgcatalogus/evenement/{gemeentecode}")
	public List<Evenement> getEvenementen(@PathVariable("gemeentecode") int gemeenteCode){
		List<Evenement> evenementen = evenementRepository.getEvenementen(gemeenteCode);
		return evenementen;		
	}
	
	
	@RequestMapping(value ="/zorgcatalogus/evenement/toevoegen",method=RequestMethod.POST)
	public Evenement evenementToevoegen(@RequestBody Evenement evenement, int gemeenteCode){
		evenementRepository.evenementToevoegen(evenement, gemeenteCode);
		 return evenement;
	 }
	
	@RequestMapping(value ="/zorgcatalogus/evenement/updaten",method=RequestMethod.POST)
	public Evenement evenementUpdaten(@RequestBody Evenement evenement, int gemeenteCode){
		evenementRepository.evenementUpdaten(evenement, gemeenteCode);
		 return evenement;
	 }
}
