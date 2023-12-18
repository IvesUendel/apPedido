package br.com.apPedido.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.clients.IAddressClient;
import br.com.apPedido.model.domain.Address;

@Service
public class AddressService {
	
	@Autowired
	private IAddressClient addressClient;

	public Address searchCep(String cep) {
		return addressClient.searchCep(cep);
	}
}
