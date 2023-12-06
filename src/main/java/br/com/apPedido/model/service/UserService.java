package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.User;
import br.com.apPedido.model.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void includeData(User user){
		userRepository.save(user);
	}
	
	public Collection<User> getList()
	{
		return (Collection<User>) userRepository.findAll();
	}
}
