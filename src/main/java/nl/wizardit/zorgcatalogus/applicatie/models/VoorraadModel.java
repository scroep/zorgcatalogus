package nl.wizardit.zorgcatalogus.applicatie.models;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Voorraad;

public class VoorraadModel {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	 public Voorraad getVoorraad(int gemeenteCode, int productCode){
		 Voorraad voorraad = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/voorraad/{gemeentecode}/{productcode}",Voorraad.class, gemeenteCode, productCode );
		 return voorraad;
	 }

}
