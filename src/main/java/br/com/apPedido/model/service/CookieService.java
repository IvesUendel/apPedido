package br.com.apPedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.Cookie;
import br.com.apPedido.model.repositories.CookieRepository;

@Service
public class CookieService {
	
	@Autowired
	private CookieRepository cookieRepository;
	
	public void includeData(Cookie cookie){
		cookieRepository.save(cookie);
	}
	
	public Collection<Cookie> getList(){
		return (Collection<Cookie>) cookieRepository.findAll();
    }
}
