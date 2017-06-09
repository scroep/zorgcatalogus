package nl.wizardit.zorgcatalogus.applicatie.models;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.repositories.GebruikerRepository.Gebruikersfunctie;

public class GebruikerModel {

	private RestTemplate restTemplate = new RestTemplate();

	public Gebruikersfunctie getGebruikerFunctie() {
		Gebruikersfunctie gebruikersfunctie = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/gebruiker/functie", Gebruikersfunctie.class);
		return gebruikersfunctie;
	}
	
	public int getGebruikerGemeentecode() {
		int gebruikerGemeentecode = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/gebruiker/gemeentecode", Integer.class);
		return gebruikerGemeentecode;
	}

}
