package br.com.apPedido.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apPedido.model.domain.OrderApp;

@Repository
public interface OrderAppRepository extends CrudRepository<OrderApp, Integer> {

}
