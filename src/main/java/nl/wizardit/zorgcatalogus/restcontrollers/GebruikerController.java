package nl.wizardit.zorgcatalogus.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.repositories.GebruikerRepository;
import nl.wizardit.zorgcatalogus.repositories.GebruikerRepository.Gebruikersfunctie;

@RestController
public class GebruikerController {

	@Autowired
	private GebruikerRepository gebruikerRepository;

	@RequestMapping("/zorgcatalogus/gebruiker/functie")
	public Gebruikersfunctie getGebruikerFunctie() {
		Gebruikersfunctie gebruikersfunctie = gebruikerRepository.getGebruikerFunctie();
		return gebruikersfunctie;

	}
	
	@RequestMapping("/zorgcatalogus/gebruiker/gemeentecode")
	public int getGebruikerGemeentecode() {
		int gebruikerGemeentecode = gebruikerRepository.getGebruikerGemeentecode();
		return gebruikerGemeentecode;

	}
}
