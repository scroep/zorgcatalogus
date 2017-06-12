package nl.wizardit.zorgcatalogus.applicatie.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import nl.wizardit.zorgcatalogus.domein.Contract;

public class ContractModel {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Contract[] getContracten(int productcode, int gemeentecode){
		Map<String, Integer> vars = new HashMap<String, Integer>();
		vars.put("productcode", productcode);
		vars.put("gemeentecode", gemeentecode);

		Contract[] contracten = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/contract/{productcode}/{gemeentecode}", Contract[].class,vars);
		
		return contracten;
	}
	
	public Contract[] getAlleContracten(int gemeenteCode){
		
		Contract[] contracten = restTemplate.getForObject("http://localhost:8080/zorgcatalogus/contract/{gemeentecode}", Contract[].class, gemeenteCode);
		
		return contracten;
		
	}
	
	public void voegContractToe(Contract contract){
		Contract toegevoegdecontract = restTemplate.postForObject("http://localhost:8080/zorgcatalogus/contract/toevoegen", contract, Contract.class);
		System.out.println("contract is toegevoegd" + toegevoegdecontract.getContractBeschrijving());
	}

}
