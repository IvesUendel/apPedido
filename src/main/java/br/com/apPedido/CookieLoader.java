package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.Cookie;
import br.com.apPedido.model.service.CookieService;

@Order(5)
@Component
public class CookieLoader implements ApplicationRunner {
	
	@Autowired
	private CookieService cookieService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/cookie.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			Cookie cookie = new Cookie(fields[0], Double.valueOf(fields[1]), Integer.valueOf(fields[2]),
												fields[3], fields[4], Double.valueOf(fields[5]), Integer.valueOf(fields[6]) , fields[7]);
						
			cookieService.includeData(cookie);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(Cookie cookie : cookieService.getList()) {
			System.out.println("Cookie : " + cookie);
		}
		
		readBufferedReader.close();
	}

}
