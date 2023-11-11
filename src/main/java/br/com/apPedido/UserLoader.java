package br.com.apPedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.apPedido.model.domain.User;

@Component
public class UserLoader implements ApplicationRunner{

	private Map<String, User> maps = new HashMap<String, User>();
	@Override
	public void run(ApplicationArguments args) throws Exception {
				
		FileReader fileReader = new FileReader("files/users.txt");
		BufferedReader readBufferedReader = new BufferedReader(fileReader);
		
		String rowReader = readBufferedReader.readLine();
		String[] fields = null;
		
		while(rowReader != null){		
			fields = rowReader.split(";");	
			
			User user = new User();
			user.setName(fields[0]);
			user.setAddress(fields[1]);
			user.setEmail(fields[2]);
			
			maps.put(user.getEmail(), user);
			
			rowReader = readBufferedReader.readLine();
		}
		
		for(User user : maps.values()) {
			System.out.println("User : " + user);
		}
		
		readBufferedReader.close();
	}

	
	
}
