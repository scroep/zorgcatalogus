package nl.wizardit.zorgcatalogus.applicatie.models;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Offerte;

public class OfferteModel {
	
	private RestTemplate restTemplate = new RestTemplate();

	
	public void offerteOpSlaan(Offerte offerte){
		
		    Offerte toegevoegdeOfferte = restTemplate.postForObject("http://localhost:8080/zorgcatalogus/offerte/slaop", offerte, Offerte.class);
		    
		    System.out.println("toegevoegde offerte " + toegevoegdeOfferte.getOfferteTitel());
	}

}
