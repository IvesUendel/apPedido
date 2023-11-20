package br.com.apPedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.PhysicalCustomer;

@Service
public class PhysicalCustomerService {

	private Map<Integer, PhysicalCustomer>maps = new HashMap<Integer, PhysicalCustomer>();
	
	public void includeData(PhysicalCustomer physicalCustomer){
		maps.put(physicalCustomer.getCpf(), physicalCustomer);
	}
	
	public Collection<PhysicalCustomer> getList()
	{
		return maps.values();
	}
}
