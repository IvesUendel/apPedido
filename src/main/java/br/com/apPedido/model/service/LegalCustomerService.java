package br.com.apPedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.LegalCustomer;

@Service
public class LegalCustomerService {
	private Map<Integer, LegalCustomer> maps = new HashMap<Integer, LegalCustomer>();
	
	public void includeData(LegalCustomer legalCustomer){
		maps.put(legalCustomer.getCnpj(), legalCustomer);
	}
	
	public Collection<LegalCustomer> getList(){
		return maps.values();
	}
}
