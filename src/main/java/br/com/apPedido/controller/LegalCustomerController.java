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

import br.com.apPedido.model.domain.LegalCustomer;
import br.com.apPedido.model.service.LegalCustomerService;

@RestController
@RequestMapping("/api/legalCustomer")
public class LegalCustomerController {
	
	@Autowired
	private LegalCustomerService legalCustomerService;

	@GetMapping(value = "/list" )
	public List<LegalCustomer> getList(){
		return (List<LegalCustomer>) legalCustomerService.getList();
	}
	
	@PostMapping(value = "/include")
	public void includeData(@RequestBody LegalCustomer legalCustomer) {
		legalCustomerService.includeData(legalCustomer);
	}
	
	@DeleteMapping(value = "/{id}/delete")
	public void deleteData(@PathVariable Integer id) {
		legalCustomerService.deleteData(id);
	}
	
}