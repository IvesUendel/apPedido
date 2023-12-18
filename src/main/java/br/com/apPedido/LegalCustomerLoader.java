package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.Address;
import br.com.apPedido.model.domain.LegalCustomer;
import br.com.apPedido.model.service.AddressService;
import br.com.apPedido.model.service.LegalCustomerService;


@Order(2)
@Component
public class LegalCustomerLoader implements ApplicationRunner{

	@Autowired
	private LegalCustomerService legalService;
	@Autowired
	private AddressService brazilAddressService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/legalCustomers.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			String cep = fields[4];
			Address brazilAddress = brazilAddressService.searchCep(cep);
			
			LegalCustomer legalCustomer = new LegalCustomer(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]), brazilAddress);
						
			legalService.includeData(legalCustomer);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(LegalCustomer legalCustomer : legalService.getList()) {
			System.out.println("Legal Customer : " + legalCustomer);
		}
		
		readBufferedReader.close();
		
	}

}
