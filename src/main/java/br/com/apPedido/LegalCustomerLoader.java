package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.LegalCustomer;


@Order(2)
@Component
public class LegalCustomerLoader implements ApplicationRunner{

private Map<Integer, LegalCustomer>maps = new HashMap<Integer, LegalCustomer>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/legalCustomers.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			LegalCustomer legalCustomer = new LegalCustomer(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]));
						
			maps.put(legalCustomer.getCnpj(), legalCustomer);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(LegalCustomer legalCustomer : maps.values()) {
			System.out.println("Legal Customer : " + legalCustomer);
		}
		
		readBufferedReader.close();
		
	}

}
