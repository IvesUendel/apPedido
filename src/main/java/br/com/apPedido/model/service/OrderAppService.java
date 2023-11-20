package br.com.apPedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.OrderApp;

@Service
public class OrderAppService {

	private Map<Integer, OrderApp>maps = new HashMap<Integer, OrderApp>();
	
	public void includeData(OrderApp orderApp){
		maps.put(orderApp.getOrder_code(), orderApp);
	}
	
	public Collection<OrderApp> getList()
	{
		return maps.values();
	}
}
