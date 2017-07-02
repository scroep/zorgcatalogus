package nl.wizardit.zorgcatalogus.applicatie.models;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Offerte;

public class OfferteModel {
	
	private RestTemplate restTemplate = new RestTemplate();

	
	public void offerteOpSlaan(Offerte offerte){
		
		    Offerte toegevoegdeOfferte = restTemplate.postForObject("http://localhost:8080/zorgcatalogus/offerte/toevoegen", offerte, Offerte.class);
		    
		    System.out.println("toegevoegde offerte " + toegevoegdeOfferte.getOfferteTitel());
	}
	
	
	public Offerte[] getOffertes(int gemeenteCode){
		Offerte[] offertes = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/offerte/{gemeentecode}",Offerte[].class, gemeenteCode);
		return offertes;
	}

}
