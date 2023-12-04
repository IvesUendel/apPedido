package br.com.apPedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.Seller;

@Service
public class SellerService {
	
private Map<Integer, Seller> maps = new HashMap<Integer, Seller>();
	
	public void includeData(Seller seller){
		maps.put(seller.getEmployee_code(), seller);
	}
	
	public Collection<Seller> getList()
	{
		return maps.values();
	}
}
