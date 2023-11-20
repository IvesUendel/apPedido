package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.CerealBar;
import br.com.apPedido.model.service.CerealBarService;

@Order(4)
@Component
public class CerealBarLoader implements ApplicationRunner{

	@Autowired
	private CerealBarService cerealBarService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader fileReader = new FileReader("files/cerealbars.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			CerealBar cerealBar = new CerealBar(fields[0], Double.valueOf(fields[1]), Integer.valueOf(fields[2]),
												fields[3], fields[4], Double.valueOf(fields[5]), Integer.valueOf(fields[6]) , fields[7]);
						
			cerealBarService.includeData(cerealBar);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(CerealBar cerealBar : cerealBarService.getList()) {
			System.out.println("Cereal Bar : " + cerealBar);
		}
		
		readBufferedReader.close();
		
	}

}
