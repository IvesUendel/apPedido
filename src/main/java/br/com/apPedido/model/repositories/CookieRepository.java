package br.com.apPedido.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apPedido.model.domain.Cookie;

@Repository
public interface CookieRepository extends CrudRepository<Cookie, Integer> {

}
