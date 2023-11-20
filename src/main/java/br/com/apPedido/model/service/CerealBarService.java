package br.com.apPedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.CerealBar;

@Service
public class CerealBarService {
	private Map<Integer, CerealBar>maps = new HashMap<Integer, CerealBar>();
	
	public void includeData(CerealBar cerealBar){
		maps.put(cerealBar.getProduct_code(), cerealBar);
	}
	
	public Collection<CerealBar> getList(){
		return maps.values();
	}
}
