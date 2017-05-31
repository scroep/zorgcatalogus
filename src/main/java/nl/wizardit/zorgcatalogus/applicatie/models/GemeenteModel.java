package nl.wizardit.zorgcatalogus.applicatie.models;


import org.springframework.web.client.RestTemplate;
import nl.wizardit.zorgcatalogus.domein.Gemeente;




public class GemeenteModel {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Gemeente[] getAlleGemeentes(){
		Gemeente[] gemeenten = restTemplate.getForObject("http://localhost:8080/sjoerd", Gemeente[].class);
		return gemeenten;
	}
	

}
