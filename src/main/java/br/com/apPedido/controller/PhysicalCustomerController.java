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

import br.com.apPedido.model.domain.PhysicalCustomer;
import br.com.apPedido.model.service.PhysicalCustomerService;

@RestController
@RequestMapping("/api/physicalCustomer")
public class PhysicalCustomerController {
	
	@Autowired
	private PhysicalCustomerService physicalCustomerService;
	
	@GetMapping(value = "/list")
	public List<PhysicalCustomer> getList(){
		return (List<PhysicalCustomer>) physicalCustomerService.getList();
	}
	
	@PostMapping(value = "/include")
	public void includeData(@RequestBody PhysicalCustomer physicalCustomer) {
		physicalCustomerService.includeData(physicalCustomer);
	}
	
	@DeleteMapping(value = "/{id}/delete")
	public void deleteData(@PathVariable Integer id) {
		physicalCustomerService.deleteData(id);
	}
}
