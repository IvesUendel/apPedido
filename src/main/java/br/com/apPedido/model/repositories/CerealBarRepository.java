package br.com.apPedido.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apPedido.model.domain.CerealBar;

@Repository
public interface CerealBarRepository extends CrudRepository<CerealBar, Integer>{

}
