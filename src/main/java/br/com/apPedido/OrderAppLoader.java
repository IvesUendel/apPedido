package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.CerealBar;
import br.com.apPedido.model.domain.Cookie;
import br.com.apPedido.model.domain.OrderApp;
import br.com.apPedido.model.domain.PhysicalCustomer;
import br.com.apPedido.model.domain.Product;
import br.com.apPedido.model.service.OrderAppService;

@Order(6)
@Component
public class OrderAppLoader implements ApplicationRunner{
	
	@Autowired
	private OrderAppService orderAppService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/orders.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		OrderApp orderApp = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			switch (fields[0]) {
			case "OD": 
				orderApp = new OrderApp();
				orderApp.setOrder_date(LocalDate.now());
				orderApp.setDescription(fields[1]);
				orderApp.setOrder_code(Integer.valueOf(fields[2]));
				orderApp.setUser(new PhysicalCustomer(fields[3], fields[4], fields[5],Integer.valueOf(fields[6])));
				orderApp.setProducts(new ArrayList<Product>());	
				
				orderAppService.includeData(orderApp);
				break;
				
			case "CB": 
				CerealBar cerealBar = new CerealBar(fields[1], Double.valueOf(fields[2]), Integer.valueOf(fields[3]),
						fields[4], fields[5], Double.valueOf(fields[6]), Integer.valueOf(fields[7]) , fields[8]);
				
				orderApp.getProducts().add(cerealBar);
				break;
				
			case "CK": 
				Cookie cookie = new Cookie(fields[1], Double.valueOf(fields[2]), Integer.valueOf(fields[3]),
						fields[4], fields[5], Double.valueOf(fields[6]), Integer.valueOf(fields[7]) , fields[8]);
				
				orderApp.getProducts().add(cookie);
				break;
				
			}
			
			rowReader = readBufferedReader.readLine();
		}
		
		for (OrderApp odApp : orderAppService.getList()) {
			System.out.println("Order: " + odApp);
		}
		
		readBufferedReader.close();
		
	}

}
