package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.CerealBar;
import br.com.apPedido.model.repositories.CerealBarRepository;

@Service
public class CerealBarService {
	
	@Autowired
	private CerealBarRepository cerealBarRepository;
	
	public void includeData(CerealBar cerealBar){
		cerealBarRepository.save(cerealBar);	
	}
	
	public Collection<CerealBar> getList(){
		return (Collection<CerealBar>) cerealBarRepository.findAll();
	}
}
