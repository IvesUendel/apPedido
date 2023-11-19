package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.PhysicalCustomer;

@Order(1)
@Component
public class PhysicalCustomerLoader implements ApplicationRunner{

	private Map<Integer, PhysicalCustomer>maps = new HashMap<Integer, PhysicalCustomer>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/physicalCustomers.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			PhysicalCustomer physicalCustomer = new PhysicalCustomer(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]));
						
			maps.put(physicalCustomer.getCpf(), physicalCustomer);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(PhysicalCustomer physicalCustomer : maps.values()) {
			System.out.println("Physical Customer : " + physicalCustomer);
		}
		
		readBufferedReader.close();
		
	}

}