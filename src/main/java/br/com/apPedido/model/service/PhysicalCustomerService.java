package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.PhysicalCustomer;
import br.com.apPedido.model.repositories.PhysicalCustomerRepository;

@Service
public class PhysicalCustomerService {

	@Autowired
	private PhysicalCustomerRepository physicalCustomerRepository;
	
	public void includeData(PhysicalCustomer physicalCustomer){
		physicalCustomerRepository.save(physicalCustomer);
	}
	
	public Collection<PhysicalCustomer> getList()
	{
		return (Collection<PhysicalCustomer>) physicalCustomerRepository.findAll();
	}
}
