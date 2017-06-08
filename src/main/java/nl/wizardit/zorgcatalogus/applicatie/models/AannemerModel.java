package nl.wizardit.zorgcatalogus.applicatie.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Aannemer;
import nl.wizardit.zorgcatalogus.domein.Specialiteit;

public class AannemerModel {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	public Aannemer[] getAannemers(int specialiteitCode, int gemeenteCode){
		
		Map<String,Integer> vars = new HashMap<String,Integer>();
		vars.put("specialiteitcode", specialiteitCode);
		vars.put("gemeentecode", gemeenteCode);
		Aannemer[] aannemers = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/aannemer/{specialiteitcode}/{gemeentecode}",Aannemer[].class,vars);
		return aannemers;	
	}
	
	public Specialiteit[] getSpecialiteiten(){
		Specialiteit[] specialiteiten = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/aannemer/specialiteit",Specialiteit[].class);
		return specialiteiten;
	}

}
