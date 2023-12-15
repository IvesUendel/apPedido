package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.LegalCustomer;
import br.com.apPedido.model.repositories.LegalCustomerRepository;

@Service
public class LegalCustomerService {
	
	@Autowired
	private LegalCustomerRepository legalCustomerRepository;
	
	public void includeData(LegalCustomer legalCustomer){
		legalCustomerRepository.save(legalCustomer);
	}
	
	public Collection<LegalCustomer> getList(){
		return (Collection<LegalCustomer>) legalCustomerRepository.findAll();
	}
	
	public void deleteData(Integer id) {
		legalCustomerRepository.deleteById(id);	
	}
}
