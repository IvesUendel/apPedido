package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.Address;
import br.com.apPedido.model.domain.PhysicalCustomer;
import br.com.apPedido.model.service.AddressService;
import br.com.apPedido.model.service.PhysicalCustomerService;

@Order(1)
@Component
public class PhysicalCustomerLoader implements ApplicationRunner{
	
	@Autowired
	private PhysicalCustomerService physicalService;
	@Autowired
	private AddressService brazilAddressService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/physicalCustomers.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			String cep = fields[4];
			Address brazilAddress = brazilAddressService.searchCep(cep);
			
			PhysicalCustomer physicalCustomer = new PhysicalCustomer(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]), brazilAddress);
			
			physicalService.includeData(physicalCustomer);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(PhysicalCustomer physicalCustomer : physicalService.getList()) {
			System.out.println("Physical Customer : " + physicalCustomer);
		}
		
		readBufferedReader.close();
		
	}

}