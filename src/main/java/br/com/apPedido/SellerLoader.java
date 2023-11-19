package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.Seller;

@Order(3)
@Component
public class SellerLoader implements ApplicationRunner {

private Map<Integer, Seller>maps = new HashMap<Integer, Seller>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/sellers.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			Seller seller = new Seller(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]), Double.valueOf(fields[4]), Double.valueOf(fields[5]));
						
			maps.put(seller.getEmployee_code(), seller);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(Seller seller : maps.values()) {
			System.out.println("Seller : " + seller);
		}
		
		readBufferedReader.close();
		
	}

}
