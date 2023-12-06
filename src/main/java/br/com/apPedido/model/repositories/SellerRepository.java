package br.com.apPedido.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apPedido.model.domain.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {

}
