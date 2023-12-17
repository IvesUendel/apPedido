package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.Seller;
import br.com.apPedido.model.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public void includeData(Seller seller){
		sellerRepository.save(seller);
	}
	
	public Collection<Seller> getList()
	{
		return (Collection<Seller>) sellerRepository.findAll();
	}
	
	public void deleteData(Integer id) {
		sellerRepository.deleteById(id);
	}
}
