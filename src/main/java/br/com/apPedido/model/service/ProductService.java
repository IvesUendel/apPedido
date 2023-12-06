package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.Product;
import br.com.apPedido.model.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void includeData(Product product){
		productRepository.save(product);	
	}
	
	public Collection<Product> getList(){
		return (Collection<Product>) productRepository.findAll();
	}
}
