package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.Seller;
import br.com.apPedido.model.service.SellerService;

@Order(3)
@Component
public class SellerLoader implements ApplicationRunner {

	@Autowired
	private SellerService sellerService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/sellers.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			Seller seller = new Seller(fields[0], fields[1], fields[2], Integer.valueOf(fields[3]), Double.valueOf(fields[4]), Double.valueOf(fields[5]));
						
			sellerService.includeData(seller);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(Seller seller : sellerService.getList()) {
			System.out.println("Seller : " + seller);
		}
		
		readBufferedReader.close();
		
	}

}
