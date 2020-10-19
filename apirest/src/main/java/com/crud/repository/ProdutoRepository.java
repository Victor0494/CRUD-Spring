package com.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.models.Contato;
import com.crud.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
	Iterable<Produto> findByContato(Contato contato);
	Produto findByCodigo(int codigo);
}
