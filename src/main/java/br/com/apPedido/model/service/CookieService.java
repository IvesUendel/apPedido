package br.com.apPedido.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.apPedido.model.domain.Cookie;

@Service
public class CookieService {
	private Map<Integer, Cookie>maps = new HashMap<Integer, Cookie>();
	
	public void includeData(Cookie cookie){
		maps.put(cookie.getProduct_code(), cookie);
	}
	
	public Collection<Cookie> getList(){
		return maps.values();
	}
}
