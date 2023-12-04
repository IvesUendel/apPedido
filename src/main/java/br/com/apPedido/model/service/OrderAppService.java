package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.OrderApp;
import br.com.apPedido.model.repositories.OrderAppRepository;

@Service
public class OrderAppService {

	@Autowired
	private OrderAppRepository orderAppRepository;
	
	public void includeData(OrderApp orderApp){
		orderAppRepository.save(orderApp);
	}
	
	public Collection<OrderApp> getList(){
		return (Collection<OrderApp>) orderAppRepository.findAll();
	}
}
