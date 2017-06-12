package nl.wizardit.zorgcatalogus.applicatie.models;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Evenement;

public class EvenementModel {
	
	private RestTemplate restTemplate = new RestTemplate();

	
	public Evenement[] getEvenementen(int gemeenteCode){
		Evenement[] evenementen = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/evenement/{gemeentecode}",Evenement[].class,gemeenteCode);
		return evenementen;
	}

}
