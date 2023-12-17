package br.com.apPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apPedido.model.domain.Seller;
import br.com.apPedido.model.service.SellerService;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping(value = "/list")
	public List<Seller> getList(){
		return (List<Seller>) sellerService.getList();
	}
	
	@PostMapping(value = "/include")
	public void includeData(@RequestBody Seller seller) {
		sellerService.includeData(seller);
	}
	
	@DeleteMapping(value = "/{id}/delete")
	public void deleteData(@PathVariable Integer id) {
		sellerService.deleteData(id);
	}
}
