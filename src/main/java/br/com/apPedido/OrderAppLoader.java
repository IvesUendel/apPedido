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
import br.com.apPedido.model.domain.Product;
import br.com.apPedido.model.domain.Seller;
import br.com.apPedido.model.domain.User;
import br.com.apPedido.model.service.OrderAppService;

@Order(9)
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
				
				User user = new Seller();
				user.setId(Integer.valueOf(fields[3]));	
				
				orderApp = new OrderApp();
				orderApp.setOrder_date(LocalDate.now());
				orderApp.setDescription(fields[1]);
				orderApp.setOrder_code(Integer.valueOf(fields[2]));
				//orderApp.setUser(new PhysicalCustomer(fields[3], fields[4], fields[5],Integer.valueOf(fields[6])));
				orderApp.setUser(user);
				orderApp.setProducts(new ArrayList<Product>());	
				break;
				
			case "CB": 
				CerealBar cerealBar = new CerealBar();
				cerealBar.setId(Integer.valueOf(fields[1]));
				
				orderApp.getProducts().add(cerealBar);
				break;
				
			case "CK": 
				Cookie cookie = new Cookie();
				cookie.setId(Integer.valueOf(fields[1]));
				
				orderApp.getProducts().add(cookie);
				break;
				
			}
			
			rowReader = readBufferedReader.readLine();
		}
		
		orderAppService.includeData(orderApp);
		
		for (OrderApp odApp : orderAppService.getList()) {
			System.out.println("Order: " + odApp);
		}
		
		readBufferedReader.close();
		
	}

}
