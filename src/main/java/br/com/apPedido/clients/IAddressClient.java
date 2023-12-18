package br.com.apPedido.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.apPedido.model.domain.Address;

@FeignClient(name = "addresClient", url = "https://viacep.com.br/ws")
public interface IAddressClient {
	
	@GetMapping(value = "/{cep}/json/")
	public Address searchCep(@PathVariable String cep);
}
